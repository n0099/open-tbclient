package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.homepage.alalivelist.view.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cGT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cGT = aVar;
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
        a.InterfaceC0065a interfaceC0065a;
        a.InterfaceC0065a interfaceC0065a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.cGT.cGP;
        if (cVar != null) {
            TiebaStatic.log(new au("c11831").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.cGT.bub;
            if (view != headImageView) {
                headImageView2 = this.cGT.buc;
                if (view != headImageView2) {
                    headImageView3 = this.cGT.bud;
                    if (view == headImageView3) {
                        a aVar = this.cGT;
                        cVar2 = this.cGT.cGP;
                        int i = cVar2.cGF;
                        cVar3 = this.cGT.cGP;
                        aVar.a(i, cVar3.cGG.get(2));
                    }
                } else {
                    a aVar2 = this.cGT;
                    cVar4 = this.cGT.cGP;
                    int i2 = cVar4.cGF;
                    cVar5 = this.cGT.cGP;
                    aVar2.a(i2, cVar5.cGG.get(1));
                }
            } else {
                a aVar3 = this.cGT;
                cVar7 = this.cGT.cGP;
                int i3 = cVar7.cGF;
                cVar8 = this.cGT.cGP;
                aVar3.a(i3, cVar8.cGG.get(0));
            }
            interfaceC0065a = this.cGT.cGQ;
            if (interfaceC0065a != null) {
                interfaceC0065a2 = this.cGT.cGQ;
                cVar6 = this.cGT.cGP;
                interfaceC0065a2.a(view, cVar6);
            }
        }
    }
}
