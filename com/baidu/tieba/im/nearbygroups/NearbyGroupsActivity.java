package com.baidu.tieba.im.nearbygroups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.o;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.model.ay;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends com.baidu.tbadk.a {
    private m b = null;
    private ay c = null;
    private com.baidu.adp.lib.util.d d = null;
    private com.baidu.adp.widget.ListView.d e = new b(this);
    com.baidu.adp.lib.c.d a = new c(this);
    private com.baidu.adp.framework.c.a f = new d(this, 2001115);
    private com.baidu.adp.framework.c.g g = new e(this, 0);

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new m(this);
        this.b.a(this.e);
        this.b.a(new f(this));
        this.b.a(new g(this));
        this.d = new com.baidu.adp.lib.util.d(this);
        this.c = new ay();
        this.c.setUniqueId(getUniqueId());
        registerListener(103009, this.g);
        registerListener(103008, this.g);
        registerListener(this.f);
        registerListener(103105, this.g);
        this.b.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return bf.a(bf.a(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(NearbyGroupsActivity nearbyGroupsActivity) {
        if (!nearbyGroupsActivity.c.b()) {
            nearbyGroupsActivity.b.d();
        } else if (nearbyGroupsActivity.c.a()) {
        } else {
            nearbyGroupsActivity.b.e();
            nearbyGroupsActivity.c.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.b.h()) {
            if (!TbadkApplication.F()) {
                LoginActivity.a((Activity) this, "", true, 0);
                return;
            }
            showProgressBar();
            this.c.a(0L);
        } else if (view.getId() == com.baidu.tieba.im.h.guide_setting) {
            this.d.a();
        } else if (view.getId() == com.baidu.tieba.im.h.list_item_content && (tag = view.getTag()) != null) {
            sendMessage(new com.baidu.adp.framework.message.a(2008011, new o(this, com.baidu.adp.lib.f.b.a(tag.toString(), 0L), 1)));
        }
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.cancelMessage();
    }
}
