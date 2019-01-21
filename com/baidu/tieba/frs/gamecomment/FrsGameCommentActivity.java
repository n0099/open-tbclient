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
    private NavigationBar cRx;
    private TextView dXE;
    private RadioButton dXF;
    private RadioButton dXG;
    private RadioButton dXH;
    private RadioButton dXI;
    private RadioButton dXJ;
    private EditText dXK;
    private int dXL;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dXF) {
                FrsGameCommentActivity.this.dXG.setChecked(false);
                FrsGameCommentActivity.this.dXH.setChecked(false);
                FrsGameCommentActivity.this.dXI.setChecked(false);
                FrsGameCommentActivity.this.dXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dXG) {
                FrsGameCommentActivity.this.dXF.setChecked(true);
                FrsGameCommentActivity.this.dXH.setChecked(false);
                FrsGameCommentActivity.this.dXI.setChecked(false);
                FrsGameCommentActivity.this.dXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dXH) {
                FrsGameCommentActivity.this.dXF.setChecked(true);
                FrsGameCommentActivity.this.dXG.setChecked(true);
                FrsGameCommentActivity.this.dXI.setChecked(false);
                FrsGameCommentActivity.this.dXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dXI) {
                FrsGameCommentActivity.this.dXF.setChecked(true);
                FrsGameCommentActivity.this.dXG.setChecked(true);
                FrsGameCommentActivity.this.dXH.setChecked(true);
                FrsGameCommentActivity.this.dXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dXJ) {
                FrsGameCommentActivity.this.dXF.setChecked(true);
                FrsGameCommentActivity.this.dXG.setChecked(true);
                FrsGameCommentActivity.this.dXH.setChecked(true);
                FrsGameCommentActivity.this.dXI.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dXM = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dXK.getText().length() > 0) {
                FrsGameCommentActivity.this.dXE.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dXE, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dXE.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dXE, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dXN = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dXL = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").y(ImageViewerConfig.FORUM_ID, this.dXL));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cRx = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cRx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cRx.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cRx.showBottomLine(true);
        this.dXE = this.cRx.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kV()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aFX();
            }
        });
        this.dXE.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dXE.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dXE.setEnabled(false);
        this.dXF = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dXF.setOnClickListener(this.mOnClickListener);
        this.dXG = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dXG.setOnClickListener(this.mOnClickListener);
        this.dXH = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dXH.setOnClickListener(this.mOnClickListener);
        this.dXI = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dXI.setOnClickListener(this.mOnClickListener);
        this.dXJ = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dXJ.setOnClickListener(this.mOnClickListener);
        this.dXK = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dXK.addTextChangedListener(this.dXM);
        switch (this.mScore) {
            case 2:
                this.dXF.setChecked(true);
                this.dXG.setChecked(false);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(false);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 6:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(false);
                this.dXJ.setChecked(false);
                return;
            case 8:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(true);
                this.dXJ.setChecked(false);
                return;
            case 10:
                this.dXF.setChecked(true);
                this.dXG.setChecked(true);
                this.dXH.setChecked(true);
                this.dXI.setChecked(true);
                this.dXJ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFX() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dXL);
        httpMessage.addParam("content", this.dXK.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dXN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dXN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dXF, e.f.game_comment_score_btn_bg);
        al.i(this.dXG, e.f.game_comment_score_btn_bg);
        al.i(this.dXH, e.f.game_comment_score_btn_bg);
        al.i(this.dXI, e.f.game_comment_score_btn_bg);
        al.i(this.dXJ, e.f.game_comment_score_btn_bg);
        if (this.dXE.isEnabled()) {
            al.h(this.dXE, e.d.cp_link_tip_g);
        } else {
            al.h(this.dXE, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dXK.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dXK.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
