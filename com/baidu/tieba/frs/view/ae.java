package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad bwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bwZ = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        int i;
        ab abVar2;
        TbPageContext<?> tbPageContext;
        ab abVar3;
        ak akVar;
        ab abVar4;
        ab.a aVar;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        ab abVar8;
        Animation animation;
        ab abVar9;
        abVar = this.bwZ.bwX;
        i = abVar.mState;
        switch (i) {
            case 0:
                abVar7 = this.bwZ.bwX;
                View view2 = abVar7.bwV;
                abVar8 = this.bwZ.bwX;
                animation = abVar8.bwS;
                view2.startAnimation(animation);
                abVar9 = this.bwZ.bwX;
                abVar9.aG("c11104", "2");
                return;
            case 1:
                bg ut = bg.ut();
                abVar2 = this.bwZ.bwX;
                tbPageContext = abVar2.mTbPageContext;
                abVar3 = this.bwZ.bwX;
                akVar = abVar3.mRealTimeData;
                ut.c(tbPageContext, new String[]{akVar.getUrl()});
                abVar4 = this.bwZ.bwX;
                aVar = abVar4.bwU;
                aVar.removeMessages(1);
                abVar5 = this.bwZ.bwX;
                abVar5.aH(8000L);
                abVar6 = this.bwZ.bwX;
                abVar6.aG("c11104", "1");
                return;
            default:
                return;
        }
    }
}
