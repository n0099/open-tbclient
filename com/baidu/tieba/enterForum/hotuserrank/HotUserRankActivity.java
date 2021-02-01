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
    private HotUserRankView iKi;
    private com.baidu.tieba.enterForum.hotuserrank.model.a iKj;
    private String iKk;
    private String iKl;
    private boolean isGod;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int iKm = 0;
    private Runnable iKn = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iKi.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.iKm, HotUserRankActivity.this.iKl);
        }
    };
    private Runnable iKo = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.iKi.xH(8);
        }
    };
    private a.InterfaceC0706a iKp = new a.InterfaceC0706a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0706a
        public void a(c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iKi.getView());
            if (cVar != null && cVar.iLj != null) {
                HotUserRankActivity.this.iKl = cVar.hcK;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.mA().post(HotUserRankActivity.this.iKn);
                } else if (cVar.iLj.iLe == null || y.isEmpty(cVar.iLj.iLe.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iKi.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.iLj.iLe.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.mA().post(HotUserRankActivity.this.iKn);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.iKk)) {
                            HotUserRankActivity.this.iKm = i2;
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
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.iKi.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.iKi.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKi = new HotUserRankView(this);
        setContentView(this.iKi.getView());
        this.iKj = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.iKj.a(this.iKp);
        cwt();
        if (!TextUtils.isEmpty(this.iKk)) {
            this.iKj.Jm(this.iKk);
        } else if (this.mForumId > 0) {
            this.iKi.setTitle(getString(R.string.forum_hot_user_rank));
            this.iKj.gj(this.mForumId);
        }
        this.iKi.setIsGod(this.isGod);
        if (this.isGod) {
            this.iKi.setTitle(getString(R.string.all_god_user_rank));
        }
        showLoadingView(this.iKi.getView());
    }

    private void cwt() {
        Uri uri;
        if (getIntent() != null) {
            this.iKk = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.iKk) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.iKk = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.iKk)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
            this.isGod = getIntent().getBooleanExtra(HotUserRankActivityConfig.KEY_IS_GOD, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.iKj.Jm(this.iKk);
        showLoadingView(this.iKi.getView());
        hideNetRefreshView(this.iKi.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iKi.onChangeSkinType(i);
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
        e.mA().removeCallbacks(this.iKn);
        e.mA().removeCallbacks(this.iKo);
        this.iKj.onDestroy();
        this.iKi.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
