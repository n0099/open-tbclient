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
import com.repackage.iu4;
import com.repackage.k56;
import com.repackage.kg;
import com.repackage.l56;
import com.repackage.m56;
import com.repackage.ng;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes3.dex */
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
    public m56 mModel;
    public m56.b mOnDataResListener;
    public String mRuleUrl;
    public List<l56> mTabDataList;

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
                this.a.mHotUserRankView.l(this.a.mTabDataList, this.a.mForumId, this.a.mJumpPosition, this.a.mRuleUrl);
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
                this.a.mHotUserRankView.o(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements m56.b {
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

        @Override // com.repackage.m56.b
        public void a(k56 k56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k56Var) == null) {
                HotUserRankActivity hotUserRankActivity = this.a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
                if (k56Var == null || k56Var.a == null) {
                    return;
                }
                this.a.mRuleUrl = k56Var.d;
                if (this.a.mForumId > 0) {
                    ng.a().post(this.a.mLoadDataRunnable);
                    return;
                }
                TiebaFieldsInfo tiebaFieldsInfo = k56Var.a.f;
                if (tiebaFieldsInfo != null && !ListUtils.isEmpty(tiebaFieldsInfo.tieba_fields)) {
                    List<String> list = k56Var.a.f.tieba_fields;
                    this.a.mTabDataList.clear();
                    for (int i = 0; i < list.size(); i++) {
                        String str = list.get(i);
                        if (str != null && str.equals(this.a.mInputCategory)) {
                            this.a.mJumpPosition = i;
                        }
                        l56 l56Var = new l56();
                        l56Var.b = str;
                        l56Var.a = str;
                        this.a.mTabDataList.add(l56Var);
                    }
                    ng.a().post(this.a.mLoadDataRunnable);
                    return;
                }
                HotUserRankActivity hotUserRankActivity2 = this.a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), this.a.getString(R.string.obfuscated_res_0x7f0f0c2d), true);
            }
        }

        @Override // com.repackage.m56.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                HotUserRankActivity hotUserRankActivity = this.a;
                hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
                HotUserRankActivity hotUserRankActivity2 = this.a;
                hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), str, true);
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
        this.mTabDataList = new ArrayList();
        this.mJumpPosition = 0;
        this.mLoadDataRunnable = new a(this);
        this.mHideUpdateTipRunnable = new b(this);
        this.mOnDataResListener = new c(this);
    }

    private void checkShowUpdateTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            long m = iu4.k().m("key_hot_user_rank_last_update_time", 0L);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 6);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            if (currentTimeMillis <= timeInMillis ? m >= timeInMillis - 86400000 : m >= timeInMillis) {
                z = false;
            }
            if (z) {
                this.mHotUserRankView.o(0);
                ng.a().postDelayed(this.mHideUpdateTipRunnable, 5000L);
                iu4.k().x("key_hot_user_rank_last_update_time", currentTimeMillis);
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
            String queryParameter = uri.getQueryParameter(Info.kBaiduModuleKey);
            this.mInputCategory = queryParameter;
            if (TextUtils.isEmpty(queryParameter)) {
                this.mForumId = kg.g(uri.getQueryParameter("fid"), -1L);
            }
        }
        this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a074" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mHotUserRankView.j(i);
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
            m56 m56Var = new m56(getUniqueId());
            this.mModel = m56Var;
            m56Var.n(this.mOnDataResListener);
            parseIntent();
            if (!TextUtils.isEmpty(this.mInputCategory)) {
                this.mModel.i(this.mInputCategory);
            } else if (this.mForumId > 0) {
                this.mHotUserRankView.n(getString(R.string.obfuscated_res_0x7f0f0670));
                this.mModel.h(this.mForumId);
            }
            this.mHotUserRankView.m(this.isGod);
            if (this.isGod) {
                this.mHotUserRankView.n(getString(R.string.obfuscated_res_0x7f0f0266));
            }
            showLoadingView(this.mHotUserRankView.i());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            ng.a().removeCallbacks(this.mLoadDataRunnable);
            ng.a().removeCallbacks(this.mHideUpdateTipRunnable);
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
