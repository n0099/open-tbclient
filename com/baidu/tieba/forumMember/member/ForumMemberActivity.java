package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements j.b {
    private ao doJ;
    private com.baidu.tieba.forumMember.member.a.b doL;
    private e doM;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> doK = null;
    private al doN = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.doL.hideLoadingView();
            ForumMemberActivity.this.doL.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.z(arrayList)) {
                ForumMemberActivity.this.doL.Wa();
                ForumMemberActivity.this.doK = arrayList;
                ForumMemberActivity.this.doL.bj(ForumMemberActivity.this.doK);
            } else if (v.z(ForumMemberActivity.this.doK) && arVar != null) {
                ForumMemberActivity.this.doL.mR(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            ForumMemberActivity.this.doL.fJ(z);
            if (z) {
                if (v.z(ForumMemberActivity.this.doK)) {
                    ForumMemberActivity.this.auN();
                } else {
                    ForumMemberActivity.this.doL.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.doL = new com.baidu.tieba.forumMember.member.a.b(this);
        this.doL.g(this.cJe);
        this.doM = new e();
        this.doM.setTag(getUniqueId());
        this.doM.init();
        this.doM.a(this.doN);
        auN();
    }

    private void j(Bundle bundle) {
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
        this.doJ = new ao();
        this.doJ.forumId = this.mForumId;
        this.doJ.forumName = this.mForumName;
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
        this.doL.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.doM.Xn();
        if (this.doL != null) {
            this.doL.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        e eVar = this.doM;
        e eVar2 = this.doM;
        eVar.a(3, 0, this.doJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ky()) {
            auN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auN() {
        this.doL.showLoadingView();
        e eVar = this.doM;
        e eVar2 = this.doM;
        eVar.a(3, 0, this.doJ);
    }
}
