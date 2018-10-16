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
    private NavigationBar cGd;
    private RadioButton dMA;
    private RadioButton dMB;
    private RadioButton dMC;
    private RadioButton dMD;
    private RadioButton dME;
    private EditText dMF;
    private int dMG;
    private TextView dMz;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dMA) {
                FrsGameCommentActivity.this.dMB.setChecked(false);
                FrsGameCommentActivity.this.dMC.setChecked(false);
                FrsGameCommentActivity.this.dMD.setChecked(false);
                FrsGameCommentActivity.this.dME.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dMB) {
                FrsGameCommentActivity.this.dMA.setChecked(true);
                FrsGameCommentActivity.this.dMC.setChecked(false);
                FrsGameCommentActivity.this.dMD.setChecked(false);
                FrsGameCommentActivity.this.dME.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dMC) {
                FrsGameCommentActivity.this.dMA.setChecked(true);
                FrsGameCommentActivity.this.dMB.setChecked(true);
                FrsGameCommentActivity.this.dMD.setChecked(false);
                FrsGameCommentActivity.this.dME.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dMD) {
                FrsGameCommentActivity.this.dMA.setChecked(true);
                FrsGameCommentActivity.this.dMB.setChecked(true);
                FrsGameCommentActivity.this.dMC.setChecked(true);
                FrsGameCommentActivity.this.dME.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dME) {
                FrsGameCommentActivity.this.dMA.setChecked(true);
                FrsGameCommentActivity.this.dMB.setChecked(true);
                FrsGameCommentActivity.this.dMC.setChecked(true);
                FrsGameCommentActivity.this.dMD.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dMH = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dMF.getText().length() > 0) {
                FrsGameCommentActivity.this.dMz.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dMz, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dMz.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dMz, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dMI = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dMG = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").x(ImageViewerConfig.FORUM_ID, this.dMG));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cGd = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cGd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cGd.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cGd.showBottomLine(true);
        this.dMz = this.cGd.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kX()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aDE();
            }
        });
        this.dMz.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dMz.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dMz.setEnabled(false);
        this.dMA = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dMA.setOnClickListener(this.mOnClickListener);
        this.dMB = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dMB.setOnClickListener(this.mOnClickListener);
        this.dMC = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dMC.setOnClickListener(this.mOnClickListener);
        this.dMD = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dMD.setOnClickListener(this.mOnClickListener);
        this.dME = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dME.setOnClickListener(this.mOnClickListener);
        this.dMF = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dMF.addTextChangedListener(this.dMH);
        switch (this.mScore) {
            case 2:
                this.dMA.setChecked(true);
                this.dMB.setChecked(false);
                this.dMC.setChecked(false);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(false);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 6:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(false);
                this.dME.setChecked(false);
                return;
            case 8:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(true);
                this.dME.setChecked(false);
                return;
            case 10:
                this.dMA.setChecked(true);
                this.dMB.setChecked(true);
                this.dMC.setChecked(true);
                this.dMD.setChecked(true);
                this.dME.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dMG);
        httpMessage.addParam("content", this.dMF.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dMI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dMI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dMA, e.f.game_comment_score_btn_bg);
        al.i(this.dMB, e.f.game_comment_score_btn_bg);
        al.i(this.dMC, e.f.game_comment_score_btn_bg);
        al.i(this.dMD, e.f.game_comment_score_btn_bg);
        al.i(this.dME, e.f.game_comment_score_btn_bg);
        if (this.dMz.isEnabled()) {
            al.h(this.dMz, e.d.cp_link_tip_g);
        } else {
            al.h(this.dMz, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dMF.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dMF.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
