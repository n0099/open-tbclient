package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v chN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.chN = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        int i;
        t tVar2;
        TbPageContext<?> tbPageContext;
        t tVar3;
        av avVar;
        t tVar4;
        t.a aVar;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        Animation animation;
        t tVar9;
        tVar = this.chN.chL;
        i = tVar.mState;
        switch (i) {
            case 0:
                tVar7 = this.chN.chL;
                View view2 = tVar7.chJ;
                tVar8 = this.chN.chL;
                animation = tVar8.chG;
                view2.startAnimation(animation);
                tVar9 = this.chN.chL;
                tVar9.aM("c11104", "2");
                return;
            case 1:
                bh vL = bh.vL();
                tVar2 = this.chN.chL;
                tbPageContext = tVar2.mTbPageContext;
                tVar3 = this.chN.chL;
                avVar = tVar3.mRealTimeData;
                vL.c(tbPageContext, new String[]{avVar.getUrl()});
                tVar4 = this.chN.chL;
                aVar = tVar4.chI;
                aVar.removeMessages(1);
                tVar5 = this.chN.chL;
                tVar5.bo(8000L);
                tVar6 = this.chN.chL;
                tVar6.aM("c11104", "1");
                return;
            default:
                return;
        }
    }
}
