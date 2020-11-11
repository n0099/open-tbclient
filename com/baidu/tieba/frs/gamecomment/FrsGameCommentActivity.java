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
    private NavigationBar iWR;
    private TextView iWS;
    private RadioButton iWT;
    private RadioButton iWU;
    private RadioButton iWV;
    private RadioButton iWW;
    private RadioButton iWX;
    private EditText iWY;
    private int iWZ;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iWT) {
                FrsGameCommentActivity.this.iWU.setChecked(false);
                FrsGameCommentActivity.this.iWV.setChecked(false);
                FrsGameCommentActivity.this.iWW.setChecked(false);
                FrsGameCommentActivity.this.iWX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iWU) {
                FrsGameCommentActivity.this.iWT.setChecked(true);
                FrsGameCommentActivity.this.iWV.setChecked(false);
                FrsGameCommentActivity.this.iWW.setChecked(false);
                FrsGameCommentActivity.this.iWX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iWV) {
                FrsGameCommentActivity.this.iWT.setChecked(true);
                FrsGameCommentActivity.this.iWU.setChecked(true);
                FrsGameCommentActivity.this.iWW.setChecked(false);
                FrsGameCommentActivity.this.iWX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iWW) {
                FrsGameCommentActivity.this.iWT.setChecked(true);
                FrsGameCommentActivity.this.iWU.setChecked(true);
                FrsGameCommentActivity.this.iWV.setChecked(true);
                FrsGameCommentActivity.this.iWX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iWX) {
                FrsGameCommentActivity.this.iWT.setChecked(true);
                FrsGameCommentActivity.this.iWU.setChecked(true);
                FrsGameCommentActivity.this.iWV.setChecked(true);
                FrsGameCommentActivity.this.iWW.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iXa = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iWY.getText().length() > 0) {
                FrsGameCommentActivity.this.iWS.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iWS, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iWS.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iWS, (int) R.color.cp_cont_e);
        }
    };
    private HttpMessageListener iXb = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.iWZ = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").al("fid", this.iWZ));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iWR = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iWR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iWR.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iWR.showBottomLine(true);
        this.iWS = this.iWR.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cCO();
            }
        });
        this.iWS.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iWS.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.iWS.setEnabled(false);
        this.iWT = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iWT.setOnClickListener(this.mOnClickListener);
        this.iWU = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iWU.setOnClickListener(this.mOnClickListener);
        this.iWV = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iWV.setOnClickListener(this.mOnClickListener);
        this.iWW = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iWW.setOnClickListener(this.mOnClickListener);
        this.iWX = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iWX.setOnClickListener(this.mOnClickListener);
        this.iWY = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iWY.addTextChangedListener(this.iXa);
        switch (this.mScore) {
            case 2:
                this.iWT.setChecked(true);
                this.iWU.setChecked(false);
                this.iWV.setChecked(false);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(false);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 6:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(false);
                this.iWX.setChecked(false);
                return;
            case 8:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(true);
                this.iWX.setChecked(false);
                return;
            case 10:
                this.iWT.setChecked(true);
                this.iWU.setChecked(true);
                this.iWV.setChecked(true);
                this.iWW.setChecked(true);
                this.iWX.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCO() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iWZ);
        httpMessage.addParam("content", this.iWY.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.iXb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iXb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iWT, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iWU, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iWV, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iWW, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iWX, R.drawable.game_comment_score_btn_bg);
        if (this.iWS.isEnabled()) {
            ap.setViewTextColor(this.iWS, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iWS, (int) R.color.cp_cont_e);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        this.iWY.setHintTextColor(ap.getColor(R.color.cp_cont_d));
    }
}
