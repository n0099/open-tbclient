package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ax jbi;
    private com.baidu.tieba.forumMember.member.a.b jbk;
    private d jbl;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.n> jbj = null;
    private ar jbm = new ar() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            ForumMemberActivity.this.jbk.hideLoadingView();
            ForumMemberActivity.this.jbk.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!x.isEmpty(arrayList)) {
                ForumMemberActivity.this.jbk.Zj();
                ForumMemberActivity.this.jbj = arrayList;
                ForumMemberActivity.this.jbk.dk(ForumMemberActivity.this.jbj);
            } else if (x.isEmpty(ForumMemberActivity.this.jbj) && baVar != null) {
                ForumMemberActivity.this.jbk.Kz(baVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.jbk.qi(z);
            if (z) {
                if (x.isEmpty(ForumMemberActivity.this.jbj)) {
                    ForumMemberActivity.this.cDr();
                } else {
                    ForumMemberActivity.this.jbk.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.jbk = new com.baidu.tieba.forumMember.member.a.b(this);
        this.jbk.f(this.gzW);
        this.jbl = new d();
        this.jbl.setTag(getUniqueId());
        this.jbl.init();
        this.jbl.a(this.jbm);
        cDr();
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
        this.jbi = new ax();
        this.jbi.forumId = this.mForumId;
        this.jbi.forumName = this.mForumName;
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
        this.jbk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jbl.cbH();
        if (this.jbk != null) {
            this.jbk.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        d dVar = this.jbl;
        d dVar2 = this.jbl;
        dVar.a(3, 0, this.jbi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDr() {
        this.jbk.showLoadingView();
        d dVar = this.jbl;
        d dVar2 = this.jbl;
        dVar.a(3, 0, this.jbi);
    }
}
