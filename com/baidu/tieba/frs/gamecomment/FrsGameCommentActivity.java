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
import com.baidu.ar.paddle.PaddleController;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar cQL;
    private TextView dWX;
    private RadioButton dWY;
    private RadioButton dWZ;
    private RadioButton dXa;
    private RadioButton dXb;
    private RadioButton dXc;
    private EditText dXd;
    private int dXe;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dWY) {
                FrsGameCommentActivity.this.dWZ.setChecked(false);
                FrsGameCommentActivity.this.dXa.setChecked(false);
                FrsGameCommentActivity.this.dXb.setChecked(false);
                FrsGameCommentActivity.this.dXc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dWZ) {
                FrsGameCommentActivity.this.dWY.setChecked(true);
                FrsGameCommentActivity.this.dXa.setChecked(false);
                FrsGameCommentActivity.this.dXb.setChecked(false);
                FrsGameCommentActivity.this.dXc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dXa) {
                FrsGameCommentActivity.this.dWY.setChecked(true);
                FrsGameCommentActivity.this.dWZ.setChecked(true);
                FrsGameCommentActivity.this.dXb.setChecked(false);
                FrsGameCommentActivity.this.dXc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dXb) {
                FrsGameCommentActivity.this.dWY.setChecked(true);
                FrsGameCommentActivity.this.dWZ.setChecked(true);
                FrsGameCommentActivity.this.dXa.setChecked(true);
                FrsGameCommentActivity.this.dXc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dXc) {
                FrsGameCommentActivity.this.dWY.setChecked(true);
                FrsGameCommentActivity.this.dWZ.setChecked(true);
                FrsGameCommentActivity.this.dXa.setChecked(true);
                FrsGameCommentActivity.this.dXb.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dXf = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dXd.getText().length() > 0) {
                FrsGameCommentActivity.this.dWX.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dWX, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dWX.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dWX, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dXg = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.mScore = getIntent().getIntExtra(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, 0);
        this.dXe = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").x(ImageViewerConfig.FORUM_ID, this.dXe));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cQL = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cQL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cQL.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cQL.showBottomLine(true);
        this.dWX = this.cQL.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kV()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aFA();
            }
        });
        this.dWX.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dWX.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dWX.setEnabled(false);
        this.dWY = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dWY.setOnClickListener(this.mOnClickListener);
        this.dWZ = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dWZ.setOnClickListener(this.mOnClickListener);
        this.dXa = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dXa.setOnClickListener(this.mOnClickListener);
        this.dXb = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dXb.setOnClickListener(this.mOnClickListener);
        this.dXc = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dXc.setOnClickListener(this.mOnClickListener);
        this.dXd = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dXd.addTextChangedListener(this.dXf);
        switch (this.mScore) {
            case 2:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(false);
                this.dXa.setChecked(false);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(false);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 6:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(false);
                this.dXc.setChecked(false);
                return;
            case 8:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(true);
                this.dXc.setChecked(false);
                return;
            case 10:
                this.dWY.setChecked(true);
                this.dWZ.setChecked(true);
                this.dXa.setChecked(true);
                this.dXb.setChecked(true);
                this.dXc.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFA() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dXe);
        httpMessage.addParam("content", this.dXd.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dXg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dXg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dWY, e.f.game_comment_score_btn_bg);
        al.i(this.dWZ, e.f.game_comment_score_btn_bg);
        al.i(this.dXa, e.f.game_comment_score_btn_bg);
        al.i(this.dXb, e.f.game_comment_score_btn_bg);
        al.i(this.dXc, e.f.game_comment_score_btn_bg);
        if (this.dWX.isEnabled()) {
            al.h(this.dWX, e.d.cp_link_tip_g);
        } else {
            al.h(this.dWX, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dXd.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dXd.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
