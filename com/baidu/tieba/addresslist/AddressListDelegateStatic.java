package com.baidu.tieba.addresslist;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class AddressListDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView ayU;
    CustomMessageListener ayV = new b(this, 2001180);
    CustomMessageListener ayW = new c(this, 2001189);

    public AddressListDelegateStatic() {
        this.ayV.setPriority(6);
        MessageManager.getInstance().registerListener(this.ayV);
        this.ayW.setPriority(6);
        MessageManager.getInstance().registerListener(this.ayW);
    }

    static {
        d dVar = new d(2007002);
        dVar.setPriority(6);
        MessageManager.getInstance().registerListener(dVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.ADDRESS_LIST_DELEGATE_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d AD() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.anf = new e();
            dVar.type = 4;
            dVar.ang = com.baidu.tieba.t.contacts;
            dVar.anh = com.baidu.tieba.p.icon_tabbar_contact;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.amS = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(context, com.baidu.tieba.r.fragmenttabindicator, null);
        this.ayU = new ImageView(context);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ane = this.amS;
        cVar.ur = com.baidu.adp.lib.util.n.dip2px(context, 7.0f);
        cVar.view = this.ayU;
        cVar.anc = com.baidu.tieba.p.icon_news_down_bar_one;
        this.ayU.setVisibility(8);
        this.amS.a("addresslist", cVar);
        return this.amS;
    }
}
