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
/* loaded from: classes8.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.c {
    private com.baidu.tieba.forumMember.member.a.b giA;
    private e giB;
    private an giy;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> giz = null;
    private aj giC = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.giA.hideLoadingView();
            ForumMemberActivity.this.giA.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.j) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.giA.baf();
                ForumMemberActivity.this.giz = arrayList;
                ForumMemberActivity.this.giA.ce(ForumMemberActivity.this.giz);
            } else if (v.isEmpty(ForumMemberActivity.this.giz) && aqVar != null) {
                ForumMemberActivity.this.giA.AI(aqVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.giA.kU(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.giz)) {
                    ForumMemberActivity.this.bAR();
                } else {
                    ForumMemberActivity.this.giA.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.giA = new com.baidu.tieba.forumMember.member.a.b(this);
        this.giA.f(this.fWI);
        this.giB = new e();
        this.giB.setTag(getUniqueId());
        this.giB.init();
        this.giB.a(this.giC);
        bAR();
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
        this.giy = new an();
        this.giy.forumId = this.mForumId;
        this.giy.forumName = this.mForumName;
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
        this.giA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.giB.beK();
        if (this.giA != null) {
            this.giA.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.giB;
        e eVar2 = this.giB;
        eVar.a(3, 0, this.giy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bAR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAR() {
        this.giA.showLoadingView();
        e eVar = this.giB;
        e eVar2 = this.giB;
        eVar.a(3, 0, this.giy);
    }
}
