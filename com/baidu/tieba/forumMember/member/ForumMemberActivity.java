package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.b {
    private ao diQ;
    private com.baidu.tieba.forumMember.member.a.b diS;
    private e diT;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> diR = null;
    private al diU = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.diS.hideLoadingView();
            ForumMemberActivity.this.diS.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!w.z(arrayList)) {
                ForumMemberActivity.this.diS.Un();
                ForumMemberActivity.this.diR = arrayList;
                ForumMemberActivity.this.diS.bi(ForumMemberActivity.this.diR);
            } else if (w.z(ForumMemberActivity.this.diR) && arVar != null) {
                ForumMemberActivity.this.diS.mp(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            ForumMemberActivity.this.diS.fs(z);
            if (z) {
                if (w.z(ForumMemberActivity.this.diR)) {
                    ForumMemberActivity.this.asZ();
                } else {
                    ForumMemberActivity.this.diS.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.diS = new com.baidu.tieba.forumMember.member.a.b(this);
        this.diS.g(this.cDn);
        this.diT = new e();
        this.diT.setTag(getUniqueId());
        this.diT.init();
        this.diT.a(this.diU);
        asZ();
    }

    private void j(Bundle bundle) {
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
        this.diQ = new ao();
        this.diQ.forumId = this.mForumId;
        this.diQ.forumName = this.mForumName;
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
        this.diS.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.diT.VA();
        if (this.diS != null) {
            this.diS.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aT(boolean z) {
        e eVar = this.diT;
        e eVar2 = this.diT;
        eVar.a(3, 0, this.diQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.js()) {
            asZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        this.diS.showLoadingView();
        e eVar = this.diT;
        e eVar2 = this.diT;
        eVar.a(3, 0, this.diQ);
    }
}
