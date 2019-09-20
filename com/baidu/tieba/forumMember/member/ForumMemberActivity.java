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
    private am fsw;
    private com.baidu.tieba.forumMember.member.a.b fsy;
    private e fsz;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> fsx = null;
    private ai fsA = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.fsy.hideLoadingView();
            ForumMemberActivity.this.fsy.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.aa(arrayList)) {
                ForumMemberActivity.this.fsy.aJN();
                ForumMemberActivity.this.fsx = arrayList;
                ForumMemberActivity.this.fsy.bV(ForumMemberActivity.this.fsx);
            } else if (v.aa(ForumMemberActivity.this.fsx) && apVar != null) {
                ForumMemberActivity.this.fsy.xo(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            ForumMemberActivity.this.fsy.jJ(z);
            if (z) {
                if (v.aa(ForumMemberActivity.this.fsx)) {
                    ForumMemberActivity.this.blq();
                } else {
                    ForumMemberActivity.this.fsy.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O(bundle);
        this.fsy = new com.baidu.tieba.forumMember.member.a.b(this);
        this.fsy.g(this.eIX);
        this.fsz = new e();
        this.fsz.setTag(getUniqueId());
        this.fsz.init();
        this.fsz.a(this.fsA);
        blq();
    }

    private void O(Bundle bundle) {
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
        this.fsw = new am();
        this.fsw.forumId = this.mForumId;
        this.fsw.forumName = this.mForumName;
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
        this.fsy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fsz.aMd();
        if (this.fsy != null) {
            this.fsy.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        e eVar = this.fsz;
        e eVar2 = this.fsz;
        eVar.a(3, 0, this.fsw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            blq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        this.fsy.showLoadingView();
        e eVar = this.fsz;
        e eVar2 = this.fsz;
        eVar.a(3, 0, this.fsw);
    }
}
