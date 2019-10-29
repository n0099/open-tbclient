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
    private am frJ;
    private com.baidu.tieba.forumMember.member.a.b frL;
    private e frM;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> frK = null;
    private ai frN = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.frL.hideLoadingView();
            ForumMemberActivity.this.frL.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.frL.aJo();
                ForumMemberActivity.this.frK = arrayList;
                ForumMemberActivity.this.frL.ci(ForumMemberActivity.this.frK);
            } else if (v.isEmpty(ForumMemberActivity.this.frK) && apVar != null) {
                ForumMemberActivity.this.frL.vG(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.frL.jx(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.frK)) {
                    ForumMemberActivity.this.biw();
                } else {
                    ForumMemberActivity.this.frL.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.frL = new com.baidu.tieba.forumMember.member.a.b(this);
        this.frL.g(this.eRC);
        this.frM = new e();
        this.frM.setTag(getUniqueId());
        this.frM.init();
        this.frM.a(this.frN);
        biw();
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
        this.frJ = new am();
        this.frJ.forumId = this.mForumId;
        this.frJ.forumName = this.mForumName;
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
        this.frL.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.frM.aMM();
        if (this.frL != null) {
            this.frL.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.frM;
        e eVar2 = this.frM;
        eVar.a(3, 0, this.frJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            biw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biw() {
        this.frL.showLoadingView();
        e eVar = this.frM;
        e eVar2 = this.frM;
        eVar.a(3, 0, this.frJ);
    }
}
