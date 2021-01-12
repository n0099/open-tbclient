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
    private NavigationBar jsX;
    private TextView jsY;
    private RadioButton jsZ;
    private RadioButton jta;
    private RadioButton jtb;
    private RadioButton jtc;
    private RadioButton jtd;
    private EditText jte;
    private int jtf;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.jsZ) {
                FrsGameCommentActivity.this.jta.setChecked(false);
                FrsGameCommentActivity.this.jtb.setChecked(false);
                FrsGameCommentActivity.this.jtc.setChecked(false);
                FrsGameCommentActivity.this.jtd.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.jta) {
                FrsGameCommentActivity.this.jsZ.setChecked(true);
                FrsGameCommentActivity.this.jtb.setChecked(false);
                FrsGameCommentActivity.this.jtc.setChecked(false);
                FrsGameCommentActivity.this.jtd.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.jtb) {
                FrsGameCommentActivity.this.jsZ.setChecked(true);
                FrsGameCommentActivity.this.jta.setChecked(true);
                FrsGameCommentActivity.this.jtc.setChecked(false);
                FrsGameCommentActivity.this.jtd.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.jtc) {
                FrsGameCommentActivity.this.jsZ.setChecked(true);
                FrsGameCommentActivity.this.jta.setChecked(true);
                FrsGameCommentActivity.this.jtb.setChecked(true);
                FrsGameCommentActivity.this.jtd.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.jtd) {
                FrsGameCommentActivity.this.jsZ.setChecked(true);
                FrsGameCommentActivity.this.jta.setChecked(true);
                FrsGameCommentActivity.this.jtb.setChecked(true);
                FrsGameCommentActivity.this.jtc.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher jtg = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.jte.getText().length() > 0) {
                FrsGameCommentActivity.this.jsY.setEnabled(true);
                ao.setViewTextColor(FrsGameCommentActivity.this.jsY, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.jsY.setEnabled(false);
            ao.setViewTextColor(FrsGameCommentActivity.this.jsY, R.color.CAM_X0110);
        }
    };
    private HttpMessageListener jth = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.jtf = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new aq("c12340").an("fid", this.jtf));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.jsX = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.jsX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.jsX.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.jsX.showBottomLine(true);
        this.jsY = this.jsX.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cGN();
            }
        });
        this.jsY.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.jsY.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.jsY.setEnabled(false);
        this.jsZ = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.jsZ.setOnClickListener(this.mOnClickListener);
        this.jta = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.jta.setOnClickListener(this.mOnClickListener);
        this.jtb = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.jtb.setOnClickListener(this.mOnClickListener);
        this.jtc = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.jtc.setOnClickListener(this.mOnClickListener);
        this.jtd = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.jtd.setOnClickListener(this.mOnClickListener);
        this.jte = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.jte.addTextChangedListener(this.jtg);
        switch (this.mScore) {
            case 2:
                this.jsZ.setChecked(true);
                this.jta.setChecked(false);
                this.jtb.setChecked(false);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(false);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 6:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(false);
                this.jtd.setChecked(false);
                return;
            case 8:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(true);
                this.jtd.setChecked(false);
                return;
            case 10:
                this.jsZ.setChecked(true);
                this.jta.setChecked(true);
                this.jtb.setChecked(true);
                this.jtc.setChecked(true);
                this.jtd.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGN() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.jtf);
        httpMessage.addParam("content", this.jte.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.jth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.jth);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundResource(this.jsZ, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jta, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jtb, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jtc, R.drawable.game_comment_score_btn_bg);
        ao.setBackgroundResource(this.jtd, R.drawable.game_comment_score_btn_bg);
        if (this.jsY.isEnabled()) {
            ao.setViewTextColor(this.jsY, R.color.cp_link_tip_g);
        } else {
            ao.setViewTextColor(this.jsY, R.color.CAM_X0110);
        }
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        this.jte.setHintTextColor(ao.getColor(R.color.CAM_X0109));
    }
}
