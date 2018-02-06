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
    private NavigationBar cSd;
    private TextView dPg;
    private RadioButton dPh;
    private RadioButton dPi;
    private RadioButton dPj;
    private RadioButton dPk;
    private RadioButton dPl;
    private EditText dPm;
    private TextView dPn;
    private int dPo;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dPh) {
                FrsGameCommentActivity.this.dPi.setChecked(false);
                FrsGameCommentActivity.this.dPj.setChecked(false);
                FrsGameCommentActivity.this.dPk.setChecked(false);
                FrsGameCommentActivity.this.dPl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dPi) {
                FrsGameCommentActivity.this.dPh.setChecked(true);
                FrsGameCommentActivity.this.dPj.setChecked(false);
                FrsGameCommentActivity.this.dPk.setChecked(false);
                FrsGameCommentActivity.this.dPl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dPj) {
                FrsGameCommentActivity.this.dPh.setChecked(true);
                FrsGameCommentActivity.this.dPi.setChecked(true);
                FrsGameCommentActivity.this.dPk.setChecked(false);
                FrsGameCommentActivity.this.dPl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dPk) {
                FrsGameCommentActivity.this.dPh.setChecked(true);
                FrsGameCommentActivity.this.dPi.setChecked(true);
                FrsGameCommentActivity.this.dPj.setChecked(true);
                FrsGameCommentActivity.this.dPl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dPl) {
                FrsGameCommentActivity.this.dPh.setChecked(true);
                FrsGameCommentActivity.this.dPi.setChecked(true);
                FrsGameCommentActivity.this.dPj.setChecked(true);
                FrsGameCommentActivity.this.dPk.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dPp = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = 50;
            int length = FrsGameCommentActivity.this.dPm.getText().length();
            if (length > 50) {
                FrsGameCommentActivity.this.dPm.setText(FrsGameCommentActivity.this.dPm.getText().toString().substring(0, 50));
                FrsGameCommentActivity.this.dPm.setSelection(FrsGameCommentActivity.this.dPm.length());
                FrsGameCommentActivity.this.showToast(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_limit_tip));
            } else {
                i = length;
            }
            FrsGameCommentActivity.this.dPn.setText(String.format(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), Integer.valueOf(i)));
            if (i > 0) {
                FrsGameCommentActivity.this.dPg.setEnabled(true);
                aj.r(FrsGameCommentActivity.this.dPg, d.C0140d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dPg.setEnabled(false);
            aj.r(FrsGameCommentActivity.this.dPg, d.C0140d.cp_cont_e);
        }
    };
    private HttpMessageListener dPq = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dPo = getIntent().getIntExtra("forum_id", -1);
        initView();
        HQ();
        registerListener();
        TiebaStatic.log(new ak("c12340").s(ImageViewerConfig.FORUM_ID, this.dPo));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.cSd = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.cSd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cSd.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.cSd.showBottomLine(true);
        this.dPg = this.cSd.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.oJ()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.aye();
            }
        });
        this.dPg.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.dPg.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0140d.cp_cont_e));
        this.dPg.setEnabled(false);
        this.dPh = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dPh.setOnClickListener(this.mOnClickListener);
        this.dPi = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dPi.setOnClickListener(this.mOnClickListener);
        this.dPj = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dPj.setOnClickListener(this.mOnClickListener);
        this.dPk = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dPk.setOnClickListener(this.mOnClickListener);
        this.dPl = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dPl.setOnClickListener(this.mOnClickListener);
        this.dPm = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dPm.addTextChangedListener(this.dPp);
        this.dPn = (TextView) findViewById(d.g.frs_game_comment_chars_num);
        this.dPn.setText(String.format(getPageContext().getPageActivity().getString(d.j.frs_game_comment_char_num), 0));
        switch (this.mScore) {
            case 2:
                this.dPh.setChecked(true);
                this.dPi.setChecked(false);
                this.dPj.setChecked(false);
                this.dPk.setChecked(false);
                this.dPl.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dPh.setChecked(true);
                this.dPi.setChecked(true);
                this.dPj.setChecked(false);
                this.dPk.setChecked(false);
                this.dPl.setChecked(false);
                return;
            case 6:
                this.dPh.setChecked(true);
                this.dPi.setChecked(true);
                this.dPj.setChecked(true);
                this.dPk.setChecked(false);
                this.dPl.setChecked(false);
                return;
            case 8:
                this.dPh.setChecked(true);
                this.dPi.setChecked(true);
                this.dPj.setChecked(true);
                this.dPk.setChecked(true);
                this.dPl.setChecked(false);
                return;
            case 10:
                this.dPh.setChecked(true);
                this.dPi.setChecked(true);
                this.dPj.setChecked(true);
                this.dPk.setChecked(true);
                this.dPl.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aye() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(WBConstants.GAME_PARAMS_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dPo);
        httpMessage.addParam("content", this.dPm.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dPq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dPq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.s(this.dPh, d.f.game_comment_score_btn_bg);
        aj.s(this.dPi, d.f.game_comment_score_btn_bg);
        aj.s(this.dPj, d.f.game_comment_score_btn_bg);
        aj.s(this.dPk, d.f.game_comment_score_btn_bg);
        aj.s(this.dPl, d.f.game_comment_score_btn_bg);
        if (this.dPg.isEnabled()) {
            aj.r(this.dPg, d.C0140d.cp_link_tip_g);
        } else {
            aj.r(this.dPg, d.C0140d.cp_cont_e);
        }
        aj.r(this.mTitle, d.C0140d.cp_cont_b);
        aj.r(this.dPn, d.C0140d.cp_cont_d);
        if (i == 1) {
            this.dPm.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d_1));
        } else {
            this.dPm.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_d));
        }
    }
}
