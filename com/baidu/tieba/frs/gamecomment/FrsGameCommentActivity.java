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
/* loaded from: classes4.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar fHp;
    private TextView fHq;
    private RadioButton fHr;
    private RadioButton fHs;
    private RadioButton fHt;
    private RadioButton fHu;
    private RadioButton fHv;
    private EditText fHw;
    private int fHx;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fHr) {
                FrsGameCommentActivity.this.fHs.setChecked(false);
                FrsGameCommentActivity.this.fHt.setChecked(false);
                FrsGameCommentActivity.this.fHu.setChecked(false);
                FrsGameCommentActivity.this.fHv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fHs) {
                FrsGameCommentActivity.this.fHr.setChecked(true);
                FrsGameCommentActivity.this.fHt.setChecked(false);
                FrsGameCommentActivity.this.fHu.setChecked(false);
                FrsGameCommentActivity.this.fHv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fHt) {
                FrsGameCommentActivity.this.fHr.setChecked(true);
                FrsGameCommentActivity.this.fHs.setChecked(true);
                FrsGameCommentActivity.this.fHu.setChecked(false);
                FrsGameCommentActivity.this.fHv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fHu) {
                FrsGameCommentActivity.this.fHr.setChecked(true);
                FrsGameCommentActivity.this.fHs.setChecked(true);
                FrsGameCommentActivity.this.fHt.setChecked(true);
                FrsGameCommentActivity.this.fHv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fHv) {
                FrsGameCommentActivity.this.fHr.setChecked(true);
                FrsGameCommentActivity.this.fHs.setChecked(true);
                FrsGameCommentActivity.this.fHt.setChecked(true);
                FrsGameCommentActivity.this.fHu.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fHy = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fHw.getText().length() > 0) {
                FrsGameCommentActivity.this.fHq.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.fHq, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fHq.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.fHq, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fHz = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fHx = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").O("fid", this.fHx));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.fHp = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.fHp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.fHp.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.fHp.showBottomLine(true);
        this.fHq = this.fHp.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bnK();
            }
        });
        this.fHq.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fHq.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fHq.setEnabled(false);
        this.fHr = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fHr.setOnClickListener(this.mOnClickListener);
        this.fHs = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fHs.setOnClickListener(this.mOnClickListener);
        this.fHt = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fHt.setOnClickListener(this.mOnClickListener);
        this.fHu = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fHu.setOnClickListener(this.mOnClickListener);
        this.fHv = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fHv.setOnClickListener(this.mOnClickListener);
        this.fHw = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fHw.addTextChangedListener(this.fHy);
        switch (this.mScore) {
            case 2:
                this.fHr.setChecked(true);
                this.fHs.setChecked(false);
                this.fHt.setChecked(false);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(false);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 6:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(false);
                this.fHv.setChecked(false);
                return;
            case 8:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(true);
                this.fHv.setChecked(false);
                return;
            case 10:
                this.fHr.setChecked(true);
                this.fHs.setChecked(true);
                this.fHt.setChecked(true);
                this.fHu.setChecked(true);
                this.fHv.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnK() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fHx);
        httpMessage.addParam("content", this.fHw.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fHz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.fHz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.fHr, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fHs, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fHt, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fHu, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fHv, R.drawable.game_comment_score_btn_bg);
        if (this.fHq.isEnabled()) {
            am.setViewTextColor(this.fHq, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.fHq, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.fHw.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
