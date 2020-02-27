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
    private com.baidu.tieba.forumMember.member.a.b gkB;
    private e gkC;
    private an gkz;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gkA = null;
    private aj gkD = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gkB.hideLoadingView();
            ForumMemberActivity.this.gkB.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.j) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gkB.bcv();
                ForumMemberActivity.this.gkA = arrayList;
                ForumMemberActivity.this.gkB.ca(ForumMemberActivity.this.gkA);
            } else if (v.isEmpty(ForumMemberActivity.this.gkA) && aqVar != null) {
                ForumMemberActivity.this.gkB.AY(aqVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gkB.kY(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gkA)) {
                    ForumMemberActivity.this.bCt();
                } else {
                    ForumMemberActivity.this.gkB.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gkB = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gkB.f(this.fYJ);
        this.gkC = new e();
        this.gkC.setTag(getUniqueId());
        this.gkC.init();
        this.gkC.a(this.gkD);
        bCt();
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
        this.gkz = new an();
        this.gkz.forumId = this.mForumId;
        this.gkz.forumName = this.mForumName;
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
        this.gkB.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gkC.bgU();
        if (this.gkB != null) {
            this.gkB.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gkC;
        e eVar2 = this.gkC;
        eVar.a(3, 0, this.gkz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bCt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCt() {
        this.gkB.showLoadingView();
        e eVar = this.gkC;
        e eVar2 = this.gkC;
        eVar.a(3, 0, this.gkz);
    }
}
