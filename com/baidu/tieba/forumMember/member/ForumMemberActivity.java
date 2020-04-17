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
    private as gUC;
    private com.baidu.tieba.forumMember.member.a.b gUE;
    private e gUF;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gUD = null;
    private ao gUG = new ao() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gUE.hideLoadingView();
            ForumMemberActivity.this.gUE.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.k) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gUE.blt();
                ForumMemberActivity.this.gUD = arrayList;
                ForumMemberActivity.this.gUE.cm(ForumMemberActivity.this.gUD);
            } else if (v.isEmpty(ForumMemberActivity.this.gUD) && avVar != null) {
                ForumMemberActivity.this.gUE.CL(avVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gUE.mi(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gUD)) {
                    ForumMemberActivity.this.bNc();
                } else {
                    ForumMemberActivity.this.gUE.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gUE = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gUE.f(this.gGl);
        this.gUF = new e();
        this.gUF.setTag(getUniqueId());
        this.gUF.init();
        this.gUF.a(this.gUG);
        bNc();
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
        this.gUC = new as();
        this.gUC.forumId = this.mForumId;
        this.gUC.forumName = this.mForumName;
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
        this.gUE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gUF.bqt();
        if (this.gUE != null) {
            this.gUE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gUF;
        e eVar2 = this.gUF;
        eVar.a(3, 0, this.gUC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bNc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNc() {
        this.gUE.showLoadingView();
        e eVar = this.gUF;
        e eVar2 = this.gUF;
        eVar.a(3, 0, this.gUC);
    }
}
