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
import c.a.e.e.p.l;
import c.a.o0.s.s.a;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentChoosedID;
    public String currentUrl;
    public c.a.o0.w0.a.a mAdapter;
    public View mBackButton;
    public c.a.e.e.l.c<c.a.e.k.d.a> mCallback;
    public TextView mDoneButton;
    public BdGridView mGridView;
    public c.a.o0.s.f0.a mLoadingDialog;
    public NavigationBar mNavigationBar;
    public c.a.e.k.d.a mPhotoData;
    public h mResetTask;
    public LinearLayout mRootView;
    public boolean needUpload;
    public ArrayList<c.a.o0.w0.a.b> recommendPhotos;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48248e;

        public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48248e = changeSystemPhotoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48248e.currentChoosedID != -1) {
                    this.f48248e.showDialog();
                    return;
                }
                this.f48248e.setResult(0);
                this.f48248e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48249e;

        public b(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48249e = changeSystemPhotoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48249e.currentChoosedID == -1) {
                return;
            }
            ChangeSystemPhotoActivity changeSystemPhotoActivity = this.f48249e;
            changeSystemPhotoActivity.resetUserPortraits((c.a.o0.w0.a.b) changeSystemPhotoActivity.recommendPhotos.get(this.f48249e.currentChoosedID));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48250e;

        public c(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48250e = changeSystemPhotoActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f48250e.recommendPhotos == null || this.f48250e.recommendPhotos.size() <= 0 || this.f48250e.recommendPhotos.size() <= i2 || this.f48250e.recommendPhotos.get(i2) == null) {
                return;
            }
            this.f48250e.currentChoosedID = i2;
            this.f48250e.changeDoneButtonState(true);
            this.f48250e.mAdapter.b(i2);
            this.f48250e.mAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends GetPopularPortraitsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48251e;

        public d(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48251e = changeSystemPhotoActivity;
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
                    c.a.o0.w0.a.b bVar = new c.a.o0.w0.a.b();
                    bVar.d(popularPortraitsInfo.url);
                    bVar.c(popularPortraitsInfo.num);
                    bVar.b(popularPortraitsInfo.myItem);
                    this.f48251e.recommendPhotos.add(bVar);
                }
            }
            this.f48251e.mAdapter.c(this.f48251e.recommendPhotos);
            this.f48251e.mAdapter.notifyDataSetChanged();
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

    /* loaded from: classes6.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48252e;

        public e(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48252e = changeSystemPhotoActivity;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48253e;

        public f(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48253e = changeSystemPhotoActivity;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48253e.setResult(0);
                this.f48253e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends c.a.e.e.l.c<c.a.e.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48254a;

        public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48254a = changeSystemPhotoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((g) aVar, str, i2);
                if (aVar == null) {
                    return;
                }
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.f48254a;
                if (changeSystemPhotoActivity.mLoadingDialog == null) {
                    changeSystemPhotoActivity.mLoadingDialog = new c.a.o0.s.f0.a(changeSystemPhotoActivity.getPageContext());
                    this.f48254a.mLoadingDialog.e(null);
                }
                this.f48254a.mLoadingDialog.h(true);
                if (this.f48254a.needUpload) {
                    this.f48254a.mPhotoData = aVar;
                    if (this.f48254a.mResetTask != null) {
                        this.f48254a.mResetTask.cancel();
                    }
                    this.f48254a.mResetTask = new h(this.f48254a, null);
                    this.f48254a.mResetTask.execute(new String[0]);
                    return;
                }
                Bitmap p = aVar.p();
                if (p != null) {
                    if (!this.f48254a.saveFile(TbConfig.PERSON_USER_PIC_TEMP_FILE, p)) {
                        c.a.o0.s.f0.a aVar2 = this.f48254a.mLoadingDialog;
                        if (aVar2 != null) {
                            aVar2.h(false);
                            return;
                        }
                        return;
                    }
                    c.a.o0.s.f0.a aVar3 = this.f48254a.mLoadingDialog;
                    if (aVar3 != null) {
                        aVar3.h(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    this.f48254a.setResult(-1, intent);
                    this.f48254a.finish();
                    return;
                }
                c.a.o0.s.f0.a aVar4 = this.f48254a.mLoadingDialog;
                if (aVar4 != null) {
                    aVar4.h(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f48255a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChangeSystemPhotoActivity f48256b;

        public h(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {changeSystemPhotoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48256b = changeSystemPhotoActivity;
            this.f48255a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48256b.mResetTask = null;
                NetWork netWork = this.f48255a;
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
            Exception e2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.f48255a = netWork;
                try {
                    netWork.addPostData("pic", this.f48256b.mPhotoData.n());
                    str = this.f48255a.postMultiNetData();
                } catch (Exception e3) {
                    e2 = e3;
                    str = null;
                }
                try {
                } catch (Exception e4) {
                    e2 = e4;
                    BdLog.e(e2.getMessage());
                    return str;
                }
                if (this.f48255a.getNetContext().getResponse().isRequestSuccess()) {
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
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f48255a == null) {
                return;
            }
            c.a.o0.s.f0.a aVar = this.f48256b.mLoadingDialog;
            if (aVar != null) {
                aVar.h(false);
            }
            if (this.f48255a.getNetContext().getResponse().isRequestSuccess()) {
                new c.a.o0.s.f0.c().c(this.f48256b.getResources().getString(R.string.reset_success));
                Intent intent = new Intent();
                intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.f48256b.currentUrl);
                intent.putExtra("upload_image_type", 1);
                this.f48256b.setResult(-1, intent);
                this.f48256b.finish();
                if ("flutter".equals(this.f48256b.getIntent().getStringExtra("from"))) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.f48256b.currentUrl));
                    return;
                }
                return;
            }
            new c.a.o0.s.f0.c().b(this.f48256b.getResources().getString(R.string.setdefualt_error));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                FileHelper.SaveFile(null, str, bitmap, 80);
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
            this.mRootView = (LinearLayout) findViewById(R.id.change_system_photo_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackButton = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new a(this));
            this.mNavigationBar.setTitleText(R.string.choose_system_photo);
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.done));
            this.mDoneButton = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
            this.mDoneButton.setLayoutParams(layoutParams);
            int g2 = l.g(getPageContext().getPageActivity(), R.dimen.tbds27);
            this.mDoneButton.setPadding(g2, 0, g2, 0);
            changeDoneButtonState(false);
            SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
            this.mDoneButton.setOnClickListener(new b(this));
            this.mGridView = (BdGridView) findViewById(R.id.recommend_photos_list);
            c.a.o0.w0.a.a aVar = new c.a.o0.w0.a.a(getPageContext());
            this.mAdapter = aVar;
            this.mGridView.setAdapter((ListAdapter) aVar);
            this.mGridView.setOnItemClickListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mRootView);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundResource(this.mDoneButton, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.mDoneButton, R.color.navbar_btn_color, 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.change_system_photo_layout);
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.currentChoosedID != -1) {
                    showDialog();
                    return true;
                }
                setResult(0);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void resetUserPortraits(c.a.o0.w0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null || StringUtils.isNull(bVar.a())) {
            return;
        }
        this.currentUrl = bVar.a();
        c.a.e.e.l.d.h().k(bVar.a(), 10, this.mCallback, 0, 0, getUniqueId(), new Object[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921378, this.currentUrl));
    }

    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessageId(R.string.enter_forum_cancel_change_tip);
            aVar.setNegativeButton(R.string.cancel, new e(this));
            aVar.setPositiveButton(R.string.confirm, new f(this));
            aVar.create(getPageContext()).show();
        }
    }
}
