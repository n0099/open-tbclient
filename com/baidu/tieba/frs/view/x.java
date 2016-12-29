package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w bSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bSe = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        int i;
        u uVar2;
        av avVar;
        u uVar3;
        String str;
        u uVar4;
        TbPageContext<?> tbPageContext;
        u uVar5;
        u.a aVar;
        u uVar6;
        u uVar7;
        u uVar8;
        u uVar9;
        Animation animation;
        u uVar10;
        uVar = this.bSe.bSc;
        i = uVar.mState;
        switch (i) {
            case 0:
                uVar8 = this.bSe.bSc;
                View view2 = uVar8.bSa;
                uVar9 = this.bSe.bSc;
                animation = uVar9.bRX;
                view2.startAnimation(animation);
                uVar10 = this.bSe.bSc;
                uVar10.aJ("c11104", "2");
                return;
            case 1:
                uVar2 = this.bSe.bSc;
                avVar = uVar2.mRealTimeData;
                String url = avVar.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                if (url.indexOf("?") > 0) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                sb.append("forum_id=");
                uVar3 = this.bSe.bSc;
                str = uVar3.forumId;
                sb.append(str);
                String sb2 = sb.toString();
                bc vz = bc.vz();
                uVar4 = this.bSe.bSc;
                tbPageContext = uVar4.mTbPageContext;
                vz.c(tbPageContext, new String[]{sb2});
                uVar5 = this.bSe.bSc;
                aVar = uVar5.bRZ;
                aVar.removeMessages(1);
                uVar6 = this.bSe.bSc;
                uVar6.bb(8000L);
                uVar7 = this.bSe.bSc;
                uVar7.aJ("c11104", "1");
                return;
            default:
                return;
        }
    }
}
