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
    private NavigationBar gBg;
    private TextView gBh;
    private RadioButton gBi;
    private RadioButton gBj;
    private RadioButton gBk;
    private RadioButton gBl;
    private RadioButton gBm;
    private EditText gBn;
    private int gBo;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.gBi) {
                FrsGameCommentActivity.this.gBj.setChecked(false);
                FrsGameCommentActivity.this.gBk.setChecked(false);
                FrsGameCommentActivity.this.gBl.setChecked(false);
                FrsGameCommentActivity.this.gBm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.gBj) {
                FrsGameCommentActivity.this.gBi.setChecked(true);
                FrsGameCommentActivity.this.gBk.setChecked(false);
                FrsGameCommentActivity.this.gBl.setChecked(false);
                FrsGameCommentActivity.this.gBm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.gBk) {
                FrsGameCommentActivity.this.gBi.setChecked(true);
                FrsGameCommentActivity.this.gBj.setChecked(true);
                FrsGameCommentActivity.this.gBl.setChecked(false);
                FrsGameCommentActivity.this.gBm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.gBl) {
                FrsGameCommentActivity.this.gBi.setChecked(true);
                FrsGameCommentActivity.this.gBj.setChecked(true);
                FrsGameCommentActivity.this.gBk.setChecked(true);
                FrsGameCommentActivity.this.gBm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.gBm) {
                FrsGameCommentActivity.this.gBi.setChecked(true);
                FrsGameCommentActivity.this.gBj.setChecked(true);
                FrsGameCommentActivity.this.gBk.setChecked(true);
                FrsGameCommentActivity.this.gBl.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher gBp = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.gBn.getText().length() > 0) {
                FrsGameCommentActivity.this.gBh.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.gBh, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.gBh.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.gBh, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener gBq = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.gBo = getIntent().getIntExtra("forum_id", -1);
        initView();
        te();
        registerListener();
        TiebaStatic.log(new an("c12340").X("fid", this.gBo));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.gBg = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.gBg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.gBg.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.gBg.showBottomLine(true);
        this.gBh = this.gBg.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bHO();
            }
        });
        this.gBh.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.gBh.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.gBh.setEnabled(false);
        this.gBi = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.gBi.setOnClickListener(this.mOnClickListener);
        this.gBj = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.gBj.setOnClickListener(this.mOnClickListener);
        this.gBk = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.gBk.setOnClickListener(this.mOnClickListener);
        this.gBl = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.gBl.setOnClickListener(this.mOnClickListener);
        this.gBm = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.gBm.setOnClickListener(this.mOnClickListener);
        this.gBn = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.gBn.addTextChangedListener(this.gBp);
        switch (this.mScore) {
            case 2:
                this.gBi.setChecked(true);
                this.gBj.setChecked(false);
                this.gBk.setChecked(false);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(false);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 6:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(false);
                this.gBm.setChecked(false);
                return;
            case 8:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(true);
                this.gBm.setChecked(false);
                return;
            case 10:
                this.gBi.setChecked(true);
                this.gBj.setChecked(true);
                this.gBk.setChecked(true);
                this.gBl.setChecked(true);
                this.gBm.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHO() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.gBo);
        httpMessage.addParam("content", this.gBn.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.gBq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.gBq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.gBi, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gBj, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gBk, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gBl, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gBm, R.drawable.game_comment_score_btn_bg);
        if (this.gBh.isEnabled()) {
            am.setViewTextColor(this.gBh, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.gBh, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.gBn.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
