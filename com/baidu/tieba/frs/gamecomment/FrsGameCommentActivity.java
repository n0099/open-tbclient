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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes3.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar cig;
    private TextView dhF;
    private RadioButton dhG;
    private RadioButton dhH;
    private RadioButton dhI;
    private RadioButton dhJ;
    private RadioButton dhK;
    private EditText dhL;
    private int dhM;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == FrsGameCommentActivity.this.dhG) {
                FrsGameCommentActivity.this.dhH.setChecked(false);
                FrsGameCommentActivity.this.dhI.setChecked(false);
                FrsGameCommentActivity.this.dhJ.setChecked(false);
                FrsGameCommentActivity.this.dhK.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view2 == FrsGameCommentActivity.this.dhH) {
                FrsGameCommentActivity.this.dhG.setChecked(true);
                FrsGameCommentActivity.this.dhI.setChecked(false);
                FrsGameCommentActivity.this.dhJ.setChecked(false);
                FrsGameCommentActivity.this.dhK.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view2 == FrsGameCommentActivity.this.dhI) {
                FrsGameCommentActivity.this.dhG.setChecked(true);
                FrsGameCommentActivity.this.dhH.setChecked(true);
                FrsGameCommentActivity.this.dhJ.setChecked(false);
                FrsGameCommentActivity.this.dhK.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view2 == FrsGameCommentActivity.this.dhJ) {
                FrsGameCommentActivity.this.dhG.setChecked(true);
                FrsGameCommentActivity.this.dhH.setChecked(true);
                FrsGameCommentActivity.this.dhI.setChecked(true);
                FrsGameCommentActivity.this.dhK.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view2 == FrsGameCommentActivity.this.dhK) {
                FrsGameCommentActivity.this.dhG.setChecked(true);
                FrsGameCommentActivity.this.dhH.setChecked(true);
                FrsGameCommentActivity.this.dhI.setChecked(true);
                FrsGameCommentActivity.this.dhJ.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dhN = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dhL.getText().length() > 0) {
                FrsGameCommentActivity.this.dhF.setEnabled(true);
                ak.h(FrsGameCommentActivity.this.dhF, d.C0126d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dhF.setEnabled(false);
            ak.h(FrsGameCommentActivity.this.dhF, d.C0126d.cp_cont_e);
        }
    };
    private HttpMessageListener dhO = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.mScore = getIntent().getIntExtra(WBConstants.GAME_PARAMS_SCORE, 0);
        this.dhM = getIntent().getIntExtra("forum_id", -1);
        initView();
        AE();
        registerListener();
        TiebaStatic.log(new al("c12340").r(ImageViewerConfig.FORUM_ID, this.dhM));
    }

    private void initView() {
        setContentView(d.i.frs_game_comment_layout);
        this.cig = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.cig.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cig.setCenterTextTitle(getPageContext().getPageActivity().getString(d.k.frs_game_comment_title));
        this.cig.showBottomLine(true);
        this.dhF = this.cig.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.gP()) {
                    FrsGameCommentActivity.this.showToast(d.k.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.k.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.asK();
            }
        });
        this.dhF.setText(getPageContext().getPageActivity().getString(d.k.send_post));
        this.dhF.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0126d.cp_cont_e));
        this.dhF.setEnabled(false);
        this.dhG = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dhG.setOnClickListener(this.mOnClickListener);
        this.dhH = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dhH.setOnClickListener(this.mOnClickListener);
        this.dhI = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dhI.setOnClickListener(this.mOnClickListener);
        this.dhJ = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dhJ.setOnClickListener(this.mOnClickListener);
        this.dhK = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dhK.setOnClickListener(this.mOnClickListener);
        this.dhL = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dhL.addTextChangedListener(this.dhN);
        switch (this.mScore) {
            case 2:
                this.dhG.setChecked(true);
                this.dhH.setChecked(false);
                this.dhI.setChecked(false);
                this.dhJ.setChecked(false);
                this.dhK.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dhG.setChecked(true);
                this.dhH.setChecked(true);
                this.dhI.setChecked(false);
                this.dhJ.setChecked(false);
                this.dhK.setChecked(false);
                return;
            case 6:
                this.dhG.setChecked(true);
                this.dhH.setChecked(true);
                this.dhI.setChecked(true);
                this.dhJ.setChecked(false);
                this.dhK.setChecked(false);
                return;
            case 8:
                this.dhG.setChecked(true);
                this.dhH.setChecked(true);
                this.dhI.setChecked(true);
                this.dhJ.setChecked(true);
                this.dhK.setChecked(false);
                return;
            case 10:
                this.dhG.setChecked(true);
                this.dhH.setChecked(true);
                this.dhI.setChecked(true);
                this.dhJ.setChecked(true);
                this.dhK.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asK() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(WBConstants.GAME_PARAMS_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dhM);
        httpMessage.addParam("content", this.dhL.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void AE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dhO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dhO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.i(this.dhG, d.f.game_comment_score_btn_bg);
        ak.i(this.dhH, d.f.game_comment_score_btn_bg);
        ak.i(this.dhI, d.f.game_comment_score_btn_bg);
        ak.i(this.dhJ, d.f.game_comment_score_btn_bg);
        ak.i(this.dhK, d.f.game_comment_score_btn_bg);
        if (this.dhF.isEnabled()) {
            ak.h(this.dhF, d.C0126d.cp_link_tip_g);
        } else {
            ak.h(this.dhF, d.C0126d.cp_cont_e);
        }
        ak.h(this.mTitle, d.C0126d.cp_cont_b);
        if (i == 1) {
            this.dhL.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d_1));
        } else {
            this.dhL.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d));
        }
    }
}
