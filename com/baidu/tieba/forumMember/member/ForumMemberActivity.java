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
    private ba iOU;
    private com.baidu.tieba.forumMember.member.a.b iOW;
    private e iOX;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> iOV = null;
    private au iOY = new au() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.au
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.iOW.hideLoadingView();
            ForumMemberActivity.this.iOW.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.iOW.Yb();
                ForumMemberActivity.this.iOV = arrayList;
                ForumMemberActivity.this.iOW.dd(ForumMemberActivity.this.iOV);
            } else if (y.isEmpty(ForumMemberActivity.this.iOV) && bdVar != null) {
                ForumMemberActivity.this.iOW.KC(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a gpx = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.iOW.pL(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.iOV)) {
                    ForumMemberActivity.this.cAw();
                } else {
                    ForumMemberActivity.this.iOW.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.iOW = new com.baidu.tieba.forumMember.member.a.b(this);
        this.iOW.f(this.gpx);
        this.iOX = new e();
        this.iOX.setTag(getUniqueId());
        this.iOX.init();
        this.iOX.a(this.iOY);
        cAw();
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
        this.iOU = new ba();
        this.iOU.forumId = this.mForumId;
        this.iOU.forumName = this.mForumName;
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
        this.iOW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iOX.bYY();
        if (this.iOW != null) {
            this.iOW.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.iOX;
        e eVar2 = this.iOX;
        eVar.a(3, 0, this.iOU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cAw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAw() {
        this.iOW.showLoadingView();
        e eVar = this.iOX;
        e eVar2 = this.iOX;
        eVar.a(3, 0, this.iOU);
    }
}
