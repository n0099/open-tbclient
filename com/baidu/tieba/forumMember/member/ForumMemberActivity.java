package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.c {
    private an gkO;
    private com.baidu.tieba.forumMember.member.a.b gkQ;
    private e gkR;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gkP = null;
    private aj gkS = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gkQ.hideLoadingView();
            ForumMemberActivity.this.gkQ.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.j) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gkQ.bcy();
                ForumMemberActivity.this.gkP = arrayList;
                ForumMemberActivity.this.gkQ.ca(ForumMemberActivity.this.gkP);
            } else if (v.isEmpty(ForumMemberActivity.this.gkP) && aqVar != null) {
                ForumMemberActivity.this.gkQ.AZ(aqVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gkQ.kY(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gkP)) {
                    ForumMemberActivity.this.bCw();
                } else {
                    ForumMemberActivity.this.gkQ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gkQ = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gkQ.f(this.fYY);
        this.gkR = new e();
        this.gkR.setTag(getUniqueId());
        this.gkR.init();
        this.gkR.a(this.gkS);
        bCw();
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
        this.gkO = new an();
        this.gkO.forumId = this.mForumId;
        this.gkO.forumName = this.mForumName;
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
        this.gkQ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gkR.bgX();
        if (this.gkQ != null) {
            this.gkQ.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gkR;
        e eVar2 = this.gkR;
        eVar.a(3, 0, this.gkO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bCw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCw() {
        this.gkQ.showLoadingView();
        e eVar = this.gkR;
        e eVar2 = this.gkR;
        eVar.a(3, 0, this.gkO);
    }
}
