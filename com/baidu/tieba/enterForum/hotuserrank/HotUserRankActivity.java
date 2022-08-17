package com.baidu.tieba.enterForum.hotuserrank;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m76;
import com.repackage.n76;
import com.repackage.o76;
import com.repackage.og;
import com.repackage.rg;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes3.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotUserRankView a;
    public o76 b;
    public String c;
    public long d;
    public List<n76> e;
    public String f;
    public int g;
    public boolean h;
    public Runnable i;
    public Runnable j;
    public o76.b k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankActivity a;

        public a(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.l(this.a.e, this.a.d, this.a.g, this.a.f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankActivity a;

        public b(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.o(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements o76.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankActivity a;

        public c(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankActivity;
        }

        @Override // com.repackage.o76.b
        public void a(m76 m76Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m76Var) == null) {
                HotUserRankActivity hotUserRankActivity = this.a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.a.i());
                if (m76Var == null || m76Var.a == null) {
                    return;
                }
                this.a.f = m76Var.d;
                if (this.a.d > 0) {
                    rg.a().post(this.a.i);
                    return;
                }
                TiebaFieldsInfo tiebaFieldsInfo = m76Var.a.f;
                if (tiebaFieldsInfo != null && !ListUtils.isEmpty(tiebaFieldsInfo.tieba_fields)) {
                    List<String> list = m76Var.a.f.tieba_fields;
                    this.a.e.clear();
                    for (int i = 0; i < list.size(); i++) {
                        String str = list.get(i);
                        if (str != null && str.equals(this.a.c)) {
                            this.a.g = i;
                        }
                        n76 n76Var = new n76();
                        n76Var.b = str;
                        n76Var.a = str;
                        this.a.e.add(n76Var);
                    }
                    rg.a().post(this.a.i);
                    return;
                }
                HotUserRankActivity hotUserRankActivity2 = this.a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.a.i(), this.a.getString(R.string.obfuscated_res_0x7f0f0c3d), true);
            }
        }

        @Override // com.repackage.o76.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                HotUserRankActivity hotUserRankActivity = this.a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.a.i());
                HotUserRankActivity hotUserRankActivity2 = this.a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.a.i(), str, true);
            }
        }
    }

    public HotUserRankActivity() {
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
        this.e = new ArrayList();
        this.g = 0;
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
    }

    public final void P0() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getIntent() == null) {
            return;
        }
        this.c = getIntent().getStringExtra("key_category");
        this.d = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
        if (TextUtils.isEmpty(this.c) && this.d == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter(Info.kBaiduModuleKey);
            this.c = queryParameter;
            if (TextUtils.isEmpty(queryParameter)) {
                this.d = og.g(uri.getQueryParameter("fid"), -1L);
            }
        }
        this.h = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a074" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.j(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            HotUserRankView hotUserRankView = new HotUserRankView(this);
            this.a = hotUserRankView;
            setContentView(hotUserRankView.i());
            o76 o76Var = new o76(getUniqueId());
            this.b = o76Var;
            o76Var.n(this.k);
            P0();
            if (!TextUtils.isEmpty(this.c)) {
                this.b.i(this.c);
            } else if (this.d > 0) {
                this.a.n(getString(R.string.obfuscated_res_0x7f0f067f));
                this.b.h(this.d);
            }
            this.a.m(this.h);
            if (this.h) {
                this.a.n(getString(R.string.obfuscated_res_0x7f0f026d));
            }
            showLoadingView(this.a.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            rg.a().removeCallbacks(this.i);
            rg.a().removeCallbacks(this.j);
            this.b.k();
            this.a.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.i(this.c);
            showLoadingView(this.a.i());
            hideNetRefreshView(this.a.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            if (this.d > 0) {
                StatisticItem statisticItem = new StatisticItem("c13667");
                statisticItem.param("fid", this.d);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
