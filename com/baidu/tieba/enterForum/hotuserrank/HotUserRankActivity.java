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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView iJg;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iJh;
    private String iJi;
    private String iJj;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iJk = 0;
    private Runnable iJl = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iJg.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iJk, HotUserRankActivity.this.iJj);
        }
    };
    private Runnable iJm = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iJg.zd(8);
        }
    };
    private a.InterfaceC0723a iJn = new a.InterfaceC0723a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0723a
        public void a(c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iJg.getView());
            if (cVar != null && cVar.iKh != null) {
                HotUserRankActivity.this.iJj = cVar.heG;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mB().post(HotUserRankActivity.this.iJl);
                } else if (cVar.iKh.iKc == null || x.isEmpty(cVar.iKh.iKc.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iJg.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.iKh.iKc.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mB().post(HotUserRankActivity.this.iJl);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iJi)) {
                            HotUserRankActivity.this.iJk = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0723a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iJg.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iJg.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iJg = new HotUserRankView(this);
        setContentView(this.iJg.getView());
        this.iJh = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iJh.a(this.iJn);
        cyZ();
        if (!TextUtils.isEmpty(this.iJi)) {
            this.iJh.JM(this.iJi);
        } else if (this.mForumId > 0) {
            this.iJg.setTitle(getString(R.string.forum_hot_user_rank));
            this.iJh.ge(this.mForumId);
        }
        this.iJg.setIsGod(this.isGod);
        if (this.isGod) {
            this.iJg.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iJg.getView());
    }

    private void cyZ() {
        Uri uri;
        if (getIntent() != null) {
            this.iJi = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iJi) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iJi = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iJi)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iJh.JM(this.iJi);
        showLoadingView(this.iJg.getView());
        hideNetRefreshView(this.iJg.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iJg.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            aq aqVar = new aq("c13667");
            aqVar.w("fid", this.mForumId);
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mB().removeCallbacks(this.iJl);
        e.mB().removeCallbacks(this.iJm);
        this.iJh.onDestroy();
        this.iJg.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
