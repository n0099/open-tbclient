package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ctB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ctB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.alalivelist.a.c cVar;
        HeadImageView headImageView;
        HeadImageView headImageView2;
        HeadImageView headImageView3;
        com.baidu.tieba.homepage.alalivelist.a.c cVar2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar3;
        com.baidu.tieba.homepage.alalivelist.a.c cVar4;
        com.baidu.tieba.homepage.alalivelist.a.c cVar5;
        a.InterfaceC0059a interfaceC0059a;
        a.InterfaceC0059a interfaceC0059a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.ctB.ctx;
        if (cVar != null) {
            TiebaStatic.log(new as("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.ctB.bmu;
            if (view != headImageView) {
                headImageView2 = this.ctB.bmv;
                if (view != headImageView2) {
                    headImageView3 = this.ctB.bmw;
                    if (view == headImageView3) {
                        a aVar = this.ctB;
                        cVar2 = this.ctB.ctx;
                        int i = cVar2.ctk;
                        cVar3 = this.ctB.ctx;
                        aVar.a(i, cVar3.ctl.get(2));
                    }
                } else {
                    a aVar2 = this.ctB;
                    cVar4 = this.ctB.ctx;
                    int i2 = cVar4.ctk;
                    cVar5 = this.ctB.ctx;
                    aVar2.a(i2, cVar5.ctl.get(1));
                }
            } else {
                a aVar3 = this.ctB;
                cVar7 = this.ctB.ctx;
                int i3 = cVar7.ctk;
                cVar8 = this.ctB.ctx;
                aVar3.a(i3, cVar8.ctl.get(0));
            }
            interfaceC0059a = this.ctB.cty;
            if (interfaceC0059a != null) {
                interfaceC0059a2 = this.ctB.cty;
                cVar6 = this.ctB.ctx;
                interfaceC0059a2.a(view, cVar6);
            }
        }
    }
}
