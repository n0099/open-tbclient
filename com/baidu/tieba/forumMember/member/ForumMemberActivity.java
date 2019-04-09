package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements h.c {
    private am eVa;
    private com.baidu.tieba.forumMember.member.a.b eVc;
    private e eVd;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> eVb = null;
    private ai eVe = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.eVc.hideLoadingView();
            ForumMemberActivity.this.eVc.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.T(arrayList)) {
                ForumMemberActivity.this.eVc.aBq();
                ForumMemberActivity.this.eVb = arrayList;
                ForumMemberActivity.this.eVc.bM(ForumMemberActivity.this.eVb);
            } else if (v.T(ForumMemberActivity.this.eVb) && apVar != null) {
                ForumMemberActivity.this.eVc.uQ(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            ForumMemberActivity.this.eVc.iO(z);
            if (z) {
                if (v.T(ForumMemberActivity.this.eVb)) {
                    ForumMemberActivity.this.bba();
                } else {
                    ForumMemberActivity.this.eVc.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N(bundle);
        this.eVc = new com.baidu.tieba.forumMember.member.a.b(this);
        this.eVc.g(this.emz);
        this.eVd = new e();
        this.eVd.setTag(getUniqueId());
        this.eVd.init();
        this.eVd.a(this.eVe);
        bba();
    }

    private void N(Bundle bundle) {
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
        this.eVa = new am();
        this.eVa.forumId = this.mForumId;
        this.eVa.forumName = this.mForumName;
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
        this.eVc.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eVd.aDC();
        if (this.eVc != null) {
            this.eVc.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        e eVar = this.eVd;
        e eVar2 = this.eVd;
        eVar.a(3, 0, this.eVa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kM()) {
            bba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        this.eVc.showLoadingView();
        e eVar = this.eVd;
        e eVar2 = this.eVd;
        eVar.a(3, 0, this.eVa);
    }
}
