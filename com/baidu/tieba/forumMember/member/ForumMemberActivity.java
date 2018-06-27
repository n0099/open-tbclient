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
    private ao dgc;
    private com.baidu.tieba.forumMember.member.a.b dge;
    private e dgf;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dgd = null;
    private al dgg = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dge.hideLoadingView();
            ForumMemberActivity.this.dge.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!w.A(arrayList)) {
                ForumMemberActivity.this.dge.Uc();
                ForumMemberActivity.this.dgd = arrayList;
                ForumMemberActivity.this.dge.bj(ForumMemberActivity.this.dgd);
            } else if (w.A(ForumMemberActivity.this.dgd) && arVar != null) {
                ForumMemberActivity.this.dge.mo(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            ForumMemberActivity.this.dge.fr(z);
            if (z) {
                if (w.A(ForumMemberActivity.this.dgd)) {
                    ForumMemberActivity.this.asw();
                } else {
                    ForumMemberActivity.this.dge.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.dge = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dge.g(this.cAL);
        this.dgf = new e();
        this.dgf.setTag(getUniqueId());
        this.dgf.init();
        this.dgf.a(this.dgg);
        asw();
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
        this.dgc = new ao();
        this.dgc.forumId = this.mForumId;
        this.dgc.forumName = this.mForumName;
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
        this.dge.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dgf.Vo();
        if (this.dge != null) {
            this.dge.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aU(boolean z) {
        e eVar = this.dgf;
        e eVar2 = this.dgf;
        eVar.a(3, 0, this.dgc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jr()) {
            asw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asw() {
        this.dge.showLoadingView();
        e eVar = this.dgf;
        e eVar2 = this.dgf;
        eVar.a(3, 0, this.dgc);
    }
}
