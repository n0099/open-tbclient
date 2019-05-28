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
    private am fll;
    private com.baidu.tieba.forumMember.member.a.b fln;
    private e flo;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> flm = null;
    private ai flp = new ai() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.fln.hideLoadingView();
            ForumMemberActivity.this.fln.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.aa(arrayList)) {
                ForumMemberActivity.this.fln.aHK();
                ForumMemberActivity.this.flm = arrayList;
                ForumMemberActivity.this.fln.bU(ForumMemberActivity.this.flm);
            } else if (v.aa(ForumMemberActivity.this.flm) && apVar != null) {
                ForumMemberActivity.this.fln.wk(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            ForumMemberActivity.this.fln.jw(z);
            if (z) {
                if (v.aa(ForumMemberActivity.this.flm)) {
                    ForumMemberActivity.this.biw();
                } else {
                    ForumMemberActivity.this.fln.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O(bundle);
        this.fln = new com.baidu.tieba.forumMember.member.a.b(this);
        this.fln.g(this.eCl);
        this.flo = new e();
        this.flo.setTag(getUniqueId());
        this.flo.init();
        this.flo.a(this.flp);
        biw();
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
        this.fll = new am();
        this.fll.forumId = this.mForumId;
        this.fll.forumName = this.mForumName;
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
        this.fln.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.flo.aJS();
        if (this.fln != null) {
            this.fln.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        e eVar = this.flo;
        e eVar2 = this.flo;
        eVar.a(3, 0, this.fll);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.jG()) {
            biw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biw() {
        this.fln.showLoadingView();
        e eVar = this.flo;
        e eVar2 = this.flo;
        eVar.a(3, 0, this.fll);
    }
}
