package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w cmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cmU = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        int i;
        u uVar2;
        ax axVar;
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
        uVar = this.cmU.cmS;
        i = uVar.mState;
        switch (i) {
            case 0:
                uVar8 = this.cmU.cmS;
                View view2 = uVar8.cmQ;
                uVar9 = this.cmU.cmS;
                animation = uVar9.cmN;
                view2.startAnimation(animation);
                uVar10 = this.cmU.cmS;
                uVar10.aN("c11104", "2");
                return;
            case 1:
                uVar2 = this.cmU.cmS;
                axVar = uVar2.mRealTimeData;
                String url = axVar.getUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                if (url.indexOf("?") > 0) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                sb.append("forum_id=");
                uVar3 = this.cmU.cmS;
                str = uVar3.forumId;
                sb.append(str);
                String sb2 = sb.toString();
                bf vP = bf.vP();
                uVar4 = this.cmU.cmS;
                tbPageContext = uVar4.mTbPageContext;
                vP.c(tbPageContext, new String[]{sb2});
                uVar5 = this.cmU.cmS;
                aVar = uVar5.cmP;
                aVar.removeMessages(1);
                uVar6 = this.cmU.cmS;
                uVar6.bn(8000L);
                uVar7 = this.cmU.cmS;
                uVar7.aN("c11104", "1");
                return;
            default:
                return;
        }
    }
}
