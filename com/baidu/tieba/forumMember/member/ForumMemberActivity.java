package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ax iWB;
    private com.baidu.tieba.forumMember.member.a.b iWD;
    private d iWE;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.n> iWC = null;
    private ar iWF = new ar() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ar
        public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
            ForumMemberActivity.this.iWD.hideLoadingView();
            ForumMemberActivity.this.iWD.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!x.isEmpty(arrayList)) {
                ForumMemberActivity.this.iWD.Vq();
                ForumMemberActivity.this.iWC = arrayList;
                ForumMemberActivity.this.iWD.dk(ForumMemberActivity.this.iWC);
            } else if (x.isEmpty(ForumMemberActivity.this.iWC) && baVar != null) {
                ForumMemberActivity.this.iWD.Jo(baVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.iWD.qe(z);
            if (z) {
                if (x.isEmpty(ForumMemberActivity.this.iWC)) {
                    ForumMemberActivity.this.czz();
                } else {
                    ForumMemberActivity.this.iWD.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.iWD = new com.baidu.tieba.forumMember.member.a.b(this);
        this.iWD.f(this.gvp);
        this.iWE = new d();
        this.iWE.setTag(getUniqueId());
        this.iWE.init();
        this.iWE.a(this.iWF);
        czz();
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
        this.iWB = new ax();
        this.iWB.forumId = this.mForumId;
        this.iWB.forumName = this.mForumName;
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
        this.iWD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iWE.bXP();
        if (this.iWD != null) {
            this.iWD.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        d dVar = this.iWE;
        d dVar2 = this.iWE;
        dVar.a(3, 0, this.iWB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            czz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czz() {
        this.iWD.showLoadingView();
        d dVar = this.iWE;
        d dVar2 = this.iWE;
        dVar.a(3, 0, this.iWB);
    }
}
