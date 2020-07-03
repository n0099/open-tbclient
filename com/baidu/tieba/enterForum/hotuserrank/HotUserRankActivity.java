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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.a.d;
import com.baidu.tieba.enterForum.hotuserrank.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class HotUserRankActivity extends BaseFragmentActivity {
    private HotUserRankView hee;
    private com.baidu.tieba.enterForum.hotuserrank.model.a hef;
    private String heg;
    private String heh;
    private long mForumId;
    private List<d> mTabDataList = new ArrayList();
    private int hei = 0;
    private Runnable hej = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hee.a(HotUserRankActivity.this.mTabDataList, HotUserRankActivity.this.mForumId, HotUserRankActivity.this.hei, HotUserRankActivity.this.heh);
        }
    };
    private Runnable hek = new Runnable() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HotUserRankActivity.this.hee.tv(8);
        }
    };
    private a.InterfaceC0610a hel = new a.InterfaceC0610a() { // from class: com.baidu.tieba.enterForum.hotuserrank.HotUserRankActivity.3
        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0610a
        public void a(com.baidu.tieba.enterForum.hotuserrank.a.c cVar) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hee.getView());
            if (cVar != null && cVar.hfi != null) {
                HotUserRankActivity.this.heh = cVar.fNm;
                if (HotUserRankActivity.this.mForumId > 0) {
                    e.lt().post(HotUserRankActivity.this.hej);
                } else if (cVar.hfi.hfc == null || w.isEmpty(cVar.hfi.hfc.tieba_fields)) {
                    HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hee.getView(), HotUserRankActivity.this.getString(R.string.neterror), true);
                } else {
                    List<String> list = cVar.hfi.hfc.tieba_fields;
                    HotUserRankActivity.this.mTabDataList.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            e.lt().post(HotUserRankActivity.this.hej);
                            return;
                        }
                        String str = list.get(i2);
                        if (str != null && str.equals(HotUserRankActivity.this.heg)) {
                            HotUserRankActivity.this.hei = i2;
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

        @Override // com.baidu.tieba.enterForum.hotuserrank.model.a.InterfaceC0610a
        public void onError(int i, String str) {
            HotUserRankActivity.this.hideLoadingView(HotUserRankActivity.this.hee.getView());
            HotUserRankActivity.this.showNetRefreshView(HotUserRankActivity.this.hee.getView(), str, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hee = new HotUserRankView(this);
        setContentView(this.hee.getView());
        this.hef = new com.baidu.tieba.enterForum.hotuserrank.model.a(getUniqueId());
        this.hef.a(this.hel);
        bSl();
        if (!TextUtils.isEmpty(this.heg)) {
            this.hef.En(this.heg);
        } else if (this.mForumId > 0) {
            this.hee.setTitle(getString(R.string.forum_hot_user_rank));
            this.hef.eb(this.mForumId);
        }
        showLoadingView(this.hee.getView());
    }

    private void bSl() {
        Uri uri;
        if (getIntent() != null) {
            this.heg = getIntent().getStringExtra(HotUserRankActivityConfig.KEY_CATEGORY);
            this.mForumId = getIntent().getLongExtra(HotUserRankActivityConfig.KEY_FORUM_ID, -1L);
            if (TextUtils.isEmpty(this.heg) && this.mForumId == -1 && (uri = (Uri) getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.heg = uri.getQueryParameter(Info.kBaiduModuleKey);
                if (TextUtils.isEmpty(this.heg)) {
                    this.mForumId = com.baidu.adp.lib.f.b.toLong(uri.getQueryParameter("fid"), -1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        this.hef.En(this.heg);
        showLoadingView(this.hee.getView());
        hideNetRefreshView(this.hee.getView());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hee.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mForumId > 0) {
            ao aoVar = new ao("c13667");
            aoVar.s("fid", this.mForumId);
            TiebaStatic.log(aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.lt().removeCallbacks(this.hej);
        e.lt().removeCallbacks(this.hek);
        this.hef.onDestroy();
        this.hee.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a074";
    }
}
