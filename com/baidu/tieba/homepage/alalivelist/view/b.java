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
    final /* synthetic */ a csP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.csP = aVar;
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
        a.InterfaceC0064a interfaceC0064a;
        a.InterfaceC0064a interfaceC0064a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.csP.csL;
        if (cVar != null) {
            TiebaStatic.log(new as("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.csP.bpi;
            if (view != headImageView) {
                headImageView2 = this.csP.bpj;
                if (view != headImageView2) {
                    headImageView3 = this.csP.bpk;
                    if (view == headImageView3) {
                        a aVar = this.csP;
                        cVar2 = this.csP.csL;
                        int i = cVar2.csB;
                        cVar3 = this.csP.csL;
                        aVar.a(i, cVar3.csC.get(2));
                    }
                } else {
                    a aVar2 = this.csP;
                    cVar4 = this.csP.csL;
                    int i2 = cVar4.csB;
                    cVar5 = this.csP.csL;
                    aVar2.a(i2, cVar5.csC.get(1));
                }
            } else {
                a aVar3 = this.csP;
                cVar7 = this.csP.csL;
                int i3 = cVar7.csB;
                cVar8 = this.csP.csL;
                aVar3.a(i3, cVar8.csC.get(0));
            }
            interfaceC0064a = this.csP.csM;
            if (interfaceC0064a != null) {
                interfaceC0064a2 = this.csP.csM;
                cVar6 = this.csP.csL;
                interfaceC0064a2.a(view, cVar6);
            }
        }
    }
}
