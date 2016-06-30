package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.bFI = bqVar;
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
        dVar = this.bFI.EF;
        if (dVar == null) {
            frsActivity = this.bFI.bET;
            String string = frsActivity.getPageContext().getPageActivity().getResources().getString(u.j.add_frequently_forum_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.bFI.bFf;
                gVar.o(imageView).N(0).u(true).v(true);
                bu buVar = new bu(this, string);
                gVar.t(true);
                gVar.v(false);
                gVar.a(buVar);
                this.bFI.EF = gVar.cW();
                dVar2 = this.bFI.EF;
                dVar2.s(false);
                dVar3 = this.bFI.EF;
                frsActivity2 = this.bFI.bET;
                dVar3.f(frsActivity2.getPageContext().getPageActivity());
                this.bFI.WL();
                handler = this.bFI.mHandler;
                runnable = this.bFI.bFG;
                handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }
}
