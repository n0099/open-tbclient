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
    private am fqI;
    private com.baidu.tieba.forumMember.member.a.b fqK;
    private e fqL;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> fqJ = null;
    private ai fqM = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.fqK.hideLoadingView();
            ForumMemberActivity.this.fqK.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.aa(arrayList)) {
                ForumMemberActivity.this.fqK.aJj();
                ForumMemberActivity.this.fqJ = arrayList;
                ForumMemberActivity.this.fqK.bV(ForumMemberActivity.this.fqJ);
            } else if (v.aa(ForumMemberActivity.this.fqJ) && apVar != null) {
                ForumMemberActivity.this.fqK.wP(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            ForumMemberActivity.this.fqK.jG(z);
            if (z) {
                if (v.aa(ForumMemberActivity.this.fqJ)) {
                    ForumMemberActivity.this.bkF();
                } else {
                    ForumMemberActivity.this.fqK.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O(bundle);
        this.fqK = new com.baidu.tieba.forumMember.member.a.b(this);
        this.fqK.g(this.eHo);
        this.fqL = new e();
        this.fqL.setTag(getUniqueId());
        this.fqL.init();
        this.fqL.a(this.fqM);
        bkF();
    }

    private void O(Bundle bundle) {
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
        this.fqI = new am();
        this.fqI.forumId = this.mForumId;
        this.fqI.forumName = this.mForumName;
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
        this.fqK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqL.aLz();
        if (this.fqK != null) {
            this.fqK.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        e eVar = this.fqL;
        e eVar2 = this.fqL;
        eVar.a(3, 0, this.fqI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            bkF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkF() {
        this.fqK.showLoadingView();
        e eVar = this.fqL;
        e eVar2 = this.fqL;
        eVar.a(3, 0, this.fqI);
    }
}
