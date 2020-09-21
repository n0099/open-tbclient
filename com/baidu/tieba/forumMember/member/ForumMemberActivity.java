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
/* loaded from: classes22.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ba hVU;
    private com.baidu.tieba.forumMember.member.a.b hVW;
    private e hVX;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> hVV = null;
    private av hVY = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.hVW.hideLoadingView();
            ForumMemberActivity.this.hVW.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.hVW.bHn();
                ForumMemberActivity.this.hVV = arrayList;
                ForumMemberActivity.this.hVW.cF(ForumMemberActivity.this.hVV);
            } else if (y.isEmpty(ForumMemberActivity.this.hVV) && bdVar != null) {
                ForumMemberActivity.this.hVW.II(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hVW.of(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.hVV)) {
                    ForumMemberActivity.this.cny();
                } else {
                    ForumMemberActivity.this.hVW.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hVW = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hVW.f(this.fFF);
        this.hVX = new e();
        this.hVX.setTag(getUniqueId());
        this.hVX.init();
        this.hVX.a(this.hVY);
        cny();
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
        this.hVU = new ba();
        this.hVU.forumId = this.mForumId;
        this.hVU.forumName = this.mForumName;
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
        this.hVW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hVX.bMZ();
        if (this.hVW != null) {
            this.hVW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hVX;
        e eVar2 = this.hVX;
        eVar.a(3, 0, this.hVU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cny();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cny() {
        this.hVW.showLoadingView();
        e eVar = this.hVX;
        e eVar2 = this.hVX;
        eVar.a(3, 0, this.hVU);
    }
}
