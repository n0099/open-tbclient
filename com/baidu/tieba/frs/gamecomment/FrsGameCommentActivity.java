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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar ecO;
    private TextView fkS;
    private RadioButton fkT;
    private RadioButton fkU;
    private RadioButton fkV;
    private RadioButton fkW;
    private RadioButton fkX;
    private EditText fkY;
    private int fkZ;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.fkT) {
                FrsGameCommentActivity.this.fkU.setChecked(false);
                FrsGameCommentActivity.this.fkV.setChecked(false);
                FrsGameCommentActivity.this.fkW.setChecked(false);
                FrsGameCommentActivity.this.fkX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fkU) {
                FrsGameCommentActivity.this.fkT.setChecked(true);
                FrsGameCommentActivity.this.fkV.setChecked(false);
                FrsGameCommentActivity.this.fkW.setChecked(false);
                FrsGameCommentActivity.this.fkX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.fkV) {
                FrsGameCommentActivity.this.fkT.setChecked(true);
                FrsGameCommentActivity.this.fkU.setChecked(true);
                FrsGameCommentActivity.this.fkW.setChecked(false);
                FrsGameCommentActivity.this.fkX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.fkW) {
                FrsGameCommentActivity.this.fkT.setChecked(true);
                FrsGameCommentActivity.this.fkU.setChecked(true);
                FrsGameCommentActivity.this.fkV.setChecked(true);
                FrsGameCommentActivity.this.fkX.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fkX) {
                FrsGameCommentActivity.this.fkT.setChecked(true);
                FrsGameCommentActivity.this.fkU.setChecked(true);
                FrsGameCommentActivity.this.fkV.setChecked(true);
                FrsGameCommentActivity.this.fkW.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher fla = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.fkY.getText().length() > 0) {
                FrsGameCommentActivity.this.fkS.setEnabled(true);
                al.j(FrsGameCommentActivity.this.fkS, d.C0277d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.fkS.setEnabled(false);
            al.j(FrsGameCommentActivity.this.fkS, d.C0277d.cp_cont_e);
        }
    };
    private HttpMessageListener flb = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.mScore = getIntent().getIntExtra("score", 0);
        this.fkZ = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").T(ImageViewerConfig.FORUM_ID, this.fkZ));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.ecO = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.ecO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.ecO.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.ecO.showBottomLine(true);
        this.fkS = this.ecO.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kY()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bgn();
            }
        });
        this.fkS.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.fkS.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0277d.cp_cont_e));
        this.fkS.setEnabled(false);
        this.fkT = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.fkT.setOnClickListener(this.mOnClickListener);
        this.fkU = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.fkU.setOnClickListener(this.mOnClickListener);
        this.fkV = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.fkV.setOnClickListener(this.mOnClickListener);
        this.fkW = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.fkW.setOnClickListener(this.mOnClickListener);
        this.fkX = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.fkX.setOnClickListener(this.mOnClickListener);
        this.fkY = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.fkY.addTextChangedListener(this.fla);
        switch (this.mScore) {
            case 2:
                this.fkT.setChecked(true);
                this.fkU.setChecked(false);
                this.fkV.setChecked(false);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(false);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 6:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(false);
                this.fkX.setChecked(false);
                return;
            case 8:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(true);
                this.fkX.setChecked(false);
                return;
            case 10:
                this.fkT.setChecked(true);
                this.fkU.setChecked(true);
                this.fkV.setChecked(true);
                this.fkW.setChecked(true);
                this.fkX.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fkZ);
        httpMessage.addParam("content", this.fkY.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.flb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.flb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.fkT, d.f.game_comment_score_btn_bg);
        al.k(this.fkU, d.f.game_comment_score_btn_bg);
        al.k(this.fkV, d.f.game_comment_score_btn_bg);
        al.k(this.fkW, d.f.game_comment_score_btn_bg);
        al.k(this.fkX, d.f.game_comment_score_btn_bg);
        if (this.fkS.isEnabled()) {
            al.j(this.fkS, d.C0277d.cp_link_tip_g);
        } else {
            al.j(this.fkS, d.C0277d.cp_cont_e);
        }
        al.j(this.mTitle, d.C0277d.cp_cont_b);
        if (i == 1) {
            this.fkY.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d_1));
        } else {
            this.fkY.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d));
        }
    }
}
