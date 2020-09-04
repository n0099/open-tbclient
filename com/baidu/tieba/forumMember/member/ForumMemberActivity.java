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
    private ba hOU;
    private com.baidu.tieba.forumMember.member.a.b hOW;
    private e hOX;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> hOV = null;
    private av hOY = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.hOW.hideLoadingView();
            ForumMemberActivity.this.hOW.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.hOW.bFX();
                ForumMemberActivity.this.hOV = arrayList;
                ForumMemberActivity.this.hOW.cz(ForumMemberActivity.this.hOV);
            } else if (y.isEmpty(ForumMemberActivity.this.hOV) && bdVar != null) {
                ForumMemberActivity.this.hOW.Il(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fCt = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hOW.nZ(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.hOV)) {
                    ForumMemberActivity.this.ckl();
                } else {
                    ForumMemberActivity.this.hOW.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hOW = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hOW.f(this.fCt);
        this.hOX = new e();
        this.hOX.setTag(getUniqueId());
        this.hOX.init();
        this.hOX.a(this.hOY);
        ckl();
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
        this.hOU = new ba();
        this.hOU.forumId = this.mForumId;
        this.hOU.forumName = this.mForumName;
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
        this.hOW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hOX.bLP();
        if (this.hOW != null) {
            this.hOW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hOX;
        e eVar2 = this.hOX;
        eVar.a(3, 0, this.hOU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            ckl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckl() {
        this.hOW.showLoadingView();
        e eVar = this.hOX;
        e eVar2 = this.hOX;
        eVar.a(3, 0, this.hOU);
    }
}
