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
    private NavigationBar hUq;
    private TextView hUr;
    private RadioButton hUs;
    private RadioButton hUt;
    private RadioButton hUu;
    private RadioButton hUv;
    private RadioButton hUw;
    private EditText hUx;
    private int hUy;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.hUs) {
                FrsGameCommentActivity.this.hUt.setChecked(false);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.hUv.setChecked(false);
                FrsGameCommentActivity.this.hUw.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.hUt) {
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUu.setChecked(false);
                FrsGameCommentActivity.this.hUv.setChecked(false);
                FrsGameCommentActivity.this.hUw.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.hUu) {
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUt.setChecked(true);
                FrsGameCommentActivity.this.hUv.setChecked(false);
                FrsGameCommentActivity.this.hUw.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.hUv) {
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUt.setChecked(true);
                FrsGameCommentActivity.this.hUu.setChecked(true);
                FrsGameCommentActivity.this.hUw.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.hUw) {
                FrsGameCommentActivity.this.hUs.setChecked(true);
                FrsGameCommentActivity.this.hUt.setChecked(true);
                FrsGameCommentActivity.this.hUu.setChecked(true);
                FrsGameCommentActivity.this.hUv.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher hUz = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.hUx.getText().length() > 0) {
                FrsGameCommentActivity.this.hUr.setEnabled(true);
                ao.setViewTextColor(FrsGameCommentActivity.this.hUr, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.hUr.setEnabled(false);
            ao.setViewTextColor(FrsGameCommentActivity.this.hUr, R.color.cp_cont_e);
        }
    };
    private HttpMessageListener hUA = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.hUy = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ap("c12340").ah("fid", this.hUy));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.hUq = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.hUq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.hUq.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.hUq.showBottomLine(true);
        this.hUr = this.hUq.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
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
        this.hUr.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.hUr.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.cp_cont_e));
        this.hUr.setEnabled(false);
        this.hUs = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.hUs.setOnClickListener(this.mOnClickListener);
        this.hUt = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.hUt.setOnClickListener(this.mOnClickListener);
        this.hUu = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.hUu.setOnClickListener(this.mOnClickListener);
        this.hUv = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.hUv.setOnClickListener(this.mOnClickListener);
        this.hUw = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.hUw.setOnClickListener(this.mOnClickListener);
        this.hUx = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.hUx.addTextChangedListener(this.hUz);
        switch (this.mScore) {
            case 2:
                this.hUs.setChecked(true);
                this.hUt.setChecked(false);
                this.hUu.setChecked(false);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(false);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 6:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(false);
                this.hUw.setChecked(false);
                return;
            case 8:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(true);
                this.hUw.setChecked(false);
                return;
            case 10:
                this.hUs.setChecked(true);
                this.hUt.setChecked(true);
                this.hUu.setChecked(true);
                this.hUv.setChecked(true);
                this.hUw.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfQ() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.hUy);
        httpMessage.addParam("content", this.hUx.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.hUA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.hUA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.hUs, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUt, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUu, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUv, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.hUw, R.drawable.game_comment_score_btn_bg);
        if (this.hUr.isEnabled()) {
            ao.setViewTextColor(this.hUr, R.color.cp_link_tip_g);
        } else {
            ao.setViewTextColor(this.hUr, R.color.cp_cont_e);
        }
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        this.hUx.setHintTextColor(ao.getColor(R.color.cp_cont_d));
    }
}
