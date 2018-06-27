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
    private NavigationBar cpl;
    private TextView dvg;
    private RadioButton dvh;
    private RadioButton dvi;
    private RadioButton dvj;
    private RadioButton dvk;
    private RadioButton dvl;
    private EditText dvm;
    private int dvn;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.dvh) {
                FrsGameCommentActivity.this.dvi.setChecked(false);
                FrsGameCommentActivity.this.dvj.setChecked(false);
                FrsGameCommentActivity.this.dvk.setChecked(false);
                FrsGameCommentActivity.this.dvl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.dvi) {
                FrsGameCommentActivity.this.dvh.setChecked(true);
                FrsGameCommentActivity.this.dvj.setChecked(false);
                FrsGameCommentActivity.this.dvk.setChecked(false);
                FrsGameCommentActivity.this.dvl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dvj) {
                FrsGameCommentActivity.this.dvh.setChecked(true);
                FrsGameCommentActivity.this.dvi.setChecked(true);
                FrsGameCommentActivity.this.dvk.setChecked(false);
                FrsGameCommentActivity.this.dvl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dvk) {
                FrsGameCommentActivity.this.dvh.setChecked(true);
                FrsGameCommentActivity.this.dvi.setChecked(true);
                FrsGameCommentActivity.this.dvj.setChecked(true);
                FrsGameCommentActivity.this.dvl.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dvl) {
                FrsGameCommentActivity.this.dvh.setChecked(true);
                FrsGameCommentActivity.this.dvi.setChecked(true);
                FrsGameCommentActivity.this.dvj.setChecked(true);
                FrsGameCommentActivity.this.dvk.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dvo = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dvm.getText().length() > 0) {
                FrsGameCommentActivity.this.dvg.setEnabled(true);
                am.h(FrsGameCommentActivity.this.dvg, d.C0142d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.dvg.setEnabled(false);
            am.h(FrsGameCommentActivity.this.dvg, d.C0142d.cp_cont_e);
        }
    };
    private HttpMessageListener dvp = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dvn = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new an("c12340").r(ImageViewerConfig.FORUM_ID, this.dvn));
    }

    private void initView() {
        setContentView(d.i.frs_game_comment_layout);
        this.cpl = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.cpl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.cpl.setCenterTextTitle(getPageContext().getPageActivity().getString(d.k.frs_game_comment_title));
        this.cpl.showBottomLine(true);
        this.dvg = this.cpl.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.jD()) {
                    FrsGameCommentActivity.this.showToast(d.k.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.k.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.axt();
            }
        });
        this.dvg.setText(getPageContext().getPageActivity().getString(d.k.send_post));
        this.dvg.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0142d.cp_cont_e));
        this.dvg.setEnabled(false);
        this.dvh = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.dvh.setOnClickListener(this.mOnClickListener);
        this.dvi = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.dvi.setOnClickListener(this.mOnClickListener);
        this.dvj = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dvj.setOnClickListener(this.mOnClickListener);
        this.dvk = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dvk.setOnClickListener(this.mOnClickListener);
        this.dvl = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dvl.setOnClickListener(this.mOnClickListener);
        this.dvm = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dvm.addTextChangedListener(this.dvo);
        switch (this.mScore) {
            case 2:
                this.dvh.setChecked(true);
                this.dvi.setChecked(false);
                this.dvj.setChecked(false);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(false);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 6:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(false);
                this.dvl.setChecked(false);
                return;
            case 8:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(true);
                this.dvl.setChecked(false);
                return;
            case 10:
                this.dvh.setChecked(true);
                this.dvi.setChecked(true);
                this.dvj.setChecked(true);
                this.dvk.setChecked(true);
                this.dvl.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.dvn);
        httpMessage.addParam("content", this.dvm.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dvp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dvp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.i(this.dvh, d.f.game_comment_score_btn_bg);
        am.i(this.dvi, d.f.game_comment_score_btn_bg);
        am.i(this.dvj, d.f.game_comment_score_btn_bg);
        am.i(this.dvk, d.f.game_comment_score_btn_bg);
        am.i(this.dvl, d.f.game_comment_score_btn_bg);
        if (this.dvg.isEnabled()) {
            am.h(this.dvg, d.C0142d.cp_link_tip_g);
        } else {
            am.h(this.dvg, d.C0142d.cp_cont_e);
        }
        am.h(this.mTitle, d.C0142d.cp_cont_b);
        if (i == 1) {
            this.dvm.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_d_1));
        } else {
            this.dvm.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_d));
        }
    }
}
