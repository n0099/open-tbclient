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
    private NavigationBar fIg;
    private TextView fIh;
    private RadioButton fIi;
    private RadioButton fIj;
    private RadioButton fIk;
    private RadioButton fIl;
    private RadioButton fIm;
    private EditText fIn;
    private int fIo;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fIi) {
                FrsGameCommentActivity.this.fIj.setChecked(false);
                FrsGameCommentActivity.this.fIk.setChecked(false);
                FrsGameCommentActivity.this.fIl.setChecked(false);
                FrsGameCommentActivity.this.fIm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fIj) {
                FrsGameCommentActivity.this.fIi.setChecked(true);
                FrsGameCommentActivity.this.fIk.setChecked(false);
                FrsGameCommentActivity.this.fIl.setChecked(false);
                FrsGameCommentActivity.this.fIm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fIk) {
                FrsGameCommentActivity.this.fIi.setChecked(true);
                FrsGameCommentActivity.this.fIj.setChecked(true);
                FrsGameCommentActivity.this.fIl.setChecked(false);
                FrsGameCommentActivity.this.fIm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fIl) {
                FrsGameCommentActivity.this.fIi.setChecked(true);
                FrsGameCommentActivity.this.fIj.setChecked(true);
                FrsGameCommentActivity.this.fIk.setChecked(true);
                FrsGameCommentActivity.this.fIm.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fIm) {
                FrsGameCommentActivity.this.fIi.setChecked(true);
                FrsGameCommentActivity.this.fIj.setChecked(true);
                FrsGameCommentActivity.this.fIk.setChecked(true);
                FrsGameCommentActivity.this.fIl.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fIp = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fIn.getText().length() > 0) {
                FrsGameCommentActivity.this.fIh.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.fIh, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fIh.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.fIh, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fIq = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fIo = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").O("fid", this.fIo));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.fIg = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.fIg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.fIg.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.fIg.showBottomLine(true);
        this.fIh = this.fIg.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bnM();
            }
        });
        this.fIh.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fIh.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fIh.setEnabled(false);
        this.fIi = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fIi.setOnClickListener(this.mOnClickListener);
        this.fIj = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fIj.setOnClickListener(this.mOnClickListener);
        this.fIk = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fIk.setOnClickListener(this.mOnClickListener);
        this.fIl = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fIl.setOnClickListener(this.mOnClickListener);
        this.fIm = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fIm.setOnClickListener(this.mOnClickListener);
        this.fIn = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fIn.addTextChangedListener(this.fIp);
        switch (this.mScore) {
            case 2:
                this.fIi.setChecked(true);
                this.fIj.setChecked(false);
                this.fIk.setChecked(false);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(false);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 6:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(false);
                this.fIm.setChecked(false);
                return;
            case 8:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(true);
                this.fIm.setChecked(false);
                return;
            case 10:
                this.fIi.setChecked(true);
                this.fIj.setChecked(true);
                this.fIk.setChecked(true);
                this.fIl.setChecked(true);
                this.fIm.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fIo);
        httpMessage.addParam("content", this.fIn.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.fIq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.fIq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.fIi, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fIj, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fIk, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fIl, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.fIm, R.drawable.game_comment_score_btn_bg);
        if (this.fIh.isEnabled()) {
            am.setViewTextColor(this.fIh, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.fIh, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.fIn.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
