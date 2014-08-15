package com.baidu.tieba.im.live.room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
/* loaded from: classes.dex */
public class LiveGroupLikeListActivity extends BaseActivity {
    private static int a;
    private e b = null;
    private d c = null;
    private com.baidu.adp.framework.listener.d d = new a(this, 107006);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.aj.class, LiveGroupLikeListActivity.class);
        a = 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new d(this);
        this.c.a(getIntent(), bundle);
        this.b = new e(this, this.c.c(), this.c.e());
        registerListener(this.d);
        showProgressBar();
        this.c.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        getLayoutMode().a(view);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.b()) {
            finish();
        } else if (view == this.b.c() && this.c.d()) {
            this.c.i();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LikeUserInfo a2 = this.c.a(i);
        if (a2 != null) {
            sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this, String.valueOf(a2.userId), a2.userName)));
        }
    }
}
