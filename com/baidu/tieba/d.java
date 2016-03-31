package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aKG = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LogoActivity logoActivity;
        LogoActivity.a aVar;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        com.baidu.tbadk.core.util.TiebaStatic.log(new aw("c10793"));
        Intent intent = new Intent();
        intent.putExtra("class", 30);
        intent.putExtra("jump_url", "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + com.baidu.tieba.a.a.Mw().MD());
        intent.putExtra("is_ad", true);
        TbadkCoreApplication.setIntent(intent);
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        logoActivity = this.aKG.aKF;
        aVar = logoActivity.aKy;
        hx.removeCallbacks(aVar);
        logoActivity2 = this.aKG.aKF;
        logoActivity2.aKw = true;
        logoActivity3 = this.aKG.aKF;
        logoActivity3.Jr();
    }
}
