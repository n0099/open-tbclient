package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements f.c {
    private as hjF;
    private com.baidu.tieba.forumMember.member.a.b hjH;
    private e hjI;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.o> hjG = null;
    private ao hjJ = new ao() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ao
        public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
            ForumMemberActivity.this.hjH.hideLoadingView();
            ForumMemberActivity.this.hjH.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.k) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.hjH.bqQ();
                ForumMemberActivity.this.hjG = arrayList;
                ForumMemberActivity.this.hjH.cj(ForumMemberActivity.this.hjG);
            } else if (v.isEmpty(ForumMemberActivity.this.hjG) && avVar != null) {
                ForumMemberActivity.this.hjH.Ex(avVar.errMsg);
            }
        }
    };
    private NoNetworkView.a faB = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.hjH.mD(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.hjG)) {
                    ForumMemberActivity.this.bTy();
                } else {
                    ForumMemberActivity.this.hjH.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.hjH = new com.baidu.tieba.forumMember.member.a.b(this);
        this.hjH.f(this.faB);
        this.hjI = new e();
        this.hjI.setTag(getUniqueId());
        this.hjI.init();
        this.hjI.a(this.hjJ);
        bTy();
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
        this.hjF = new as();
        this.hjF.forumId = this.mForumId;
        this.hjF.forumName = this.mForumName;
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
        this.hjH.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hjI.bwk();
        if (this.hjH != null) {
            this.hjH.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.hjI;
        e eVar2 = this.hjI;
        eVar.a(3, 0, this.hjF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bTy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTy() {
        this.hjH.showLoadingView();
        e eVar = this.hjI;
        e eVar2 = this.hjI;
        eVar.a(3, 0, this.hjF);
    }
}
