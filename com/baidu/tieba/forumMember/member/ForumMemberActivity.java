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
    private ba iDo;
    private com.baidu.tieba.forumMember.member.a.b iDq;
    private e iDr;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> iDp = null;
    private av iDs = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.iDq.hideLoadingView();
            ForumMemberActivity.this.iDq.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.iDq.Wk();
                ForumMemberActivity.this.iDp = arrayList;
                ForumMemberActivity.this.iDq.cZ(ForumMemberActivity.this.iDp);
            } else if (y.isEmpty(ForumMemberActivity.this.iDp) && bdVar != null) {
                ForumMemberActivity.this.iDq.Kl(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.iDq.pl(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.iDp)) {
                    ForumMemberActivity.this.cwE();
                } else {
                    ForumMemberActivity.this.iDq.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.iDq = new com.baidu.tieba.forumMember.member.a.b(this);
        this.iDq.f(this.ghG);
        this.iDr = new e();
        this.iDr.setTag(getUniqueId());
        this.iDr.init();
        this.iDr.a(this.iDs);
        cwE();
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
        this.iDo = new ba();
        this.iDo.forumId = this.mForumId;
        this.iDo.forumName = this.mForumName;
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
        this.iDq.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iDr.bVV();
        if (this.iDq != null) {
            this.iDq.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.iDr;
        e eVar2 = this.iDr;
        eVar.a(3, 0, this.iDo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cwE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwE() {
        this.iDq.showLoadingView();
        e eVar = this.iDr;
        e eVar2 = this.iDr;
        eVar.a(3, 0, this.iDo);
    }
}
