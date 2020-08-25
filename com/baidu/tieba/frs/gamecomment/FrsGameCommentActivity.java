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
    private RadioButton iiA;
    private RadioButton iiB;
    private RadioButton iiC;
    private RadioButton iiD;
    private EditText iiE;
    private int iiF;
    private NavigationBar iix;
    private TextView iiy;
    private RadioButton iiz;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iiz) {
                FrsGameCommentActivity.this.iiA.setChecked(false);
                FrsGameCommentActivity.this.iiB.setChecked(false);
                FrsGameCommentActivity.this.iiC.setChecked(false);
                FrsGameCommentActivity.this.iiD.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iiA) {
                FrsGameCommentActivity.this.iiz.setChecked(true);
                FrsGameCommentActivity.this.iiB.setChecked(false);
                FrsGameCommentActivity.this.iiC.setChecked(false);
                FrsGameCommentActivity.this.iiD.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iiB) {
                FrsGameCommentActivity.this.iiz.setChecked(true);
                FrsGameCommentActivity.this.iiA.setChecked(true);
                FrsGameCommentActivity.this.iiC.setChecked(false);
                FrsGameCommentActivity.this.iiD.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iiC) {
                FrsGameCommentActivity.this.iiz.setChecked(true);
                FrsGameCommentActivity.this.iiA.setChecked(true);
                FrsGameCommentActivity.this.iiB.setChecked(true);
                FrsGameCommentActivity.this.iiD.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iiD) {
                FrsGameCommentActivity.this.iiz.setChecked(true);
                FrsGameCommentActivity.this.iiA.setChecked(true);
                FrsGameCommentActivity.this.iiB.setChecked(true);
                FrsGameCommentActivity.this.iiC.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iiG = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iiE.getText().length() > 0) {
                FrsGameCommentActivity.this.iiy.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iiy, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iiy.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iiy, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener iiH = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.iiF = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").ai("fid", this.iiF));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iix = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iix.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iix.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iix.showBottomLine(true);
        this.iiy = this.iix.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cqv();
            }
        });
        this.iiy.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iiy.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.iiy.setEnabled(false);
        this.iiz = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iiz.setOnClickListener(this.mOnClickListener);
        this.iiA = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iiA.setOnClickListener(this.mOnClickListener);
        this.iiB = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iiB.setOnClickListener(this.mOnClickListener);
        this.iiC = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iiC.setOnClickListener(this.mOnClickListener);
        this.iiD = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iiD.setOnClickListener(this.mOnClickListener);
        this.iiE = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iiE.addTextChangedListener(this.iiG);
        switch (this.mScore) {
            case 2:
                this.iiz.setChecked(true);
                this.iiA.setChecked(false);
                this.iiB.setChecked(false);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(false);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 6:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(false);
                this.iiD.setChecked(false);
                return;
            case 8:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(true);
                this.iiD.setChecked(false);
                return;
            case 10:
                this.iiz.setChecked(true);
                this.iiA.setChecked(true);
                this.iiB.setChecked(true);
                this.iiC.setChecked(true);
                this.iiD.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqv() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iiF);
        httpMessage.addParam("content", this.iiE.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.iiH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iiH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iiz, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiA, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiB, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiC, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iiD, R.drawable.game_comment_score_btn_bg);
        if (this.iiy.isEnabled()) {
            ap.setViewTextColor(this.iiy, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iiy, (int) R.color.cp_cont_e);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.iiE.setHintTextColor(ap.getColor(R.color.cp_cont_d));
    }
}
