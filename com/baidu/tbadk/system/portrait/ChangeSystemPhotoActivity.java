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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.fv4;
import com.baidu.tieba.hi;
import com.baidu.tieba.p35;
import com.baidu.tieba.r35;
import com.baidu.tieba.rm;
import com.baidu.tieba.wl5;
import com.baidu.tieba.xl5;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TextView b;
    public View c;
    public BdGridView d;
    public LinearLayout e;
    public wl5 f;
    public ArrayList<xl5> g;
    public int h;
    public h i;
    public rm j;
    public String k;
    public boolean l;
    public p35 m;
    public bg<rm> n;

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
                if (this.a.h != -1) {
                    this.a.Q1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != -1) {
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
                changeSystemPhotoActivity.O1((xl5) changeSystemPhotoActivity.g.get(this.a.h));
            }
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.g != null && this.a.g.size() > 0 && this.a.g.size() > i && this.a.g.get(i) != null) {
                this.a.h = i;
                this.a.L1(true);
                this.a.f.b(i);
                this.a.f.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        xl5 xl5Var = new xl5();
                        xl5Var.d(popularPortraitsInfo.url);
                        xl5Var.c(popularPortraitsInfo.num);
                        xl5Var.b(popularPortraitsInfo.myItem);
                        this.a.g.add(xl5Var);
                    }
                }
                this.a.f.c(this.a.g);
                this.a.f.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.setResult(0);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends bg<rm> {
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
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                super.onLoaded((g) rmVar, str, i);
                if (rmVar == null) {
                    return;
                }
                ChangeSystemPhotoActivity changeSystemPhotoActivity = this.a;
                if (changeSystemPhotoActivity.m == null) {
                    changeSystemPhotoActivity.m = new p35(changeSystemPhotoActivity.getPageContext());
                    this.a.m.e(null);
                }
                this.a.m.h(true);
                if (this.a.l) {
                    this.a.j = rmVar;
                    if (this.a.i != null) {
                        this.a.i.cancel();
                    }
                    this.a.i = new h(this.a, null);
                    this.a.i.execute(new String[0]);
                    return;
                }
                Bitmap p = rmVar.p();
                if (p != null) {
                    if (!this.a.P1(TbConfig.PERSON_USER_PIC_TEMP_FILE, p)) {
                        p35 p35Var = this.a.m;
                        if (p35Var != null) {
                            p35Var.h(false);
                            return;
                        }
                        return;
                    }
                    p35 p35Var2 = this.a.m;
                    if (p35Var2 != null) {
                        p35Var2.h(false);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("upload_image_type", 2);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                    return;
                }
                p35 p35Var3 = this.a.m;
                if (p35Var3 != null) {
                    p35Var3.h(false);
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

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Exception e;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_HEAD_MODIFY);
                this.a = netWork;
                try {
                    netWork.addPostData("pic", this.b.j.n());
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && this.a != null) {
                p35 p35Var = this.b.m;
                if (p35Var != null) {
                    p35Var.h(false);
                }
                if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SET_USER_AVATAR)) {
                    MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SET_USER_AVATAR));
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    new r35().d(this.b.getResources().getString(R.string.reset_success));
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
                new r35().c(this.a.getNetContext().getResponse().mErrorString);
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

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            zz4 zz4Var = new zz4(getPageContext().getPageActivity());
            zz4Var.setMessageId(R.string.enter_forum_cancel_change_tip);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new e(this));
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045e, new f(this));
            zz4Var.create(getPageContext()).show();
        }
    }

    public final boolean P1(String str, Bitmap bitmap) {
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
                    Q1();
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

    public void L1(boolean z) {
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
            setContentView(R.layout.obfuscated_res_0x7f0d01e1);
            N1();
            initData();
        }
    }

    public final void M1() {
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
            M1();
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09066c);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new a(this));
            this.a.setTitleText(R.string.choose_system_photo);
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f0532));
            this.b = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = hi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
            this.b.setLayoutParams(layoutParams);
            int g2 = hi.g(getPageContext().getPageActivity(), R.dimen.tbds27);
            this.b.setPadding(g2, 0, g2, 0);
            L1(false);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.b, R.color.navbar_btn_color, 1);
            this.b.setOnClickListener(new b(this));
            this.d = (BdGridView) findViewById(R.id.obfuscated_res_0x7f091d4d);
            wl5 wl5Var = new wl5(getPageContext());
            this.f = wl5Var;
            this.d.setAdapter((ListAdapter) wl5Var);
            this.d.setOnItemClickListener(new c(this));
        }
    }

    public void O1(xl5 xl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xl5Var) == null) && xl5Var != null && !StringUtils.isNull(xl5Var.a())) {
            this.k = xl5Var.a();
            cg.h().k(xl5Var.a(), 10, this.n, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            super.onChangeSkinType(i);
            fv4 layoutMode = getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.e);
            this.a.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.b, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.b, R.color.navbar_btn_color, 1);
        }
    }
}
