package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes17.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private com.baidu.tieba.forumMember.member.a.b hBB;
    private e hBC;
    private ay hBz;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> hBA = null;
    private at hBD = new at() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.hBB.hideLoadingView();
            ForumMemberActivity.this.hBB.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.m) {
                        it.remove();
                    }
                }
            }
            if (!x.isEmpty(arrayList)) {
                ForumMemberActivity.this.hBB.bwX();
                ForumMemberActivity.this.hBA = arrayList;
                ForumMemberActivity.this.hBB.cx(ForumMemberActivity.this.hBA);
            } else if (x.isEmpty(ForumMemberActivity.this.hBA) && bbVar != null) {
                ForumMemberActivity.this.hBB.FJ(bbVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hBB.nt(z);
            if (z) {
                if (x.isEmpty(ForumMemberActivity.this.hBA)) {
                    ForumMemberActivity.this.bZO();
                } else {
                    ForumMemberActivity.this.hBB.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hBB = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hBB.f(this.fqT);
        this.hBC = new e();
        this.hBC.setTag(getUniqueId());
        this.hBC.init();
        this.hBC.a(this.hBD);
        bZO();
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
        this.hBz = new ay();
        this.hBz.forumId = this.mForumId;
        this.hBz.forumName = this.mForumName;
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
        this.hBB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hBC.bCu();
        if (this.hBB != null) {
            this.hBB.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hBC;
        e eVar2 = this.hBC;
        eVar.a(3, 0, this.hBz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bZO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZO() {
        this.hBB.showLoadingView();
        e eVar = this.hBC;
        e eVar2 = this.hBC;
        eVar.a(3, 0, this.hBz);
    }
}
