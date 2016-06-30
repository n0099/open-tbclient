package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ d aHt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aHt = dVar;
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
        intent.putExtra("jump_url", "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + com.baidu.tieba.c.a.Me().Ml());
        intent.putExtra("is_ad", true);
        TbadkCoreApplication.setIntent(intent);
        com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
        logoActivity = this.aHt.aHs;
        aVar = logoActivity.aHl;
        dM.removeCallbacks(aVar);
        logoActivity2 = this.aHt.aHs;
        logoActivity2.aHj = true;
        logoActivity3 = this.aHt.aHs;
        logoActivity3.HM();
    }
}
