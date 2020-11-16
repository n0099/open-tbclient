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
import com.baidu.ar.gesture.GestureAR;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    private NavigationBar iXD;
    private TextView iXE;
    private RadioButton iXF;
    private RadioButton iXG;
    private RadioButton iXH;
    private RadioButton iXI;
    private RadioButton iXJ;
    private EditText iXK;
    private int iXL;
    private int mScore;
    private TextView mTitle;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.iXF) {
                FrsGameCommentActivity.this.iXG.setChecked(false);
                FrsGameCommentActivity.this.iXH.setChecked(false);
                FrsGameCommentActivity.this.iXI.setChecked(false);
                FrsGameCommentActivity.this.iXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.iXG) {
                FrsGameCommentActivity.this.iXF.setChecked(true);
                FrsGameCommentActivity.this.iXH.setChecked(false);
                FrsGameCommentActivity.this.iXI.setChecked(false);
                FrsGameCommentActivity.this.iXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.iXH) {
                FrsGameCommentActivity.this.iXF.setChecked(true);
                FrsGameCommentActivity.this.iXG.setChecked(true);
                FrsGameCommentActivity.this.iXI.setChecked(false);
                FrsGameCommentActivity.this.iXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.iXI) {
                FrsGameCommentActivity.this.iXF.setChecked(true);
                FrsGameCommentActivity.this.iXG.setChecked(true);
                FrsGameCommentActivity.this.iXH.setChecked(true);
                FrsGameCommentActivity.this.iXJ.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.iXJ) {
                FrsGameCommentActivity.this.iXF.setChecked(true);
                FrsGameCommentActivity.this.iXG.setChecked(true);
                FrsGameCommentActivity.this.iXH.setChecked(true);
                FrsGameCommentActivity.this.iXI.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    };
    private TextWatcher iXM = new TextWatcher() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.iXK.getText().length() > 0) {
                FrsGameCommentActivity.this.iXE.setEnabled(true);
                ap.setViewTextColor(FrsGameCommentActivity.this.iXE, (int) R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.iXE.setEnabled(false);
            ap.setViewTextColor(FrsGameCommentActivity.this.iXE, (int) R.color.CAM_X0110);
        }
    };
    private HttpMessageListener iXN = new HttpMessageListener(1001712) { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.4
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
        this.mScore = getIntent().getIntExtra(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, 0);
        this.iXL = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new ar("c12340").ak("fid", this.iXL));
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        this.iXD = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.iXD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.iXD.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.iXD.showBottomLine(true);
        this.iXE = this.iXD.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamecomment.FrsGameCommentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.isNetWorkAvailable()) {
                    FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                FrsGameCommentActivity.this.closeLoadingDialog();
                FrsGameCommentActivity.this.showLoadingDialog(FrsGameCommentActivity.this.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                FrsGameCommentActivity.this.cCs();
            }
        });
        this.iXE.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.iXE.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.iXE.setEnabled(false);
        this.iXF = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.iXF.setOnClickListener(this.mOnClickListener);
        this.iXG = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.iXG.setOnClickListener(this.mOnClickListener);
        this.iXH = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.iXH.setOnClickListener(this.mOnClickListener);
        this.iXI = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.iXI.setOnClickListener(this.mOnClickListener);
        this.iXJ = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.iXJ.setOnClickListener(this.mOnClickListener);
        this.iXK = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.iXK.addTextChangedListener(this.iXM);
        switch (this.mScore) {
            case 2:
                this.iXF.setChecked(true);
                this.iXG.setChecked(false);
                this.iXH.setChecked(false);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 3:
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 4:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(false);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 6:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(false);
                this.iXJ.setChecked(false);
                return;
            case 8:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(true);
                this.iXJ.setChecked(false);
                return;
            case 10:
                this.iXF.setChecked(true);
                this.iXG.setChecked(true);
                this.iXH.setChecked(true);
                this.iXI.setChecked(true);
                this.iXJ.setChecked(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCs() {
        HttpMessage httpMessage = new HttpMessage(1001712);
        httpMessage.addParam(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.mScore);
        httpMessage.addParam("forum_id", this.iXL);
        httpMessage.addParam("content", this.iXK.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001712, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.iXN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(1001712);
        MessageManager.getInstance().unRegisterListener(this.iXN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundResource(this.iXF, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iXG, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iXH, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iXI, R.drawable.game_comment_score_btn_bg);
        ap.setBackgroundResource(this.iXJ, R.drawable.game_comment_score_btn_bg);
        if (this.iXE.isEnabled()) {
            ap.setViewTextColor(this.iXE, (int) R.color.cp_link_tip_g);
        } else {
            ap.setViewTextColor(this.iXE, (int) R.color.CAM_X0110);
        }
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
        this.iXK.setHintTextColor(ap.getColor(R.color.CAM_X0109));
    }
}
