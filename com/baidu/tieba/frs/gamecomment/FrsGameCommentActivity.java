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
    private NavigationBar cNU;
    private TextView dUg;
    private RadioButton dUh;
    private RadioButton dUi;
    private RadioButton dUj;
    private RadioButton dUk;
    private RadioButton dUl;
    private EditText dUm;
    private int dUn;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dUh) {
                FrsGameCommentActivity.this.dUi.setChecked(false);
                FrsGameCommentActivity.this.dUj.setChecked(false);
                FrsGameCommentActivity.this.dUk.setChecked(false);
                FrsGameCommentActivity.this.dUl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dUi) {
                FrsGameCommentActivity.this.dUh.setChecked(true);
                FrsGameCommentActivity.this.dUj.setChecked(false);
                FrsGameCommentActivity.this.dUk.setChecked(false);
                FrsGameCommentActivity.this.dUl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dUj) {
                FrsGameCommentActivity.this.dUh.setChecked(true);
                FrsGameCommentActivity.this.dUi.setChecked(true);
                FrsGameCommentActivity.this.dUk.setChecked(false);
                FrsGameCommentActivity.this.dUl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dUk) {
                FrsGameCommentActivity.this.dUh.setChecked(true);
                FrsGameCommentActivity.this.dUi.setChecked(true);
                FrsGameCommentActivity.this.dUj.setChecked(true);
                FrsGameCommentActivity.this.dUl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dUl) {
                FrsGameCommentActivity.this.dUh.setChecked(true);
                FrsGameCommentActivity.this.dUi.setChecked(true);
                FrsGameCommentActivity.this.dUj.setChecked(true);
                FrsGameCommentActivity.this.dUk.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dUo = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dUm.getText().length() > 0) {
                FrsGameCommentActivity.this.dUg.setEnabled(true);
                al.h(FrsGameCommentActivity.this.dUg, e.d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dUg.setEnabled(false);
            al.h(FrsGameCommentActivity.this.dUg, e.d.cp_cont_e);
        }
    };
    private HttpMessageListener dUp = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dUn = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").x(ImageViewerConfig.FORUM_ID, this.dUn));
    }

    private void initView() {
        setContentView(e.h.frs_game_comment_layout);
        this.cNU = (NavigationBar) findViewById(e.g.frs_game_comment_navigation_bar);
        this.cNU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cNU.setCenterTextTitle(getPageContext().getPageActivity().getString(e.j.frs_game_comment_title));
        this.cNU.showBottomLine(true);
        this.dUg = this.cNU.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kV()) {
                    FrsGameCommentActivity.this.showToast(e.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(e.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aEL();
            }
        });
        this.dUg.setText(getPageContext().getPageActivity().getString(e.j.send_post));
        this.dUg.setTextColor(getPageContext().getPageActivity().getResources().getColor(e.d.cp_cont_e));
        this.dUg.setEnabled(false);
        this.dUh = (RadioButton) findViewById(e.g.frs_game_comment_grade_1);
        this.dUh.setOnClickListener(this.mOnClickListener);
        this.dUi = (RadioButton) findViewById(e.g.frs_game_comment_grade_2);
        this.dUi.setOnClickListener(this.mOnClickListener);
        this.dUj = (RadioButton) findViewById(e.g.frs_game_comment_grade_3);
        this.dUj.setOnClickListener(this.mOnClickListener);
        this.dUk = (RadioButton) findViewById(e.g.frs_game_comment_grade_4);
        this.dUk.setOnClickListener(this.mOnClickListener);
        this.dUl = (RadioButton) findViewById(e.g.frs_game_comment_grade_5);
        this.dUl.setOnClickListener(this.mOnClickListener);
        this.dUm = (EditText) findViewById(e.g.frs_game_comment_edit);
        this.dUm.addTextChangedListener(this.dUo);
        switch (this.mScore) {
            case 2:
                this.dUh.setChecked(true);
                this.dUi.setChecked(false);
                this.dUj.setChecked(false);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(false);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 6:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(false);
                this.dUl.setChecked(false);
                return;
            case 8:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(true);
                this.dUl.setChecked(false);
                return;
            case 10:
                this.dUh.setChecked(true);
                this.dUi.setChecked(true);
                this.dUj.setChecked(true);
                this.dUk.setChecked(true);
                this.dUl.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEL() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dUn);
        httpMessage.addParam("content", this.dUm.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dUp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dUp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.dUh, e.f.game_comment_score_btn_bg);
        al.i(this.dUi, e.f.game_comment_score_btn_bg);
        al.i(this.dUj, e.f.game_comment_score_btn_bg);
        al.i(this.dUk, e.f.game_comment_score_btn_bg);
        al.i(this.dUl, e.f.game_comment_score_btn_bg);
        if (this.dUg.isEnabled()) {
            al.h(this.dUg, e.d.cp_link_tip_g);
        } else {
            al.h(this.dUg, e.d.cp_cont_e);
        }
        al.h(this.mTitle, e.d.cp_cont_b);
        if (i == 1) {
            this.dUm.setHintTextColor(getResources().getColor(e.d.cp_cont_d_1));
        } else {
            this.dUm.setHintTextColor(getResources().getColor(e.d.cp_cont_d));
        }
    }
}
