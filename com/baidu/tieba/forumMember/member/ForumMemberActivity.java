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
    private am fqj;
    private com.baidu.tieba.forumMember.member.a.b fql;
    private e fqm;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> fqk = null;
    private ai fqn = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.fql.hideLoadingView();
            ForumMemberActivity.this.fql.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.aa(arrayList)) {
                ForumMemberActivity.this.fql.aJh();
                ForumMemberActivity.this.fqk = arrayList;
                ForumMemberActivity.this.fql.bV(ForumMemberActivity.this.fqk);
            } else if (v.aa(ForumMemberActivity.this.fqk) && apVar != null) {
                ForumMemberActivity.this.fql.wO(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            ForumMemberActivity.this.fql.jG(z);
            if (z) {
                if (v.aa(ForumMemberActivity.this.fqk)) {
                    ForumMemberActivity.this.bky();
                } else {
                    ForumMemberActivity.this.fql.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O(bundle);
        this.fql = new com.baidu.tieba.forumMember.member.a.b(this);
        this.fql.g(this.eHh);
        this.fqm = new e();
        this.fqm.setTag(getUniqueId());
        this.fqm.init();
        this.fqm.a(this.fqn);
        bky();
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
        this.fqj = new am();
        this.fqj.forumId = this.mForumId;
        this.fqj.forumName = this.mForumName;
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
        this.fql.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fqm.aLx();
        if (this.fql != null) {
            this.fql.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        e eVar = this.fqm;
        e eVar2 = this.fqm;
        eVar.a(3, 0, this.fqj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            bky();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bky() {
        this.fql.showLoadingView();
        e eVar = this.fqm;
        e eVar2 = this.fqm;
        eVar.a(3, 0, this.fqj);
    }
}
