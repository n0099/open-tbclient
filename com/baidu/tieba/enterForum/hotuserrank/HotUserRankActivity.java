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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private boolean isGod;
    private HotUserRankView iwR;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iwS;
    private String iwT;
    private String iwU;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iwV = 0;
    private Runnable iwW = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iwR.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iwV, HotUserRankActivity.this.iwU);
        }
    };
    private Runnable iwX = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iwR.yQ(8);
        }
    };
    private a.InterfaceC0732a iwY = new a.InterfaceC0732a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0732a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iwR.getView());
            if (cVar != null && cVar.ixS != null) {
                HotUserRankActivity.this.iwU = cVar.gSR;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mY().post(HotUserRankActivity.this.iwW);
                } else if (cVar.ixS.ixN == null || y.isEmpty(cVar.ixS.ixN.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iwR.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.ixS.ixN.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mY().post(HotUserRankActivity.this.iwW);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iwT)) {
                            HotUserRankActivity.this.iwV = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0732a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iwR.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iwR.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iwR = new HotUserRankView(this);
        setContentView(this.iwR.getView());
        this.iwS = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iwS.a(this.iwY);
        cwe();
        if (!TextUtils.isEmpty(this.iwT)) {
            this.iwS.JP(this.iwT);
        } else if (this.mForumId > 0) {
            this.iwR.setTitle(getString(R.string.forum_hot_user_rank));
            this.iwS.ge(this.mForumId);
        }
        this.iwR.setIsGod(this.isGod);
        if (this.isGod) {
            this.iwR.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iwR.getView());
    }

    private void cwe() {
        Uri uri;
        if (getIntent() != null) {
            this.iwT = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iwT) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iwT = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iwT)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iwS.JP(this.iwT);
        showLoadingView(this.iwR.getView());
        hideNetRefreshView(this.iwR.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iwR.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            ar arVar = new ar("c13667");
            arVar.w("fid", this.mForumId);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mY().removeCallbacks(this.iwW);
        e.mY().removeCallbacks(this.iwX);
        this.iwS.onDestroy();
        this.iwR.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
