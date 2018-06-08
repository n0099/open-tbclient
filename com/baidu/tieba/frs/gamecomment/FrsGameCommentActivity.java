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
/* loaded from: classes3.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar crf;
    private TextView drX;
    private RadioButton drY;
    private RadioButton drZ;
    private RadioButton dsa;
    private RadioButton dsb;
    private RadioButton dsc;
    private EditText dsd;
    private int dse;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.drY) {
                FrsGameCommentActivity.this.drZ.setChecked(false);
                FrsGameCommentActivity.this.dsa.setChecked(false);
                FrsGameCommentActivity.this.dsb.setChecked(false);
                FrsGameCommentActivity.this.dsc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.drZ) {
                FrsGameCommentActivity.this.drY.setChecked(true);
                FrsGameCommentActivity.this.dsa.setChecked(false);
                FrsGameCommentActivity.this.dsb.setChecked(false);
                FrsGameCommentActivity.this.dsc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.dsa) {
                FrsGameCommentActivity.this.drY.setChecked(true);
                FrsGameCommentActivity.this.drZ.setChecked(true);
                FrsGameCommentActivity.this.dsb.setChecked(false);
                FrsGameCommentActivity.this.dsc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.dsb) {
                FrsGameCommentActivity.this.drY.setChecked(true);
                FrsGameCommentActivity.this.drZ.setChecked(true);
                FrsGameCommentActivity.this.dsa.setChecked(true);
                FrsGameCommentActivity.this.dsc.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.dsc) {
                FrsGameCommentActivity.this.drY.setChecked(true);
                FrsGameCommentActivity.this.drZ.setChecked(true);
                FrsGameCommentActivity.this.dsa.setChecked(true);
                FrsGameCommentActivity.this.dsb.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher dsf = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.dsd.getText().length() > 0) {
                FrsGameCommentActivity.this.drX.setEnabled(true);
                al.h(FrsGameCommentActivity.this.drX, d.C0141d.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.drX.setEnabled(false);
            al.h(FrsGameCommentActivity.this.drX, d.C0141d.cp_cont_e);
        }
    };
    private HttpMessageListener dsg = new HttpMessageListener(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.dse = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new am("c12340").r(ImageViewerConfig.FORUM_ID, this.dse));
    }

    private void initView() {
        setContentView(d.i.frs_game_comment_layout);
        this.crf = (NavigationBar) findViewById(d.g.frs_game_comment_navigation_bar);
        this.crf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.crf.setCenterTextTitle(getPageContext().getPageActivity().getString(d.k.frs_game_comment_title));
        this.crf.showBottomLine(true);
        this.drX = this.crf.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.jD()) {
                    FrsGameCommentActivity.this.showToast(d.k.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(d.k.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.awP();
            }
        });
        this.drX.setText(getPageContext().getPageActivity().getString(d.k.send_post));
        this.drX.setTextColor(getPageContext().getPageActivity().getResources().getColor(d.C0141d.cp_cont_e));
        this.drX.setEnabled(false);
        this.drY = (RadioButton) findViewById(d.g.frs_game_comment_grade_1);
        this.drY.setOnClickListener(this.mOnClickListener);
        this.drZ = (RadioButton) findViewById(d.g.frs_game_comment_grade_2);
        this.drZ.setOnClickListener(this.mOnClickListener);
        this.dsa = (RadioButton) findViewById(d.g.frs_game_comment_grade_3);
        this.dsa.setOnClickListener(this.mOnClickListener);
        this.dsb = (RadioButton) findViewById(d.g.frs_game_comment_grade_4);
        this.dsb.setOnClickListener(this.mOnClickListener);
        this.dsc = (RadioButton) findViewById(d.g.frs_game_comment_grade_5);
        this.dsc.setOnClickListener(this.mOnClickListener);
        this.dsd = (EditText) findViewById(d.g.frs_game_comment_edit);
        this.dsd.addTextChangedListener(this.dsf);
        switch (this.mScore) {
            case 2:
                this.drY.setChecked(true);
                this.drZ.setChecked(false);
                this.dsa.setChecked(false);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(false);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 6:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(false);
                this.dsc.setChecked(false);
                return;
            case 8:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(true);
                this.dsc.setChecked(false);
                return;
            case 10:
                this.drY.setChecked(true);
                this.drZ.setChecked(true);
                this.dsa.setChecked(true);
                this.dsb.setChecked(true);
                this.dsc.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awP() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.dse);
        httpMessage.addParam("content", this.dsd.getText().toString().trim());
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
        MessageManager.getInstance().registerListener(this.dsg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.dsg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.i(this.drY, d.f.game_comment_score_btn_bg);
        al.i(this.drZ, d.f.game_comment_score_btn_bg);
        al.i(this.dsa, d.f.game_comment_score_btn_bg);
        al.i(this.dsb, d.f.game_comment_score_btn_bg);
        al.i(this.dsc, d.f.game_comment_score_btn_bg);
        if (this.drX.isEnabled()) {
            al.h(this.drX, d.C0141d.cp_link_tip_g);
        } else {
            al.h(this.drX, d.C0141d.cp_cont_e);
        }
        al.h(this.mTitle, d.C0141d.cp_cont_b);
        if (i == 1) {
            this.dsd.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d_1));
        } else {
            this.dsd.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_d));
        }
    }
}
