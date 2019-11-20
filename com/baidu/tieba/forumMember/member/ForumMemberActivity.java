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
    private am fqR;
    private com.baidu.tieba.forumMember.member.a.b fqT;
    private e fqU;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> fqS = null;
    private ai fqV = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.fqT.hideLoadingView();
            ForumMemberActivity.this.fqT.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.fqT.aJm();
                ForumMemberActivity.this.fqS = arrayList;
                ForumMemberActivity.this.fqT.ci(ForumMemberActivity.this.fqS);
            } else if (v.isEmpty(ForumMemberActivity.this.fqS) && apVar != null) {
                ForumMemberActivity.this.fqT.vG(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.fqT.jx(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.fqS)) {
                    ForumMemberActivity.this.biu();
                } else {
                    ForumMemberActivity.this.fqT.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.fqT = new com.baidu.tieba.forumMember.member.a.b(this);
        this.fqT.g(this.eQL);
        this.fqU = new e();
        this.fqU.setTag(getUniqueId());
        this.fqU.init();
        this.fqU.a(this.fqV);
        biu();
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
        this.fqR = new am();
        this.fqR.forumId = this.mForumId;
        this.fqR.forumName = this.mForumName;
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
        this.fqT.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqU.aMK();
        if (this.fqT != null) {
            this.fqT.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.fqU;
        e eVar2 = this.fqU;
        eVar.a(3, 0, this.fqR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            biu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biu() {
        this.fqT.showLoadingView();
        e eVar = this.fqU;
        e eVar2 = this.fqU;
        eVar.a(3, 0, this.fqR);
    }
}
