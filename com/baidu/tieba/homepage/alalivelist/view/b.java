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
    final /* synthetic */ a cvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvb = aVar;
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
        a.InterfaceC0060a interfaceC0060a;
        a.InterfaceC0060a interfaceC0060a2;
        com.baidu.tieba.homepage.alalivelist.a.c cVar6;
        com.baidu.tieba.homepage.alalivelist.a.c cVar7;
        com.baidu.tieba.homepage.alalivelist.a.c cVar8;
        cVar = this.cvb.cuX;
        if (cVar != null) {
            TiebaStatic.log(new as("c11831").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            headImageView = this.cvb.bmB;
            if (view != headImageView) {
                headImageView2 = this.cvb.bmC;
                if (view != headImageView2) {
                    headImageView3 = this.cvb.bmD;
                    if (view == headImageView3) {
                        a aVar = this.cvb;
                        cVar2 = this.cvb.cuX;
                        int i = cVar2.cuK;
                        cVar3 = this.cvb.cuX;
                        aVar.a(i, cVar3.cuL.get(2));
                    }
                } else {
                    a aVar2 = this.cvb;
                    cVar4 = this.cvb.cuX;
                    int i2 = cVar4.cuK;
                    cVar5 = this.cvb.cuX;
                    aVar2.a(i2, cVar5.cuL.get(1));
                }
            } else {
                a aVar3 = this.cvb;
                cVar7 = this.cvb.cuX;
                int i3 = cVar7.cuK;
                cVar8 = this.cvb.cuX;
                aVar3.a(i3, cVar8.cuL.get(0));
            }
            interfaceC0060a = this.cvb.cuY;
            if (interfaceC0060a != null) {
                interfaceC0060a2 = this.cvb.cuY;
                cVar6 = this.cvb.cuX;
                interfaceC0060a2.a(view, cVar6);
            }
        }
    }
}
