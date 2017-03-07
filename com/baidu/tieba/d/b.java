package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bBk = aVar;
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
        dVar = this.bBk.bBb;
        if (dVar == null) {
            str = this.bBk.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bBk.jv;
                gVar.o(view).ae(0).z(true).A(true);
                gVar.a(new c(this));
                this.bBk.bBb = gVar.eW();
                dVar2 = this.bBk.bBb;
                dVar2.x(false);
                dVar3 = this.bBk.bBb;
                tbPageContext = this.bBk.ajF;
                dVar3.j(tbPageContext.getPageActivity());
                this.bBk.bBc = true;
                this.bBk.Ui();
                handler = this.bBk.mHandler;
                runnable = this.bBk.bBj;
                i = this.bBk.bBi;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
