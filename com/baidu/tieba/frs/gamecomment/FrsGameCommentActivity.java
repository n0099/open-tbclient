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
/* loaded from: classes7.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar gyS;
    private TextView gyT;
    private RadioButton gyU;
    private RadioButton gyV;
    private RadioButton gyW;
    private RadioButton gyX;
    private RadioButton gyY;
    private EditText gyZ;
    private int gza;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.gyU) {
                FrsGameCommentActivity.this.gyV.setChecked(false);
                FrsGameCommentActivity.this.gyW.setChecked(false);
                FrsGameCommentActivity.this.gyX.setChecked(false);
                FrsGameCommentActivity.this.gyY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.gyV) {
                FrsGameCommentActivity.this.gyU.setChecked(true);
                FrsGameCommentActivity.this.gyW.setChecked(false);
                FrsGameCommentActivity.this.gyX.setChecked(false);
                FrsGameCommentActivity.this.gyY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.gyW) {
                FrsGameCommentActivity.this.gyU.setChecked(true);
                FrsGameCommentActivity.this.gyV.setChecked(true);
                FrsGameCommentActivity.this.gyX.setChecked(false);
                FrsGameCommentActivity.this.gyY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.gyX) {
                FrsGameCommentActivity.this.gyU.setChecked(true);
                FrsGameCommentActivity.this.gyV.setChecked(true);
                FrsGameCommentActivity.this.gyW.setChecked(true);
                FrsGameCommentActivity.this.gyY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.gyY) {
                FrsGameCommentActivity.this.gyU.setChecked(true);
                FrsGameCommentActivity.this.gyV.setChecked(true);
                FrsGameCommentActivity.this.gyW.setChecked(true);
                FrsGameCommentActivity.this.gyX.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher gzb = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.gyZ.getText().length() > 0) {
                FrsGameCommentActivity.this.gyT.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.gyT, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.gyT.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.gyT, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener gzc = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.gza = getIntent().getIntExtra("forum_id", -1);
        initView();
        rT();
        registerListener();
        TiebaStatic.log(new an("c12340").Z("fid", this.gza));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.gyS = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.gyS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.gyS.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.gyS.showBottomLine(true);
        this.gyT = this.gyS.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bGj();
            }
        });
        this.gyT.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.gyT.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.gyT.setEnabled(false);
        this.gyU = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.gyU.setOnClickListener(this.mOnClickListener);
        this.gyV = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.gyV.setOnClickListener(this.mOnClickListener);
        this.gyW = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.gyW.setOnClickListener(this.mOnClickListener);
        this.gyX = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.gyX.setOnClickListener(this.mOnClickListener);
        this.gyY = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.gyY.setOnClickListener(this.mOnClickListener);
        this.gyZ = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.gyZ.addTextChangedListener(this.gzb);
        switch (this.mScore) {
            case 2:
                this.gyU.setChecked(true);
                this.gyV.setChecked(false);
                this.gyW.setChecked(false);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(false);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 6:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(false);
                this.gyY.setChecked(false);
                return;
            case 8:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(true);
                this.gyY.setChecked(false);
                return;
            case 10:
                this.gyU.setChecked(true);
                this.gyV.setChecked(true);
                this.gyW.setChecked(true);
                this.gyX.setChecked(true);
                this.gyY.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.gza);
        httpMessage.addParam("content", this.gyZ.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gzc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.gzc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.gyU, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gyV, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gyW, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gyX, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gyY, R.drawable.game_comment_score_btn_bg);
        if (this.gyT.isEnabled()) {
            am.setViewTextColor(this.gyT, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.gyT, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.gyZ.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
