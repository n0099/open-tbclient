package com.baidu.tieba.im.nearbygroups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.y;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.model.an;
import com.baidu.tieba.u;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends BaseActivity {
    private m b = null;
    private an c = null;
    private com.baidu.adp.lib.util.d d = null;
    private com.baidu.adp.widget.ListView.d e = new b(this);
    com.baidu.adp.lib.c.d a = new c(this);
    private CustomMessageListener f = new d(this, 2001115);
    private com.baidu.adp.framework.listener.d g = new e(this, 0);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new m(this);
        this.b.a(this.e);
        this.b.a(new f(this));
        this.b.a(new g(this));
        this.d = new com.baidu.adp.lib.util.d(this);
        this.c = new an(this);
        this.c.setUniqueId(getUniqueId());
        registerListener(103009, this.g);
        registerListener(103008, this.g);
        registerListener(this.f);
        registerListener(103105, this.g);
        this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return bf.a(bf.a(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!this.c.b()) {
            this.b.b();
        } else if (!this.c.a()) {
            this.b.d();
            this.c.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    private void b() {
        showProgressBar();
        this.c.a(0L);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.b.g()) {
            if (!TbadkApplication.isLogin()) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                b();
            }
        } else if (view.getId() == u.guide_setting) {
            this.d.a();
        } else if (view.getId() == u.list_item_content && (tag = view.getTag()) != null) {
            sendMessage(new CustomMessage(2008011, new y(this, com.baidu.adp.lib.e.b.a(tag.toString(), 0L), 1)));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.cancelMessage();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.b.a();
    }
}
