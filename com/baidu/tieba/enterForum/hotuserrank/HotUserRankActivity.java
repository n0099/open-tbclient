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
    private com.baidu.tieba.enterForum.hotuserrank.model.a iEA;
    private String iEB;
    private String iEC;
    private HotUserRankView iEz;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iED = 0;
    private Runnable iEE = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iEz.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iED, HotUserRankActivity.this.iEC);
        }
    };
    private Runnable iEF = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iEz.xx(8);
        }
    };
    private a.InterfaceC0706a iEG = new a.InterfaceC0706a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0706a
        public void a(c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iEz.getView());
            if (cVar != null && cVar.iFA != null) {
                HotUserRankActivity.this.iEC = cVar.haa;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mB().post(HotUserRankActivity.this.iEE);
                } else if (cVar.iFA.iFv == null || x.isEmpty(cVar.iFA.iFv.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iEz.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.iFA.iFv.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mB().post(HotUserRankActivity.this.iEE);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iEB)) {
                            HotUserRankActivity.this.iED = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0706a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iEz.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iEz.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEz = new HotUserRankView(this);
        setContentView(this.iEz.getView());
        this.iEA = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iEA.a(this.iEG);
        cvh();
        if (!TextUtils.isEmpty(this.iEB)) {
            this.iEA.IB(this.iEB);
        } else if (this.mForumId > 0) {
            this.iEz.setTitle(getString(R.string.forum_hot_user_rank));
            this.iEA.ge(this.mForumId);
        }
        this.iEz.setIsGod(this.isGod);
        if (this.isGod) {
            this.iEz.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iEz.getView());
    }

    private void cvh() {
        Uri uri;
        if (getIntent() != null) {
            this.iEB = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iEB) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iEB = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iEB)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iEA.IB(this.iEB);
        showLoadingView(this.iEz.getView());
        hideNetRefreshView(this.iEz.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iEz.onChangeSkinType(i);
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
        e.mB().removeCallbacks(this.iEE);
        e.mB().removeCallbacks(this.iEF);
        this.iEA.onDestroy();
        this.iEz.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
