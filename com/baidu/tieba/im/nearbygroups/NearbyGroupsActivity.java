package com.baidu.tieba.im.nearbygroups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.q;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.model.bd;
import com.baidu.tieba.r;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends BaseActivity {
    private m b = null;
    private bd c = null;
    private com.baidu.adp.lib.util.d d = null;
    private com.baidu.adp.widget.ListView.d e = new b(this);
    com.baidu.adp.lib.c.d a = new c(this);
    private CustomMessageListener f = new d(this, MessageTypes.CMD_REQUEST_GROUP_BY_LOCATION_LOCAL);
    private com.baidu.adp.framework.listener.b g = new e(this, 0);

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
        this.c = new bd();
        this.c.setUniqueId(getUniqueId());
        registerListener(MessageTypes.CMD_NEARBY_GROUP, this.g);
        registerListener(MessageTypes.CMD_GET_USER_PERMISSION, this.g);
        registerListener(this.f);
        registerListener(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, this.g);
        this.b.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return bh.a(bh.a(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!this.c.b()) {
            this.b.b();
        } else if (!this.c.a()) {
            this.b.c();
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
        if (view.getId() == this.b.f()) {
            if (!TbadkApplication.isLogin()) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                b();
            }
        } else if (view.getId() == r.guide_setting) {
            this.d.a();
        } else if (view.getId() == r.list_item_content && (tag = view.getTag()) != null) {
            sendMessage(new CustomMessage(2010011, new q(this, com.baidu.adp.lib.f.b.a(tag.toString(), 0L), 1)));
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
}
