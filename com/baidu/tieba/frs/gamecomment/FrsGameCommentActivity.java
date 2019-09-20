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
    private NavigationBar euh;
    private TextView fIP;
    private RadioButton fIQ;
    private RadioButton fIR;
    private RadioButton fIS;
    private RadioButton fIT;
    private RadioButton fIU;
    private EditText fIV;
    private int fIW;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fIQ) {
                FrsGameCommentActivity.this.fIR.setChecked(false);
                FrsGameCommentActivity.this.fIS.setChecked(false);
                FrsGameCommentActivity.this.fIT.setChecked(false);
                FrsGameCommentActivity.this.fIU.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fIR) {
                FrsGameCommentActivity.this.fIQ.setChecked(true);
                FrsGameCommentActivity.this.fIS.setChecked(false);
                FrsGameCommentActivity.this.fIT.setChecked(false);
                FrsGameCommentActivity.this.fIU.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fIS) {
                FrsGameCommentActivity.this.fIQ.setChecked(true);
                FrsGameCommentActivity.this.fIR.setChecked(true);
                FrsGameCommentActivity.this.fIT.setChecked(false);
                FrsGameCommentActivity.this.fIU.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fIT) {
                FrsGameCommentActivity.this.fIQ.setChecked(true);
                FrsGameCommentActivity.this.fIR.setChecked(true);
                FrsGameCommentActivity.this.fIS.setChecked(true);
                FrsGameCommentActivity.this.fIU.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fIU) {
                FrsGameCommentActivity.this.fIQ.setChecked(true);
                FrsGameCommentActivity.this.fIR.setChecked(true);
                FrsGameCommentActivity.this.fIS.setChecked(true);
                FrsGameCommentActivity.this.fIT.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fIX = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fIV.getText().length() > 0) {
                FrsGameCommentActivity.this.fIP.setEnabled(true);
                am.j(FrsGameCommentActivity.this.fIP, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fIP.setEnabled(false);
            am.j(FrsGameCommentActivity.this.fIP, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener fIY = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fIW = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").P("fid", this.fIW));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.euh = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.euh.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.euh.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.euh.showBottomLine(true);
        this.fIP = this.euh.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kc()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bqH();
            }
        });
        this.fIP.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.fIP.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.fIP.setEnabled(false);
        this.fIQ = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.fIQ.setOnClickListener(this.mOnClickListener);
        this.fIR = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.fIR.setOnClickListener(this.mOnClickListener);
        this.fIS = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.fIS.setOnClickListener(this.mOnClickListener);
        this.fIT = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.fIT.setOnClickListener(this.mOnClickListener);
        this.fIU = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.fIU.setOnClickListener(this.mOnClickListener);
        this.fIV = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.fIV.addTextChangedListener(this.fIX);
        switch (this.mScore) {
            case 2:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(false);
                this.fIS.setChecked(false);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(false);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 6:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(false);
                this.fIU.setChecked(false);
                return;
            case 8:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(true);
                this.fIU.setChecked(false);
                return;
            case 10:
                this.fIQ.setChecked(true);
                this.fIR.setChecked(true);
                this.fIS.setChecked(true);
                this.fIT.setChecked(true);
                this.fIU.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqH() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fIW);
        httpMessage.addParam("content", this.fIV.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.fIY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.fIY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.k(this.fIQ, R.drawable.game_comment_score_btn_bg);
        am.k(this.fIR, R.drawable.game_comment_score_btn_bg);
        am.k(this.fIS, R.drawable.game_comment_score_btn_bg);
        am.k(this.fIT, R.drawable.game_comment_score_btn_bg);
        am.k(this.fIU, R.drawable.game_comment_score_btn_bg);
        if (this.fIP.isEnabled()) {
            am.j(this.fIP, R.color.cp_link_tip_g);
        } else {
            am.j(this.fIP, R.color.cp_cont_e);
        }
        am.j(this.mTitle, R.color.cp_cont_b);
        this.fIV.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
