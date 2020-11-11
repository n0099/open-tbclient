package com.baidu.tieba.enterForum.hotuserrank;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.f.e;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView ilj;
    private com.baidu.tieba.enterForum.hotuserrank.model.a ilk;
    private String ill;
    private String ilm;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iln = 0;
    private Runnable ilo = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.ilj.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iln, HotUserRankActivity.this.ilm);
        }
    };
    private Runnable ilp = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.ilj.xN(8);
        }
    };
    private a.InterfaceC0715a ilq = new a.InterfaceC0715a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0715a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.ilj.getView());
            if (cVar != null && cVar.iml != null) {
                HotUserRankActivity.this.ilm = cVar.gJZ;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mY().post(HotUserRankActivity.this.ilo);
                } else if (cVar.iml.imf == null || y.isEmpty(cVar.iml.imf.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.ilj.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.iml.imf.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mY().post(HotUserRankActivity.this.ilo);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.ill)) {
                            HotUserRankActivity.this.iln = i2;
                        }
                        d dVar = new d();
                        dVar.category = str;
                        dVar.name = str;
                        HotUserRankActivity.this.mTabDataList.add(dVar);
                        i = i2 + 1;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0715a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.ilj.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.ilj.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilj = new HotUserRankView(this);
        setContentView(this.ilj.getView());
        this.ilk = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.ilk.a(this.ilq);
        csm();
        if (!TextUtils.isEmpty(this.ill)) {
            this.ilk.Jy(this.ill);
        } else if (this.mForumId > 0) {
            this.ilj.setTitle(getString(R.string.forum_hot_user_rank));
            this.ilk.fx(this.mForumId);
        }
        this.ilj.setIsGod(this.isGod);
        if (this.isGod) {
            this.ilj.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.ilj.getView());
    }

    private void csm() {
        Uri uri;
        if (getIntent() != null) {
            this.ill = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.ill) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.ill = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.ill)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.ilk.Jy(this.ill);
        showLoadingView(this.ilj.getView());
        hideNetRefreshView(this.ilj.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.ilj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            aq aqVar = new aq("c13667");
            aqVar.w("fid", this.mForumId);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mY().removeCallbacks(this.ilo);
        e.mY().removeCallbacks(this.ilp);
        this.ilk.onDestroy();
        this.ilj.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
