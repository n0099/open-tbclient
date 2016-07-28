package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v bWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.bWF = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        int i;
        t tVar2;
        TbPageContext<?> tbPageContext;
        t tVar3;
        ar arVar;
        t tVar4;
        t.a aVar;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        Animation animation;
        t tVar9;
        tVar = this.bWF.bWD;
        i = tVar.mState;
        switch (i) {
            case 0:
                tVar7 = this.bWF.bWD;
                View view2 = tVar7.bWB;
                tVar8 = this.bWF.bWD;
                animation = tVar8.bWy;
                view2.startAnimation(animation);
                tVar9 = this.bWF.bWD;
                tVar9.aJ("c11104", "2");
                return;
            case 1:
                bi us = bi.us();
                tVar2 = this.bWF.bWD;
                tbPageContext = tVar2.mTbPageContext;
                tVar3 = this.bWF.bWD;
                arVar = tVar3.mRealTimeData;
                us.c(tbPageContext, new String[]{arVar.getUrl()});
                tVar4 = this.bWF.bWD;
                aVar = tVar4.bWA;
                aVar.removeMessages(1);
                tVar5 = this.bWF.bWD;
                tVar5.aS(8000L);
                tVar6 = this.bWF.bWD;
                tVar6.aJ("c11104", "1");
                return;
            default:
                return;
        }
    }
}
