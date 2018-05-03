package com.baidu.tieba.forumMember.member;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumMemberActivity extends BaseActivity<ForumMemberActivity> implements e.b {
    private am cTS;
    private com.baidu.tieba.forumMember.member.a.b cTU;
    private e cTV;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> cTT = null;
    private aj cTW = new aj() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.cTU.Ou();
            ForumMemberActivity.this.cTU.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.g) {
                        it.remove();
                    }
                }
            }
            if (!v.w(arrayList)) {
                ForumMemberActivity.this.cTU.Qn();
                ForumMemberActivity.this.cTT = arrayList;
                ForumMemberActivity.this.cTU.bc(ForumMemberActivity.this.cTT);
            } else if (v.w(ForumMemberActivity.this.cTT) && apVar != null) {
                ForumMemberActivity.this.cTU.lE(apVar.errMsg);
            }
        }
    };
    private NoNetworkView.a ctd = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            ForumMemberActivity.this.cTU.fl(z);
            if (z) {
                if (v.w(ForumMemberActivity.this.cTT)) {
                    ForumMemberActivity.this.aoh();
                } else {
                    ForumMemberActivity.this.cTU.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j(bundle);
        this.cTU = new com.baidu.tieba.forumMember.member.a.b(this);
        this.cTU.g(this.ctd);
        this.cTV = new e();
        this.cTV.setTag(getUniqueId());
        this.cTV.init();
        this.cTV.a(this.cTW);
        aoh();
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
        this.cTS = new am();
        this.cTS.forumId = this.mForumId;
        this.cTS.forumName = this.mForumName;
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
        this.cTU.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cTV.Ry();
    }

    @Override // com.baidu.tbadk.core.view.e.b
    public void aO(boolean z) {
        e eVar = this.cTV;
        e eVar2 = this.cTV;
        eVar.a(3, 0, this.cTS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.gD()) {
            aoh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoh() {
        this.cTU.showLoadingView();
        e eVar = this.cTV;
        e eVar2 = this.cTV;
        eVar.a(3, 0, this.cTS);
    }
}
