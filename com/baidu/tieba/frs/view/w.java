package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v chP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.chP = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        int i;
        t tVar2;
        TbPageContext<?> tbPageContext;
        t tVar3;
        at atVar;
        t tVar4;
        t.a aVar;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        Animation animation;
        t tVar9;
        tVar = this.chP.chN;
        i = tVar.mState;
        switch (i) {
            case 0:
                tVar7 = this.chP.chN;
                View view2 = tVar7.chL;
                tVar8 = this.chP.chN;
                animation = tVar8.chI;
                view2.startAnimation(animation);
                tVar9 = this.chP.chN;
                tVar9.aK("c11104", "2");
                return;
            case 1:
                bi vx = bi.vx();
                tVar2 = this.chP.chN;
                tbPageContext = tVar2.mTbPageContext;
                tVar3 = this.chP.chN;
                atVar = tVar3.mRealTimeData;
                vx.c(tbPageContext, new String[]{atVar.getUrl()});
                tVar4 = this.chP.chN;
                aVar = tVar4.chK;
                aVar.removeMessages(1);
                tVar5 = this.chP.chN;
                tVar5.bo(8000L);
                tVar6 = this.chP.chN;
                tVar6.aK("c11104", "1");
                return;
            default:
                return;
        }
    }
}
