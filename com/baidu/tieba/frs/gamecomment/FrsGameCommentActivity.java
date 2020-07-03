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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar hOp;
    private TextView hOq;
    private RadioButton hOr;
    private RadioButton hOs;
    private RadioButton hOt;
    private RadioButton hOu;
    private RadioButton hOv;
    private EditText hOw;
    private int hOx;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.hOr) {
                FrsGameCommentActivity.this.hOs.setChecked(false);
                FrsGameCommentActivity.this.hOt.setChecked(false);
                FrsGameCommentActivity.this.hOu.setChecked(false);
                FrsGameCommentActivity.this.hOv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.hOs) {
                FrsGameCommentActivity.this.hOr.setChecked(true);
                FrsGameCommentActivity.this.hOt.setChecked(false);
                FrsGameCommentActivity.this.hOu.setChecked(false);
                FrsGameCommentActivity.this.hOv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.hOt) {
                FrsGameCommentActivity.this.hOr.setChecked(true);
                FrsGameCommentActivity.this.hOs.setChecked(true);
                FrsGameCommentActivity.this.hOu.setChecked(false);
                FrsGameCommentActivity.this.hOv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.hOu) {
                FrsGameCommentActivity.this.hOr.setChecked(true);
                FrsGameCommentActivity.this.hOs.setChecked(true);
                FrsGameCommentActivity.this.hOt.setChecked(true);
                FrsGameCommentActivity.this.hOv.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.hOv) {
                FrsGameCommentActivity.this.hOr.setChecked(true);
                FrsGameCommentActivity.this.hOs.setChecked(true);
                FrsGameCommentActivity.this.hOt.setChecked(true);
                FrsGameCommentActivity.this.hOu.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher hOy = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.hOw.getText().length() > 0) {
                FrsGameCommentActivity.this.hOq.setEnabled(true);
                an.setViewTextColor(FrsGameCommentActivity.this.hOq, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.hOq.setEnabled(false);
            an.setViewTextColor(FrsGameCommentActivity.this.hOq, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener hOz = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.hOx = getIntent().getIntExtra("forum_id", -1);
        initView();
        xp();
        registerListener();
        TiebaStatic.log(new ao("c12340").ag("fid", this.hOx));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.hOp = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.hOp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.hOp.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.hOp.showBottomLine(true);
        this.hOq = this.hOp.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.ccr();
            }
        });
        this.hOq.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.hOq.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.hOq.setEnabled(false);
        this.hOr = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.hOr.setOnClickListener(this.mOnClickListener);
        this.hOs = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.hOs.setOnClickListener(this.mOnClickListener);
        this.hOt = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.hOt.setOnClickListener(this.mOnClickListener);
        this.hOu = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.hOu.setOnClickListener(this.mOnClickListener);
        this.hOv = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.hOv.setOnClickListener(this.mOnClickListener);
        this.hOw = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.hOw.addTextChangedListener(this.hOy);
        switch (this.mScore) {
            case 2:
                this.hOr.setChecked(true);
                this.hOs.setChecked(false);
                this.hOt.setChecked(false);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(false);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 6:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(false);
                this.hOv.setChecked(false);
                return;
            case 8:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(true);
                this.hOv.setChecked(false);
                return;
            case 10:
                this.hOr.setChecked(true);
                this.hOs.setChecked(true);
                this.hOt.setChecked(true);
                this.hOu.setChecked(true);
                this.hOv.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccr() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.hOx);
        httpMessage.addParam("content", this.hOw.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void xp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hOz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.hOz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundResource(this.hOr, R.drawable.game_comment_score_btn_bg);
        an.setBackgroundResource(this.hOs, R.drawable.game_comment_score_btn_bg);
        an.setBackgroundResource(this.hOt, R.drawable.game_comment_score_btn_bg);
        an.setBackgroundResource(this.hOu, R.drawable.game_comment_score_btn_bg);
        an.setBackgroundResource(this.hOv, R.drawable.game_comment_score_btn_bg);
        if (this.hOq.isEnabled()) {
            an.setViewTextColor(this.hOq, (int) R.color.cp_link_tip_g);
        } else {
            an.setViewTextColor(this.hOq, (int) R.color.cp_cont_e);
        }
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.hOw.setHintTextColor(an.getColor(R.color.cp_cont_d));
    }
}
