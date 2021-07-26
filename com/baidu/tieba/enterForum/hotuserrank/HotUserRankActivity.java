package com.baidu.tieba.enterForum.hotuserrank;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.d.e.m.e;
import d.a.q0.l0.i.c.d;
import d.a.q0.l0.i.d.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes4.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ONE_DAY_MIllIS = 86400000;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isGod;
    public long mForumId;
    public Runnable mHideUpdateTipRunnable;
    public HotUserRankView mHotUserRankView;
    public String mInputCategory;
    public int mJumpPosition;
    public Runnable mLoadDataRunnable;
    public d.a.q0.l0.i.d.a mModel;
    public a.b mOnDataResListener;
    public String mRuleUrl;
    public List<d> mTabDataList;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankActivity f14747e;

        public a(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14747e = hotUserRankActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14747e.mHotUserRankView.l(this.f14747e.mTabDataList, this.f14747e.mForumId, this.f14747e.mJumpPosition, this.f14747e.mRuleUrl);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankActivity f14748e;

        public b(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14748e = hotUserRankActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14748e.mHotUserRankView.o(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankActivity f14749a;

        public c(HotUserRankActivity hotUserRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14749a = hotUserRankActivity;
        }

        @Override // d.a.q0.l0.i.d.a.b
        public void a(d.a.q0.l0.i.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                HotUserRankActivity hotUserRankActivity = this.f14749a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
                if (cVar == null || cVar.f60295a == null) {
                    return;
                }
                this.f14749a.mRuleUrl = cVar.f60298d;
                if (this.f14749a.mForumId > 0) {
                    e.a().post(this.f14749a.mLoadDataRunnable);
                    return;
                }
                TiebaFieldsInfo tiebaFieldsInfo = cVar.f60295a.f60286f;
                if (tiebaFieldsInfo != null && !ListUtils.isEmpty(tiebaFieldsInfo.tieba_fields)) {
                    List<String> list = cVar.f60295a.f60286f.tieba_fields;
                    this.f14749a.mTabDataList.clear();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        String str = list.get(i2);
                        if (str != null && str.equals(this.f14749a.mInputCategory)) {
                            this.f14749a.mJumpPosition = i2;
                        }
                        d dVar = new d();
                        dVar.f60303b = str;
                        dVar.f60302a = str;
                        this.f14749a.mTabDataList.add(dVar);
                    }
                    e.a().post(this.f14749a.mLoadDataRunnable);
                    return;
                }
                HotUserRankActivity hotUserRankActivity2 = this.f14749a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), this.f14749a.getString(R.string.neterror), true);
            }
        }

        @Override // d.a.q0.l0.i.d.a.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                HotUserRankActivity hotUserRankActivity = this.f14749a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
                HotUserRankActivity hotUserRankActivity2 = this.f14749a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), str, true);
            }
        }
    }

    public HotUserRankActivity() {
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
        this.mTabDataList = new ArrayList();
        this.mJumpPosition = 0;
        this.mLoadDataRunnable = new a(this);
        this.mHideUpdateTipRunnable = new b(this);
        this.mOnDataResListener = new c(this);
    }

    private void checkShowUpdateTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            long l = d.a.p0.s.d0.b.j().l("key_hot_user_rank_last_update_time", 0L);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 6);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            if (currentTimeMillis <= timeInMillis ? l >= timeInMillis - 86400000 : l >= timeInMillis) {
                z = false;
            }
            if (z) {
                this.mHotUserRankView.o(0);
                e.a().postDelayed(this.mHideUpdateTipRunnable, 5000L);
                d.a.p0.s.d0.b.j().w("key_hot_user_rank_last_update_time", currentTimeMillis);
            }
        }
    }

    private void parseIntent() {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || getIntent() == null) {
            return;
        }
        this.mInputCategory = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
        this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
        if (TextUtils.isEmpty(this.mInputCategory) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("module_name");
            this.mInputCategory = queryParameter;
            if (TextUtils.isEmpty(queryParameter)) {
                this.mForumId = d.a.d.e.m.b.f(uri.getQueryParameter("fid"), -1L);
            }
        }
        this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a074" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mHotUserRankView.j(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            HotUserRankView hotUserRankView = new HotUserRankView(this);
            this.mHotUserRankView = hotUserRankView;
            setContentView(hotUserRankView.i());
            d.a.q0.l0.i.d.a aVar = new d.a.q0.l0.i.d.a(getUniqueId());
            this.mModel = aVar;
            aVar.n(this.mOnDataResListener);
            parseIntent();
            if (!TextUtils.isEmpty(this.mInputCategory)) {
                this.mModel.i(this.mInputCategory);
            } else if (this.mForumId > 0) {
                this.mHotUserRankView.n(getString(R.string.forum_hot_user_rank));
                this.mModel.h(this.mForumId);
            }
            this.mHotUserRankView.m(this.isGod);
            if (this.isGod) {
                this.mHotUserRankView.n(getString(R.string.all_god_user_rank));
            }
            showLoadingView(this.mHotUserRankView.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            e.a().removeCallbacks(this.mLoadDataRunnable);
            e.a().removeCallbacks(this.mHideUpdateTipRunnable);
            this.mModel.k();
            this.mHotUserRankView.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mModel.i(this.mInputCategory);
            showLoadingView(this.mHotUserRankView.i());
            hideNetRefreshView(this.mHotUserRankView.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            if (this.mForumId > 0) {
                StatisticItem statisticItem = new StatisticItem("c13667");
                statisticItem.param("fid", this.mForumId);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
