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
    private HotUserRankView ifm;
    private com.baidu.tieba.enterForum.hotuserrank.model.a ifn;
    private String ifo;
    private String ifp;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int ifq = 0;
    private Runnable ifr = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.ifm.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.ifq, HotUserRankActivity.this.ifp);
        }
    };
    private Runnable ifs = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.ifm.xA(8);
        }
    };
    private a.InterfaceC0701a ift = new a.InterfaceC0701a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0701a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.ifm.getView());
            if (cVar != null && cVar.ign != null) {
                HotUserRankActivity.this.ifp = cVar.gEm;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mY().post(HotUserRankActivity.this.ifr);
                } else if (cVar.ign.igi == null || y.isEmpty(cVar.ign.igi.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.ifm.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.ign.igi.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mY().post(HotUserRankActivity.this.ifr);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.ifo)) {
                            HotUserRankActivity.this.ifq = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0701a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.ifm.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.ifm.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ifm = new HotUserRankView(this);
        setContentView(this.ifm.getView());
        this.ifn = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.ifn.a(this.ift);
        cpL();
        if (!TextUtils.isEmpty(this.ifo)) {
            this.ifn.Jh(this.ifo);
        } else if (this.mForumId > 0) {
            this.ifm.setTitle(getString(R.string.forum_hot_user_rank));
            this.ifn.fb(this.mForumId);
        }
        this.ifm.setIsGod(this.isGod);
        if (this.isGod) {
            this.ifm.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.ifm.getView());
    }

    private void cpL() {
        Uri uri;
        if (getIntent() != null) {
            this.ifo = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.ifo) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.ifo = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.ifo)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.ifn.Jh(this.ifo);
        showLoadingView(this.ifm.getView());
        hideNetRefreshView(this.ifm.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.ifm.onChangeSkinType(i);
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
        e.mY().removeCallbacks(this.ifr);
        e.mY().removeCallbacks(this.ifs);
        this.ifn.onDestroy();
        this.ifm.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
