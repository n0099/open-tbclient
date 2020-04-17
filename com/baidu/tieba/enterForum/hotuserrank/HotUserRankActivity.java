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
    private HotUserRankView gCv;
    private com.baidu.tieba.enterForum.hotuserrank.model.a gCw;
    private String gCx;
    private String gCy;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int gCz = 0;
    private Runnable gCA = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gCv.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.gCz, HotUserRankActivity.this.gCy);
        }
    };
    private Runnable gCB = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.gCv.sn(8);
        }
    };
    private a.InterfaceC0531a gCC = new a.InterfaceC0531a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0531a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gCv.getView());
            if (cVar != null && cVar.gDz != null) {
                HotUserRankActivity.this.gCy = cVar.foa;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.lb().post(HotUserRankActivity.this.gCA);
                } else if (cVar.gDz.gDt == null || v.isEmpty(cVar.gDz.gDt.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gCv.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.gDz.gDt.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.lb().post(HotUserRankActivity.this.gCA);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.gCx)) {
                            HotUserRankActivity.this.gCz = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0531a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.gCv.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.gCv.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCv = new HotUserRankView(this);
        setContentView(this.gCv.getView());
        this.gCw = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.gCw.a(this.gCC);
        bIO();
        if (!TextUtils.isEmpty(this.gCx)) {
            this.gCw.Ca(this.gCx);
        } else if (this.mForumId > 0) {
            this.gCv.setTitle(getString(R.string.forum_hot_user_rank));
            this.gCw.dX(this.mForumId);
        }
        showLoadingView(this.gCv.getView());
    }

    private void bIO() {
        Uri uri;
        if (getIntent() != null) {
            this.gCx = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.gCx) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.gCx = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.gCx)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.gCw.Ca(this.gCx);
        showLoadingView(this.gCv.getView());
        hideNetRefreshView(this.gCv.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gCv.onChangeSkinType(i);
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
        e.lb().removeCallbacks(this.gCA);
        e.lb().removeCallbacks(this.gCB);
        this.gCw.onDestroy();
        this.gCv.onDestroy();
    }
}
