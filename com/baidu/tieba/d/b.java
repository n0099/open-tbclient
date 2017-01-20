package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bub = aVar;
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
        dVar = this.bub.GD;
        if (dVar == null) {
            str = this.bub.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bub.bK;
                gVar.o(view).ae(0).y(true).z(true);
                gVar.a(new c(this));
                this.bub.GD = gVar.dO();
                dVar2 = this.bub.GD;
                dVar2.w(false);
                dVar3 = this.bub.GD;
                tbPageContext = this.bub.FY;
                dVar3.j(tbPageContext.getPageActivity());
                this.bub.btT = true;
                this.bub.Tf();
                handler = this.bub.mHandler;
                runnable = this.bub.bua;
                i = this.bub.btZ;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
