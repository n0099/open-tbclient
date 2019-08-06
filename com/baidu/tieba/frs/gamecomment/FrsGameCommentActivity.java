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
    private NavigationBar esw;
    private TextView fHa;
    private RadioButton fHb;
    private RadioButton fHc;
    private RadioButton fHd;
    private RadioButton fHe;
    private RadioButton fHf;
    private EditText fHg;
    private int fHh;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fHb) {
                FrsGameCommentActivity.this.fHc.setChecked(false);
                FrsGameCommentActivity.this.fHd.setChecked(false);
                FrsGameCommentActivity.this.fHe.setChecked(false);
                FrsGameCommentActivity.this.fHf.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fHc) {
                FrsGameCommentActivity.this.fHb.setChecked(true);
                FrsGameCommentActivity.this.fHd.setChecked(false);
                FrsGameCommentActivity.this.fHe.setChecked(false);
                FrsGameCommentActivity.this.fHf.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fHd) {
                FrsGameCommentActivity.this.fHb.setChecked(true);
                FrsGameCommentActivity.this.fHc.setChecked(true);
                FrsGameCommentActivity.this.fHe.setChecked(false);
                FrsGameCommentActivity.this.fHf.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fHe) {
                FrsGameCommentActivity.this.fHb.setChecked(true);
                FrsGameCommentActivity.this.fHc.setChecked(true);
                FrsGameCommentActivity.this.fHd.setChecked(true);
                FrsGameCommentActivity.this.fHf.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fHf) {
                FrsGameCommentActivity.this.fHb.setChecked(true);
                FrsGameCommentActivity.this.fHc.setChecked(true);
                FrsGameCommentActivity.this.fHd.setChecked(true);
                FrsGameCommentActivity.this.fHe.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fHi = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fHg.getText().length() > 0) {
                FrsGameCommentActivity.this.fHa.setEnabled(true);
                am.j(FrsGameCommentActivity.this.fHa, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fHa.setEnabled(false);
            am.j(FrsGameCommentActivity.this.fHa, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fHj = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fHh = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").P("fid", this.fHh));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.esw = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.esw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.esw.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.esw.showBottomLine(true);
        this.fHa = this.esw.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kc()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bpV();
            }
        });
        this.fHa.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fHa.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fHa.setEnabled(false);
        this.fHb = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fHb.setOnClickListener(this.mOnClickListener);
        this.fHc = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fHc.setOnClickListener(this.mOnClickListener);
        this.fHd = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fHd.setOnClickListener(this.mOnClickListener);
        this.fHe = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fHe.setOnClickListener(this.mOnClickListener);
        this.fHf = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fHf.setOnClickListener(this.mOnClickListener);
        this.fHg = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fHg.addTextChangedListener(this.fHi);
        switch (this.mScore) {
            case 2:
                this.fHb.setChecked(true);
                this.fHc.setChecked(false);
                this.fHd.setChecked(false);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(false);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 6:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(false);
                this.fHf.setChecked(false);
                return;
            case 8:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(true);
                this.fHf.setChecked(false);
                return;
            case 10:
                this.fHb.setChecked(true);
                this.fHc.setChecked(true);
                this.fHd.setChecked(true);
                this.fHe.setChecked(true);
                this.fHf.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpV() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fHh);
        httpMessage.addParam("content", this.fHg.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.fHj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.fHj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.k(this.fHb, R.drawable.game_comment_score_btn_bg);
        am.k(this.fHc, R.drawable.game_comment_score_btn_bg);
        am.k(this.fHd, R.drawable.game_comment_score_btn_bg);
        am.k(this.fHe, R.drawable.game_comment_score_btn_bg);
        am.k(this.fHf, R.drawable.game_comment_score_btn_bg);
        if (this.fHa.isEnabled()) {
            am.j(this.fHa, R.color.cp_link_tip_g);
        } else {
            am.j(this.fHa, R.color.cp_cont_e);
        }
        am.j(this.mTitle, R.color.cp_cont_b);
        if (i == 1) {
            this.fHg.setHintTextColor(getResources().getColor(R.color.cp_cont_d_1));
        } else {
            this.fHg.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        }
    }
}
