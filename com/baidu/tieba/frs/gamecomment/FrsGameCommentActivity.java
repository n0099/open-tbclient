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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar crN;
    private TextView dxT;
    private RadioButton dxU;
    private RadioButton dxV;
    private RadioButton dxW;
    private RadioButton dxX;
    private RadioButton dxY;
    private EditText dxZ;
    private int dya;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dxU) {
                FrsGameCommentActivity.this.dxV.setChecked(false);
                FrsGameCommentActivity.this.dxW.setChecked(false);
                FrsGameCommentActivity.this.dxX.setChecked(false);
                FrsGameCommentActivity.this.dxY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dxV) {
                FrsGameCommentActivity.this.dxU.setChecked(true);
                FrsGameCommentActivity.this.dxW.setChecked(false);
                FrsGameCommentActivity.this.dxX.setChecked(false);
                FrsGameCommentActivity.this.dxY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dxW) {
                FrsGameCommentActivity.this.dxU.setChecked(true);
                FrsGameCommentActivity.this.dxV.setChecked(true);
                FrsGameCommentActivity.this.dxX.setChecked(false);
                FrsGameCommentActivity.this.dxY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dxX) {
                FrsGameCommentActivity.this.dxU.setChecked(true);
                FrsGameCommentActivity.this.dxV.setChecked(true);
                FrsGameCommentActivity.this.dxW.setChecked(true);
                FrsGameCommentActivity.this.dxY.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dxY) {
                FrsGameCommentActivity.this.dxU.setChecked(true);
                FrsGameCommentActivity.this.dxV.setChecked(true);
                FrsGameCommentActivity.this.dxW.setChecked(true);
                FrsGameCommentActivity.this.dxX.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dyb = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dxZ.getText().length() > 0) {
                FrsGameCommentActivity.this.dxT.setEnabled(true);
                am.h(FrsGameCommentActivity.this.dxT, d.C0140d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dxT.setEnabled(false);
            am.h(FrsGameCommentActivity.this.dxT, d.C0140d.cp_cont_e);
        }
    };
    private HttpMessageListener dyc = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dya = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").r(ImageViewerConfig.FORUM_ID, this.dya));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.crN = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.crN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.crN.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.crN.showBottomLine(true);
        this.dxT = this.crN.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.jE()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.axY();
            }
        });
        this.dxT.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.dxT.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0140d.cp_cont_e));
        this.dxT.setEnabled(false);
        this.dxU = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dxU.setOnClickListener(this.mOnClickListener);
        this.dxV = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dxV.setOnClickListener(this.mOnClickListener);
        this.dxW = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dxW.setOnClickListener(this.mOnClickListener);
        this.dxX = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dxX.setOnClickListener(this.mOnClickListener);
        this.dxY = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dxY.setOnClickListener(this.mOnClickListener);
        this.dxZ = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dxZ.addTextChangedListener(this.dyb);
        switch (this.mScore) {
            case 2:
                this.dxU.setChecked(true);
                this.dxV.setChecked(false);
                this.dxW.setChecked(false);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(false);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 6:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(false);
                this.dxY.setChecked(false);
                return;
            case 8:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(true);
                this.dxY.setChecked(false);
                return;
            case 10:
                this.dxU.setChecked(true);
                this.dxV.setChecked(true);
                this.dxW.setChecked(true);
                this.dxX.setChecked(true);
                this.dxY.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axY() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dya);
        httpMessage.addParam("content", this.dxZ.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dyc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dyc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.dxU, d.f.game_comment_score_btn_bg);
        am.i(this.dxV, d.f.game_comment_score_btn_bg);
        am.i(this.dxW, d.f.game_comment_score_btn_bg);
        am.i(this.dxX, d.f.game_comment_score_btn_bg);
        am.i(this.dxY, d.f.game_comment_score_btn_bg);
        if (this.dxT.isEnabled()) {
            am.h(this.dxT, d.C0140d.cp_link_tip_g);
        } else {
            am.h(this.dxT, d.C0140d.cp_cont_e);
        }
        am.h(this.mTitle, d.C0140d.cp_cont_b);
        if (i == 1) {
            this.dxZ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d_1));
        } else {
            this.dxZ.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d));
        }
    }
}
