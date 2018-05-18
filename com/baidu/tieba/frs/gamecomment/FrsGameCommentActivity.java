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
    private NavigationBar ciZ;
    private TextView diJ;
    private RadioButton diK;
    private RadioButton diL;
    private RadioButton diM;
    private RadioButton diN;
    private RadioButton diO;
    private EditText diP;
    private int diQ;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 == FrsGameCommentActivity.this.diK) {
                FrsGameCommentActivity.this.diL.setChecked(false);
                FrsGameCommentActivity.this.diM.setChecked(false);
                FrsGameCommentActivity.this.diN.setChecked(false);
                FrsGameCommentActivity.this.diO.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view2 == FrsGameCommentActivity.this.diL) {
                FrsGameCommentActivity.this.diK.setChecked(true);
                FrsGameCommentActivity.this.diM.setChecked(false);
                FrsGameCommentActivity.this.diN.setChecked(false);
                FrsGameCommentActivity.this.diO.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view2 == FrsGameCommentActivity.this.diM) {
                FrsGameCommentActivity.this.diK.setChecked(true);
                FrsGameCommentActivity.this.diL.setChecked(true);
                FrsGameCommentActivity.this.diN.setChecked(false);
                FrsGameCommentActivity.this.diO.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view2 == FrsGameCommentActivity.this.diN) {
                FrsGameCommentActivity.this.diK.setChecked(true);
                FrsGameCommentActivity.this.diL.setChecked(true);
                FrsGameCommentActivity.this.diM.setChecked(true);
                FrsGameCommentActivity.this.diO.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view2 == FrsGameCommentActivity.this.diO) {
                FrsGameCommentActivity.this.diK.setChecked(true);
                FrsGameCommentActivity.this.diL.setChecked(true);
                FrsGameCommentActivity.this.diM.setChecked(true);
                FrsGameCommentActivity.this.diN.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher diR = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.diP.getText().length() > 0) {
                FrsGameCommentActivity.this.diJ.setEnabled(true);
                ak.h(FrsGameCommentActivity.this.diJ, d.C0126d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.diJ.setEnabled(false);
            ak.h(FrsGameCommentActivity.this.diJ, d.C0126d.cp_cont_e);
        }
    };
    private HttpMessageListener diS = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.diQ = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new al("c12340").r(ImageViewerConfig.FORUM_ID, this.diQ));
    }

    private void initView() {
        setContentView(d.i.frs_game_comment_layout);
        this.ciZ = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.ciZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.ciZ.setCenterTextTitle(getPageContext().getPageActivity().getString(d.k.frs_game_comment_title));
        this.ciZ.showBottomLine(true);
        this.diJ = this.ciZ.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!j.gP()) {
                    FrsGameCommentActivity.this.showToast(d.k.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.k.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.asJ();
            }
        });
        this.diJ.setText(getPageContext().getPageActivity().getString(d.k.send_post));
        this.diJ.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0126d.cp_cont_e));
        this.diJ.setEnabled(false);
        this.diK = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.diK.setOnClickListener(this.mOnClickListener);
        this.diL = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.diL.setOnClickListener(this.mOnClickListener);
        this.diM = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.diM.setOnClickListener(this.mOnClickListener);
        this.diN = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.diN.setOnClickListener(this.mOnClickListener);
        this.diO = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.diO.setOnClickListener(this.mOnClickListener);
        this.diP = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.diP.addTextChangedListener(this.diR);
        switch (this.mScore) {
            case 2:
                this.diK.setChecked(true);
                this.diL.setChecked(false);
                this.diM.setChecked(false);
                this.diN.setChecked(false);
                this.diO.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.diK.setChecked(true);
                this.diL.setChecked(true);
                this.diM.setChecked(false);
                this.diN.setChecked(false);
                this.diO.setChecked(false);
                return;
            case 6:
                this.diK.setChecked(true);
                this.diL.setChecked(true);
                this.diM.setChecked(true);
                this.diN.setChecked(false);
                this.diO.setChecked(false);
                return;
            case 8:
                this.diK.setChecked(true);
                this.diL.setChecked(true);
                this.diM.setChecked(true);
                this.diN.setChecked(true);
                this.diO.setChecked(false);
                return;
            case 10:
                this.diK.setChecked(true);
                this.diL.setChecked(true);
                this.diM.setChecked(true);
                this.diN.setChecked(true);
                this.diO.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asJ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(WBConstants.GAME_PARAMS_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.diQ);
        httpMessage.addParam("content", this.diP.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.diS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.diS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.i(this.diK, d.f.game_comment_score_btn_bg);
        ak.i(this.diL, d.f.game_comment_score_btn_bg);
        ak.i(this.diM, d.f.game_comment_score_btn_bg);
        ak.i(this.diN, d.f.game_comment_score_btn_bg);
        ak.i(this.diO, d.f.game_comment_score_btn_bg);
        if (this.diJ.isEnabled()) {
            ak.h(this.diJ, d.C0126d.cp_link_tip_g);
        } else {
            ak.h(this.diJ, d.C0126d.cp_cont_e);
        }
        ak.h(this.mTitle, d.C0126d.cp_cont_b);
        if (i == 1) {
            this.diP.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d_1));
        } else {
            this.diP.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_d));
        }
    }
}
