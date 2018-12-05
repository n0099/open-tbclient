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
    private ao dEC;
    private com.baidu.tieba.forumMember.member.a.b dEE;
    private e dEF;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dED = null;
    private al dEG = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dEE.hideLoadingView();
            ForumMemberActivity.this.dEE.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.I(arrayList)) {
                ForumMemberActivity.this.dEE.aaY();
                ForumMemberActivity.this.dED = arrayList;
                ForumMemberActivity.this.dEE.bz(ForumMemberActivity.this.dED);
            } else if (v.I(ForumMemberActivity.this.dED) && arVar != null) {
                ForumMemberActivity.this.dEE.nT(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            ForumMemberActivity.this.dEE.gm(z);
            if (z) {
                if (v.I(ForumMemberActivity.this.dED)) {
                    ForumMemberActivity.this.azr();
                } else {
                    ForumMemberActivity.this.dEE.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q(bundle);
        this.dEE = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dEE.g(this.cZk);
        this.dEF = new e();
        this.dEF.setTag(getUniqueId());
        this.dEF.init();
        this.dEF.a(this.dEG);
        azr();
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
        this.dEC = new ao();
        this.dEC.forumId = this.mForumId;
        this.dEC.forumName = this.mForumName;
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
        this.dEE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dEF.acl();
        if (this.dEE != null) {
            this.dEE.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        e eVar = this.dEF;
        e eVar2 = this.dEF;
        eVar.a(3, 0, this.dEC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            azr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azr() {
        this.dEE.showLoadingView();
        e eVar = this.dEF;
        e eVar2 = this.dEF;
        eVar.a(3, 0, this.dEC);
    }
}
