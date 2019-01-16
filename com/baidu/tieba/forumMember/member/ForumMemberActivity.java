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
    private ao dHZ;
    private com.baidu.tieba.forumMember.member.a.b dIb;
    private e dIc;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dIa = null;
    private al dId = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dIb.hideLoadingView();
            ForumMemberActivity.this.dIb.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.I(arrayList)) {
                ForumMemberActivity.this.dIb.abx();
                ForumMemberActivity.this.dIa = arrayList;
                ForumMemberActivity.this.dIb.bB(ForumMemberActivity.this.dIa);
            } else if (v.I(ForumMemberActivity.this.dIa) && arVar != null) {
                ForumMemberActivity.this.dIb.oo(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            ForumMemberActivity.this.dIb.gr(z);
            if (z) {
                if (v.I(ForumMemberActivity.this.dIa)) {
                    ForumMemberActivity.this.aAD();
                } else {
                    ForumMemberActivity.this.dIb.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q(bundle);
        this.dIb = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dIb.g(this.dcP);
        this.dIc = new e();
        this.dIc.setTag(getUniqueId());
        this.dIc.init();
        this.dIc.a(this.dId);
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
        this.dHZ = new ao();
        this.dHZ.forumId = this.mForumId;
        this.dHZ.forumName = this.mForumName;
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
        this.dIb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dIc.acK();
        if (this.dIb != null) {
            this.dIb.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        e eVar = this.dIc;
        e eVar2 = this.dIc;
        eVar.a(3, 0, this.dHZ);
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
        this.dIb.showLoadingView();
        e eVar = this.dIc;
        e eVar2 = this.dIc;
        eVar.a(3, 0, this.dHZ);
    }
}
