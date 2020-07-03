package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ay hvN;
    private com.baidu.tieba.forumMember.member.a.b hvP;
    private e hvQ;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> hvO = null;
    private at hvR = new at() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.at
        public void a(int i, int i2, bb bbVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.hvP.hideLoadingView();
            ForumMemberActivity.this.hvP.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.m) {
                        it.remove();
                    }
                }
            }
            if (!w.isEmpty(arrayList)) {
                ForumMemberActivity.this.hvP.btN();
                ForumMemberActivity.this.hvO = arrayList;
                ForumMemberActivity.this.hvP.cs(ForumMemberActivity.this.hvO);
            } else if (w.isEmpty(ForumMemberActivity.this.hvO) && bbVar != null) {
                ForumMemberActivity.this.hvP.EY(bbVar.errMsg);
            }
        }
    };
    private NoNetworkView.a flL = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hvP.mO(z);
            if (z) {
                if (w.isEmpty(ForumMemberActivity.this.hvO)) {
                    ForumMemberActivity.this.bWu();
                } else {
                    ForumMemberActivity.this.hvP.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hvP = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hvP.f(this.flL);
        this.hvQ = new e();
        this.hvQ.setTag(getUniqueId());
        this.hvQ.init();
        this.hvQ.a(this.hvR);
        bWu();
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
        this.hvN = new ay();
        this.hvN.forumId = this.mForumId;
        this.hvN.forumName = this.mForumName;
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
        this.hvP.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hvQ.bzf();
        if (this.hvP != null) {
            this.hvP.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hvQ;
        e eVar2 = this.hvQ;
        eVar.a(3, 0, this.hvN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bWu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWu() {
        this.hvP.showLoadingView();
        e eVar = this.hvQ;
        e eVar2 = this.hvQ;
        eVar.a(3, 0, this.hvN);
    }
}
