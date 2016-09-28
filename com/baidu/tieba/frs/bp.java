package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bm bmVar) {
        this.bRV = bmVar;
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
        dVar = this.bRV.Hs;
        if (dVar == null) {
            frsActivity = this.bRV.bRi;
            String string = frsActivity.getPageContext().getPageActivity().getResources().getString(r.j.add_frequently_forum_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                imageView = this.bRV.bRu;
                gVar.o(imageView).ad(0).y(true).z(true);
                bq bqVar = new bq(this, string);
                gVar.x(true);
                gVar.z(false);
                gVar.a(bqVar);
                this.bRV.Hs = gVar.dQ();
                dVar2 = this.bRV.Hs;
                dVar2.w(false);
                dVar3 = this.bRV.Hs;
                frsActivity2 = this.bRV.bRi;
                dVar3.j(frsActivity2.getPageContext().getPageActivity());
                this.bRV.acn();
                handler = this.bRV.mHandler;
                runnable = this.bRV.bRT;
                handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }
}
