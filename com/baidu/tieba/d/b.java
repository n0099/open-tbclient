package com.baidu.tieba.d;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.guide.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bJl = aVar;
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
        dVar = this.bJl.bJc;
        if (dVar == null) {
            str = this.bJl.mMessage;
            if (!StringUtils.isNull(str)) {
                g gVar = new g();
                view = this.bJl.jv;
                gVar.o(view).ad(0).z(true).A(true);
                gVar.a(new c(this));
                this.bJl.bJc = gVar.fc();
                dVar2 = this.bJl.bJc;
                dVar2.x(false);
                dVar3 = this.bJl.bJc;
                tbPageContext = this.bJl.ajh;
                dVar3.j(tbPageContext.getPageActivity());
                this.bJl.bJd = true;
                this.bJl.Wd();
                handler = this.bJl.mHandler;
                runnable = this.bJl.bJk;
                i = this.bJl.bJj;
                handler.postDelayed(runnable, i);
            }
        }
    }
}
