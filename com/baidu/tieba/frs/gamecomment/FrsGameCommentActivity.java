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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar enq;
    private TextView fBo;
    private RadioButton fBp;
    private RadioButton fBq;
    private RadioButton fBr;
    private RadioButton fBs;
    private RadioButton fBt;
    private EditText fBu;
    private int fBv;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fBp) {
                FrsGameCommentActivity.this.fBq.setChecked(false);
                FrsGameCommentActivity.this.fBr.setChecked(false);
                FrsGameCommentActivity.this.fBs.setChecked(false);
                FrsGameCommentActivity.this.fBt.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fBq) {
                FrsGameCommentActivity.this.fBp.setChecked(true);
                FrsGameCommentActivity.this.fBr.setChecked(false);
                FrsGameCommentActivity.this.fBs.setChecked(false);
                FrsGameCommentActivity.this.fBt.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fBr) {
                FrsGameCommentActivity.this.fBp.setChecked(true);
                FrsGameCommentActivity.this.fBq.setChecked(true);
                FrsGameCommentActivity.this.fBs.setChecked(false);
                FrsGameCommentActivity.this.fBt.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fBs) {
                FrsGameCommentActivity.this.fBp.setChecked(true);
                FrsGameCommentActivity.this.fBq.setChecked(true);
                FrsGameCommentActivity.this.fBr.setChecked(true);
                FrsGameCommentActivity.this.fBt.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fBt) {
                FrsGameCommentActivity.this.fBp.setChecked(true);
                FrsGameCommentActivity.this.fBq.setChecked(true);
                FrsGameCommentActivity.this.fBr.setChecked(true);
                FrsGameCommentActivity.this.fBs.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fBw = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fBu.getText().length() > 0) {
                FrsGameCommentActivity.this.fBo.setEnabled(true);
                al.j(FrsGameCommentActivity.this.fBo, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fBo.setEnabled(false);
            al.j(FrsGameCommentActivity.this.fBo, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fBx = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fBv = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").P("fid", this.fBv));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.enq = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.enq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.enq.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.enq.showBottomLine(true);
        this.fBo = this.enq.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.jS()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bnH();
            }
        });
        this.fBo.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fBo.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fBo.setEnabled(false);
        this.fBp = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fBp.setOnClickListener(this.mOnClickListener);
        this.fBq = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fBq.setOnClickListener(this.mOnClickListener);
        this.fBr = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fBr.setOnClickListener(this.mOnClickListener);
        this.fBs = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fBs.setOnClickListener(this.mOnClickListener);
        this.fBt = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fBt.setOnClickListener(this.mOnClickListener);
        this.fBu = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fBu.addTextChangedListener(this.fBw);
        switch (this.mScore) {
            case 2:
                this.fBp.setChecked(true);
                this.fBq.setChecked(false);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(false);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 6:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(false);
                this.fBt.setChecked(false);
                return;
            case 8:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(true);
                this.fBt.setChecked(false);
                return;
            case 10:
                this.fBp.setChecked(true);
                this.fBq.setChecked(true);
                this.fBr.setChecked(true);
                this.fBs.setChecked(true);
                this.fBt.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnH() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fBv);
        httpMessage.addParam("content", this.fBu.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fBx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.fBx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.fBp, R.drawable.game_comment_score_btn_bg);
        al.k(this.fBq, R.drawable.game_comment_score_btn_bg);
        al.k(this.fBr, R.drawable.game_comment_score_btn_bg);
        al.k(this.fBs, R.drawable.game_comment_score_btn_bg);
        al.k(this.fBt, R.drawable.game_comment_score_btn_bg);
        if (this.fBo.isEnabled()) {
            al.j(this.fBo, R.color.cp_link_tip_g);
        } else {
            al.j(this.fBo, R.color.cp_cont_e);
        }
        al.j(this.mTitle, R.color.cp_cont_b);
        if (i == 1) {
            this.fBu.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        } else {
            this.fBu.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        }
    }
}
