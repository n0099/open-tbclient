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
    private ao dIa;
    private com.baidu.tieba.forumMember.member.a.b dIc;
    private e dId;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dIb = null;
    private al dIe = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dIc.hideLoadingView();
            ForumMemberActivity.this.dIc.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.I(arrayList)) {
                ForumMemberActivity.this.dIc.abx();
                ForumMemberActivity.this.dIb = arrayList;
                ForumMemberActivity.this.dIc.bB(ForumMemberActivity.this.dIb);
            } else if (v.I(ForumMemberActivity.this.dIb) && arVar != null) {
                ForumMemberActivity.this.dIc.oo(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            ForumMemberActivity.this.dIc.gr(z);
            if (z) {
                if (v.I(ForumMemberActivity.this.dIb)) {
                    ForumMemberActivity.this.aAD();
                } else {
                    ForumMemberActivity.this.dIc.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q(bundle);
        this.dIc = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dIc.g(this.dcQ);
        this.dId = new e();
        this.dId.setTag(getUniqueId());
        this.dId.init();
        this.dId.a(this.dIe);
        aAD();
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
        this.dIa = new ao();
        this.dIa.forumId = this.mForumId;
        this.dIa.forumName = this.mForumName;
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
        this.dIc.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dId.acK();
        if (this.dIc != null) {
            this.dIc.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        e eVar = this.dId;
        e eVar2 = this.dId;
        eVar.a(3, 0, this.dIa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAD() {
        this.dIc.showLoadingView();
        e eVar = this.dId;
        e eVar2 = this.dId;
        eVar.a(3, 0, this.dIa);
    }
}
