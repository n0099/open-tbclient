package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements j.b {
    private aq dBj;
    private com.baidu.tieba.forumMember.member.a.b dBl;
    private e dBm;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.i> dBk = null;
    private an dBn = new an() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            ForumMemberActivity.this.dBl.VV();
            ForumMemberActivity.this.dBl.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.h) {
                        it.remove();
                    }
                }
            }
            if (!v.E(arrayList)) {
                ForumMemberActivity.this.dBl.XN();
                ForumMemberActivity.this.dBk = arrayList;
                ForumMemberActivity.this.dBl.bi(ForumMemberActivity.this.dBk);
            } else if (v.E(ForumMemberActivity.this.dBk) && atVar != null) {
                ForumMemberActivity.this.dBl.lB(atVar.errMsg);
            }
        }
    };
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            ForumMemberActivity.this.dBl.fG(z);
            if (z) {
                if (v.E(ForumMemberActivity.this.dBk)) {
                    ForumMemberActivity.this.atS();
                } else {
                    ForumMemberActivity.this.dBl.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m(bundle);
        this.dBl = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dBl.g(this.dbo);
        this.dBm = new e();
        this.dBm.setTag(getUniqueId());
        this.dBm.init();
        this.dBm.a(this.dBn);
        atS();
    }

    private void m(Bundle bundle) {
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
        this.dBj = new aq();
        this.dBj.forumId = this.mForumId;
        this.dBj.forumName = this.mForumName;
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
        this.dBl.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dBm.Za();
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        e eVar = this.dBm;
        e eVar2 = this.dBm;
        eVar.a(3, 0, this.dBj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ox()) {
            atS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atS() {
        this.dBl.VU();
        e eVar = this.dBm;
        e eVar2 = this.dBm;
        eVar.a(3, 0, this.dBj);
    }
}
