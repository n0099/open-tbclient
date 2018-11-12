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
    private ao dyd;
    private com.baidu.tieba.forumMember.member.a.b dyf;
    private e dyg;
    private String mForumId;
    private String mForumName;
    private List<com.baidu.adp.widget.ListView.h> dye = null;
    private al dyh = new al() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.1
        @Override // com.baidu.tieba.frs.al
        public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
            ForumMemberActivity.this.dyf.hideLoadingView();
            ForumMemberActivity.this.dyf.completePullRefresh();
            if (arrayList != null) {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof com.baidu.tieba.frs.i) {
                        it.remove();
                    }
                }
            }
            if (!v.I(arrayList)) {
                ForumMemberActivity.this.dyf.ZS();
                ForumMemberActivity.this.dye = arrayList;
                ForumMemberActivity.this.dyf.bx(ForumMemberActivity.this.dye);
            } else if (v.I(ForumMemberActivity.this.dye) && arVar != null) {
                ForumMemberActivity.this.dyf.nu(arVar.errMsg);
            }
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.member.ForumMemberActivity.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            ForumMemberActivity.this.dyf.gl(z);
            if (z) {
                if (v.I(ForumMemberActivity.this.dye)) {
                    ForumMemberActivity.this.axH();
                } else {
                    ForumMemberActivity.this.dyf.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n(bundle);
        this.dyf = new com.baidu.tieba.forumMember.member.a.b(this);
        this.dyf.g(this.cSD);
        this.dyg = new e();
        this.dyg.setTag(getUniqueId());
        this.dyg.init();
        this.dyg.a(this.dyh);
        axH();
    }

    private void n(Bundle bundle) {
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
        this.dyd = new ao();
        this.dyd.forumId = this.mForumId;
        this.dyd.forumName = this.mForumName;
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
        this.dyf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dyg.abf();
        if (this.dyf != null) {
            this.dyf.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        e eVar = this.dyg;
        e eVar2 = this.dyg;
        eVar.a(3, 0, this.dyd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            axH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axH() {
        this.dyf.showLoadingView();
        e eVar = this.dyg;
        e eVar2 = this.dyg;
        eVar.a(3, 0, this.dyd);
    }
}
