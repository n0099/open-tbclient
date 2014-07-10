package com.baidu.tieba.im.group;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.j;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class DiscoverGroupActivity extends BaseActivity implements com.baidu.tieba.im.a.e {
    private c a;
    private com.baidu.tieba.im.a.a b;

    static {
        TbadkApplication.m252getInst().RegisterIntent(j.class, DiscoverGroupActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.discover_group_activity);
        d();
        e();
    }

    private void d() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.im.a.a();
            this.b.setUniqueId(getUniqueId());
            this.b.b();
            this.b.a(this);
        }
    }

    private void e() {
        this.a = new c(this);
        this.a.a().setOnItemClickListener(this);
        this.a.b().notifyDataSetChanged();
        this.a.a().e();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.c();
        }
        com.baidu.tieba.im.a.a.a = true;
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(int i, int i2, String str, String str2, String str3) {
        if (this.a != null) {
            this.a.a().d();
            this.a.b(i2);
            this.a.a(str3);
        }
    }

    public com.baidu.tieba.im.a.a a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.tieba.im.a.e
    public void b() {
        if (this.a != null) {
            this.a.b().notifyDataSetChanged();
            this.a.a().d();
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(String str) {
    }

    @Override // com.baidu.tieba.im.a.e
    public void c() {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                NearbyGroupsActivity.a(this);
                return;
            case 1:
                sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.g(this, 16003)));
                return;
            case 2:
                AddGroupActivity.a(this);
                return;
            default:
                return;
        }
    }
}
