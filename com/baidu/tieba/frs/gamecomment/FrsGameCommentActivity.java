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
    private RadioButton hAA;
    private EditText hAB;
    private int hAC;
    private NavigationBar hAu;
    private TextView hAv;
    private RadioButton hAw;
    private RadioButton hAx;
    private RadioButton hAy;
    private RadioButton hAz;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.hAw) {
                FrsGameCommentActivity.this.hAx.setChecked(false);
                FrsGameCommentActivity.this.hAy.setChecked(false);
                FrsGameCommentActivity.this.hAz.setChecked(false);
                FrsGameCommentActivity.this.hAA.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.hAx) {
                FrsGameCommentActivity.this.hAw.setChecked(true);
                FrsGameCommentActivity.this.hAy.setChecked(false);
                FrsGameCommentActivity.this.hAz.setChecked(false);
                FrsGameCommentActivity.this.hAA.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.hAy) {
                FrsGameCommentActivity.this.hAw.setChecked(true);
                FrsGameCommentActivity.this.hAx.setChecked(true);
                FrsGameCommentActivity.this.hAz.setChecked(false);
                FrsGameCommentActivity.this.hAA.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.hAz) {
                FrsGameCommentActivity.this.hAw.setChecked(true);
                FrsGameCommentActivity.this.hAx.setChecked(true);
                FrsGameCommentActivity.this.hAy.setChecked(true);
                FrsGameCommentActivity.this.hAA.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.hAA) {
                FrsGameCommentActivity.this.hAw.setChecked(true);
                FrsGameCommentActivity.this.hAx.setChecked(true);
                FrsGameCommentActivity.this.hAy.setChecked(true);
                FrsGameCommentActivity.this.hAz.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher hAD = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.hAB.getText().length() > 0) {
                FrsGameCommentActivity.this.hAv.setEnabled(true);
                am.setViewTextColor(FrsGameCommentActivity.this.hAv, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.hAv.setEnabled(false);
            am.setViewTextColor(FrsGameCommentActivity.this.hAv, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener hAE = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.hAC = getIntent().getIntExtra("forum_id", -1);
        initView();
        Fv();
        registerListener();
        TiebaStatic.log(new an("c12340").ag("fid", this.hAC));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.hAu = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.hAu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.hAu.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.hAu.showBottomLine(true);
        this.hAv = this.hAu.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bYT();
            }
        });
        this.hAv.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.hAv.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.hAv.setEnabled(false);
        this.hAw = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.hAw.setOnClickListener(this.mOnClickListener);
        this.hAx = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.hAx.setOnClickListener(this.mOnClickListener);
        this.hAy = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.hAy.setOnClickListener(this.mOnClickListener);
        this.hAz = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.hAz.setOnClickListener(this.mOnClickListener);
        this.hAA = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.hAA.setOnClickListener(this.mOnClickListener);
        this.hAB = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.hAB.addTextChangedListener(this.hAD);
        switch (this.mScore) {
            case 2:
                this.hAw.setChecked(true);
                this.hAx.setChecked(false);
                this.hAy.setChecked(false);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(false);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 6:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(false);
                this.hAA.setChecked(false);
                return;
            case 8:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(true);
                this.hAA.setChecked(false);
                return;
            case 10:
                this.hAw.setChecked(true);
                this.hAx.setChecked(true);
                this.hAy.setChecked(true);
                this.hAz.setChecked(true);
                this.hAA.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYT() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.hAC);
        httpMessage.addParam("content", this.hAB.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hAE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.hAE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundResource(this.hAw, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hAx, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hAy, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hAz, R.drawable.game_comment_score_btn_bg);
        am.setBackgroundResource(this.hAA, R.drawable.game_comment_score_btn_bg);
        if (this.hAv.isEnabled()) {
            am.setViewTextColor(this.hAv, (int) R.color.cp_link_tip_g);
        } else {
            am.setViewTextColor(this.hAv, (int) R.color.cp_cont_e);
        }
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.hAB.setHintTextColor(am.getColor(R.color.cp_cont_d));
    }
}
