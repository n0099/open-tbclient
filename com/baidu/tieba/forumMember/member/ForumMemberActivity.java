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
    private am eUZ;
    private com.baidu.tieba.forumMember.member.a.b eVb;
    private e eVc;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> eVa = null;
    private ai eVd = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.eVb.hideLoadingView();
            ForumMemberActivity.this.eVb.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.T(arrayList)) {
                ForumMemberActivity.this.eVb.aBq();
                ForumMemberActivity.this.eVa = arrayList;
                ForumMemberActivity.this.eVb.bM(ForumMemberActivity.this.eVa);
            } else if (v.T(ForumMemberActivity.this.eVa) && apVar != null) {
                ForumMemberActivity.this.eVb.uQ(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a emy = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            ForumMemberActivity.this.eVb.iO(z);
            if (z) {
                if (v.T(ForumMemberActivity.this.eVa)) {
                    ForumMemberActivity.this.bba();
                } else {
                    ForumMemberActivity.this.eVb.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N(bundle);
        this.eVb = new com.baidu.tieba.forumMember.member.a.b(this);
        this.eVb.g(this.emy);
        this.eVc = new e();
        this.eVc.setTag(getUniqueId());
        this.eVc.init();
        this.eVc.a(this.eVd);
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
        this.eUZ = new am();
        this.eUZ.forumId = this.mForumId;
        this.eUZ.forumName = this.mForumName;
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
        this.eVb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eVc.aDC();
        if (this.eVb != null) {
            this.eVb.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        e eVar = this.eVc;
        e eVar2 = this.eVc;
        eVar.a(3, 0, this.eUZ);
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
        this.eVb.showLoadingView();
        e eVar = this.eVc;
        e eVar2 = this.eVc;
        eVar.a(3, 0, this.eUZ);
    }
}
