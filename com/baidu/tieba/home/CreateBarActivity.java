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
import com.repackage.oi;
import com.repackage.qx4;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        public a(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.mCreate) {
                    this.a.startCreateTask();
                } else if (view2 == this.a.mImageButton) {
                    this.a.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        public b(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = this.a.mEditName.getText().toString().trim().length();
                if (length <= 0 || length >= 32 || this.a.mEditVcode.getText().toString().trim().length() <= 0) {
                    this.a.mCreate.setEnabled(false);
                } else {
                    this.a.mCreate.setEnabled(true);
                }
                if (length >= 32) {
                    this.a.mErrorView.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02e0));
                    this.a.mErrorView.setTextColor(SupportMenu.CATEGORY_MASK);
                    return;
                }
                this.a.mErrorView.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02e1));
                this.a.mErrorView.setTextColor(-6250336);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CreateBarActivity a;

        public c(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = createBarActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    if (this.a.mEditName.hasFocus()) {
                        oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditName);
                    }
                    if (this.a.mEditVcode.hasFocus()) {
                        oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditVcode);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public NetWork c;
        public final /* synthetic */ CreateBarActivity d;

        public d(CreateBarActivity createBarActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = createBarActivity;
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.c;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.d.mProgress.setVisibility(8);
                this.d.mCreateTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.d.mProgress.setVisibility(0);
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
                    this.c = netWork;
                    netWork.getNetContext().getRequest().mIsNeedTbs = true;
                    this.c.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.a);
                    this.c.addPostData("vcode", this.b);
                    this.c.addPostData("vcode_md5", this.d.mVcode_md5);
                    this.c.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                    this.c.postNetData();
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
                this.d.mProgress.setVisibility(8);
                this.d.mCreateTask = null;
                if (this.c.getNetContext().getResponse().isRequestSuccess()) {
                    CreateBarSuccessActivity.startActivity(this.d.getPageContext().getPageActivity(), this.a);
                    this.d.finish();
                    return;
                }
                this.d.showToast(this.c.getErrorString());
                if (this.c.isNetSuccess()) {
                    this.d.startImageTask();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BdAsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public volatile boolean b;
        public final /* synthetic */ CreateBarActivity c;

        public e(CreateBarActivity createBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = createBarActivity;
            this.a = null;
            this.b = false;
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
                        qx4 qx4Var = new qx4();
                        qx4Var.e(postNetData);
                        if (qx4Var.c() != null && qx4Var.c().length() > 0) {
                            this.c.mVcode_md5 = qx4Var.b();
                            if (this.b) {
                                return null;
                            }
                            NetWork netWork2 = new NetWork(qx4Var.c());
                            this.a = netWork2;
                            return BitmapHelper.Bytes2Bitmap(netWork2.getNetData());
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
                this.b = true;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.c.mProgressImage.setVisibility(8);
                this.c.mGetImageTask = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
                this.c.mVcode_md5 = null;
                this.c.mProgressImage.setVisibility(0);
                this.c.mImage.setImageDrawable(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
                super.onPostExecute((e) bitmap);
                this.c.mProgressImage.setVisibility(8);
                this.c.mGetImageTask = null;
                if (bitmap != null) {
                    this.c.mImage.setImageBitmap(bitmap);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0457));
            this.mContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906d2);
            this.mCreateButtonText = (TextView) findViewById(R.id.obfuscated_res_0x7f091f08);
            ((LinearLayout.LayoutParams) ((TextView) findViewById(R.id.obfuscated_res_0x7f0920b7)).getLayoutParams()).height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            this.mErrorView = (TextView) findViewById(R.id.obfuscated_res_0x7f090907);
            this.mTextInfo = (TextView) findViewById(R.id.obfuscated_res_0x7f090ef0);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090722);
            this.mCreate = relativeLayout;
            relativeLayout.setOnClickListener(this.mOnClickListener);
            this.mTextInfo2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090ef1);
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f09085c);
            this.mEditName = editText;
            editText.addTextChangedListener(this.mTextWatcher);
            EditText editText2 = (EditText) findViewById(R.id.obfuscated_res_0x7f09086b);
            this.mEditVcode = editText2;
            editText2.addTextChangedListener(this.mTextWatcher);
            if (this.mBarNameIsValid) {
                this.mTextInfo2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0c62));
                this.mEditName.setText(this.mBarName);
            } else {
                this.mTextInfo2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f02df));
            }
            this.mCreatebar = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090722);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090e6c);
            this.mImageButton = frameLayout;
            frameLayout.setOnClickListener(this.mOnClickListener);
            this.mImage = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e68);
            this.mCreate.setEnabled(false);
            this.mProgress = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09191d);
            this.mProgressImage = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091926);
            if (this.mBarNameIsValid) {
                this.mEditVcode.requestFocus();
            }
            findViewById(R.id.obfuscated_res_0x7f091ce6).setOnTouchListener(new c(this));
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
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mContainer);
            SkinManager.setButtonTextColor(this.mCreateButtonText, i);
            SkinManager.setTextColor(this.mTextInfo2, i);
            String str = this.mBarName + getPageContext().getString(R.string.obfuscated_res_0x7f0f02e2);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10252)), 0, this.mBarName.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.common_color_10004)), this.mBarName.length(), str.length(), 33);
            SkinManager.setBackgroundResource(this.mCreatebar, R.drawable.btn_general_start_selector);
            this.mTextInfo.setText(spannableString);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d020a);
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
