package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.c {
    private ao glw;
    private com.baidu.tieba.forumMember.member.a.b gly;
    private e glz;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.m> glx = null;
    private ak glA = new ak() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
            ForumMemberActivity.this.gly.hideLoadingView();
            ForumMemberActivity.this.gly.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.k) {
                        it.remove();
                    }
                }
            }
            if (!v.isEmpty(arrayList)) {
                ForumMemberActivity.this.gly.bcC();
                ForumMemberActivity.this.glx = arrayList;
                ForumMemberActivity.this.gly.ca(ForumMemberActivity.this.glx);
            } else if (v.isEmpty(ForumMemberActivity.this.glx) && arVar != null) {
                ForumMemberActivity.this.gly.Ba(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            ForumMemberActivity.this.gly.ld(z);
            if (z) {
                if (v.isEmpty(ForumMemberActivity.this.glx)) {
                    ForumMemberActivity.this.bCC();
                } else {
                    ForumMemberActivity.this.gly.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBundle(bundle);
        this.gly = new com.baidu.tieba.forumMember.member.a.b(this);
        this.gly.f(this.fZG);
        this.glz = new e();
        this.glz.setTag(getUniqueId());
        this.glz.init();
        this.glz.a(this.glA);
        bCC();
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
        this.glw = new ao();
        this.glw.forumId = this.mForumId;
        this.glw.forumName = this.mForumName;
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
        this.gly.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.glz.bhc();
        if (this.gly != null) {
            this.gly.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        e eVar = this.glz;
        e eVar2 = this.glz;
        eVar.a(3, 0, this.glw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            bCC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCC() {
        this.gly.showLoadingView();
        e eVar = this.glz;
        e eVar2 = this.glz;
        eVar.a(3, 0, this.glw);
    }
}
