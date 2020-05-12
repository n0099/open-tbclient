package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.c {
    private as gUI;
    private com.baidu.tieba.forumMember.member.a.b gUK;
    private e gUL;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gUJ = null;
    private ao gUM = new ao() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gUK.hideLoadingView();
            ForumMemberActivity.this.gUK.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.k) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gUK.blr();
                ForumMemberActivity.this.gUJ = arrayList;
                ForumMemberActivity.this.gUK.cm(ForumMemberActivity.this.gUJ);
            } else if (v.isEmpty(ForumMemberActivity.this.gUJ) && avVar != null) {
                ForumMemberActivity.this.gUK.CO(avVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gUK.mi(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gUJ)) {
                    ForumMemberActivity.this.bNb();
                } else {
                    ForumMemberActivity.this.gUK.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gUK = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gUK.f(this.gGr);
        this.gUL = new e();
        this.gUL.setTag(getUniqueId());
        this.gUL.init();
        this.gUL.a(this.gUM);
        bNb();
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
        this.gUI = new as();
        this.gUI.forumId = this.mForumId;
        this.gUI.forumName = this.mForumName;
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
        this.gUK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gUL.bqr();
        if (this.gUK != null) {
            this.gUK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gUL;
        e eVar2 = this.gUL;
        eVar.a(3, 0, this.gUI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bNb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNb() {
        this.gUK.showLoadingView();
        e eVar = this.gUL;
        e eVar2 = this.gUL;
        eVar.a(3, 0, this.gUI);
    }
}
