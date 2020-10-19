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
/* loaded from: classes22.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private RadioButton iEA;
    private RadioButton iEB;
    private RadioButton iEC;
    private RadioButton iED;
    private RadioButton iEE;
    private EditText iEF;
    private int iEG;
    private NavigationBar iEy;
    private TextView iEz;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iEA) {
                FrsGameCommentActivity.this.iEB.setChecked(false);
                FrsGameCommentActivity.this.iEC.setChecked(false);
                FrsGameCommentActivity.this.iED.setChecked(false);
                FrsGameCommentActivity.this.iEE.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iEB) {
                FrsGameCommentActivity.this.iEA.setChecked(true);
                FrsGameCommentActivity.this.iEC.setChecked(false);
                FrsGameCommentActivity.this.iED.setChecked(false);
                FrsGameCommentActivity.this.iEE.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iEC) {
                FrsGameCommentActivity.this.iEA.setChecked(true);
                FrsGameCommentActivity.this.iEB.setChecked(true);
                FrsGameCommentActivity.this.iED.setChecked(false);
                FrsGameCommentActivity.this.iEE.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iED) {
                FrsGameCommentActivity.this.iEA.setChecked(true);
                FrsGameCommentActivity.this.iEB.setChecked(true);
                FrsGameCommentActivity.this.iEC.setChecked(true);
                FrsGameCommentActivity.this.iEE.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iEE) {
                FrsGameCommentActivity.this.iEA.setChecked(true);
                FrsGameCommentActivity.this.iEB.setChecked(true);
                FrsGameCommentActivity.this.iEC.setChecked(true);
                FrsGameCommentActivity.this.iED.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iEH = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iEF.getText().length() > 0) {
                FrsGameCommentActivity.this.iEz.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iEz, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iEz.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iEz, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener iEI = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.iEG = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").aj("fid", this.iEG));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iEy = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iEy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iEy.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iEy.showBottomLine(true);
        this.iEz = this.iEy.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cxg();
            }
        });
        this.iEz.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iEz.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.iEz.setEnabled(false);
        this.iEA = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iEA.setOnClickListener(this.mOnClickListener);
        this.iEB = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iEB.setOnClickListener(this.mOnClickListener);
        this.iEC = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iEC.setOnClickListener(this.mOnClickListener);
        this.iED = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iED.setOnClickListener(this.mOnClickListener);
        this.iEE = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iEE.setOnClickListener(this.mOnClickListener);
        this.iEF = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iEF.addTextChangedListener(this.iEH);
        switch (this.mScore) {
            case 2:
                this.iEA.setChecked(true);
                this.iEB.setChecked(false);
                this.iEC.setChecked(false);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(false);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 6:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(false);
                this.iEE.setChecked(false);
                return;
            case 8:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(true);
                this.iEE.setChecked(false);
                return;
            case 10:
                this.iEA.setChecked(true);
                this.iEB.setChecked(true);
                this.iEC.setChecked(true);
                this.iED.setChecked(true);
                this.iEE.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxg() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iEG);
        httpMessage.addParam("content", this.iEF.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.iEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iEA, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iEB, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iEC, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iED, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iEE, R.drawable.game_comment_score_btn_bg);
        if (this.iEz.isEnabled()) {
            ap.setViewTextColor(this.iEz, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iEz, (int) R.color.cp_cont_e);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.iEF.setHintTextColor(ap.getColor(R.color.cp_cont_d));
    }
}
