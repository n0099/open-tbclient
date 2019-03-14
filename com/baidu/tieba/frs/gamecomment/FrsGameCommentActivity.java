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
    private NavigationBar edd;
    private TextView flg;
    private RadioButton flh;
    private RadioButton fli;
    private RadioButton flj;
    private RadioButton flk;
    private RadioButton fll;
    private EditText flm;
    private int fln;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.flh) {
                FrsGameCommentActivity.this.fli.setChecked(false);
                FrsGameCommentActivity.this.flj.setChecked(false);
                FrsGameCommentActivity.this.flk.setChecked(false);
                FrsGameCommentActivity.this.fll.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.fli) {
                FrsGameCommentActivity.this.flh.setChecked(true);
                FrsGameCommentActivity.this.flj.setChecked(false);
                FrsGameCommentActivity.this.flk.setChecked(false);
                FrsGameCommentActivity.this.fll.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.flj) {
                FrsGameCommentActivity.this.flh.setChecked(true);
                FrsGameCommentActivity.this.fli.setChecked(true);
                FrsGameCommentActivity.this.flk.setChecked(false);
                FrsGameCommentActivity.this.fll.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.flk) {
                FrsGameCommentActivity.this.flh.setChecked(true);
                FrsGameCommentActivity.this.fli.setChecked(true);
                FrsGameCommentActivity.this.flj.setChecked(true);
                FrsGameCommentActivity.this.fll.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.fll) {
                FrsGameCommentActivity.this.flh.setChecked(true);
                FrsGameCommentActivity.this.fli.setChecked(true);
                FrsGameCommentActivity.this.flj.setChecked(true);
                FrsGameCommentActivity.this.flk.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher flo = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.flm.getText().length() > 0) {
                FrsGameCommentActivity.this.flg.setEnabled(true);
                al.j(FrsGameCommentActivity.this.flg, d.C0277d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.flg.setEnabled(false);
            al.j(FrsGameCommentActivity.this.flg, d.C0277d.cp_cont_e);
        }
    };
    private HttpMessageListener flp = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.fln = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").T(ImageViewerConfig.FORUM_ID, this.fln));
    }

    private void initView() {
        setContentView(d.h.frs_game_comment_layout);
        this.edd = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.edd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.edd.setCenterTextTitle(getPageContext().getPageActivity().getString(d.j.frs_game_comment_title));
        this.edd.showBottomLine(true);
        this.flg = this.edd.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.kY()) {
                    FrsGameCommentActivity.this.showToast(d.j.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.j.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.bgp();
            }
        });
        this.flg.setText(getPageContext().getPageActivity().getString(d.j.send_post));
        this.flg.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0277d.cp_cont_e));
        this.flg.setEnabled(false);
        this.flh = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.flh.setOnClickListener(this.mOnClickListener);
        this.fli = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.fli.setOnClickListener(this.mOnClickListener);
        this.flj = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.flj.setOnClickListener(this.mOnClickListener);
        this.flk = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.flk.setOnClickListener(this.mOnClickListener);
        this.fll = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.fll.setOnClickListener(this.mOnClickListener);
        this.flm = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.flm.addTextChangedListener(this.flo);
        switch (this.mScore) {
            case 2:
                this.flh.setChecked(true);
                this.fli.setChecked(false);
                this.flj.setChecked(false);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(false);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 6:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(false);
                this.fll.setChecked(false);
                return;
            case 8:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(false);
                return;
            case 10:
                this.flh.setChecked(true);
                this.fli.setChecked(true);
                this.flj.setChecked(true);
                this.flk.setChecked(true);
                this.fll.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgp() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.fln);
        httpMessage.addParam("content", this.flm.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.flp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.flp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.k(this.flh, d.f.game_comment_score_btn_bg);
        al.k(this.fli, d.f.game_comment_score_btn_bg);
        al.k(this.flj, d.f.game_comment_score_btn_bg);
        al.k(this.flk, d.f.game_comment_score_btn_bg);
        al.k(this.fll, d.f.game_comment_score_btn_bg);
        if (this.flg.isEnabled()) {
            al.j(this.flg, d.C0277d.cp_link_tip_g);
        } else {
            al.j(this.flg, d.C0277d.cp_cont_e);
        }
        al.j(this.mTitle, d.C0277d.cp_cont_b);
        if (i == 1) {
            this.flm.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d_1));
        } else {
            this.flm.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_d));
        }
    }
}
