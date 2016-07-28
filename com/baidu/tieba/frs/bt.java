package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ bq bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.bGW = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        FrsActivity frsActivity;
        ImageView imageView;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        FrsActivity frsActivity2;
        Handler handler;
        Runnable runnable;
        dVar = this.bGW.Ff;
        if (dVar == null) {
            frsActivity = this.bGW.bGh;
            String string = frsActivity.getPageContext().getPageActivity().getResources().getString(u.j.add_frequently_forum_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.bGW.bGt;
                gVar.o(imageView).Q(0).w(true).x(true);
                bu buVar = new bu(this, string);
                gVar.v(true);
                gVar.x(false);
                gVar.a(buVar);
                this.bGW.Ff = gVar.cV();
                dVar2 = this.bGW.Ff;
                dVar2.u(false);
                dVar3 = this.bGW.Ff;
                frsActivity2 = this.bGW.bGh;
                dVar3.f(frsActivity2.getPageContext().getPageActivity());
                this.bGW.Xd();
                handler = this.bGW.mHandler;
                runnable = this.bGW.bGU;
                handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }
}
