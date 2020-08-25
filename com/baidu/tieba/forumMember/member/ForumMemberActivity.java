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
/* loaded from: classes17.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ba hOO;
    private com.baidu.tieba.forumMember.member.a.b hOQ;
    private e hOR;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> hOP = null;
    private av hOS = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.hOQ.hideLoadingView();
            ForumMemberActivity.this.hOQ.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.hOQ.bFW();
                ForumMemberActivity.this.hOP = arrayList;
                ForumMemberActivity.this.hOQ.cz(ForumMemberActivity.this.hOP);
            } else if (y.isEmpty(ForumMemberActivity.this.hOP) && bdVar != null) {
                ForumMemberActivity.this.hOQ.Ik(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hOQ.nX(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.hOP)) {
                    ForumMemberActivity.this.ckk();
                } else {
                    ForumMemberActivity.this.hOQ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hOQ = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hOQ.f(this.fCp);
        this.hOR = new e();
        this.hOR.setTag(getUniqueId());
        this.hOR.init();
        this.hOR.a(this.hOS);
        ckk();
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
        this.hOO = new ba();
        this.hOO.forumId = this.mForumId;
        this.hOO.forumName = this.mForumName;
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
        this.hOQ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hOR.bLO();
        if (this.hOQ != null) {
            this.hOQ.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hOR;
        e eVar2 = this.hOR;
        eVar.a(3, 0, this.hOO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            ckk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckk() {
        this.hOQ.showLoadingView();
        e eVar = this.hOR;
        e eVar2 = this.hOR;
        eVar.a(3, 0, this.hOO);
    }
}
