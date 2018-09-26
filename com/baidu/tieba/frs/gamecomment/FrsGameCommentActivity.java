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
    private NavigationBar cxA;
    private TextView dEA;
    private RadioButton dEB;
    private RadioButton dEC;
    private RadioButton dED;
    private RadioButton dEE;
    private RadioButton dEF;
    private EditText dEG;
    private int dEH;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dEB) {
                FrsGameCommentActivity.this.dEC.setChecked(false);
                FrsGameCommentActivity.this.dED.setChecked(false);
                FrsGameCommentActivity.this.dEE.setChecked(false);
                FrsGameCommentActivity.this.dEF.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dEC) {
                FrsGameCommentActivity.this.dEB.setChecked(true);
                FrsGameCommentActivity.this.dED.setChecked(false);
                FrsGameCommentActivity.this.dEE.setChecked(false);
                FrsGameCommentActivity.this.dEF.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dED) {
                FrsGameCommentActivity.this.dEB.setChecked(true);
                FrsGameCommentActivity.this.dEC.setChecked(true);
                FrsGameCommentActivity.this.dEE.setChecked(false);
                FrsGameCommentActivity.this.dEF.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dEE) {
                FrsGameCommentActivity.this.dEB.setChecked(true);
                FrsGameCommentActivity.this.dEC.setChecked(true);
                FrsGameCommentActivity.this.dED.setChecked(true);
                FrsGameCommentActivity.this.dEF.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dEF) {
                FrsGameCommentActivity.this.dEB.setChecked(true);
                FrsGameCommentActivity.this.dEC.setChecked(true);
                FrsGameCommentActivity.this.dED.setChecked(true);
                FrsGameCommentActivity.this.dEE.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dEI = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dEG.getText().length() > 0) {
                FrsGameCommentActivity.this.dEA.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dEA, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dEA.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dEA, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dEJ = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dEH = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").w(ImageViewerConfig.FORUM_ID, this.dEH));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cxA = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cxA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cxA.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cxA.showBottomLine(true);
        this.dEA = this.cxA.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kK()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aAl();
            }
        });
        this.dEA.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dEA.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dEA.setEnabled(false);
        this.dEB = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dEB.setOnClickListener(this.mOnClickListener);
        this.dEC = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dEC.setOnClickListener(this.mOnClickListener);
        this.dED = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dED.setOnClickListener(this.mOnClickListener);
        this.dEE = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dEE.setOnClickListener(this.mOnClickListener);
        this.dEF = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dEF.setOnClickListener(this.mOnClickListener);
        this.dEG = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dEG.addTextChangedListener(this.dEI);
        switch (this.mScore) {
            case 2:
                this.dEB.setChecked(true);
                this.dEC.setChecked(false);
                this.dED.setChecked(false);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(false);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 6:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(false);
                this.dEF.setChecked(false);
                return;
            case 8:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(true);
                this.dEF.setChecked(false);
                return;
            case 10:
                this.dEB.setChecked(true);
                this.dEC.setChecked(true);
                this.dED.setChecked(true);
                this.dEE.setChecked(true);
                this.dEF.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dEH);
        httpMessage.addParam("content", this.dEG.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dEJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dEJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dEB, e.f.game_comment_score_btn_bg);
        al.i(this.dEC, e.f.game_comment_score_btn_bg);
        al.i(this.dED, e.f.game_comment_score_btn_bg);
        al.i(this.dEE, e.f.game_comment_score_btn_bg);
        al.i(this.dEF, e.f.game_comment_score_btn_bg);
        if (this.dEA.isEnabled()) {
            al.h(this.dEA, e.d.cp_link_tip_g);
        } else {
            al.h(this.dEA, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dEG.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dEG.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
