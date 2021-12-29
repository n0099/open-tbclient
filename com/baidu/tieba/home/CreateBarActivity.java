package com.baidu.tieba.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import c.a.d.f.p.n;
import c.a.s0.t.c.m0;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class CreateBarActivity extends BaseActivity<CreateBarActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBarName;
    public boolean mBarNameIsValid;
    public RelativeLayout mContainer;
    public RelativeLayout mCreate;
    public TextView mCreateButtonText;
    public d mCreateTask;
    public RelativeLayout mCreatebar;
    public EditText mEditName;
    public EditText mEditVcode;
    public TextView mErrorView;
    public e mGetImageTask;
    public ImageView mImage;
    public FrameLayout mImageButton;
    public NavigationBar mNavigationBar;
    public View.OnClickListener mOnClickListener;
    public ProgressBar mProgress;
    public ProgressBar mProgressImage;
    public TextView mTextInfo;
    public TextView mTextInfo2;
    public TextWatcher mTextWatcher;
    public String mVcode_md5;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateBarActivity f45728e;

        public a(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45728e = createBarActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f45728e.mCreate) {
                    this.f45728e.startCreateTask();
                } else if (view == this.f45728e.mImageButton) {
                    this.f45728e.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateBarActivity f45729e;

        public b(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45729e = createBarActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = this.f45729e.mEditName.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || this.f45729e.mEditVcode.getText().toString().trim().length() <= 0) {
                    this.f45729e.mCreate.setEnabled(false);
                } else {
                    this.f45729e.mCreate.setEnabled(true);
                }
                if (length >= 32) {
                    this.f45729e.mErrorView.setText(this.f45729e.getPageContext().getString(R.string.bar_name_long));
                    this.f45729e.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                this.f45729e.mErrorView.setText(this.f45729e.getPageContext().getString(R.string.bar_name_rule));
                this.f45729e.mErrorView.setTextColor(-6250336);
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
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CreateBarActivity f45730e;

        public c(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45730e = createBarActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.f45730e.mEditName.hasFocus()) {
                        n.w(this.f45730e.getPageContext().getPageActivity(), this.f45730e.mEditName);
                    }
                    if (this.f45730e.mEditVcode.hasFocus()) {
                        n.w(this.f45730e.getPageContext().getPageActivity(), this.f45730e.mEditVcode);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f45731b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f45732c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CreateBarActivity f45733d;

        public d(CreateBarActivity createBarActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45733d = createBarActivity;
            this.a = null;
            this.f45731b = null;
            this.f45732c = null;
            this.a = str;
            this.f45731b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f45732c;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f45733d.mProgress.setVisibility(8);
                this.f45733d.mCreateTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.f45733d.mProgress.setVisibility(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/create");
                    this.f45732c = netWork;
                    netWork.getNetContext().getRequest().mIsNeedTbs = true;
                    this.f45732c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a);
                    this.f45732c.addPostData("vcode", this.f45731b);
                    this.f45732c.addPostData("vcode_md5", this.f45733d.mVcode_md5);
                    this.f45732c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                    this.f45732c.postNetData();
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((d) str);
                this.f45733d.mProgress.setVisibility(8);
                this.f45733d.mCreateTask = null;
                if (this.f45732c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateBarSuccessActivity.startActivity(this.f45733d.getPageContext().getPageActivity(), this.a);
                    this.f45733d.finish();
                    return;
                }
                this.f45733d.showToast(this.f45732c.getErrorString());
                if (this.f45732c.isNetSuccess()) {
                    this.f45733d.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f45734b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CreateBarActivity f45735c;

        public e(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45735c = createBarActivity;
            this.a = null;
            this.f45734b = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/anti/vcode");
                    this.a = netWork;
                    netWork.addPostData("fid", "0");
                    this.a.addPostData("pub_type", "0");
                    this.a.addPostData("fname", "");
                    this.a.addPostData("tid", "0");
                    String postNetData = this.a.postNetData();
                    if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                        m0 m0Var = new m0();
                        m0Var.e(postNetData);
                        if (m0Var.c() != null && m0Var.c().length() > 0) {
                            this.f45735c.mVcode_md5 = m0Var.b();
                            if (this.f45734b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(m0Var.c());
                            this.a = netWork2;
                            return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                this.f45734b = true;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f45735c.mProgressImage.setVisibility(8);
                this.f45735c.mGetImageTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.f45735c.mVcode_md5 = null;
                this.f45735c.mProgressImage.setVisibility(0);
                this.f45735c.mImage.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((e) bitmap);
                this.f45735c.mProgressImage.setVisibility(8);
                this.f45735c.mGetImageTask = null;
                if (bitmap != null) {
                    this.f45735c.mImage.setImageBitmap(bitmap);
                }
            }
        }

        public /* synthetic */ e(CreateBarActivity createBarActivity, a aVar) {
            this(createBarActivity);
        }
    }

    public CreateBarActivity() {
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
        this.mTextInfo = null;
        this.mTextInfo2 = null;
        this.mEditName = null;
        this.mEditVcode = null;
        this.mCreate = null;
        this.mImageButton = null;
        this.mImage = null;
        this.mProgress = null;
        this.mProgressImage = null;
        this.mCreateTask = null;
        this.mGetImageTask = null;
        this.mOnClickListener = null;
        this.mTextWatcher = null;
        this.mVcode_md5 = null;
        this.mErrorView = null;
        this.mContainer = null;
        this.mCreateButtonText = null;
        this.mBarName = null;
        this.mBarNameIsValid = false;
    }

    private void getImage() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.mGetImageTask == null) {
            e eVar = new e(this, null);
            this.mGetImageTask = eVar;
            eVar.execute(new String[0]);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            Intent intent = getIntent();
            this.mBarName = intent.getStringExtra("barname");
            this.mBarNameIsValid = intent.getBooleanExtra("isvalid", false);
            if (this.mBarName == null) {
                this.mBarName = "";
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.mOnClickListener = new a(this);
            this.mTextWatcher = new b(this);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.create_bar));
            this.mContainer = (RelativeLayout) findViewById(R.id.container);
            this.mCreateButtonText = (TextView) findViewById(R.id.text);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.top_view)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            this.mErrorView = (TextView) findViewById(R.id.error);
            this.mTextInfo = (TextView) findViewById(R.id.info);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.create);
            this.mCreate = relativeLayout;
            relativeLayout.setOnClickListener(this.mOnClickListener);
            this.mTextInfo2 = (TextView) findViewById(R.id.info2);
            EditText editText = (EditText) findViewById(R.id.edit_name);
            this.mEditName = editText;
            editText.addTextChangedListener(this.mTextWatcher);
            EditText editText2 = (EditText) findViewById(R.id.edit_vcode);
            this.mEditVcode = editText2;
            editText2.addTextChangedListener(this.mTextWatcher);
            if (this.mBarNameIsValid) {
                this.mTextInfo2.setText(getPageContext().getString(R.string.noforum_create_form_tip));
                this.mEditName.setText(this.mBarName);
            } else {
                this.mTextInfo2.setText(getPageContext().getString(R.string.bar_name_invalid));
            }
            this.mCreatebar = (RelativeLayout) findViewById(R.id.create);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.image_button);
            this.mImageButton = frameLayout;
            frameLayout.setOnClickListener(this.mOnClickListener);
            this.mImage = (ImageView) findViewById(R.id.image);
            this.mCreate.setEnabled(false);
            this.mProgress = (ProgressBar) findViewById(R.id.progress);
            this.mProgressImage = (ProgressBar) findViewById(R.id.progress_image);
            if (this.mBarNameIsValid) {
                this.mEditVcode.requestFocus();
            }
            findViewById(R.id.show_message_container).setOnTouchListener(new c(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCreateTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.mCreateTask == null) {
            d dVar = new d(this, this.mEditName.getText().toString().trim(), this.mEditVcode.getText().toString().trim());
            this.mCreateTask = dVar;
            dVar.setPriority(3);
            this.mCreateTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.mGetImageTask == null && this.mCreateTask == null) {
            e eVar = new e(this, null);
            this.mGetImageTask = eVar;
            eVar.setPriority(3);
            this.mGetImageTask.execute(new String[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mContainer);
            SkinManager.setButtonTextColor(this.mCreateButtonText, i2);
            SkinManager.setTextColor(this.mTextInfo2, i2);
            String str = this.mBarName + getPageContext().getString(R.string.bar_not_create);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), 0, this.mBarName.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.mBarName.length(), str.length(), 33);
            SkinManager.setBackgroundResource(this.mCreatebar, R.drawable.btn_general_start_selector);
            this.mTextInfo.setText(spannableString);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.create_bar_activity);
            initData();
            initUI();
            getImage();
            adjustResizeForSoftInput();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            d dVar = this.mCreateTask;
            if (dVar != null) {
                dVar.cancel();
            }
            e eVar = this.mGetImageTask;
            if (eVar != null) {
                eVar.cancel();
            }
        }
    }
}
