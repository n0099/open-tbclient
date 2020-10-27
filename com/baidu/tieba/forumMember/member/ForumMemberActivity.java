package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes23.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ba ixr;
    private com.baidu.tieba.forumMember.member.a.b ixt;
    private e ixu;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> ixs = null;
    private av ixv = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.ixt.hideLoadingView();
            ForumMemberActivity.this.ixt.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.ixt.TK();
                ForumMemberActivity.this.ixs = arrayList;
                ForumMemberActivity.this.ixt.cR(ForumMemberActivity.this.ixs);
            } else if (y.isEmpty(ForumMemberActivity.this.ixs) && bdVar != null) {
                ForumMemberActivity.this.ixt.JU(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.ixt.pc(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.ixs)) {
                    ForumMemberActivity.this.cud();
                } else {
                    ForumMemberActivity.this.ixt.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.ixt = new com.baidu.tieba.forumMember.member.a.b(this);
        this.ixt.f(this.gbR);
        this.ixu = new e();
        this.ixu.setTag(getUniqueId());
        this.ixu.init();
        this.ixu.a(this.ixv);
        cud();
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
        this.ixr = new ba();
        this.ixr.forumId = this.mForumId;
        this.ixr.forumName = this.mForumName;
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
        this.ixt.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ixu.bTn();
        if (this.ixt != null) {
            this.ixt.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.ixu;
        e eVar2 = this.ixu;
        eVar.a(3, 0, this.ixr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cud();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        this.ixt.showLoadingView();
        e eVar = this.ixu;
        e eVar2 = this.ixu;
        eVar.a(3, 0, this.ixr);
    }
}
