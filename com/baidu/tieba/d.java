package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.LogoActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c aHK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aHK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LogoActivity logoActivity;
        LogoActivity.a aVar;
        LogoActivity logoActivity2;
        LogoActivity logoActivity3;
        com.baidu.tbadk.core.util.TiebaStatic.log(new au("c10793"));
        Intent intent = new Intent();
        intent.putExtra("class", 30);
        intent.putExtra("jump_url", "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + com.baidu.tieba.a.a.Lb().Lj());
        intent.putExtra("is_ad", true);
        TbadkCoreApplication.setIntent(intent);
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        logoActivity = this.aHK.aHJ;
        aVar = logoActivity.aHC;
        hr.removeCallbacks(aVar);
        logoActivity2 = this.aHK.aHJ;
        logoActivity2.aHA = true;
        logoActivity3 = this.aHK.aHJ;
        logoActivity3.HV();
    }
}
