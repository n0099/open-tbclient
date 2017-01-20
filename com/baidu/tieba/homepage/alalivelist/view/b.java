package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ctC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ctC = aVar;
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
        a.InterfaceC0061a interfaceC0061a;
        a.InterfaceC0061a interfaceC0061a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.ctC.cty;
        if (cVar != null) {
            TiebaStatic.log(new ar("c11831").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.ctC.bfP;
            if (view != headImageView) {
                headImageView2 = this.ctC.bfQ;
                if (view != headImageView2) {
                    headImageView3 = this.ctC.bfR;
                    if (view == headImageView3) {
                        a aVar = this.ctC;
                        cVar2 = this.ctC.cty;
                        int i = cVar2.ctl;
                        cVar3 = this.ctC.cty;
                        aVar.a(i, cVar3.ctm.get(2));
                    }
                } else {
                    a aVar2 = this.ctC;
                    cVar4 = this.ctC.cty;
                    int i2 = cVar4.ctl;
                    cVar5 = this.ctC.cty;
                    aVar2.a(i2, cVar5.ctm.get(1));
                }
            } else {
                a aVar3 = this.ctC;
                cVar7 = this.ctC.cty;
                int i3 = cVar7.ctl;
                cVar8 = this.ctC.cty;
                aVar3.a(i3, cVar8.ctm.get(0));
            }
            interfaceC0061a = this.ctC.ctz;
            if (interfaceC0061a != null) {
                interfaceC0061a2 = this.ctC.ctz;
                cVar6 = this.ctC.cty;
                interfaceC0061a2.a(view, cVar6);
            }
        }
    }
}
