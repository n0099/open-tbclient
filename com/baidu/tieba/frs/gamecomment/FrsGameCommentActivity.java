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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    public static final String PUBLISH_COMMENT_URL = "game/forum/addComment";
    public EditText mCommentEdit;
    public int mForum_id;
    public RadioButton mGrade1;
    public RadioButton mGrade2;
    public RadioButton mGrade3;
    public RadioButton mGrade4;
    public RadioButton mGrade5;
    public NavigationBar mNavBar;
    public TextView mPublish;
    public int mScore;
    public TextView mTitle;
    public View.OnClickListener mOnClickListener = new b();
    public TextWatcher mCommentChangeListener = new c();
    public HttpMessageListener mCommentListener = new d(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                FrsGameCommentActivity.this.showToast(R.string.frs_head_video_slide_no_network);
                return;
            }
            FrsGameCommentActivity.this.closeLoadingDialog();
            FrsGameCommentActivity frsGameCommentActivity = FrsGameCommentActivity.this;
            frsGameCommentActivity.showLoadingDialog(frsGameCommentActivity.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
            FrsGameCommentActivity.this.publishComment();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == FrsGameCommentActivity.this.mGrade1) {
                FrsGameCommentActivity.this.mGrade2.setChecked(false);
                FrsGameCommentActivity.this.mGrade3.setChecked(false);
                FrsGameCommentActivity.this.mGrade4.setChecked(false);
                FrsGameCommentActivity.this.mGrade5.setChecked(false);
                FrsGameCommentActivity.this.mScore = 2;
            } else if (view == FrsGameCommentActivity.this.mGrade2) {
                FrsGameCommentActivity.this.mGrade1.setChecked(true);
                FrsGameCommentActivity.this.mGrade3.setChecked(false);
                FrsGameCommentActivity.this.mGrade4.setChecked(false);
                FrsGameCommentActivity.this.mGrade5.setChecked(false);
                FrsGameCommentActivity.this.mScore = 4;
            } else if (view == FrsGameCommentActivity.this.mGrade3) {
                FrsGameCommentActivity.this.mGrade1.setChecked(true);
                FrsGameCommentActivity.this.mGrade2.setChecked(true);
                FrsGameCommentActivity.this.mGrade4.setChecked(false);
                FrsGameCommentActivity.this.mGrade5.setChecked(false);
                FrsGameCommentActivity.this.mScore = 6;
            } else if (view == FrsGameCommentActivity.this.mGrade4) {
                FrsGameCommentActivity.this.mGrade1.setChecked(true);
                FrsGameCommentActivity.this.mGrade2.setChecked(true);
                FrsGameCommentActivity.this.mGrade3.setChecked(true);
                FrsGameCommentActivity.this.mGrade5.setChecked(false);
                FrsGameCommentActivity.this.mScore = 8;
            } else if (view == FrsGameCommentActivity.this.mGrade5) {
                FrsGameCommentActivity.this.mGrade1.setChecked(true);
                FrsGameCommentActivity.this.mGrade2.setChecked(true);
                FrsGameCommentActivity.this.mGrade3.setChecked(true);
                FrsGameCommentActivity.this.mGrade4.setChecked(true);
                FrsGameCommentActivity.this.mScore = 10;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FrsGameCommentActivity.this.mCommentEdit.getText().length() > 0) {
                FrsGameCommentActivity.this.mPublish.setEnabled(true);
                SkinManager.setViewTextColor(FrsGameCommentActivity.this.mPublish, R.color.cp_link_tip_g);
                return;
            }
            FrsGameCommentActivity.this.mPublish.setEnabled(false);
            SkinManager.setViewTextColor(FrsGameCommentActivity.this.mPublish, R.color.CAM_X0110);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            FrsGameCommentActivity.this.closeLoadingDialog();
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof FrsGameCommentResponseMessage)) {
                return;
            }
            FrsGameCommentResponseMessage frsGameCommentResponseMessage = (FrsGameCommentResponseMessage) httpResponsedMessage;
            if (frsGameCommentResponseMessage.getError() == 0) {
                FrsGameCommentActivity.this.setResult(-1);
                FrsGameCommentActivity.this.finish();
            } else if (StringUtils.isNull(frsGameCommentResponseMessage.getErrorString())) {
            } else {
                FrsGameCommentActivity.this.showToast(frsGameCommentResponseMessage.getErrorString());
            }
        }
    }

    private void initView() {
        setContentView(R.layout.frs_game_comment_layout);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
        this.mNavBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mTitle = this.mNavBar.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
        this.mNavBar.showBottomLine(true);
        TextView addCreateGroupButton = this.mNavBar.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new a());
        this.mPublish = addCreateGroupButton;
        addCreateGroupButton.setText(getPageContext().getPageActivity().getString(R.string.send_post));
        this.mPublish.setTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0110));
        this.mPublish.setEnabled(false);
        RadioButton radioButton = (RadioButton) findViewById(R.id.frs_game_comment_grade_1);
        this.mGrade1 = radioButton;
        radioButton.setOnClickListener(this.mOnClickListener);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.frs_game_comment_grade_2);
        this.mGrade2 = radioButton2;
        radioButton2.setOnClickListener(this.mOnClickListener);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.frs_game_comment_grade_3);
        this.mGrade3 = radioButton3;
        radioButton3.setOnClickListener(this.mOnClickListener);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.frs_game_comment_grade_4);
        this.mGrade4 = radioButton4;
        radioButton4.setOnClickListener(this.mOnClickListener);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.frs_game_comment_grade_5);
        this.mGrade5 = radioButton5;
        radioButton5.setOnClickListener(this.mOnClickListener);
        EditText editText = (EditText) findViewById(R.id.frs_game_comment_edit);
        this.mCommentEdit = editText;
        editText.addTextChangedListener(this.mCommentChangeListener);
        int i = this.mScore;
        if (i == 2) {
            this.mGrade1.setChecked(true);
            this.mGrade2.setChecked(false);
            this.mGrade3.setChecked(false);
            this.mGrade4.setChecked(false);
            this.mGrade5.setChecked(false);
        } else if (i == 4) {
            this.mGrade1.setChecked(true);
            this.mGrade2.setChecked(true);
            this.mGrade3.setChecked(false);
            this.mGrade4.setChecked(false);
            this.mGrade5.setChecked(false);
        } else if (i == 6) {
            this.mGrade1.setChecked(true);
            this.mGrade2.setChecked(true);
            this.mGrade3.setChecked(true);
            this.mGrade4.setChecked(false);
            this.mGrade5.setChecked(false);
        } else if (i == 8) {
            this.mGrade1.setChecked(true);
            this.mGrade2.setChecked(true);
            this.mGrade3.setChecked(true);
            this.mGrade4.setChecked(true);
            this.mGrade5.setChecked(false);
        } else if (i != 10) {
        } else {
            this.mGrade1.setChecked(true);
            this.mGrade2.setChecked(true);
            this.mGrade3.setChecked(true);
            this.mGrade4.setChecked(true);
            this.mGrade5.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishComment() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        httpMessage.addParam("score", this.mScore);
        httpMessage.addParam("forum_id", this.mForum_id);
        httpMessage.addParam("content", this.mCommentEdit.getText().toString().trim());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.mCommentListener);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundResource(this.mGrade1, R.drawable.game_comment_score_btn_bg);
        SkinManager.setBackgroundResource(this.mGrade2, R.drawable.game_comment_score_btn_bg);
        SkinManager.setBackgroundResource(this.mGrade3, R.drawable.game_comment_score_btn_bg);
        SkinManager.setBackgroundResource(this.mGrade4, R.drawable.game_comment_score_btn_bg);
        SkinManager.setBackgroundResource(this.mGrade5, R.drawable.game_comment_score_btn_bg);
        if (this.mPublish.isEnabled()) {
            SkinManager.setViewTextColor(this.mPublish, R.color.cp_link_tip_g);
        } else {
            SkinManager.setViewTextColor(this.mPublish, R.color.CAM_X0110);
        }
        SkinManager.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        this.mCommentEdit.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mScore = getIntent().getIntExtra("score", 0);
        this.mForum_id = getIntent().getIntExtra("forum_id", -1);
        initView();
        registerTask();
        registerListener();
        TiebaStatic.log(new StatisticItem("c12340").param("fid", this.mForum_id));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
        MessageManager.getInstance().unRegisterListener(this.mCommentListener);
    }
}
