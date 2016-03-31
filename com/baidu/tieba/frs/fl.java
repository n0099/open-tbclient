package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fl implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.as bnE;
    final /* synthetic */ fj bri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(fj fjVar, com.baidu.tbadk.core.data.as asVar) {
        this.bri = fjVar;
        this.bnE = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String url;
        Context context2;
        Context context3;
        context = this.bri.mContext;
        if (com.baidu.tbadk.core.util.bl.ad(context) && this.bnE != null && this.bnE.getAuthor() != null && this.bnE.getAuthor().getTShowInfoNew() != null) {
            ArrayList<IconData> tShowInfoNew = this.bnE.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.p(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.b(tShowInfoNew, 0) != null && (url = this.bnE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null) {
                context2 = this.bri.mContext;
                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                    com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
                    context3 = this.bri.mContext;
                    wM.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{url});
                }
            }
        }
    }
}
