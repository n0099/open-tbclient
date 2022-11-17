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
import com.baidu.tieba.ac6;
import com.baidu.tieba.ah;
import com.baidu.tieba.bc6;
import com.baidu.tieba.xg;
import com.baidu.tieba.zb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes4.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HotUserRankView a;
    public bc6 b;
    public String c;
    public long d;
    public List<ac6> e;
    public String f;
    public int g;
    public boolean h;
    public Runnable i;
    public Runnable j;
    public bc6.b k;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.de5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a074" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c implements bc6.b {
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

        @Override // com.baidu.tieba.bc6.b
        public void a(zb6 zb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zb6Var) == null) {
                HotUserRankActivity hotUserRankActivity = this.a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.a.i());
                if (zb6Var != null && zb6Var.a != null) {
                    this.a.f = zb6Var.d;
                    if (this.a.d > 0) {
                        ah.a().post(this.a.i);
                        return;
                    }
                    TiebaFieldsInfo tiebaFieldsInfo = zb6Var.a.f;
                    if (tiebaFieldsInfo != null && !ListUtils.isEmpty(tiebaFieldsInfo.tieba_fields)) {
                        List<String> list = zb6Var.a.f.tieba_fields;
                        this.a.e.clear();
                        for (int i = 0; i < list.size(); i++) {
                            String str = list.get(i);
                            if (str != null && str.equals(this.a.c)) {
                                this.a.g = i;
                            }
                            ac6 ac6Var = new ac6();
                            ac6Var.b = str;
                            ac6Var.a = str;
                            this.a.e.add(ac6Var);
                        }
                        ah.a().post(this.a.i);
                        return;
                    }
                    HotUserRankActivity hotUserRankActivity2 = this.a;
                    hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.a.i(), this.a.getString(R.string.obfuscated_res_0x7f0f0c81), true);
                }
            }
        }

        @Override // com.baidu.tieba.bc6.b
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.j(i);
        }
    }

    public final void Z0() {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getIntent() != null) {
            this.c = getIntent().getStringExtra("key_category");
            this.d = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.c) && this.d == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                String queryParameter = uri.getQueryParameter(Info.kBaiduModuleKey);
                this.c = queryParameter;
                if (TextUtils.isEmpty(queryParameter)) {
                    this.d = xg.g(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.h = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
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
            bc6 bc6Var = new bc6(getUniqueId());
            this.b = bc6Var;
            bc6Var.n(this.k);
            Z0();
            if (!TextUtils.isEmpty(this.c)) {
                this.b.i(this.c);
            } else if (this.d > 0) {
                this.a.n(getString(R.string.obfuscated_res_0x7f0f06a1));
                this.b.h(this.d);
            }
            this.a.m(this.h);
            if (this.h) {
                this.a.n(getString(R.string.obfuscated_res_0x7f0f0273));
            }
            showLoadingView(this.a.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            ah.a().removeCallbacks(this.i);
            ah.a().removeCallbacks(this.j);
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
