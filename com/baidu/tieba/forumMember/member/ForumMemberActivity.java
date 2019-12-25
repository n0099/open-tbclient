package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.c {
    private an gfo;
    private com.baidu.tieba.forumMember.member.a.b gfq;
    private e gfr;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gfp = null;
    private aj gfs = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gfq.hideLoadingView();
            ForumMemberActivity.this.gfq.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.j) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gfq.aZK();
                ForumMemberActivity.this.gfp = arrayList;
                ForumMemberActivity.this.gfq.ce(ForumMemberActivity.this.gfp);
            } else if (v.isEmpty(ForumMemberActivity.this.gfp) && aqVar != null) {
                ForumMemberActivity.this.gfq.Ay(aqVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gfq.kJ(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gfp)) {
                    ForumMemberActivity.this.bzP();
                } else {
                    ForumMemberActivity.this.gfq.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gfq = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gfq.f(this.fTz);
        this.gfr = new e();
        this.gfr.setTag(getUniqueId());
        this.gfr.init();
        this.gfr.a(this.gfs);
        bzP();
    }

    private void initBundle(Bundle bundle) {
        if (bundle == null) {
            if (getIntent() != null) {
                this.mForumId = getIntent().getStringExtra("forum_id");
                this.mForumName = getIntent().getStringExtra("forum_name");
            } else {
                return;
            }
        } else {
            this.mForumId = bundle.getString("forum_id", "");
            this.mForumName = bundle.getString("forum_name", "");
        }
        this.gfo = new an();
        this.gfo.forumId = this.mForumId;
        this.gfo.forumName = this.mForumName;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("forum_name", this.mForumName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gfq.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gfr.bep();
        if (this.gfq != null) {
            this.gfq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gfr;
        e eVar2 = this.gfr;
        eVar.a(3, 0, this.gfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bzP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzP() {
        this.gfq.showLoadingView();
        e eVar = this.gfr;
        e eVar2 = this.gfr;
        eVar.a(3, 0, this.gfo);
    }
}
