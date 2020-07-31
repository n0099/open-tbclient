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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView hjO;
    private com.baidu.tieba.enterForum.hotuserrank.model.a hjP;
    private String hjQ;
    private String hjR;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int hjS = 0;
    private Runnable hjT = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hjO.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.hjS, HotUserRankActivity.this.hjR);
        }
    };
    private Runnable hjU = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hjO.tN(8);
        }
    };
    private a.InterfaceC0619a hjV = new a.InterfaceC0619a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0619a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hjO.getView());
            if (cVar != null && cVar.hkS != null) {
                HotUserRankActivity.this.hjR = cVar.fSF;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.lt().post(HotUserRankActivity.this.hjT);
                } else if (cVar.hkS.hkM == null || x.isEmpty(cVar.hkS.hkM.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hjO.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.hkS.hkM.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.lt().post(HotUserRankActivity.this.hjT);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.hjQ)) {
                            HotUserRankActivity.this.hjS = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0619a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hjO.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hjO.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjO = new HotUserRankView(this);
        setContentView(this.hjO.getView());
        this.hjP = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hjP.a(this.hjV);
        bVD();
        if (!TextUtils.isEmpty(this.hjQ)) {
            this.hjP.EY(this.hjQ);
        } else if (this.mForumId > 0) {
            this.hjO.setTitle(getString(R.string.forum_hot_user_rank));
            this.hjP.eo(this.mForumId);
        }
        showLoadingView(this.hjO.getView());
    }

    private void bVD() {
        Uri uri;
        if (getIntent() != null) {
            this.hjQ = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.hjQ) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.hjQ = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.hjQ)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.hjP.EY(this.hjQ);
        showLoadingView(this.hjO.getView());
        hideNetRefreshView(this.hjO.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hjO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            ap apVar = new ap("c13667");
            apVar.t("fid", this.mForumId);
            TiebaStatic.log(apVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.lt().removeCallbacks(this.hjT);
        e.lt().removeCallbacks(this.hjU);
        this.hjP.onDestroy();
        this.hjO.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
