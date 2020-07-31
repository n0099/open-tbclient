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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar hUo;
    private TextView hUp;
    private RadioButton hUq;
    private RadioButton hUr;
    private RadioButton hUs;
    private RadioButton hUt;
    private RadioButton hUu;
    private EditText hUv;
    private int hUw;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.hUq) {
                FrsGameCommentActivity.this.hUr.setChecked(false);
                FrsGameCommentActivity.this.hUs.setChecked(false);
                FrsGameCommentActivity.this.hUt.setChecked(false);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.hUr) {
                FrsGameCommentActivity.this.hUq.setChecked(true);
                FrsGameCommentActivity.this.hUs.setChecked(false);
                FrsGameCommentActivity.this.hUt.setChecked(false);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.hUs) {
                FrsGameCommentActivity.this.hUq.setChecked(true);
                FrsGameCommentActivity.this.hUr.setChecked(true);
                FrsGameCommentActivity.this.hUt.setChecked(false);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.hUt) {
                FrsGameCommentActivity.this.hUq.setChecked(true);
                FrsGameCommentActivity.this.hUr.setChecked(true);
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.hUu) {
                FrsGameCommentActivity.this.hUq.setChecked(true);
                FrsGameCommentActivity.this.hUr.setChecked(true);
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUt.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher hUx = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.hUv.getText().length() > 0) {
                FrsGameCommentActivity.this.hUp.setEnabled(true);
                ao.setViewTextColor(FrsGameCommentActivity.this.hUp, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.hUp.setEnabled(false);
            ao.setViewTextColor(FrsGameCommentActivity.this.hUp, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener hUy = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.hUw = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ap("c12340").ah("fid", this.hUw));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.hUo = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.hUo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.hUo.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.hUo.showBottomLine(true);
        this.hUp = this.hUo.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cfQ();
            }
        });
        this.hUp.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.hUp.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.hUp.setEnabled(false);
        this.hUq = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.hUq.setOnClickListener(this.mOnClickListener);
        this.hUr = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.hUr.setOnClickListener(this.mOnClickListener);
        this.hUs = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.hUs.setOnClickListener(this.mOnClickListener);
        this.hUt = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.hUt.setOnClickListener(this.mOnClickListener);
        this.hUu = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.hUu.setOnClickListener(this.mOnClickListener);
        this.hUv = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.hUv.addTextChangedListener(this.hUx);
        switch (this.mScore) {
            case 2:
                this.hUq.setChecked(true);
                this.hUr.setChecked(false);
                this.hUs.setChecked(false);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(false);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 6:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                return;
            case 8:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(false);
                return;
            case 10:
                this.hUq.setChecked(true);
                this.hUr.setChecked(true);
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfQ() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.hUw);
        httpMessage.addParam("content", this.hUv.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.hUy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.hUy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.hUq, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUr, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUs, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUt, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUu, R.drawable.game_comment_score_btn_bg);
        if (this.hUp.isEnabled()) {
            ao.setViewTextColor(this.hUp, R.color.cp_link_tip_g);
        } else {
            ao.setViewTextColor(this.hUp, R.color.cp_cont_e);
        }
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        this.hUv.setHintTextColor(ao.getColor(R.color.cp_cont_d));
    }
}
