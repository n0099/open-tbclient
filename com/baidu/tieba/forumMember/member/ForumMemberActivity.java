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
    private an gkB;
    private com.baidu.tieba.forumMember.member.a.b gkD;
    private e gkE;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> gkC = null;
    private aj gkF = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gkD.hideLoadingView();
            ForumMemberActivity.this.gkD.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.j) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gkD.bcx();
                ForumMemberActivity.this.gkC = arrayList;
                ForumMemberActivity.this.gkD.ca(ForumMemberActivity.this.gkC);
            } else if (v.isEmpty(ForumMemberActivity.this.gkC) && aqVar != null) {
                ForumMemberActivity.this.gkD.AY(aqVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gkD.kY(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.gkC)) {
                    ForumMemberActivity.this.bCv();
                } else {
                    ForumMemberActivity.this.gkD.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gkD = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gkD.f(this.fYL);
        this.gkE = new e();
        this.gkE.setTag(getUniqueId());
        this.gkE.init();
        this.gkE.a(this.gkF);
        bCv();
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
        this.gkB = new an();
        this.gkB.forumId = this.mForumId;
        this.gkB.forumName = this.mForumName;
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
        this.gkD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gkE.bgW();
        if (this.gkD != null) {
            this.gkD.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.gkE;
        e eVar2 = this.gkE;
        eVar.a(3, 0, this.gkB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bCv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCv() {
        this.gkD.showLoadingView();
        e eVar = this.gkE;
        e eVar2 = this.gkE;
        eVar.a(3, 0, this.gkB);
    }
}
