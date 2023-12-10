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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.f05;
import com.baidu.tieba.l55;
import com.baidu.tieba.mq5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.pic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TextView b;
    public View c;
    public BdGridView d;
    public LinearLayout e;
    public mq5 f;
    public ArrayList<nq5> g;
    public int h;
    public h i;
    public BdImage j;
    public String k;
    public boolean l;
    public BlueCircleProgressDialog m;
    public BdResourceCallback<BdImage> n;

    /* loaded from: classes5.dex */
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
                if (this.a.h != -1) {
                    this.a.c1();
                    return;
                }
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != -1) {
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
                changeSystemPhotoActivity.a1((nq5) changeSystemPhotoActivity.g.get(this.a.h));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.g == null || this.a.g.size() <= 0 || this.a.g.size() <= i || this.a.g.get(i) == null) {
                return;
            }
            this.a.h = i;
            this.a.W0(true);
            this.a.f.b(i);
            this.a.f.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends GetPopularPortraitsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChangeSystemPhotoActivity a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getPopularPortraitsInfoResult) == null) {
            }
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
        /* renamed from: b */
        public void onSuccess(GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            List<GetPopularPortraitsInfoResult.PopularPortraitsInfo> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPopularPortraitsInfoResult) == null) && getPopularPortraitsInfoResult != null && (list = getPopularPortraitsInfoResult.popularPortraitsInfoList) != null && list.size() > 0) {
                for (GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo : getPopularPortraitsInfoResult.popularPortraitsInfoList) {
                    if (popularPortraitsInfo != null && popularPortraitsInfo.url != null) {
                        nq5 nq5Var = new nq5();
                        nq5Var.d(popularPortraitsInfo.url);
                        nq5Var.c(popularPortraitsInfo.num);
                        nq5Var.b(popularPortraitsInfo.myItem);
                        this.a.g.add(nq5Var);
                    }
                }
                this.a.f.c(this.a.g);
                this.a.f.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f05.e {
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

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdResourceCallback<BdImage> {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((g) bdImage, str, i);
                if (bdImage == null) {
                    return;
                }
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
                if (changeSystemPhotoActivity.m == null) {
                    changeSystemPhotoActivity.m = new BlueCircleProgressDialog(changeSystemPhotoActivity.getPageContext());
                    this.a.m.setCancelListener(null);
                }
                this.a.m.setDialogVisiable(true);
                if (!this.a.l) {
                    Bitmap rawBitmap = bdImage.getRawBitmap();
                    if (rawBitmap != null) {
                        if (!this.a.b1(TbConfig.PERSON_USER_PIC_TEMP_FILE, rawBitmap)) {
                            BlueCircleProgressDialog blueCircleProgressDialog = this.a.m;
                            if (blueCircleProgressDialog != null) {
                                blueCircleProgressDialog.setDialogVisiable(false);
                                return;
                            }
                            return;
                        }
                        BlueCircleProgressDialog blueCircleProgressDialog2 = this.a.m;
                        if (blueCircleProgressDialog2 != null) {
                            blueCircleProgressDialog2.setDialogVisiable(false);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("upload_image_type", 2);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        return;
                    }
                    BlueCircleProgressDialog blueCircleProgressDialog3 = this.a.m;
                    if (blueCircleProgressDialog3 != null) {
                        blueCircleProgressDialog3.setDialogVisiable(false);
                        return;
                    }
                    return;
                }
                this.a.j = bdImage;
                if (this.a.i != null) {
                    this.a.i.cancel();
                }
                this.a.i = new h(this.a, null);
                this.a.i.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ ChangeSystemPhotoActivity b;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

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

        public /* synthetic */ h(ChangeSystemPhotoActivity changeSystemPhotoActivity, a aVar) {
            this(changeSystemPhotoActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Exception e;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.a = netWork;
                try {
                    netWork.addPostData(pic.f, this.b.j.getImageByte());
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
                if (!this.a.getNetContext().getResponse().isRequestSuccess()) {
                    return null;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.i = null;
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a != null) {
                BlueCircleProgressDialog blueCircleProgressDialog = this.b.m;
                if (blueCircleProgressDialog != null) {
                    blueCircleProgressDialog.setDialogVisiable(false);
                }
                if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SET_USER_AVATAR)) {
                    MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SET_USER_AVATAR));
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    new l55().d(this.b.getResources().getString(R.string.reset_success));
                    Intent intent = new Intent();
                    intent.putExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL, this.b.k);
                    intent.putExtra("upload_image_type", 1);
                    this.b.setResult(-1, intent);
                    this.b.finish();
                    if ("flutter".equals(this.b.getIntent().getStringExtra("from"))) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.b.k));
                        return;
                    }
                    return;
                }
                new l55().c(this.a.getNetContext().getResponse().mErrorString);
                this.b.finish();
            }
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = -1;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = true;
        this.n = new g(this);
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f05 f05Var = new f05(getPageContext().getPageActivity());
            f05Var.setMessageId(R.string.enter_forum_cancel_change_tip);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03db, new e(this));
            f05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04d2, new f(this));
            f05Var.create(getPageContext()).show();
        }
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.b.setEnabled(z);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0206);
            Z0();
            initData();
        }
    }

    public final boolean b1(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bitmap)) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (this.h != -1) {
                    c1();
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

    public final void Y0() {
        SapiAccount session;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (session = SapiAccountManager.getInstance().getSession()) == null) {
            return;
        }
        SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new d(this), session.bduss);
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = getIntent().getBooleanExtra("need_upload", true);
            this.g = new ArrayList<>();
            Y0();
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906f0);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new a(this));
            this.a.setTitleText(R.string.choose_system_photo);
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f05bc));
            this.b = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.b.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds27);
            this.b.setPadding(dimens, 0, dimens, 0);
            W0(false);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.b, R.color.navbar_btn_color, 1);
            this.b.setOnClickListener(new b(this));
            this.d = (BdGridView) findViewById(R.id.obfuscated_res_0x7f091f69);
            mq5 mq5Var = new mq5(getPageContext());
            this.f = mq5Var;
            this.d.setAdapter((ListAdapter) mq5Var);
            this.d.setOnItemClickListener(new c(this));
        }
    }

    public void a1(nq5 nq5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, nq5Var) == null) && nq5Var != null && !StringUtils.isNull(nq5Var.a())) {
            this.k = nq5Var.a();
            BdResourceLoader.getInstance().loadResource(nq5Var.a(), 10, this.n, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.e);
            this.a.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.b, R.color.navbar_btn_color, 1);
        }
    }
}
