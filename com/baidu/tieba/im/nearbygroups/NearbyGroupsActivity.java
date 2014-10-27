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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.im.model.NearbyGroupsModel;
import com.baidu.tieba.v;
import java.util.Date;
/* loaded from: classes.dex */
public class NearbyGroupsActivity extends BaseActivity {
    private m bfZ = null;
    private NearbyGroupsModel bga = null;
    private com.baidu.adp.lib.util.e bgb = null;
    private com.baidu.adp.widget.ListView.f uo = new b(this);
    com.baidu.adp.lib.d.d locationCallBack = new c(this);
    private CustomMessageListener mCustomListener = new d(this, 2001115);
    private com.baidu.adp.framework.listener.e ayJ = new e(this, 0);

    public static void k(Activity activity) {
        activity.startActivity(new Intent(activity, NearbyGroupsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bfZ = new m(this);
        this.bfZ.a(this.uo);
        this.bfZ.h(new f(this));
        this.bfZ.a(new g(this));
        this.bgb = new com.baidu.adp.lib.util.e(this);
        this.bga = new NearbyGroupsModel(this);
        this.bga.setUniqueId(getUniqueId());
        registerListener(103009, this.ayJ);
        registerListener(103008, this.ayJ);
        registerListener(this.mCustomListener);
        registerListener(103105, this.ayJ);
        this.bfZ.NP();
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
            return be.c(be.mQ(), new Date(j)) >= 1;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        if (!this.bga.getHasMore()) {
            this.bfZ.Ep();
        } else if (!this.bga.getIsLoading()) {
            this.bfZ.DF();
            this.bga.sendNextPageMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bfZ.onChangeSkinType(i);
    }

    private void Nn() {
        showProgressBar();
        this.bga.sendUserPermissionMessage(0L);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        super.onClick(view);
        if (view.getId() == this.bfZ.Rc()) {
            if (!TbadkApplication.isLogin()) {
                LoginActivity.a((Activity) this, "", true, 0);
            } else {
                Nn();
            }
        } else if (view.getId() == v.guide_setting) {
            this.bgb.eV();
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
        this.bga.cancelMessage();
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bfZ.Ra();
    }
}
