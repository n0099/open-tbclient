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
    private HotUserRankView iwT;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iwU;
    private String iwV;
    private String iwW;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iwX = 0;
    private Runnable iwY = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iwT.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iwX, HotUserRankActivity.this.iwW);
        }
    };
    private Runnable iwZ = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iwT.yQ(8);
        }
    };
    private a.InterfaceC0732a ixa = new a.InterfaceC0732a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0732a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iwT.getView());
            if (cVar != null && cVar.ixU != null) {
                HotUserRankActivity.this.iwW = cVar.gST;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mY().post(HotUserRankActivity.this.iwY);
                } else if (cVar.ixU.ixP == null || y.isEmpty(cVar.ixU.ixP.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iwT.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.ixU.ixP.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mY().post(HotUserRankActivity.this.iwY);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iwV)) {
                            HotUserRankActivity.this.iwX = i2;
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
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iwT.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iwT.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iwT = new HotUserRankView(this);
        setContentView(this.iwT.getView());
        this.iwU = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iwU.a(this.ixa);
        cwf();
        if (!TextUtils.isEmpty(this.iwV)) {
            this.iwU.JP(this.iwV);
        } else if (this.mForumId > 0) {
            this.iwT.setTitle(getString(R.string.forum_hot_user_rank));
            this.iwU.ge(this.mForumId);
        }
        this.iwT.setIsGod(this.isGod);
        if (this.isGod) {
            this.iwT.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iwT.getView());
    }

    private void cwf() {
        Uri uri;
        if (getIntent() != null) {
            this.iwV = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iwV) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iwV = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iwV)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iwU.JP(this.iwV);
        showLoadingView(this.iwT.getView());
        hideNetRefreshView(this.iwT.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iwT.onChangeSkinType(i);
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
        e.mY().removeCallbacks(this.iwY);
        e.mY().removeCallbacks(this.iwZ);
        this.iwU.onDestroy();
        this.iwT.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
