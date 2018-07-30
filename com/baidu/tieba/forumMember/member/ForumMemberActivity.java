package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements g.b {
    private ao diS;
    private com.baidu.tieba.forumMember.member.a.b diU;
    private e diV;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> diT = null;
    private al diW = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.diU.hideLoadingView();
            ForumMemberActivity.this.diU.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!w.z(arrayList)) {
                ForumMemberActivity.this.diU.Uk();
                ForumMemberActivity.this.diT = arrayList;
                ForumMemberActivity.this.diU.bi(ForumMemberActivity.this.diT);
            } else if (w.z(ForumMemberActivity.this.diT) && arVar != null) {
                ForumMemberActivity.this.diU.mn(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            ForumMemberActivity.this.diU.fs(z);
            if (z) {
                if (w.z(ForumMemberActivity.this.diT)) {
                    ForumMemberActivity.this.ata();
                } else {
                    ForumMemberActivity.this.diU.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.diU = new com.baidu.tieba.forumMember.member.a.b(this);
        this.diU.g(this.cDq);
        this.diV = new e();
        this.diV.setTag(getUniqueId());
        this.diV.init();
        this.diV.a(this.diW);
        ata();
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
        this.diS = new ao();
        this.diS.forumId = this.mForumId;
        this.diS.forumName = this.mForumName;
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
        this.diU.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.diV.Vx();
        if (this.diU != null) {
            this.diU.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        e eVar = this.diV;
        e eVar2 = this.diV;
        eVar.a(3, 0, this.diS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.js()) {
            ata();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        this.diU.showLoadingView();
        e eVar = this.diV;
        e eVar2 = this.diV;
        eVar.a(3, 0, this.diS);
    }
}
