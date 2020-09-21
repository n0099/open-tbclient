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
/* loaded from: classes21.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView hDP;
    private com.baidu.tieba.enterForum.hotuserrank.model.a hDQ;
    private String hDR;
    private String hDS;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int hDT = 0;
    private Runnable hDU = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hDP.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.hDT, HotUserRankActivity.this.hDS);
        }
    };
    private Runnable hDV = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hDP.wB(8);
        }
    };
    private a.InterfaceC0667a hDW = new a.InterfaceC0667a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0667a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hDP.getView());
            if (cVar != null && cVar.hER != null) {
                HotUserRankActivity.this.hDS = cVar.ghT;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mX().post(HotUserRankActivity.this.hDU);
                } else if (cVar.hER.hEL == null || y.isEmpty(cVar.hER.hEL.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hDP.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.hER.hEL.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mX().post(HotUserRankActivity.this.hDU);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.hDR)) {
                            HotUserRankActivity.this.hDT = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0667a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hDP.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hDP.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hDP = new HotUserRankView(this);
        setContentView(this.hDP.getView());
        this.hDQ = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hDQ.a(this.hDW);
        cji();
        if (!TextUtils.isEmpty(this.hDR)) {
            this.hDQ.HV(this.hDR);
        } else if (this.mForumId > 0) {
            this.hDP.setTitle(getString(R.string.forum_hot_user_rank));
            this.hDQ.eJ(this.mForumId);
        }
        this.hDP.setIsGod(this.isGod);
        if (this.isGod) {
            this.hDP.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.hDP.getView());
    }

    private void cji() {
        Uri uri;
        if (getIntent() != null) {
            this.hDR = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.hDR) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.hDR = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.hDR)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.hDQ.HV(this.hDR);
        showLoadingView(this.hDP.getView());
        hideNetRefreshView(this.hDP.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hDP.onChangeSkinType(i);
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
        e.mX().removeCallbacks(this.hDU);
        e.mX().removeCallbacks(this.hDV);
        this.hDQ.onDestroy();
        this.hDP.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
