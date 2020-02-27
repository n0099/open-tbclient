package com.baidu.tieba.frs.gamecomment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar gAS;
    private TextView gAT;
    private RadioButton gAU;
    private RadioButton gAV;
    private RadioButton gAW;
    private RadioButton gAX;
    private RadioButton gAY;
    private EditText gAZ;
    private int gBa;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.gAU) {
                FrsGameCommentActivity.this.gAV.setChecked(false);
                FrsGameCommentActivity.this.gAW.setChecked(false);
                FrsGameCommentActivity.this.gAX.setChecked(false);
                FrsGameCommentActivity.this.gAY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.gAV) {
                FrsGameCommentActivity.this.gAU.setChecked(true);
                FrsGameCommentActivity.this.gAW.setChecked(false);
                FrsGameCommentActivity.this.gAX.setChecked(false);
                FrsGameCommentActivity.this.gAY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.gAW) {
                FrsGameCommentActivity.this.gAU.setChecked(true);
                FrsGameCommentActivity.this.gAV.setChecked(true);
                FrsGameCommentActivity.this.gAX.setChecked(false);
                FrsGameCommentActivity.this.gAY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.gAX) {
                FrsGameCommentActivity.this.gAU.setChecked(true);
                FrsGameCommentActivity.this.gAV.setChecked(true);
                FrsGameCommentActivity.this.gAW.setChecked(true);
                FrsGameCommentActivity.this.gAY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.gAY) {
                FrsGameCommentActivity.this.gAU.setChecked(true);
                FrsGameCommentActivity.this.gAV.setChecked(true);
                FrsGameCommentActivity.this.gAW.setChecked(true);
                FrsGameCommentActivity.this.gAX.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher gBb = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.gAZ.getText().length() > 0) {
                FrsGameCommentActivity.this.gAT.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.gAT, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.gAT.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.gAT, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener gBc = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            FrsGameCommentActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrsGameCommentResponseMessage)) {
                FrsGameCommentResponseMessage frsGameCommentResponseMessage = (FrsGameCommentResponseMessage) httpResponsedMessage;
                if (frsGameCommentResponseMessage.getError() == 0) {
                    FrsGameCommentActivity.this.setResult(-1);
                    FrsGameCommentActivity.this.finish();
                } else if (!StringUtils.isNull(frsGameCommentResponseMessage.getErrorString())) {
                    FrsGameCommentActivity.this.showToast(frsGameCommentResponseMessage.getErrorString());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mScore = getIntent().getIntExtra("score", 0);
        this.gBa = getIntent().getIntExtra("forum_id", -1);
        initView();
        te();
        registerListener();
        TiebaStatic.log(new an("c12340").X("fid", this.gBa));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.gAS = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.gAS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.gAS.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.gAS.showBottomLine(true);
        this.gAT = this.gAS.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bHL();
            }
        });
        this.gAT.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.gAT.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.gAT.setEnabled(false);
        this.gAU = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.gAU.setOnClickListener(this.mOnClickListener);
        this.gAV = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.gAV.setOnClickListener(this.mOnClickListener);
        this.gAW = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.gAW.setOnClickListener(this.mOnClickListener);
        this.gAX = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.gAX.setOnClickListener(this.mOnClickListener);
        this.gAY = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.gAY.setOnClickListener(this.mOnClickListener);
        this.gAZ = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.gAZ.addTextChangedListener(this.gBb);
        switch (this.mScore) {
            case 2:
                this.gAU.setChecked(true);
                this.gAV.setChecked(false);
                this.gAW.setChecked(false);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(false);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 6:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(false);
                this.gAY.setChecked(false);
                return;
            case 8:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(false);
                return;
            case 10:
                this.gAU.setChecked(true);
                this.gAV.setChecked(true);
                this.gAW.setChecked(true);
                this.gAX.setChecked(true);
                this.gAY.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHL() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.gBa);
        httpMessage.addParam("content", this.gAZ.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void te() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gBc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.gBc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.gAU, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gAV, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gAW, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gAX, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gAY, R.drawable.game_comment_score_btn_bg);
        if (this.gAT.isEnabled()) {
            am.setViewTextColor(this.gAT, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.gAT, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.gAZ.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
