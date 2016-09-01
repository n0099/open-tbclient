package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c aLB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aLB = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LogoActivity logoActivity;
        LogoActivity.a aVar;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        com.baidu.tbadk.core.util.TiebaStatic.log(new ay("c10793"));
        Intent intent = new Intent();
        intent.putExtra("class", 30);
        intent.putExtra("jump_url", "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + com.baidu.tieba.d.a.OI().OP());
        intent.putExtra("is_ad", true);
        TbadkCoreApplication.setIntent(intent);
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        logoActivity = this.aLB.aLA;
        aVar = logoActivity.aLt;
        eG.removeCallbacks(aVar);
        logoActivity2 = this.aLB.aLA;
        logoActivity2.aLr = true;
        logoActivity3 = this.aLB.aLA;
        logoActivity3.Je();
    }
}
