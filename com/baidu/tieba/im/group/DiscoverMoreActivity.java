package com.baidu.tieba.im.group;

import android.content.Context;
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
    private static CustomMessageListener aYm;
    private static com.baidu.tbadk.b.a.b aYn;
    private static g aYo;
    public static Context mContext;
    private com.baidu.tieba.im.a.a aYp;

    static {
        TbadkApplication.m251getInst().RegisterIntent(DiscoverMoreActivityConfig.class, DiscoverMoreActivity.class);
        aYm = new a(2009502);
        aYm.setPriority(10);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mContext = this;
        NR();
        setContentView(w.discover_group_activity);
        initData();
        initUI();
    }

    private void NR() {
        registerListener(aYm);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2009502, new com.baidu.tbadk.b.a.b(this)));
    }

    private void initData() {
        if (this.aYp == null) {
            this.aYp = new com.baidu.tieba.im.a.a(this);
            this.aYp.setUniqueId(getUniqueId());
            this.aYp.onStart();
            this.aYp.a(this);
        }
    }

    private void initUI() {
        aYo = new g((DiscoverMoreActivity) mContext);
        aYo.ud().setOnItemClickListener((DiscoverMoreActivity) mContext);
        aYo.NW().notifyDataSetChanged();
        aYo.ud().hO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void NS() {
        aYo.w(aYn.qZ());
        aYo.NW().notifyDataSetChanged();
        aYo.ud().hO();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aYp != null) {
            this.aYp.onStop();
        }
        com.baidu.tieba.im.a.a.bcs = true;
    }

    @Override // com.baidu.tieba.im.a.e
    public void a(int i, int i2, String str, String str2, String str3) {
        if (aYo != null) {
            aYo.ud().hN();
            aYo.fL(i2);
            aYo.gf(str3);
        }
    }

    public com.baidu.tieba.im.a.a NT() {
        return this.aYp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aYo.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.a.e
    public void ig() {
        if (aYo != null) {
            aYo.NW().notifyDataSetChanged();
            aYo.ud().hN();
        }
    }

    @Override // com.baidu.tieba.im.a.e
    public void ge(String str) {
    }

    @Override // com.baidu.tieba.im.a.e
    public void NU() {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (aYo != null && aYo.NW() != null && aYo.NW().NV() != null && aYo.NW().getItem(i) != null && i < aYo.NW().getCount()) {
            b NW = aYo.NW();
            if (i < NW.getCount()) {
                NW.getItem(i).onClick();
            }
        }
    }
}
