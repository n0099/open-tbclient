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
    private NavigationBar gCe;
    private TextView gCf;
    private RadioButton gCg;
    private RadioButton gCh;
    private RadioButton gCi;
    private RadioButton gCj;
    private RadioButton gCk;
    private EditText gCl;
    private int gCm;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.gCg) {
                FrsGameCommentActivity.this.gCh.setChecked(false);
                FrsGameCommentActivity.this.gCi.setChecked(false);
                FrsGameCommentActivity.this.gCj.setChecked(false);
                FrsGameCommentActivity.this.gCk.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.gCh) {
                FrsGameCommentActivity.this.gCg.setChecked(true);
                FrsGameCommentActivity.this.gCi.setChecked(false);
                FrsGameCommentActivity.this.gCj.setChecked(false);
                FrsGameCommentActivity.this.gCk.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.gCi) {
                FrsGameCommentActivity.this.gCg.setChecked(true);
                FrsGameCommentActivity.this.gCh.setChecked(true);
                FrsGameCommentActivity.this.gCj.setChecked(false);
                FrsGameCommentActivity.this.gCk.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.gCj) {
                FrsGameCommentActivity.this.gCg.setChecked(true);
                FrsGameCommentActivity.this.gCh.setChecked(true);
                FrsGameCommentActivity.this.gCi.setChecked(true);
                FrsGameCommentActivity.this.gCk.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.gCk) {
                FrsGameCommentActivity.this.gCg.setChecked(true);
                FrsGameCommentActivity.this.gCh.setChecked(true);
                FrsGameCommentActivity.this.gCi.setChecked(true);
                FrsGameCommentActivity.this.gCj.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher gCn = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.gCl.getText().length() > 0) {
                FrsGameCommentActivity.this.gCf.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.gCf, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.gCf.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.gCf, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener gCo = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.gCm = getIntent().getIntExtra("forum_id", -1);
        initView();
        tj();
        registerListener();
        TiebaStatic.log(new an("c12340").X("fid", this.gCm));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.gCe = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.gCe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.gCe.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.gCe.showBottomLine(true);
        this.gCf = this.gCe.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bIa();
            }
        });
        this.gCf.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.gCf.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.gCf.setEnabled(false);
        this.gCg = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.gCg.setOnClickListener(this.mOnClickListener);
        this.gCh = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.gCh.setOnClickListener(this.mOnClickListener);
        this.gCi = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.gCi.setOnClickListener(this.mOnClickListener);
        this.gCj = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.gCj.setOnClickListener(this.mOnClickListener);
        this.gCk = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.gCk.setOnClickListener(this.mOnClickListener);
        this.gCl = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.gCl.addTextChangedListener(this.gCn);
        switch (this.mScore) {
            case 2:
                this.gCg.setChecked(true);
                this.gCh.setChecked(false);
                this.gCi.setChecked(false);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(false);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 6:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(false);
                this.gCk.setChecked(false);
                return;
            case 8:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(true);
                this.gCk.setChecked(false);
                return;
            case 10:
                this.gCg.setChecked(true);
                this.gCh.setChecked(true);
                this.gCi.setChecked(true);
                this.gCj.setChecked(true);
                this.gCk.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIa() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.gCm);
        httpMessage.addParam("content", this.gCl.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void tj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gCo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.gCo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.gCg, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gCh, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gCi, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gCj, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.gCk, R.drawable.game_comment_score_btn_bg);
        if (this.gCf.isEnabled()) {
            am.setViewTextColor(this.gCf, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.gCf, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.gCl.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
