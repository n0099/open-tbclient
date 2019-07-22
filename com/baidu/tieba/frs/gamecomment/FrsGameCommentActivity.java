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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar esp;
    private TextView fGm;
    private RadioButton fGn;
    private RadioButton fGo;
    private RadioButton fGp;
    private RadioButton fGq;
    private RadioButton fGr;
    private EditText fGs;
    private int fGt;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fGn) {
                FrsGameCommentActivity.this.fGo.setChecked(false);
                FrsGameCommentActivity.this.fGp.setChecked(false);
                FrsGameCommentActivity.this.fGq.setChecked(false);
                FrsGameCommentActivity.this.fGr.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fGo) {
                FrsGameCommentActivity.this.fGn.setChecked(true);
                FrsGameCommentActivity.this.fGp.setChecked(false);
                FrsGameCommentActivity.this.fGq.setChecked(false);
                FrsGameCommentActivity.this.fGr.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fGp) {
                FrsGameCommentActivity.this.fGn.setChecked(true);
                FrsGameCommentActivity.this.fGo.setChecked(true);
                FrsGameCommentActivity.this.fGq.setChecked(false);
                FrsGameCommentActivity.this.fGr.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fGq) {
                FrsGameCommentActivity.this.fGn.setChecked(true);
                FrsGameCommentActivity.this.fGo.setChecked(true);
                FrsGameCommentActivity.this.fGp.setChecked(true);
                FrsGameCommentActivity.this.fGr.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fGr) {
                FrsGameCommentActivity.this.fGn.setChecked(true);
                FrsGameCommentActivity.this.fGo.setChecked(true);
                FrsGameCommentActivity.this.fGp.setChecked(true);
                FrsGameCommentActivity.this.fGq.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fGu = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fGs.getText().length() > 0) {
                FrsGameCommentActivity.this.fGm.setEnabled(true);
                am.j(FrsGameCommentActivity.this.fGm, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fGm.setEnabled(false);
            am.j(FrsGameCommentActivity.this.fGm, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fGv = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fGt = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").P("fid", this.fGt));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.esp = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.esp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.esp.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.esp.showBottomLine(true);
        this.fGm = this.esp.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kc()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bpI();
            }
        });
        this.fGm.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fGm.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fGm.setEnabled(false);
        this.fGn = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fGn.setOnClickListener(this.mOnClickListener);
        this.fGo = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fGo.setOnClickListener(this.mOnClickListener);
        this.fGp = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fGp.setOnClickListener(this.mOnClickListener);
        this.fGq = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fGq.setOnClickListener(this.mOnClickListener);
        this.fGr = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fGr.setOnClickListener(this.mOnClickListener);
        this.fGs = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fGs.addTextChangedListener(this.fGu);
        switch (this.mScore) {
            case 2:
                this.fGn.setChecked(true);
                this.fGo.setChecked(false);
                this.fGp.setChecked(false);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(false);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 6:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(false);
                this.fGr.setChecked(false);
                return;
            case 8:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(true);
                this.fGr.setChecked(false);
                return;
            case 10:
                this.fGn.setChecked(true);
                this.fGo.setChecked(true);
                this.fGp.setChecked(true);
                this.fGq.setChecked(true);
                this.fGr.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpI() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fGt);
        httpMessage.addParam("content", this.fGs.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.fGv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.fGv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.k(this.fGn, R.drawable.game_comment_score_btn_bg);
        am.k(this.fGo, R.drawable.game_comment_score_btn_bg);
        am.k(this.fGp, R.drawable.game_comment_score_btn_bg);
        am.k(this.fGq, R.drawable.game_comment_score_btn_bg);
        am.k(this.fGr, R.drawable.game_comment_score_btn_bg);
        if (this.fGm.isEnabled()) {
            am.j(this.fGm, R.color.cp_link_tip_g);
        } else {
            am.j(this.fGm, R.color.cp_cont_e);
        }
        am.j(this.mTitle, R.color.cp_cont_b);
        if (i == 1) {
            this.fGs.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        } else {
            this.fGs.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        }
    }
}
