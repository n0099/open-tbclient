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
    private HotUserRankView hSL;
    private com.baidu.tieba.enterForum.hotuserrank.model.a hSM;
    private String hSN;
    private String hSO;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int hSP = 0;
    private Runnable hSQ = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hSL.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.hSP, HotUserRankActivity.this.hSO);
        }
    };
    private Runnable hSR = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hSL.xh(8);
        }
    };
    private a.InterfaceC0685a hSS = new a.InterfaceC0685a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0685a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hSL.getView());
            if (cVar != null && cVar.hTN != null) {
                HotUserRankActivity.this.hSO = cVar.gui;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mY().post(HotUserRankActivity.this.hSQ);
                } else if (cVar.hTN.hTH == null || y.isEmpty(cVar.hTN.hTH.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hSL.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.hTN.hTH.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mY().post(HotUserRankActivity.this.hSQ);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.hSN)) {
                            HotUserRankActivity.this.hSP = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0685a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hSL.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hSL.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hSL = new HotUserRankView(this);
        setContentView(this.hSL.getView());
        this.hSM = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hSM.a(this.hSS);
        cmE();
        if (!TextUtils.isEmpty(this.hSN)) {
            this.hSM.II(this.hSN);
        } else if (this.mForumId > 0) {
            this.hSL.setTitle(getString(R.string.forum_hot_user_rank));
            this.hSM.fa(this.mForumId);
        }
        this.hSL.setIsGod(this.isGod);
        if (this.isGod) {
            this.hSL.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.hSL.getView());
    }

    private void cmE() {
        Uri uri;
        if (getIntent() != null) {
            this.hSN = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.hSN) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.hSN = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.hSN)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.hSM.II(this.hSN);
        showLoadingView(this.hSL.getView());
        hideNetRefreshView(this.hSL.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hSL.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            aq aqVar = new aq("c13667");
            aqVar.u("fid", this.mForumId);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mY().removeCallbacks(this.hSQ);
        e.mY().removeCallbacks(this.hSR);
        this.hSM.onDestroy();
        this.hSL.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
