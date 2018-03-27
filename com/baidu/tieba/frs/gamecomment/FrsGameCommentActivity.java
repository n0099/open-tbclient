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
    private NavigationBar cRU;
    private TextView dOZ;
    private RadioButton dPa;
    private RadioButton dPb;
    private RadioButton dPc;
    private RadioButton dPd;
    private RadioButton dPe;
    private EditText dPf;
    private TextView dPg;
    private int dPh;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dPa) {
                FrsGameCommentActivity.this.dPb.setChecked(false);
                FrsGameCommentActivity.this.dPc.setChecked(false);
                FrsGameCommentActivity.this.dPd.setChecked(false);
                FrsGameCommentActivity.this.dPe.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dPb) {
                FrsGameCommentActivity.this.dPa.setChecked(true);
                FrsGameCommentActivity.this.dPc.setChecked(false);
                FrsGameCommentActivity.this.dPd.setChecked(false);
                FrsGameCommentActivity.this.dPe.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dPc) {
                FrsGameCommentActivity.this.dPa.setChecked(true);
                FrsGameCommentActivity.this.dPb.setChecked(true);
                FrsGameCommentActivity.this.dPd.setChecked(false);
                FrsGameCommentActivity.this.dPe.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dPd) {
                FrsGameCommentActivity.this.dPa.setChecked(true);
                FrsGameCommentActivity.this.dPb.setChecked(true);
                FrsGameCommentActivity.this.dPc.setChecked(true);
                FrsGameCommentActivity.this.dPe.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dPe) {
                FrsGameCommentActivity.this.dPa.setChecked(true);
                FrsGameCommentActivity.this.dPb.setChecked(true);
                FrsGameCommentActivity.this.dPc.setChecked(true);
                FrsGameCommentActivity.this.dPd.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dPi = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = 50;
            int length = FrsGameCommentActivity.this.dPf.getText().length();
            if (length > 50) {
                FrsGameCommentActivity.this.dPf.setText(FrsGameCommentActivity.this.dPf.getText().toString().substring(0, 50));
                FrsGameCommentActivity.this.dPf.setSelection(FrsGameCommentActivity.this.dPf.length());
                FrsGameCommentActivity.this.showToast(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_limit_tip));
            } else {
                i = length;
            }
            FrsGameCommentActivity.this.dPg.setText(String.format(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), Integer.valueOf(i)));
            if (i > 0) {
                FrsGameCommentActivity.this.dOZ.setEnabled(true);
                aj.r(FrsGameCommentActivity.this.dOZ, d.C0141d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dOZ.setEnabled(false);
            aj.r(FrsGameCommentActivity.this.dOZ, d.C0141d.cp_cont_e);
        }
    };
    private HttpMessageListener dPj = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dPh = getIntent().getIntExtra("forum_id", -1);
        initView();
        HQ();
        registerListener();
        TiebaStatic.log(new ak("c12340").s(ImageViewerConfig.FORUM_ID, this.dPh));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.cRU = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.cRU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cRU.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.cRU.showBottomLine(true);
        this.dOZ = this.cRU.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.oJ()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.ayf();
            }
        });
        this.dOZ.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.dOZ.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0141d.cp_cont_e));
        this.dOZ.setEnabled(false);
        this.dPa = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dPa.setOnClickListener(this.mOnClickListener);
        this.dPb = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dPb.setOnClickListener(this.mOnClickListener);
        this.dPc = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dPc.setOnClickListener(this.mOnClickListener);
        this.dPd = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dPd.setOnClickListener(this.mOnClickListener);
        this.dPe = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dPe.setOnClickListener(this.mOnClickListener);
        this.dPf = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dPf.addTextChangedListener(this.dPi);
        this.dPg = (TextView) findViewById(d.g.frs_game_comment_chars_num);
        this.dPg.setText(String.format(getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), 0));
        switch (this.mScore) {
            case 2:
                this.dPa.setChecked(true);
                this.dPb.setChecked(false);
                this.dPc.setChecked(false);
                this.dPd.setChecked(false);
                this.dPe.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dPa.setChecked(true);
                this.dPb.setChecked(true);
                this.dPc.setChecked(false);
                this.dPd.setChecked(false);
                this.dPe.setChecked(false);
                return;
            case 6:
                this.dPa.setChecked(true);
                this.dPb.setChecked(true);
                this.dPc.setChecked(true);
                this.dPd.setChecked(false);
                this.dPe.setChecked(false);
                return;
            case 8:
                this.dPa.setChecked(true);
                this.dPb.setChecked(true);
                this.dPc.setChecked(true);
                this.dPd.setChecked(true);
                this.dPe.setChecked(false);
                return;
            case 10:
                this.dPa.setChecked(true);
                this.dPb.setChecked(true);
                this.dPc.setChecked(true);
                this.dPd.setChecked(true);
                this.dPe.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(WBConstants.GAME_PARAMS_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dPh);
        httpMessage.addParam("content", this.dPf.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void HQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.dPj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dPj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.dPa, d.f.game_comment_score_btn_bg);
        aj.s(this.dPb, d.f.game_comment_score_btn_bg);
        aj.s(this.dPc, d.f.game_comment_score_btn_bg);
        aj.s(this.dPd, d.f.game_comment_score_btn_bg);
        aj.s(this.dPe, d.f.game_comment_score_btn_bg);
        if (this.dOZ.isEnabled()) {
            aj.r(this.dOZ, d.C0141d.cp_link_tip_g);
        } else {
            aj.r(this.dOZ, d.C0141d.cp_cont_e);
        }
        aj.r(this.mTitle, d.C0141d.cp_cont_b);
        aj.r(this.dPg, d.C0141d.cp_cont_d);
        if (i == 1) {
            this.dPf.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        } else {
            this.dPf.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        }
    }
}
