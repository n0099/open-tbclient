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
    final /* synthetic */ a czh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.czh = aVar;
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
        a.InterfaceC0062a interfaceC0062a;
        a.InterfaceC0062a interfaceC0062a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.czh.czd;
        if (cVar != null) {
            TiebaStatic.log(new as("c11831").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.czh.bqp;
            if (view != headImageView) {
                headImageView2 = this.czh.bqq;
                if (view != headImageView2) {
                    headImageView3 = this.czh.bqr;
                    if (view == headImageView3) {
                        a aVar = this.czh;
                        cVar2 = this.czh.czd;
                        int i = cVar2.cyT;
                        cVar3 = this.czh.czd;
                        aVar.a(i, cVar3.cyU.get(2));
                    }
                } else {
                    a aVar2 = this.czh;
                    cVar4 = this.czh.czd;
                    int i2 = cVar4.cyT;
                    cVar5 = this.czh.czd;
                    aVar2.a(i2, cVar5.cyU.get(1));
                }
            } else {
                a aVar3 = this.czh;
                cVar7 = this.czh.czd;
                int i3 = cVar7.cyT;
                cVar8 = this.czh.czd;
                aVar3.a(i3, cVar8.cyU.get(0));
            }
            interfaceC0062a = this.czh.cze;
            if (interfaceC0062a != null) {
                interfaceC0062a2 = this.czh.cze;
                cVar6 = this.czh.czd;
                interfaceC0062a2.a(view, cVar6);
            }
        }
    }
}
