package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v bUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.bUF = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        int i;
        t tVar2;
        TbPageContext<?> tbPageContext;
        t tVar3;
        am amVar;
        t tVar4;
        t.a aVar;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        Animation animation;
        t tVar9;
        tVar = this.bUF.bUD;
        i = tVar.mState;
        switch (i) {
            case 0:
                tVar7 = this.bUF.bUD;
                View view2 = tVar7.bUB;
                tVar8 = this.bUF.bUD;
                animation = tVar8.bUy;
                view2.startAnimation(animation);
                tVar9 = this.bUF.bUD;
                tVar9.aI("c11104", "2");
                return;
            case 1:
                bi us = bi.us();
                tVar2 = this.bUF.bUD;
                tbPageContext = tVar2.mTbPageContext;
                tVar3 = this.bUF.bUD;
                amVar = tVar3.mRealTimeData;
                us.c(tbPageContext, new String[]{amVar.getUrl()});
                tVar4 = this.bUF.bUD;
                aVar = tVar4.bUA;
                aVar.removeMessages(1);
                tVar5 = this.bUF.bUD;
                tVar5.aX(8000L);
                tVar6 = this.bUF.bUD;
                tVar6.aI("c11104", "1");
                return;
            default:
                return;
        }
    }
}
