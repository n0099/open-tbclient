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
import com.baidu.ar.gesture.GestureAR;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar hlG;
    private TextView hlH;
    private RadioButton hlI;
    private RadioButton hlJ;
    private RadioButton hlK;
    private RadioButton hlL;
    private RadioButton hlM;
    private EditText hlN;
    private int hlO;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.hlI) {
                FrsGameCommentActivity.this.hlJ.setChecked(false);
                FrsGameCommentActivity.this.hlK.setChecked(false);
                FrsGameCommentActivity.this.hlL.setChecked(false);
                FrsGameCommentActivity.this.hlM.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.hlJ) {
                FrsGameCommentActivity.this.hlI.setChecked(true);
                FrsGameCommentActivity.this.hlK.setChecked(false);
                FrsGameCommentActivity.this.hlL.setChecked(false);
                FrsGameCommentActivity.this.hlM.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.hlK) {
                FrsGameCommentActivity.this.hlI.setChecked(true);
                FrsGameCommentActivity.this.hlJ.setChecked(true);
                FrsGameCommentActivity.this.hlL.setChecked(false);
                FrsGameCommentActivity.this.hlM.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.hlL) {
                FrsGameCommentActivity.this.hlI.setChecked(true);
                FrsGameCommentActivity.this.hlJ.setChecked(true);
                FrsGameCommentActivity.this.hlK.setChecked(true);
                FrsGameCommentActivity.this.hlM.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.hlM) {
                FrsGameCommentActivity.this.hlI.setChecked(true);
                FrsGameCommentActivity.this.hlJ.setChecked(true);
                FrsGameCommentActivity.this.hlK.setChecked(true);
                FrsGameCommentActivity.this.hlL.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher hlP = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.hlN.getText().length() > 0) {
                FrsGameCommentActivity.this.hlH.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.hlH, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.hlH.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.hlH, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener hlQ = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.mScore = getIntent().getIntExtra(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, 0);
        this.hlO = getIntent().getIntExtra("forum_id", -1);
        initView();
        xB();
        registerListener();
        TiebaStatic.log(new an("c12340").af("fid", this.hlO));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.hlG = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.hlG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.hlG.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.hlG.showBottomLine(true);
        this.hlH = this.hlG.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bSy();
            }
        });
        this.hlH.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.hlH.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.hlH.setEnabled(false);
        this.hlI = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.hlI.setOnClickListener(this.mOnClickListener);
        this.hlJ = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.hlJ.setOnClickListener(this.mOnClickListener);
        this.hlK = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.hlK.setOnClickListener(this.mOnClickListener);
        this.hlL = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.hlL.setOnClickListener(this.mOnClickListener);
        this.hlM = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.hlM.setOnClickListener(this.mOnClickListener);
        this.hlN = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.hlN.addTextChangedListener(this.hlP);
        switch (this.mScore) {
            case 2:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(false);
                this.hlK.setChecked(false);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(false);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 6:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(false);
                this.hlM.setChecked(false);
                return;
            case 8:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(true);
                this.hlM.setChecked(false);
                return;
            case 10:
                this.hlI.setChecked(true);
                this.hlJ.setChecked(true);
                this.hlK.setChecked(true);
                this.hlL.setChecked(true);
                this.hlM.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.hlO);
        httpMessage.addParam("content", this.hlN.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void xB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hlQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.hlQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.hlI, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hlJ, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hlK, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hlL, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hlM, R.drawable.game_comment_score_btn_bg);
        if (this.hlH.isEnabled()) {
            am.setViewTextColor(this.hlH, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.hlH, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.hlN.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
