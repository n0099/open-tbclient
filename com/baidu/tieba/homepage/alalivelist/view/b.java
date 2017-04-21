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
    final /* synthetic */ a cvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvS = aVar;
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
        cVar = this.cvS.cvO;
        if (cVar != null) {
            TiebaStatic.log(new as("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.cvS.boL;
            if (view != headImageView) {
                headImageView2 = this.cvS.boM;
                if (view != headImageView2) {
                    headImageView3 = this.cvS.boN;
                    if (view == headImageView3) {
                        a aVar = this.cvS;
                        cVar2 = this.cvS.cvO;
                        int i = cVar2.cvB;
                        cVar3 = this.cvS.cvO;
                        aVar.a(i, cVar3.cvC.get(2));
                    }
                } else {
                    a aVar2 = this.cvS;
                    cVar4 = this.cvS.cvO;
                    int i2 = cVar4.cvB;
                    cVar5 = this.cvS.cvO;
                    aVar2.a(i2, cVar5.cvC.get(1));
                }
            } else {
                a aVar3 = this.cvS;
                cVar7 = this.cvS.cvO;
                int i3 = cVar7.cvB;
                cVar8 = this.cvS.cvO;
                aVar3.a(i3, cVar8.cvC.get(0));
            }
            interfaceC0059a = this.cvS.cvP;
            if (interfaceC0059a != null) {
                interfaceC0059a2 = this.cvS.cvP;
                cVar6 = this.cvS.cvO;
                interfaceC0059a2.a(view, cVar6);
            }
        }
    }
}
