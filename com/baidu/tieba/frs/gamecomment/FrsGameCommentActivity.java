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
/* loaded from: classes22.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar jlc;
    private TextView jld;
    private RadioButton jle;
    private RadioButton jlf;
    private RadioButton jlg;
    private RadioButton jlh;
    private RadioButton jli;
    private EditText jlj;
    private int jlk;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.jle) {
                FrsGameCommentActivity.this.jlf.setChecked(false);
                FrsGameCommentActivity.this.jlg.setChecked(false);
                FrsGameCommentActivity.this.jlh.setChecked(false);
                FrsGameCommentActivity.this.jli.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.jlf) {
                FrsGameCommentActivity.this.jle.setChecked(true);
                FrsGameCommentActivity.this.jlg.setChecked(false);
                FrsGameCommentActivity.this.jlh.setChecked(false);
                FrsGameCommentActivity.this.jli.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.jlg) {
                FrsGameCommentActivity.this.jle.setChecked(true);
                FrsGameCommentActivity.this.jlf.setChecked(true);
                FrsGameCommentActivity.this.jlh.setChecked(false);
                FrsGameCommentActivity.this.jli.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.jlh) {
                FrsGameCommentActivity.this.jle.setChecked(true);
                FrsGameCommentActivity.this.jlf.setChecked(true);
                FrsGameCommentActivity.this.jlg.setChecked(true);
                FrsGameCommentActivity.this.jli.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.jli) {
                FrsGameCommentActivity.this.jle.setChecked(true);
                FrsGameCommentActivity.this.jlf.setChecked(true);
                FrsGameCommentActivity.this.jlg.setChecked(true);
                FrsGameCommentActivity.this.jlh.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher jll = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.jlj.getText().length() > 0) {
                FrsGameCommentActivity.this.jld.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.jld, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.jld.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.jld, (int) R.color.CAM_X0110);
        }
    };
    private HttpMessageListener jlm = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.jlk = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ar("c12340").al("fid", this.jlk));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.jlc = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.jlc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.jlc.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.jlc.showBottomLine(true);
        this.jld = this.jlc.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cHD();
            }
        });
        this.jld.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.jld.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.jld.setEnabled(false);
        this.jle = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.jle.setOnClickListener(this.mOnClickListener);
        this.jlf = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.jlf.setOnClickListener(this.mOnClickListener);
        this.jlg = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.jlg.setOnClickListener(this.mOnClickListener);
        this.jlh = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.jlh.setOnClickListener(this.mOnClickListener);
        this.jli = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.jli.setOnClickListener(this.mOnClickListener);
        this.jlj = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.jlj.addTextChangedListener(this.jll);
        switch (this.mScore) {
            case 2:
                this.jle.setChecked(true);
                this.jlf.setChecked(false);
                this.jlg.setChecked(false);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(false);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 6:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(false);
                this.jli.setChecked(false);
                return;
            case 8:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(true);
                this.jli.setChecked(false);
                return;
            case 10:
                this.jle.setChecked(true);
                this.jlf.setChecked(true);
                this.jlg.setChecked(true);
                this.jlh.setChecked(true);
                this.jli.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHD() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.jlk);
        httpMessage.addParam("content", this.jlj.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.jlm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.jlm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.jle, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jlf, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jlg, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jlh, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.jli, R.drawable.game_comment_score_btn_bg);
        if (this.jld.isEnabled()) {
            ap.setViewTextColor(this.jld, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.jld, (int) R.color.CAM_X0110);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
        this.jlj.setHintTextColor(ap.getColor(R.color.CAM_X0109));
    }
}
