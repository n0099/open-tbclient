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
/* loaded from: classes16.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView hwF;
    private com.baidu.tieba.enterForum.hotuserrank.model.a hwG;
    private String hwH;
    private String hwI;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int hwJ = 0;
    private Runnable hwK = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hwF.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.hwJ, HotUserRankActivity.this.hwI);
        }
    };
    private Runnable hwL = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hwF.wc(8);
        }
    };
    private a.InterfaceC0670a hwM = new a.InterfaceC0670a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0670a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hwF.getView());
            if (cVar != null && cVar.hxJ != null) {
                HotUserRankActivity.this.hwI = cVar.geE;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mS().post(HotUserRankActivity.this.hwK);
                } else if (cVar.hxJ.hxD == null || y.isEmpty(cVar.hxJ.hxD.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hwF.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.hxJ.hxD.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mS().post(HotUserRankActivity.this.hwK);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.hwH)) {
                            HotUserRankActivity.this.hwJ = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0670a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hwF.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hwF.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwF = new HotUserRankView(this);
        setContentView(this.hwF.getView());
        this.hwG = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hwG.a(this.hwM);
        cfQ();
        if (!TextUtils.isEmpty(this.hwH)) {
            this.hwG.Hx(this.hwH);
        } else if (this.mForumId > 0) {
            this.hwF.setTitle(getString(R.string.forum_hot_user_rank));
            this.hwG.ez(this.mForumId);
        }
        this.hwF.setIsGod(this.isGod);
        if (this.isGod) {
            this.hwF.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.hwF.getView());
    }

    private void cfQ() {
        Uri uri;
        if (getIntent() != null) {
            this.hwH = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.hwH) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.hwH = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.hwH)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.hwG.Hx(this.hwH);
        showLoadingView(this.hwF.getView());
        hideNetRefreshView(this.hwF.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hwF.onChangeSkinType(i);
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
        e.mS().removeCallbacks(this.hwK);
        e.mS().removeCallbacks(this.hwL);
        this.hwG.onDestroy();
        this.hwF.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
