package com.baidu.tieba.frs;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bxN = aVar;
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
        dVar = this.bxN.Ht;
        if (dVar == null) {
            str = this.bxN.mMessage;
            if (!StringUtils.isNull(str)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.bxN.bL;
                gVar.o(view).ae(0).y(true).z(true);
                gVar.a(new c(this));
                this.bxN.Ht = gVar.dQ();
                dVar2 = this.bxN.Ht;
                dVar2.w(false);
                dVar3 = this.bxN.Ht;
                tbPageContext = this.bxN.GO;
                dVar3.j(tbPageContext.getPageActivity());
                this.bxN.bxJ = true;
                this.bxN.VX();
                handler = this.bxN.mHandler;
                runnable = this.bxN.bxM;
                handler.postDelayed(runnable, 3000L);
            }
        }
    }
}
