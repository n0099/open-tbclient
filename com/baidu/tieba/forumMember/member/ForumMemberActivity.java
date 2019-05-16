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
    private am flk;
    private com.baidu.tieba.forumMember.member.a.b flm;
    private e fln;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> fll = null;
    private ai flo = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.flm.hideLoadingView();
            ForumMemberActivity.this.flm.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.aa(arrayList)) {
                ForumMemberActivity.this.flm.aHH();
                ForumMemberActivity.this.fll = arrayList;
                ForumMemberActivity.this.flm.bU(ForumMemberActivity.this.fll);
            } else if (v.aa(ForumMemberActivity.this.fll) && apVar != null) {
                ForumMemberActivity.this.flm.wk(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            ForumMemberActivity.this.flm.jw(z);
            if (z) {
                if (v.aa(ForumMemberActivity.this.fll)) {
                    ForumMemberActivity.this.bit();
                } else {
                    ForumMemberActivity.this.flm.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O(bundle);
        this.flm = new com.baidu.tieba.forumMember.member.a.b(this);
        this.flm.g(this.eCk);
        this.fln = new e();
        this.fln.setTag(getUniqueId());
        this.fln.init();
        this.fln.a(this.flo);
        bit();
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
        this.flk = new am();
        this.flk.forumId = this.mForumId;
        this.flk.forumName = this.mForumName;
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
        this.flm.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fln.aJP();
        if (this.flm != null) {
            this.flm.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        e eVar = this.fln;
        e eVar2 = this.fln;
        eVar.a(3, 0, this.flk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jG()) {
            bit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bit() {
        this.flm.showLoadingView();
        e eVar = this.fln;
        e eVar2 = this.fln;
        eVar.a(3, 0, this.flk);
    }
}
