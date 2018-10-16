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
    private ao dwL;
    private com.baidu.tieba.forumMember.member.a.b dwN;
    private e dwO;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dwM = null;
    private al dwP = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dwN.hideLoadingView();
            ForumMemberActivity.this.dwN.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.J(arrayList)) {
                ForumMemberActivity.this.dwN.ZH();
                ForumMemberActivity.this.dwM = arrayList;
                ForumMemberActivity.this.dwN.bz(ForumMemberActivity.this.dwM);
            } else if (v.J(ForumMemberActivity.this.dwM) && arVar != null) {
                ForumMemberActivity.this.dwN.nt(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            ForumMemberActivity.this.dwN.gb(z);
            if (z) {
                if (v.J(ForumMemberActivity.this.dwM)) {
                    ForumMemberActivity.this.ayj();
                } else {
                    ForumMemberActivity.this.dwN.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k(bundle);
        this.dwN = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dwN.g(this.cRx);
        this.dwO = new e();
        this.dwO.setTag(getUniqueId());
        this.dwO.init();
        this.dwO.a(this.dwP);
        ayj();
    }

    private void k(Bundle bundle) {
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
        this.dwL = new ao();
        this.dwL.forumId = this.mForumId;
        this.dwL.forumName = this.mForumName;
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
        this.dwN.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dwO.aaU();
        if (this.dwN != null) {
            this.dwN.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        e eVar = this.dwO;
        e eVar2 = this.dwO;
        eVar.a(3, 0, this.dwL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kM()) {
            ayj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayj() {
        this.dwN.showLoadingView();
        e eVar = this.dwO;
        e eVar2 = this.dwO;
        eVar.a(3, 0, this.dwL);
    }
}
