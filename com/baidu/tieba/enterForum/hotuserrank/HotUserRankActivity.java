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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView gCB;
    private com.baidu.tieba.enterForum.hotuserrank.model.a gCC;
    private String gCD;
    private String gCE;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int gCF = 0;
    private Runnable gCG = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gCB.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.gCF, HotUserRankActivity.this.gCE);
        }
    };
    private Runnable gCH = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gCB.sn(8);
        }
    };
    private a.InterfaceC0552a gCI = new a.InterfaceC0552a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0552a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gCB.getView());
            if (cVar != null && cVar.gDF != null) {
                HotUserRankActivity.this.gCE = cVar.fof;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.lb().post(HotUserRankActivity.this.gCG);
                } else if (cVar.gDF.gDz == null || v.isEmpty(cVar.gDF.gDz.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gCB.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.gDF.gDz.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.lb().post(HotUserRankActivity.this.gCG);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.gCD)) {
                            HotUserRankActivity.this.gCF = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0552a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gCB.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gCB.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCB = new HotUserRankView(this);
        setContentView(this.gCB.getView());
        this.gCC = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.gCC.a(this.gCI);
        bIM();
        if (!TextUtils.isEmpty(this.gCD)) {
            this.gCC.Cd(this.gCD);
        } else if (this.mForumId > 0) {
            this.gCB.setTitle(getString(R.string.forum_hot_user_rank));
            this.gCC.dX(this.mForumId);
        }
        showLoadingView(this.gCB.getView());
    }

    private void bIM() {
        Uri uri;
        if (getIntent() != null) {
            this.gCD = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.gCD) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.gCD = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.gCD)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.gCC.Cd(this.gCD);
        showLoadingView(this.gCB.getView());
        hideNetRefreshView(this.gCB.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gCB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            an anVar = new an("c13667");
            anVar.t("fid", this.mForumId);
            TiebaStatic.log(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.lb().removeCallbacks(this.gCG);
        e.lb().removeCallbacks(this.gCH);
        this.gCC.onDestroy();
        this.gCB.onDestroy();
    }
}
