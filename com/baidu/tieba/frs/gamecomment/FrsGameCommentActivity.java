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
    private NavigationBar jyD;
    private TextView jyE;
    private RadioButton jyF;
    private RadioButton jyG;
    private RadioButton jyH;
    private RadioButton jyI;
    private RadioButton jyJ;
    private EditText jyK;
    private int jyL;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.jyF) {
                FrsGameCommentActivity.this.jyG.setChecked(false);
                FrsGameCommentActivity.this.jyH.setChecked(false);
                FrsGameCommentActivity.this.jyI.setChecked(false);
                FrsGameCommentActivity.this.jyJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.jyG) {
                FrsGameCommentActivity.this.jyF.setChecked(true);
                FrsGameCommentActivity.this.jyH.setChecked(false);
                FrsGameCommentActivity.this.jyI.setChecked(false);
                FrsGameCommentActivity.this.jyJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.jyH) {
                FrsGameCommentActivity.this.jyF.setChecked(true);
                FrsGameCommentActivity.this.jyG.setChecked(true);
                FrsGameCommentActivity.this.jyI.setChecked(false);
                FrsGameCommentActivity.this.jyJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.jyI) {
                FrsGameCommentActivity.this.jyF.setChecked(true);
                FrsGameCommentActivity.this.jyG.setChecked(true);
                FrsGameCommentActivity.this.jyH.setChecked(true);
                FrsGameCommentActivity.this.jyJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.jyJ) {
                FrsGameCommentActivity.this.jyF.setChecked(true);
                FrsGameCommentActivity.this.jyG.setChecked(true);
                FrsGameCommentActivity.this.jyH.setChecked(true);
                FrsGameCommentActivity.this.jyI.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher jyM = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.jyK.getText().length() > 0) {
                FrsGameCommentActivity.this.jyE.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.jyE, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.jyE.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.jyE, R.color.CAM_X0110);
        }
    };
    private HttpMessageListener jyN = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.jyL = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ar("c12340").ap("fid", this.jyL));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.jyD = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.jyD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.jyD.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.jyD.showBottomLine(true);
        this.jyE = this.jyD.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cIa();
            }
        });
        this.jyE.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.jyE.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.jyE.setEnabled(false);
        this.jyF = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.jyF.setOnClickListener(this.mOnClickListener);
        this.jyG = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.jyG.setOnClickListener(this.mOnClickListener);
        this.jyH = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.jyH.setOnClickListener(this.mOnClickListener);
        this.jyI = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.jyI.setOnClickListener(this.mOnClickListener);
        this.jyJ = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.jyJ.setOnClickListener(this.mOnClickListener);
        this.jyK = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.jyK.addTextChangedListener(this.jyM);
        switch (this.mScore) {
            case 2:
                this.jyF.setChecked(true);
                this.jyG.setChecked(false);
                this.jyH.setChecked(false);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(false);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 6:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(false);
                this.jyJ.setChecked(false);
                return;
            case 8:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(true);
                this.jyJ.setChecked(false);
                return;
            case 10:
                this.jyF.setChecked(true);
                this.jyG.setChecked(true);
                this.jyH.setChecked(true);
                this.jyI.setChecked(true);
                this.jyJ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIa() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.jyL);
        httpMessage.addParam("content", this.jyK.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.jyN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.jyN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.jyF, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jyG, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jyH, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jyI, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jyJ, R.drawable.game_comment_score_btn_bg);
        if (this.jyE.isEnabled()) {
            ap.setViewTextColor(this.jyE, R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.jyE, R.color.CAM_X0110);
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        this.jyK.setHintTextColor(ap.getColor(R.color.CAM_X0109));
    }
}
