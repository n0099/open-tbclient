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
    private NavigationBar cHm;
    private TextView dND;
    private RadioButton dNE;
    private RadioButton dNF;
    private RadioButton dNG;
    private RadioButton dNH;
    private RadioButton dNI;
    private EditText dNJ;
    private int dNK;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dNE) {
                FrsGameCommentActivity.this.dNF.setChecked(false);
                FrsGameCommentActivity.this.dNG.setChecked(false);
                FrsGameCommentActivity.this.dNH.setChecked(false);
                FrsGameCommentActivity.this.dNI.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dNF) {
                FrsGameCommentActivity.this.dNE.setChecked(true);
                FrsGameCommentActivity.this.dNG.setChecked(false);
                FrsGameCommentActivity.this.dNH.setChecked(false);
                FrsGameCommentActivity.this.dNI.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dNG) {
                FrsGameCommentActivity.this.dNE.setChecked(true);
                FrsGameCommentActivity.this.dNF.setChecked(true);
                FrsGameCommentActivity.this.dNH.setChecked(false);
                FrsGameCommentActivity.this.dNI.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dNH) {
                FrsGameCommentActivity.this.dNE.setChecked(true);
                FrsGameCommentActivity.this.dNF.setChecked(true);
                FrsGameCommentActivity.this.dNG.setChecked(true);
                FrsGameCommentActivity.this.dNI.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dNI) {
                FrsGameCommentActivity.this.dNE.setChecked(true);
                FrsGameCommentActivity.this.dNF.setChecked(true);
                FrsGameCommentActivity.this.dNG.setChecked(true);
                FrsGameCommentActivity.this.dNH.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dNL = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dNJ.getText().length() > 0) {
                FrsGameCommentActivity.this.dND.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dND, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dND.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dND, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dNM = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dNK = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").x(ImageViewerConfig.FORUM_ID, this.dNK));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cHm = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cHm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cHm.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cHm.showBottomLine(true);
        this.dND = this.cHm.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kV()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aCZ();
            }
        });
        this.dND.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dND.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dND.setEnabled(false);
        this.dNE = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dNE.setOnClickListener(this.mOnClickListener);
        this.dNF = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dNF.setOnClickListener(this.mOnClickListener);
        this.dNG = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dNG.setOnClickListener(this.mOnClickListener);
        this.dNH = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dNH.setOnClickListener(this.mOnClickListener);
        this.dNI = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dNI.setOnClickListener(this.mOnClickListener);
        this.dNJ = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dNJ.addTextChangedListener(this.dNL);
        switch (this.mScore) {
            case 2:
                this.dNE.setChecked(true);
                this.dNF.setChecked(false);
                this.dNG.setChecked(false);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(false);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 6:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(false);
                this.dNI.setChecked(false);
                return;
            case 8:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(true);
                this.dNI.setChecked(false);
                return;
            case 10:
                this.dNE.setChecked(true);
                this.dNF.setChecked(true);
                this.dNG.setChecked(true);
                this.dNH.setChecked(true);
                this.dNI.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dNK);
        httpMessage.addParam("content", this.dNJ.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dNM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dNM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dNE, e.f.game_comment_score_btn_bg);
        al.i(this.dNF, e.f.game_comment_score_btn_bg);
        al.i(this.dNG, e.f.game_comment_score_btn_bg);
        al.i(this.dNH, e.f.game_comment_score_btn_bg);
        al.i(this.dNI, e.f.game_comment_score_btn_bg);
        if (this.dND.isEnabled()) {
            al.h(this.dND, e.d.cp_link_tip_g);
        } else {
            al.h(this.dND, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dNJ.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dNJ.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
