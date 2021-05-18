package com.baidu.tieba.enterForum.hotuserrank;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.k0.i0.i.c.d;
import d.a.k0.i0.i.d.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import tbclient.TiebaFieldsInfo;
/* loaded from: classes4.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    public static final long ONE_DAY_MIllIS = 86400000;
    public boolean isGod;
    public long mForumId;
    public HotUserRankView mHotUserRankView;
    public String mInputCategory;
    public d.a.k0.i0.i.d.a mModel;
    public String mRuleUrl;
    public List<d> mTabDataList = new ArrayList();
    public int mJumpPosition = 0;
    public Runnable mLoadDataRunnable = new a();
    public Runnable mHideUpdateTipRunnable = new b();
    public a.b mOnDataResListener = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.mHotUserRankView.l(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.mJumpPosition, HotUserRankActivity.this.mRuleUrl);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.mHotUserRankView.o(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.a.k0.i0.i.d.a.b
        public void a(d.a.k0.i0.i.c.c cVar) {
            HotUserRankActivity hotUserRankActivity = HotUserRankActivity.this;
            hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
            if (cVar == null || cVar.f55789a == null) {
                return;
            }
            HotUserRankActivity.this.mRuleUrl = cVar.f55792d;
            if (HotUserRankActivity.this.mForumId > 0) {
                e.a().post(HotUserRankActivity.this.mLoadDataRunnable);
                return;
            }
            TiebaFieldsInfo tiebaFieldsInfo = cVar.f55789a.f55780f;
            if (tiebaFieldsInfo != null && !ListUtils.isEmpty(tiebaFieldsInfo.tieba_fields)) {
                List<String> list = cVar.f55789a.f55780f.tieba_fields;
                HotUserRankActivity.this.mTabDataList.clear();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (str != null && str.equals(HotUserRankActivity.this.mInputCategory)) {
                        HotUserRankActivity.this.mJumpPosition = i2;
                    }
                    d dVar = new d();
                    dVar.f55797b = str;
                    dVar.f55796a = str;
                    HotUserRankActivity.this.mTabDataList.add(dVar);
                }
                e.a().post(HotUserRankActivity.this.mLoadDataRunnable);
                return;
            }
            HotUserRankActivity hotUserRankActivity2 = HotUserRankActivity.this;
            hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), HotUserRankActivity.this.getString(R.string.neterror), true);
        }

        @Override // d.a.k0.i0.i.d.a.b
        public void onError(int i2, String str) {
            HotUserRankActivity hotUserRankActivity = HotUserRankActivity.this;
            hotUserRankActivity.hideLoadingView(hotUserRankActivity.mHotUserRankView.i());
            HotUserRankActivity hotUserRankActivity2 = HotUserRankActivity.this;
            hotUserRankActivity2.showNetRefreshView(hotUserRankActivity2.mHotUserRankView.i(), str, true);
        }
    }

    private void checkShowUpdateTip() {
        long l = d.a.j0.r.d0.b.j().l("key_hot_user_rank_last_update_time", 0L);
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
            d.a.j0.r.d0.b.j().w("key_hot_user_rank_last_update_time", currentTimeMillis);
        }
    }

    private void parseIntent() {
        Uri uri;
        if (getIntent() != null) {
            this.mInputCategory = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.mInputCategory) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                String queryParameter = uri.getQueryParameter("module_name");
                this.mInputCategory = queryParameter;
                if (TextUtils.isEmpty(queryParameter)) {
                    this.mForumId = d.a.c.e.m.b.f(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a074";
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mHotUserRankView.j(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HotUserRankView hotUserRankView = new HotUserRankView(this);
        this.mHotUserRankView = hotUserRankView;
        setContentView(hotUserRankView.i());
        d.a.k0.i0.i.d.a aVar = new d.a.k0.i0.i.d.a(getUniqueId());
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.a().removeCallbacks(this.mLoadDataRunnable);
        e.a().removeCallbacks(this.mHideUpdateTipRunnable);
        this.mModel.k();
        this.mHotUserRankView.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.mModel.i(this.mInputCategory);
        showLoadingView(this.mHotUserRankView.i());
        hideNetRefreshView(this.mHotUserRankView.i());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            StatisticItem statisticItem = new StatisticItem("c13667");
            statisticItem.param("fid", this.mForumId);
            TiebaStatic.log(statisticItem);
        }
    }
}
