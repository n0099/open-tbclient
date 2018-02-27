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
    private aq dBg;
    private com.baidu.tieba.forumMember.member.a.b dBi;
    private e dBj;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.i> dBh = null;
    private an dBk = new an() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.an
        public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
            ForumMemberActivity.this.dBi.VU();
            ForumMemberActivity.this.dBi.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.h) {
                        it.remove();
                    }
                }
            }
            if (!v.E(arrayList)) {
                ForumMemberActivity.this.dBi.XM();
                ForumMemberActivity.this.dBh = arrayList;
                ForumMemberActivity.this.dBi.bi(ForumMemberActivity.this.dBh);
            } else if (v.E(ForumMemberActivity.this.dBh) && atVar != null) {
                ForumMemberActivity.this.dBi.lB(atVar.errMsg);
            }
        }
    };
    private NoNetworkView.a dbl = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            ForumMemberActivity.this.dBi.fG(z);
            if (z) {
                if (v.E(ForumMemberActivity.this.dBh)) {
                    ForumMemberActivity.this.atR();
                } else {
                    ForumMemberActivity.this.dBi.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m(bundle);
        this.dBi = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dBi.g(this.dbl);
        this.dBj = new e();
        this.dBj.setTag(getUniqueId());
        this.dBj.init();
        this.dBj.a(this.dBk);
        atR();
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
        this.dBg = new aq();
        this.dBg.forumId = this.mForumId;
        this.dBg.forumName = this.mForumName;
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
        this.dBi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dBj.YZ();
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        e eVar = this.dBj;
        e eVar2 = this.dBj;
        eVar.a(3, 0, this.dBg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ox()) {
            atR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        this.dBi.VT();
        e eVar = this.dBj;
        e eVar2 = this.dBj;
        eVar.a(3, 0, this.dBg);
    }
}
