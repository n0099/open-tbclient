package com.baidu.tbadk.system.portrait;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa5;
import com.repackage.co;
import com.repackage.fg;
import com.repackage.gg;
import com.repackage.ku4;
import com.repackage.mi;
import com.repackage.mu4;
import com.repackage.nr4;
import com.repackage.z95;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentChoosedID;
    public String currentUrl;
    public z95 mAdapter;
    public View mBackButton;
    public fg<co> mCallback;
    public TextView mDoneButton;
    public BdGridView mGridView;
    public ku4 mLoadingDialog;
    public NavigationBar mNavigationBar;
    public co mPhotoData;
    public h mResetTask;
    public LinearLayout mRootView;
    public boolean needUpload;
    public ArrayList<aa5> recommendPhotos;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.currentChoosedID != -1) {
                    this.a.showDialog();
                    return;
                }
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.currentChoosedID == -1) {
                return;
            }
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
            changeSystemPhotoActivity.resetUserPortraits((aa5) changeSystemPhotoActivity.recommendPhotos.get(this.a.currentChoosedID));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.recommendPhotos == null || this.a.recommendPhotos.size() <= 0 || this.a.recommendPhotos.size() <= i || this.a.recommendPhotos.get(i) == null) {
                return;
            }
            this.a.currentChoosedID = i;
            this.a.changeDoneButtonState(true);
            this.a.mAdapter.b(i);
            this.a.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GetPopularPortraitsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getPopularPortraitsInfoResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            List<GetPopularPortraitsInfoResult.PopularPortraitsInfo> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPopularPortraitsInfoResult) == null) || getPopularPortraitsInfoResult == null || (list = getPopularPortraitsInfoResult.popularPortraitsInfoList) == null || list.size() <= 0) {
                return;
            }
            for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                    aa5 aa5Var = new aa5();
                    aa5Var.d(popularPortraitsInfo.url);
                    aa5Var.c(popularPortraitsInfo.num);
                    aa5Var.b(popularPortraitsInfo.myItem);
                    this.a.recommendPhotos.add(aa5Var);
                }
            }
            this.a.mAdapter.c(this.a.recommendPhotos);
            this.a.mAdapter.notifyDataSetChanged();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public e(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public f(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends fg<co> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = changeSystemPhotoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        public void onLoaded(co coVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, coVar, str, i) == null) {
                super.onLoaded((g) coVar, str, i);
                if (coVar == null) {
                    return;
                }
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
                if (changeSystemPhotoActivity.mLoadingDialog == null) {
                    changeSystemPhotoActivity.mLoadingDialog = new ku4(changeSystemPhotoActivity.getPageContext());
                    this.a.mLoadingDialog.e(null);
                }
                this.a.mLoadingDialog.h(true);
                if (this.a.needUpload) {
                    this.a.mPhotoData = coVar;
                    if (this.a.mResetTask != null) {
                        this.a.mResetTask.cancel();
                    }
                    this.a.mResetTask = new h(this.a, null);
                    this.a.mResetTask.execute(new String[0]);
                    return;
                }
                Bitmap p = coVar.p();
                if (p != null) {
                    if (!this.a.saveFile(TbConfig.PERSON_USER_PIC_TEMP_FILE, p)) {
                        ku4 ku4Var = this.a.mLoadingDialog;
                        if (ku4Var != null) {
                            ku4Var.h(false);
                            return;
                        }
                        return;
                    }
                    ku4 ku4Var2 = this.a.mLoadingDialog;
                    if (ku4Var2 != null) {
                        ku4Var2.h(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                    return;
                }
                ku4 ku4Var3 = this.a.mLoadingDialog;
                if (ku4Var3 != null) {
                    ku4Var3.h(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ ChangeSystemPhotoActivity b;

        public h(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = changeSystemPhotoActivity;
            this.a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.mResetTask = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Exception e;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.a = netWork;
                try {
                    netWork.addPostData("pic", this.b.mPhotoData.n());
                    str = this.a.postMultiNetData();
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
                try {
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    return str;
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    return str;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a == null) {
                return;
            }
            ku4 ku4Var = this.b.mLoadingDialog;
            if (ku4Var != null) {
                ku4Var.h(false);
            }
            if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                new mu4().c(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0fd3));
                Intent intent = new Intent();
                intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.b.currentUrl);
                intent.putExtra("upload_image_type", 1);
                this.b.setResult(-1, intent);
                this.b.finish();
                if ("flutter".equals(this.b.getIntent().getStringExtra("from"))) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.b.currentUrl));
                    return;
                }
                return;
            }
            new mu4().b(this.a.getNetContext().getResponse().mErrorString);
        }

        public /* synthetic */ h(ChangeSystemPhotoActivity changeSystemPhotoActivity, a aVar) {
            this(changeSystemPhotoActivity);
        }
    }

    public ChangeSystemPhotoActivity() {
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
        this.mNavigationBar = null;
        this.mDoneButton = null;
        this.mBackButton = null;
        this.mGridView = null;
        this.mRootView = null;
        this.mAdapter = null;
        this.recommendPhotos = null;
        this.currentChoosedID = -1;
        this.mResetTask = null;
        this.mPhotoData = null;
        this.currentUrl = null;
        this.needUpload = true;
        this.mCallback = new g(this);
    }

    private void getPopularPortraits() {
        SapiAccount session;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (session = SapiAccountManager.getInstance().getSession()) == null) {
            return;
        }
        SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new d(this), session.bduss);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, str, bitmap)) == null) {
            try {
                FileHelper.saveBitmapByRelativelyPath(null, str, bitmap, 80);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void changeDoneButtonState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mDoneButton.setEnabled(z);
            SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.needUpload = getIntent().getBooleanExtra("need_upload", true);
            this.recommendPhotos = new ArrayList<>();
            getPopularPortraits();
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0905e7);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackButton = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new a(this));
            this.mNavigationBar.setTitleText(R.string.obfuscated_res_0x7f0f03c9);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f04ed));
            this.mDoneButton = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.mDoneButton.setLayoutParams(layoutParams);
            int f2 = mi.f(getPageContext().getPageActivity(), R.dimen.tbds27);
            this.mDoneButton.setPadding(f2, 0, f2, 0);
            changeDoneButtonState(false);
            SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
            this.mDoneButton.setOnClickListener(new b(this));
            this.mGridView = (BdGridView) findViewById(R.id.obfuscated_res_0x7f091a5a);
            z95 z95Var = new z95(getPageContext());
            this.mAdapter = z95Var;
            this.mGridView.setAdapter((ListAdapter) z95Var);
            this.mGridView.setOnItemClickListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mRootView);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01d2);
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (this.currentChoosedID != -1) {
                    showDialog();
                    return true;
                }
                setResult(0);
                finish();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void resetUserPortraits(aa5 aa5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aa5Var) == null) || aa5Var == null || StringUtils.isNull(aa5Var.a())) {
            return;
        }
        this.currentUrl = aa5Var.a();
        gg.h().k(aa5Var.a(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.currentUrl));
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0568);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new e(this));
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new f(this));
            nr4Var.create(getPageContext()).show();
        }
    }
}
