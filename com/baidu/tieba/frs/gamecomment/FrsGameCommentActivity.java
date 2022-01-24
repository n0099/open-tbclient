package com.baidu.tieba.frs.gamecomment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsGameCommentActivity extends BaseActivity<FrsGameCommentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PUBLISH_COMMENT_URL = "game/forum/addComment";
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher mCommentChangeListener;
    public EditText mCommentEdit;
    public HttpMessageListener mCommentListener;
    public int mForum_id;
    public RadioButton mGrade1;
    public RadioButton mGrade2;
    public RadioButton mGrade3;
    public RadioButton mGrade4;
    public RadioButton mGrade5;
    public NavigationBar mNavBar;
    public View.OnClickListener mOnClickListener;
    public TextView mPublish;
    public int mScore;
    public TextView mTitle;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameCommentActivity f43411e;

        public a(FrsGameCommentActivity frsGameCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43411e = frsGameCommentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!l.z()) {
                    this.f43411e.showToast(R.string.frs_head_video_slide_no_network);
                    return;
                }
                this.f43411e.closeLoadingDialog();
                FrsGameCommentActivity frsGameCommentActivity = this.f43411e;
                frsGameCommentActivity.showLoadingDialog(frsGameCommentActivity.getPageContext().getPageActivity().getString(R.string.frs_game_comment_loading_tip));
                this.f43411e.publishComment();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameCommentActivity f43412e;

        public b(FrsGameCommentActivity frsGameCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43412e = frsGameCommentActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f43412e.mGrade1) {
                    this.f43412e.mGrade2.setChecked(false);
                    this.f43412e.mGrade3.setChecked(false);
                    this.f43412e.mGrade4.setChecked(false);
                    this.f43412e.mGrade5.setChecked(false);
                    this.f43412e.mScore = 2;
                } else if (view == this.f43412e.mGrade2) {
                    this.f43412e.mGrade1.setChecked(true);
                    this.f43412e.mGrade3.setChecked(false);
                    this.f43412e.mGrade4.setChecked(false);
                    this.f43412e.mGrade5.setChecked(false);
                    this.f43412e.mScore = 4;
                } else if (view == this.f43412e.mGrade3) {
                    this.f43412e.mGrade1.setChecked(true);
                    this.f43412e.mGrade2.setChecked(true);
                    this.f43412e.mGrade4.setChecked(false);
                    this.f43412e.mGrade5.setChecked(false);
                    this.f43412e.mScore = 6;
                } else if (view == this.f43412e.mGrade4) {
                    this.f43412e.mGrade1.setChecked(true);
                    this.f43412e.mGrade2.setChecked(true);
                    this.f43412e.mGrade3.setChecked(true);
                    this.f43412e.mGrade5.setChecked(false);
                    this.f43412e.mScore = 8;
                } else if (view == this.f43412e.mGrade5) {
                    this.f43412e.mGrade1.setChecked(true);
                    this.f43412e.mGrade2.setChecked(true);
                    this.f43412e.mGrade3.setChecked(true);
                    this.f43412e.mGrade4.setChecked(true);
                    this.f43412e.mScore = 10;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsGameCommentActivity f43413e;

        public c(FrsGameCommentActivity frsGameCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43413e = frsGameCommentActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f43413e.mCommentEdit.getText().length() > 0) {
                    this.f43413e.mPublish.setEnabled(true);
                    SkinManager.setViewTextColor(this.f43413e.mPublish, R.color.cp_link_tip_g);
                    return;
                }
                this.f43413e.mPublish.setEnabled(false);
                SkinManager.setViewTextColor(this.f43413e.mPublish, R.color.CAM_X0110);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsGameCommentActivity frsGameCommentActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsGameCommentActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsGameCommentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof FrsGameCommentResponseMessage)) {
                    return;
                }
                FrsGameCommentResponseMessage frsGameCommentResponseMessage = (FrsGameCommentResponseMessage) httpResponsedMessage;
                if (frsGameCommentResponseMessage.getError() == 0) {
                    this.a.setResult(-1);
                    this.a.finish();
                } else if (StringUtils.isNull(frsGameCommentResponseMessage.getErrorString())) {
                } else {
                    this.a.showToast(frsGameCommentResponseMessage.getErrorString());
                }
            }
        }
    }

    public FrsGameCommentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnClickListener = new b(this);
        this.mCommentChangeListener = new c(this);
        this.mCommentListener = new d(this, CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            setContentView(R.layout.frs_game_comment_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.frs_game_comment_navigation_bar);
            this.mNavBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mTitle = this.mNavBar.setCenterTextTitle(getPageContext().getPageActivity().getString(R.string.frs_game_comment_title));
            this.mNavBar.showBottomLine(true);
            TextView addCreateGroupButton = this.mNavBar.addCreateGroupButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, new a(this));
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
            int i2 = this.mScore;
            if (i2 == 2) {
                this.mGrade1.setChecked(true);
                this.mGrade2.setChecked(false);
                this.mGrade3.setChecked(false);
                this.mGrade4.setChecked(false);
                this.mGrade5.setChecked(false);
            } else if (i2 == 4) {
                this.mGrade1.setChecked(true);
                this.mGrade2.setChecked(true);
                this.mGrade3.setChecked(false);
                this.mGrade4.setChecked(false);
                this.mGrade5.setChecked(false);
            } else if (i2 == 6) {
                this.mGrade1.setChecked(true);
                this.mGrade2.setChecked(true);
                this.mGrade3.setChecked(true);
                this.mGrade4.setChecked(false);
                this.mGrade5.setChecked(false);
            } else if (i2 == 8) {
                this.mGrade1.setChecked(true);
                this.mGrade2.setChecked(true);
                this.mGrade3.setChecked(true);
                this.mGrade4.setChecked(true);
                this.mGrade5.setChecked(false);
            } else if (i2 != 10) {
            } else {
                this.mGrade1.setChecked(true);
                this.mGrade2.setChecked(true);
                this.mGrade3.setChecked(true);
                this.mGrade4.setChecked(true);
                this.mGrade5.setChecked(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishComment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
            httpMessage.addParam("score", this.mScore);
            httpMessage.addParam("forum_id", this.mForum_id);
            httpMessage.addParam("content", this.mCommentEdit.getText().toString().trim());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            MessageManager.getInstance().registerListener(this.mCommentListener);
        }
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT, "http://tieba.baidu.com/game/forum/addComment");
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(FrsGameCommentResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.mScore = getIntent().getIntExtra("score", 0);
            this.mForum_id = getIntent().getIntExtra("forum_id", -1);
            initView();
            registerTask();
            registerListener();
            TiebaStatic.log(new StatisticItem("c12340").param("fid", this.mForum_id));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.FRS_GAME_INFO_GAME_COMMENT);
            MessageManager.getInstance().unRegisterListener(this.mCommentListener);
        }
    }
}
