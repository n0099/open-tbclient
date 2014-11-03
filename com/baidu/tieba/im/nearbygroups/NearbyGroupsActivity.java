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
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.model.NearbyGroupsModel;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends BaseActivity {
    private m bgn = null;
    private NearbyGroupsModel bgo = null;
    private com.baidu.adp.lib.util.e bgp = null;
    private com.baidu.adp.widget.ListView.f uo = new b(this);
    com.baidu.adp.lib.d.d locationCallBack = new c(this);
    private CustomMessageListener mCustomListener = new d(this, 2001115);
    private com.baidu.adp.framework.listener.e ayS = new e(this, 0);

    public static void k(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bgn = new m(this);
        this.bgn.a(this.uo);
        this.bgn.h(new f(this));
        this.bgn.a(new g(this));
        this.bgp = new com.baidu.adp.lib.util.e(this);
        this.bgo = new NearbyGroupsModel(this);
        this.bgo.setUniqueId(getUniqueId());
        registerListener(103009, this.ayS);
        registerListener(103008, this.ayS);
        registerListener(this.mCustomListener);
        registerListener(103105, this.ayS);
        this.bgn.NT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(long j) {
        if (j == 0) {
            return true;
        }
        try {
            return bf.c(bf.mQ(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        if (!this.bgo.getHasMore()) {
            this.bgn.Er();
        } else if (!this.bgo.getIsLoading()) {
            this.bgn.DH();
            this.bgo.sendNextPageMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bgn.onChangeSkinType(i);
    }

    private void Nr() {
        showProgressBar();
        this.bgo.sendUserPermissionMessage(0L);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.bgn.Rf()) {
            if (!TbadkApplication.isLogin()) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                Nr();
            }
        } else if (view.getId() == v.guide_setting) {
            this.bgp.eV();
        } else if (view.getId() == v.list_item_content && (tag = view.getTag()) != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(this, com.baidu.adp.lib.g.c.a(tag.toString(), 0L), 1)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bgo.cancelMessage();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bgn.Rd();
    }
}
