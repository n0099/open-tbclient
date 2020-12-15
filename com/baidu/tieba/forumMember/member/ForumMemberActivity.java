package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes23.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private ba iOW;
    private com.baidu.tieba.forumMember.member.a.b iOY;
    private e iOZ;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> iOX = null;
    private au iPa = new au() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.iOY.hideLoadingView();
            ForumMemberActivity.this.iOY.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.iOY.Yb();
                ForumMemberActivity.this.iOX = arrayList;
                ForumMemberActivity.this.iOY.dd(ForumMemberActivity.this.iOX);
            } else if (y.isEmpty(ForumMemberActivity.this.iOX) && bdVar != null) {
                ForumMemberActivity.this.iOY.KC(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.iOY.pL(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.iOX)) {
                    ForumMemberActivity.this.cAx();
                } else {
                    ForumMemberActivity.this.iOY.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.iOY = new com.baidu.tieba.forumMember.member.a.b(this);
        this.iOY.f(this.gpz);
        this.iOZ = new e();
        this.iOZ.setTag(getUniqueId());
        this.iOZ.init();
        this.iOZ.a(this.iPa);
        cAx();
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
        this.iOW = new ba();
        this.iOW.forumId = this.mForumId;
        this.iOW.forumName = this.mForumName;
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
        this.iOY.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iOZ.bYZ();
        if (this.iOY != null) {
            this.iOY.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.iOZ;
        e eVar2 = this.iOZ;
        eVar.a(3, 0, this.iOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cAx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        this.iOY.showLoadingView();
        e eVar = this.iOZ;
        e eVar2 = this.iOZ;
        eVar.a(3, 0, this.iOW);
    }
}
