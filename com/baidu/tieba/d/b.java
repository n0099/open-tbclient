package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKi = aVar;
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
        dVar = this.bKi.bJU;
        if (dVar == null) {
            str = this.bKi.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bKi.jv;
                gVar.o(view).ad(0).z(true).A(true);
                gVar.a(new c(this));
                this.bKi.bJU = gVar.fb();
                dVar2 = this.bKi.bJU;
                dVar2.x(false);
                dVar3 = this.bKi.bJU;
                tbPageContext = this.bKi.ajP;
                dVar3.j(tbPageContext.getPageActivity());
                this.bKi.bJV = true;
                this.bKi.Xu();
                handler = this.bKi.mHandler;
                runnable = this.bKi.bKh;
                i = this.bKi.bKb;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
