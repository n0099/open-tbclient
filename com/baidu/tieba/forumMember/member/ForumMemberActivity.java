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
    private am eVn;
    private com.baidu.tieba.forumMember.member.a.b eVp;
    private e eVq;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> eVo = null;
    private ai eVr = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.eVp.hideLoadingView();
            ForumMemberActivity.this.eVp.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.T(arrayList)) {
                ForumMemberActivity.this.eVp.aBt();
                ForumMemberActivity.this.eVo = arrayList;
                ForumMemberActivity.this.eVp.bO(ForumMemberActivity.this.eVo);
            } else if (v.T(ForumMemberActivity.this.eVo) && apVar != null) {
                ForumMemberActivity.this.eVp.uR(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            ForumMemberActivity.this.eVp.iO(z);
            if (z) {
                if (v.T(ForumMemberActivity.this.eVo)) {
                    ForumMemberActivity.this.bbc();
                } else {
                    ForumMemberActivity.this.eVp.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N(bundle);
        this.eVp = new com.baidu.tieba.forumMember.member.a.b(this);
        this.eVp.g(this.emM);
        this.eVq = new e();
        this.eVq.setTag(getUniqueId());
        this.eVq.init();
        this.eVq.a(this.eVr);
        bbc();
    }

    private void N(Bundle bundle) {
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
        this.eVn = new am();
        this.eVn.forumId = this.mForumId;
        this.eVn.forumName = this.mForumName;
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
        this.eVp.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eVq.aDF();
        if (this.eVp != null) {
            this.eVp.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        e eVar = this.eVq;
        e eVar2 = this.eVq;
        eVar.a(3, 0, this.eVn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kM()) {
            bbc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbc() {
        this.eVp.showLoadingView();
        e eVar = this.eVq;
        e eVar2 = this.eVq;
        eVar.a(3, 0, this.eVn);
    }
}
