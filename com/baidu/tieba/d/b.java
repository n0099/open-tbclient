package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bDu = aVar;
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
        dVar = this.bDu.bDl;
        if (dVar == null) {
            str = this.bDu.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bDu.jv;
                gVar.o(view).ad(0).z(true).A(true);
                gVar.a(new c(this));
                this.bDu.bDl = gVar.fc();
                dVar2 = this.bDu.bDl;
                dVar2.x(false);
                dVar3 = this.bDu.bDl;
                tbPageContext = this.bDu.ajU;
                dVar3.j(tbPageContext.getPageActivity());
                this.bDu.bDm = true;
                this.bDu.VH();
                handler = this.bDu.mHandler;
                runnable = this.bDu.bDt;
                i = this.bDu.bDs;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
