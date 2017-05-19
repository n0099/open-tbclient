package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bDv = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        String str;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        TbPageContext tbPageContext;
        Handler handler;
        Runnable runnable;
        int i;
        dVar = this.bDv.bDm;
        if (dVar == null) {
            str = this.bDv.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bDv.jv;
                gVar.o(view).ad(0).z(true).A(true);
                gVar.a(new c(this));
                this.bDv.bDm = gVar.fc();
                dVar2 = this.bDv.bDm;
                dVar2.x(false);
                dVar3 = this.bDv.bDm;
                tbPageContext = this.bDv.ajr;
                dVar3.j(tbPageContext.getPageActivity());
                this.bDv.bDn = true;
                this.bDv.Va();
                handler = this.bDv.mHandler;
                runnable = this.bDv.bDu;
                i = this.bDv.bDt;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
