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
import com.baidu.tieba.enterForum.hotuserrank.a.c;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView iMf;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iMg;
    private String iMh;
    private String iMi;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iMj = 0;
    private Runnable iMk = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iMf.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iMj, HotUserRankActivity.this.iMi);
        }
    };
    private Runnable iMl = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iMf.xI(8);
        }
    };
    private a.InterfaceC0713a iMm = new a.InterfaceC0713a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0713a
        public void a(c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iMf.getView());
            if (cVar != null && cVar.iNg != null) {
                HotUserRankActivity.this.iMi = cVar.heH;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mA().post(HotUserRankActivity.this.iMk);
                } else if (cVar.iNg.iNb == null || y.isEmpty(cVar.iNg.iNb.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iMf.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.iNg.iNb.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mA().post(HotUserRankActivity.this.iMk);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iMh)) {
                            HotUserRankActivity.this.iMj = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0713a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iMf.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iMf.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iMf = new HotUserRankView(this);
        setContentView(this.iMf.getView());
        this.iMg = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iMg.a(this.iMm);
        cwG();
        if (!TextUtils.isEmpty(this.iMh)) {
            this.iMg.Jw(this.iMh);
        } else if (this.mForumId > 0) {
            this.iMf.setTitle(getString(R.string.forum_hot_user_rank));
            this.iMg.gj(this.mForumId);
        }
        this.iMf.setIsGod(this.isGod);
        if (this.isGod) {
            this.iMf.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iMf.getView());
    }

    private void cwG() {
        Uri uri;
        if (getIntent() != null) {
            this.iMh = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iMh) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iMh = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iMh)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iMg.Jw(this.iMh);
        showLoadingView(this.iMf.getView());
        hideNetRefreshView(this.iMf.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iMf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            ar arVar = new ar("c13667");
            arVar.v("fid", this.mForumId);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.mA().removeCallbacks(this.iMk);
        e.mA().removeCallbacks(this.iMl);
        this.iMg.onDestroy();
        this.iMf.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
