package com.baidu.tieba.im.group;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.DiscoverMoreActivityConfig;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class DiscoverMoreActivity extends BaseActivity implements com.baidu.tieba.im.a.e {
    private CustomMessageListener aYA = new a(this, 2009502);
    private g aYB;
    private com.baidu.tieba.im.a.a aYC;
    private com.baidu.tbadk.b.a.b aYD;

    static {
        TbadkApplication.m251getInst().RegisterIntent(DiscoverMoreActivityConfig.class, DiscoverMoreActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NV();
        setContentView(w.discover_group_activity);
        initData();
        initUI();
        this.aYA.setPriority(10);
    }

    private void NV() {
        registerListener(this.aYA);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2009502, new com.baidu.tbadk.b.a.b(this)));
    }

    private void initData() {
        if (this.aYC == null) {
            this.aYC = new com.baidu.tieba.im.a.a(this);
            this.aYC.setUniqueId(getUniqueId());
            this.aYC.onStart();
            this.aYC.a(this);
        }
    }

    private void initUI() {
        this.aYB = new g(this);
        this.aYB.uf().setOnItemClickListener(this);
        this.aYB.NZ().notifyDataSetChanged();
        this.aYB.uf().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW() {
        this.aYB.x(this.aYD.rb());
        this.aYB.NZ().notifyDataSetChanged();
        this.aYB.uf().hO();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aYC != null) {
            this.aYC.onStop();
        }
        com.baidu.tieba.im.a.a.bcG = true;
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(int i, int i2, String str, String str2, String str3) {
        if (this.aYB != null) {
            this.aYB.uf().hN();
            this.aYB.fL(i2);
            this.aYB.gf(str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aYB.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.a.e
    public void ig() {
        if (this.aYB != null) {
            this.aYB.NZ().notifyDataSetChanged();
            this.aYB.uf().hN();
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public void ge(String str) {
    }

    @Override // com.baidu.tieba.im.a.e
    public void NX() {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.aYB != null && this.aYB.NZ() != null && this.aYB.NZ().NY() != null && this.aYB.NZ().getItem(i) != null && i < this.aYB.NZ().getCount()) {
            b NZ = this.aYB.NZ();
            if (i < NZ.getCount()) {
                NZ.getItem(i).onClick();
            }
        }
    }
}
