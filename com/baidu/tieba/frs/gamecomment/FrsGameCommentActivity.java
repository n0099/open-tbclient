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
    private NavigationBar iQU;
    private TextView iQV;
    private RadioButton iQW;
    private RadioButton iQX;
    private RadioButton iQY;
    private RadioButton iQZ;
    private RadioButton iRa;
    private EditText iRb;
    private int iRc;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iQW) {
                FrsGameCommentActivity.this.iQX.setChecked(false);
                FrsGameCommentActivity.this.iQY.setChecked(false);
                FrsGameCommentActivity.this.iQZ.setChecked(false);
                FrsGameCommentActivity.this.iRa.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iQX) {
                FrsGameCommentActivity.this.iQW.setChecked(true);
                FrsGameCommentActivity.this.iQY.setChecked(false);
                FrsGameCommentActivity.this.iQZ.setChecked(false);
                FrsGameCommentActivity.this.iRa.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iQY) {
                FrsGameCommentActivity.this.iQW.setChecked(true);
                FrsGameCommentActivity.this.iQX.setChecked(true);
                FrsGameCommentActivity.this.iQZ.setChecked(false);
                FrsGameCommentActivity.this.iRa.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iQZ) {
                FrsGameCommentActivity.this.iQW.setChecked(true);
                FrsGameCommentActivity.this.iQX.setChecked(true);
                FrsGameCommentActivity.this.iQY.setChecked(true);
                FrsGameCommentActivity.this.iRa.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iRa) {
                FrsGameCommentActivity.this.iQW.setChecked(true);
                FrsGameCommentActivity.this.iQX.setChecked(true);
                FrsGameCommentActivity.this.iQY.setChecked(true);
                FrsGameCommentActivity.this.iQZ.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iRd = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iRb.getText().length() > 0) {
                FrsGameCommentActivity.this.iQV.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iQV, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iQV.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iQV, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener iRe = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.iRc = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").aj("fid", this.iRc));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iQU = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iQU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iQU.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iQU.showBottomLine(true);
        this.iQV = this.iQU.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cAn();
            }
        });
        this.iQV.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iQV.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.iQV.setEnabled(false);
        this.iQW = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iQW.setOnClickListener(this.mOnClickListener);
        this.iQX = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iQX.setOnClickListener(this.mOnClickListener);
        this.iQY = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iQY.setOnClickListener(this.mOnClickListener);
        this.iQZ = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iQZ.setOnClickListener(this.mOnClickListener);
        this.iRa = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iRa.setOnClickListener(this.mOnClickListener);
        this.iRb = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iRb.addTextChangedListener(this.iRd);
        switch (this.mScore) {
            case 2:
                this.iQW.setChecked(true);
                this.iQX.setChecked(false);
                this.iQY.setChecked(false);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(false);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 6:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(false);
                this.iRa.setChecked(false);
                return;
            case 8:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(true);
                this.iRa.setChecked(false);
                return;
            case 10:
                this.iQW.setChecked(true);
                this.iQX.setChecked(true);
                this.iQY.setChecked(true);
                this.iQZ.setChecked(true);
                this.iRa.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAn() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iRc);
        httpMessage.addParam("content", this.iRb.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.iRe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iRe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iQW, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iQX, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iQY, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iQZ, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iRa, R.drawable.game_comment_score_btn_bg);
        if (this.iQV.isEnabled()) {
            ap.setViewTextColor(this.iQV, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iQV, (int) R.color.cp_cont_e);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.iRb.setHintTextColor(ap.getColor(R.color.cp_cont_d));
    }
}
