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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar jxD;
    private TextView jxE;
    private RadioButton jxF;
    private RadioButton jxG;
    private RadioButton jxH;
    private RadioButton jxI;
    private RadioButton jxJ;
    private EditText jxK;
    private int jxL;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.jxF) {
                FrsGameCommentActivity.this.jxG.setChecked(false);
                FrsGameCommentActivity.this.jxH.setChecked(false);
                FrsGameCommentActivity.this.jxI.setChecked(false);
                FrsGameCommentActivity.this.jxJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.jxG) {
                FrsGameCommentActivity.this.jxF.setChecked(true);
                FrsGameCommentActivity.this.jxH.setChecked(false);
                FrsGameCommentActivity.this.jxI.setChecked(false);
                FrsGameCommentActivity.this.jxJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.jxH) {
                FrsGameCommentActivity.this.jxF.setChecked(true);
                FrsGameCommentActivity.this.jxG.setChecked(true);
                FrsGameCommentActivity.this.jxI.setChecked(false);
                FrsGameCommentActivity.this.jxJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.jxI) {
                FrsGameCommentActivity.this.jxF.setChecked(true);
                FrsGameCommentActivity.this.jxG.setChecked(true);
                FrsGameCommentActivity.this.jxH.setChecked(true);
                FrsGameCommentActivity.this.jxJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.jxJ) {
                FrsGameCommentActivity.this.jxF.setChecked(true);
                FrsGameCommentActivity.this.jxG.setChecked(true);
                FrsGameCommentActivity.this.jxH.setChecked(true);
                FrsGameCommentActivity.this.jxI.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher jxM = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.jxK.getText().length() > 0) {
                FrsGameCommentActivity.this.jxE.setEnabled(true);
                ao.setViewTextColor(FrsGameCommentActivity.this.jxE, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.jxE.setEnabled(false);
            ao.setViewTextColor(FrsGameCommentActivity.this.jxE, R.color.CAM_X0110);
        }
    };
    private HttpMessageListener jxN = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.jxL = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").an("fid", this.jxL));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.jxD = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.jxD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.jxD.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.jxD.showBottomLine(true);
        this.jxE = this.jxD.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cKF();
            }
        });
        this.jxE.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.jxE.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.jxE.setEnabled(false);
        this.jxF = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.jxF.setOnClickListener(this.mOnClickListener);
        this.jxG = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.jxG.setOnClickListener(this.mOnClickListener);
        this.jxH = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.jxH.setOnClickListener(this.mOnClickListener);
        this.jxI = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.jxI.setOnClickListener(this.mOnClickListener);
        this.jxJ = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.jxJ.setOnClickListener(this.mOnClickListener);
        this.jxK = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.jxK.addTextChangedListener(this.jxM);
        switch (this.mScore) {
            case 2:
                this.jxF.setChecked(true);
                this.jxG.setChecked(false);
                this.jxH.setChecked(false);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(false);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 6:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(false);
                this.jxJ.setChecked(false);
                return;
            case 8:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(true);
                this.jxJ.setChecked(false);
                return;
            case 10:
                this.jxF.setChecked(true);
                this.jxG.setChecked(true);
                this.jxH.setChecked(true);
                this.jxI.setChecked(true);
                this.jxJ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKF() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.jxL);
        httpMessage.addParam("content", this.jxK.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.jxN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.jxN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.jxF, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jxG, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jxH, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jxI, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jxJ, R.drawable.game_comment_score_btn_bg);
        if (this.jxE.isEnabled()) {
            ao.setViewTextColor(this.jxE, R.color.cp_link_tip_g);
        } else {
            ao.setViewTextColor(this.jxE, R.color.CAM_X0110);
        }
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        this.jxK.setHintTextColor(ao.getColor(R.color.CAM_X0109));
    }
}
