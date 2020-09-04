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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar iiD;
    private TextView iiE;
    private RadioButton iiF;
    private RadioButton iiG;
    private RadioButton iiH;
    private RadioButton iiI;
    private RadioButton iiJ;
    private EditText iiK;
    private int iiL;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iiF) {
                FrsGameCommentActivity.this.iiG.setChecked(false);
                FrsGameCommentActivity.this.iiH.setChecked(false);
                FrsGameCommentActivity.this.iiI.setChecked(false);
                FrsGameCommentActivity.this.iiJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iiG) {
                FrsGameCommentActivity.this.iiF.setChecked(true);
                FrsGameCommentActivity.this.iiH.setChecked(false);
                FrsGameCommentActivity.this.iiI.setChecked(false);
                FrsGameCommentActivity.this.iiJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iiH) {
                FrsGameCommentActivity.this.iiF.setChecked(true);
                FrsGameCommentActivity.this.iiG.setChecked(true);
                FrsGameCommentActivity.this.iiI.setChecked(false);
                FrsGameCommentActivity.this.iiJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iiI) {
                FrsGameCommentActivity.this.iiF.setChecked(true);
                FrsGameCommentActivity.this.iiG.setChecked(true);
                FrsGameCommentActivity.this.iiH.setChecked(true);
                FrsGameCommentActivity.this.iiJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iiJ) {
                FrsGameCommentActivity.this.iiF.setChecked(true);
                FrsGameCommentActivity.this.iiG.setChecked(true);
                FrsGameCommentActivity.this.iiH.setChecked(true);
                FrsGameCommentActivity.this.iiI.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iiM = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iiK.getText().length() > 0) {
                FrsGameCommentActivity.this.iiE.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iiE, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iiE.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iiE, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener iiN = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.iiL = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").ai("fid", this.iiL));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iiD = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iiD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iiD.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iiD.showBottomLine(true);
        this.iiE = this.iiD.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cqw();
            }
        });
        this.iiE.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iiE.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.iiE.setEnabled(false);
        this.iiF = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iiF.setOnClickListener(this.mOnClickListener);
        this.iiG = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iiG.setOnClickListener(this.mOnClickListener);
        this.iiH = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iiH.setOnClickListener(this.mOnClickListener);
        this.iiI = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iiI.setOnClickListener(this.mOnClickListener);
        this.iiJ = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iiJ.setOnClickListener(this.mOnClickListener);
        this.iiK = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iiK.addTextChangedListener(this.iiM);
        switch (this.mScore) {
            case 2:
                this.iiF.setChecked(true);
                this.iiG.setChecked(false);
                this.iiH.setChecked(false);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(false);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 6:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(false);
                this.iiJ.setChecked(false);
                return;
            case 8:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(true);
                this.iiJ.setChecked(false);
                return;
            case 10:
                this.iiF.setChecked(true);
                this.iiG.setChecked(true);
                this.iiH.setChecked(true);
                this.iiI.setChecked(true);
                this.iiJ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqw() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iiL);
        httpMessage.addParam("content", this.iiK.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.iiN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iiN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iiF, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiG, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiH, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiI, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiJ, R.drawable.game_comment_score_btn_bg);
        if (this.iiE.isEnabled()) {
            ap.setViewTextColor(this.iiE, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iiE, (int) R.color.cp_cont_e);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.iiK.setHintTextColor(ap.getColor(R.color.cp_cont_d));
    }
}
