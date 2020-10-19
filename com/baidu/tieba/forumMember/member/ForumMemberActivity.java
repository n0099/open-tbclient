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
    private ba ikT;
    private com.baidu.tieba.forumMember.member.a.b ikV;
    private e ikW;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.q> ikU = null;
    private av ikX = new av() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.av
        public void a(int i, int i2, bd bdVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
            ForumMemberActivity.this.ikV.hideLoadingView();
            ForumMemberActivity.this.ikV.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.n) {
                        it.remove();
                    }
                }
            }
            if (!y.isEmpty(arrayList)) {
                ForumMemberActivity.this.ikV.SK();
                ForumMemberActivity.this.ikU = arrayList;
                ForumMemberActivity.this.ikV.cI(ForumMemberActivity.this.ikU);
            } else if (y.isEmpty(ForumMemberActivity.this.ikU) && bdVar != null) {
                ForumMemberActivity.this.ikV.Jv(bdVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fRO = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.ikV.oK(z);
            if (z) {
                if (y.isEmpty(ForumMemberActivity.this.ikU)) {
                    ForumMemberActivity.this.cqW();
                } else {
                    ForumMemberActivity.this.ikV.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.ikV = new com.baidu.tieba.forumMember.member.a.b(this);
        this.ikV.f(this.fRO);
        this.ikW = new e();
        this.ikW.setTag(getUniqueId());
        this.ikW.init();
        this.ikW.a(this.ikX);
        cqW();
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
        this.ikT = new ba();
        this.ikT.forumId = this.mForumId;
        this.ikT.forumName = this.mForumName;
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
        this.ikV.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ikW.bQq();
        if (this.ikV != null) {
            this.ikV.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.ikW;
        e eVar2 = this.ikW;
        eVar.a(3, 0, this.ikT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            cqW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqW() {
        this.ikV.showLoadingView();
        e eVar = this.ikW;
        e eVar2 = this.ikW;
        eVar.a(3, 0, this.ikT);
    }
}
