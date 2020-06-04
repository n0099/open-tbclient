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
    private HotUserRankView gRv;
    private com.baidu.tieba.enterForum.hotuserrank.model.a gRw;
    private String gRx;
    private String gRy;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int gRz = 0;
    private Runnable gRA = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gRv.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.gRz, HotUserRankActivity.this.gRy);
        }
    };
    private Runnable gRB = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gRv.sU(8);
        }
    };
    private a.InterfaceC0602a gRC = new a.InterfaceC0602a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0602a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gRv.getView());
            if (cVar != null && cVar.gSz != null) {
                HotUserRankActivity.this.gRy = cVar.fCd;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.ld().post(HotUserRankActivity.this.gRA);
                } else if (cVar.gSz.gSt == null || v.isEmpty(cVar.gSz.gSt.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gRv.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.gSz.gSt.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.ld().post(HotUserRankActivity.this.gRA);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.gRx)) {
                            HotUserRankActivity.this.gRz = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0602a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gRv.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gRv.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gRv = new HotUserRankView(this);
        setContentView(this.gRv.getView());
        this.gRw = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.gRw.a(this.gRC);
        bPi();
        if (!TextUtils.isEmpty(this.gRx)) {
            this.gRw.DM(this.gRx);
        } else if (this.mForumId > 0) {
            this.gRv.setTitle(getString(R.string.forum_hot_user_rank));
            this.gRw.dY(this.mForumId);
        }
        showLoadingView(this.gRv.getView());
    }

    private void bPi() {
        Uri uri;
        if (getIntent() != null) {
            this.gRx = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.gRx) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.gRx = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.gRx)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.gRw.DM(this.gRx);
        showLoadingView(this.gRv.getView());
        hideNetRefreshView(this.gRv.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gRv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            an anVar = new an("c13667");
            anVar.s("fid", this.mForumId);
            TiebaStatic.log(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.ld().removeCallbacks(this.gRA);
        e.ld().removeCallbacks(this.gRB);
        this.gRw.onDestroy();
        this.gRv.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
