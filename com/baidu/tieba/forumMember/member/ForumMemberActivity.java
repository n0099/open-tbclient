package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements j.b {
    private ao dHq;
    private com.baidu.tieba.forumMember.member.a.b dHs;
    private e dHt;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dHr = null;
    private al dHu = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dHs.hideLoadingView();
            ForumMemberActivity.this.dHs.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.I(arrayList)) {
                ForumMemberActivity.this.dHs.aba();
                ForumMemberActivity.this.dHr = arrayList;
                ForumMemberActivity.this.dHs.bA(ForumMemberActivity.this.dHr);
            } else if (v.I(ForumMemberActivity.this.dHr) && arVar != null) {
                ForumMemberActivity.this.dHs.nW(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            ForumMemberActivity.this.dHs.go(z);
            if (z) {
                if (v.I(ForumMemberActivity.this.dHr)) {
                    ForumMemberActivity.this.aAg();
                } else {
                    ForumMemberActivity.this.dHs.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q(bundle);
        this.dHs = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dHs.g(this.dcc);
        this.dHt = new e();
        this.dHt.setTag(getUniqueId());
        this.dHt.init();
        this.dHt.a(this.dHu);
        aAg();
    }

    private void q(Bundle bundle) {
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
        this.dHq = new ao();
        this.dHq.forumId = this.mForumId;
        this.dHq.forumName = this.mForumName;
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
        this.dHs.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dHt.acn();
        if (this.dHs != null) {
            this.dHs.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        e eVar = this.dHt;
        e eVar2 = this.dHt;
        eVar.a(3, 0, this.dHq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aAg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAg() {
        this.dHs.showLoadingView();
        e eVar = this.dHt;
        e eVar2 = this.dHt;
        eVar.a(3, 0, this.dHq);
    }
}
