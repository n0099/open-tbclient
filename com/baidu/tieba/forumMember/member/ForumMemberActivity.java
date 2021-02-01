package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
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
    private ax jci;
    private com.baidu.tieba.forumMember.member.a.b jck;
    private d jcl;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.n> jcj = null;
    private ar jcm = new ar() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            ForumMemberActivity.this.jck.hideLoadingView();
            ForumMemberActivity.this.jck.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.jck.WZ();
                ForumMemberActivity.this.jcj = arrayList;
                ForumMemberActivity.this.jck.df(ForumMemberActivity.this.jcj);
            } else if (y.isEmpty(ForumMemberActivity.this.jcj) && baVar != null) {
                ForumMemberActivity.this.jck.JZ(baVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.jck.qo(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.jcj)) {
                    ForumMemberActivity.this.cAK();
                } else {
                    ForumMemberActivity.this.jck.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.jck = new com.baidu.tieba.forumMember.member.a.b(this);
        this.jck.f(this.gxZ);
        this.jcl = new d();
        this.jcl.setTag(getUniqueId());
        this.jcl.init();
        this.jcl.a(this.jcm);
        cAK();
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
        this.jci = new ax();
        this.jci.forumId = this.mForumId;
        this.jci.forumName = this.mForumName;
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
        this.jck.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jcl.bYN();
        if (this.jck != null) {
            this.jck.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        d dVar = this.jcl;
        d dVar2 = this.jcl;
        dVar.a(3, 0, this.jci);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cAK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAK() {
        this.jck.showLoadingView();
        d dVar = this.jcl;
        d dVar2 = this.jcl;
        dVar.a(3, 0, this.jci);
    }
}
