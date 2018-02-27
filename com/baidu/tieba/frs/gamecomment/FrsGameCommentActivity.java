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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes3.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar cRR;
    private TextView dOU;
    private RadioButton dOV;
    private RadioButton dOW;
    private RadioButton dOX;
    private RadioButton dOY;
    private RadioButton dOZ;
    private EditText dPa;
    private TextView dPb;
    private int dPc;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dOV) {
                FrsGameCommentActivity.this.dOW.setChecked(false);
                FrsGameCommentActivity.this.dOX.setChecked(false);
                FrsGameCommentActivity.this.dOY.setChecked(false);
                FrsGameCommentActivity.this.dOZ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dOW) {
                FrsGameCommentActivity.this.dOV.setChecked(true);
                FrsGameCommentActivity.this.dOX.setChecked(false);
                FrsGameCommentActivity.this.dOY.setChecked(false);
                FrsGameCommentActivity.this.dOZ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dOX) {
                FrsGameCommentActivity.this.dOV.setChecked(true);
                FrsGameCommentActivity.this.dOW.setChecked(true);
                FrsGameCommentActivity.this.dOY.setChecked(false);
                FrsGameCommentActivity.this.dOZ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dOY) {
                FrsGameCommentActivity.this.dOV.setChecked(true);
                FrsGameCommentActivity.this.dOW.setChecked(true);
                FrsGameCommentActivity.this.dOX.setChecked(true);
                FrsGameCommentActivity.this.dOZ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dOZ) {
                FrsGameCommentActivity.this.dOV.setChecked(true);
                FrsGameCommentActivity.this.dOW.setChecked(true);
                FrsGameCommentActivity.this.dOX.setChecked(true);
                FrsGameCommentActivity.this.dOY.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dPd = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = 50;
            int length = FrsGameCommentActivity.this.dPa.getText().length();
            if (length > 50) {
                FrsGameCommentActivity.this.dPa.setText(FrsGameCommentActivity.this.dPa.getText().toString().substring(0, 50));
                FrsGameCommentActivity.this.dPa.setSelection(FrsGameCommentActivity.this.dPa.length());
                FrsGameCommentActivity.this.showToast(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_limit_tip));
            } else {
                i = length;
            }
            FrsGameCommentActivity.this.dPb.setText(String.format(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), Integer.valueOf(i)));
            if (i > 0) {
                FrsGameCommentActivity.this.dOU.setEnabled(true);
                aj.r(FrsGameCommentActivity.this.dOU, d.C0141d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dOU.setEnabled(false);
            aj.r(FrsGameCommentActivity.this.dOU, d.C0141d.cp_cont_e);
        }
    };
    private HttpMessageListener dPe = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            FrsGameCommentActivity.this.closeLoadingDialog();
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof FrsGameCommentResponseMessage)) {
                FrsGameCommentResponseMessage frsGameCommentResponseMessage = (FrsGameCommentResponseMessage) httpResponsedMessage;
                if (frsGameCommentResponseMessage.getError() == 0) {
                    FrsGameCommentActivity.this.setResult(2);
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
        this.dPc = getIntent().getIntExtra("forum_id", -1);
        initView();
        HP();
        registerListener();
        TiebaStatic.log(new ak("c12340").s(ImageViewerConfig.FORUM_ID, this.dPc));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.cRR = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.cRR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cRR.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.cRR.showBottomLine(true);
        this.dOU = this.cRR.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.oJ()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.ayd();
            }
        });
        this.dOU.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.dOU.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0141d.cp_cont_e));
        this.dOU.setEnabled(false);
        this.dOV = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dOV.setOnClickListener(this.mOnClickListener);
        this.dOW = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dOW.setOnClickListener(this.mOnClickListener);
        this.dOX = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dOX.setOnClickListener(this.mOnClickListener);
        this.dOY = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dOY.setOnClickListener(this.mOnClickListener);
        this.dOZ = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dOZ.setOnClickListener(this.mOnClickListener);
        this.dPa = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dPa.addTextChangedListener(this.dPd);
        this.dPb = (TextView) findViewById(d.g.frs_game_comment_chars_num);
        this.dPb.setText(String.format(getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), 0));
        switch (this.mScore) {
            case 2:
                this.dOV.setChecked(true);
                this.dOW.setChecked(false);
                this.dOX.setChecked(false);
                this.dOY.setChecked(false);
                this.dOZ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dOV.setChecked(true);
                this.dOW.setChecked(true);
                this.dOX.setChecked(false);
                this.dOY.setChecked(false);
                this.dOZ.setChecked(false);
                return;
            case 6:
                this.dOV.setChecked(true);
                this.dOW.setChecked(true);
                this.dOX.setChecked(true);
                this.dOY.setChecked(false);
                this.dOZ.setChecked(false);
                return;
            case 8:
                this.dOV.setChecked(true);
                this.dOW.setChecked(true);
                this.dOX.setChecked(true);
                this.dOY.setChecked(true);
                this.dOZ.setChecked(false);
                return;
            case 10:
                this.dOV.setChecked(true);
                this.dOW.setChecked(true);
                this.dOX.setChecked(true);
                this.dOY.setChecked(true);
                this.dOZ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayd() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(WBConstants.GAME_PARAMS_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dPc);
        httpMessage.addParam("content", this.dPa.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void HP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dPe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dPe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.dOV, d.f.game_comment_score_btn_bg);
        aj.s(this.dOW, d.f.game_comment_score_btn_bg);
        aj.s(this.dOX, d.f.game_comment_score_btn_bg);
        aj.s(this.dOY, d.f.game_comment_score_btn_bg);
        aj.s(this.dOZ, d.f.game_comment_score_btn_bg);
        if (this.dOU.isEnabled()) {
            aj.r(this.dOU, d.C0141d.cp_link_tip_g);
        } else {
            aj.r(this.dOU, d.C0141d.cp_cont_e);
        }
        aj.r(this.mTitle, d.C0141d.cp_cont_b);
        aj.r(this.dPb, d.C0141d.cp_cont_d);
        if (i == 1) {
            this.dPa.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        } else {
            this.dPa.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        }
    }
}
