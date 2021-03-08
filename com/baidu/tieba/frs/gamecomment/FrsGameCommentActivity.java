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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar jAA;
    private TextView jAB;
    private RadioButton jAC;
    private RadioButton jAD;
    private RadioButton jAE;
    private RadioButton jAF;
    private RadioButton jAG;
    private EditText jAH;
    private int jAI;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.jAC) {
                FrsGameCommentActivity.this.jAD.setChecked(false);
                FrsGameCommentActivity.this.jAE.setChecked(false);
                FrsGameCommentActivity.this.jAF.setChecked(false);
                FrsGameCommentActivity.this.jAG.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.jAD) {
                FrsGameCommentActivity.this.jAC.setChecked(true);
                FrsGameCommentActivity.this.jAE.setChecked(false);
                FrsGameCommentActivity.this.jAF.setChecked(false);
                FrsGameCommentActivity.this.jAG.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.jAE) {
                FrsGameCommentActivity.this.jAC.setChecked(true);
                FrsGameCommentActivity.this.jAD.setChecked(true);
                FrsGameCommentActivity.this.jAF.setChecked(false);
                FrsGameCommentActivity.this.jAG.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.jAF) {
                FrsGameCommentActivity.this.jAC.setChecked(true);
                FrsGameCommentActivity.this.jAD.setChecked(true);
                FrsGameCommentActivity.this.jAE.setChecked(true);
                FrsGameCommentActivity.this.jAG.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.jAG) {
                FrsGameCommentActivity.this.jAC.setChecked(true);
                FrsGameCommentActivity.this.jAD.setChecked(true);
                FrsGameCommentActivity.this.jAE.setChecked(true);
                FrsGameCommentActivity.this.jAF.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher jAJ = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.jAH.getText().length() > 0) {
                FrsGameCommentActivity.this.jAB.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.jAB, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.jAB.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.jAB, R.color.CAM_X0110);
        }
    };
    private HttpMessageListener jAK = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.jAI = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ar("c12340").aq("fid", this.jAI));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.jAA = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.jAA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.jAA.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.jAA.showBottomLine(true);
        this.jAB = this.jAA.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cIn();
            }
        });
        this.jAB.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.jAB.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.jAB.setEnabled(false);
        this.jAC = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.jAC.setOnClickListener(this.mOnClickListener);
        this.jAD = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.jAD.setOnClickListener(this.mOnClickListener);
        this.jAE = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.jAE.setOnClickListener(this.mOnClickListener);
        this.jAF = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.jAF.setOnClickListener(this.mOnClickListener);
        this.jAG = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.jAG.setOnClickListener(this.mOnClickListener);
        this.jAH = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.jAH.addTextChangedListener(this.jAJ);
        switch (this.mScore) {
            case 2:
                this.jAC.setChecked(true);
                this.jAD.setChecked(false);
                this.jAE.setChecked(false);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(false);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 6:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(false);
                this.jAG.setChecked(false);
                return;
            case 8:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(true);
                this.jAG.setChecked(false);
                return;
            case 10:
                this.jAC.setChecked(true);
                this.jAD.setChecked(true);
                this.jAE.setChecked(true);
                this.jAF.setChecked(true);
                this.jAG.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIn() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.jAI);
        httpMessage.addParam("content", this.jAH.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.jAK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.jAK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.jAC, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jAD, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jAE, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jAF, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jAG, R.drawable.game_comment_score_btn_bg);
        if (this.jAB.isEnabled()) {
            ap.setViewTextColor(this.jAB, R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.jAB, R.color.CAM_X0110);
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        this.jAH.setHintTextColor(ap.getColor(R.color.CAM_X0109));
    }
}
