package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ah biT;
    final /* synthetic */ fa blR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar, com.baidu.tbadk.core.data.ah ahVar) {
        this.blR = faVar;
        this.biT = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String url;
        Context context2;
        Context context3;
        context = this.blR.mContext;
        if (com.baidu.tbadk.core.util.bi.ah(context) && this.biT != null && this.biT.getAuthor() != null && this.biT.getAuthor().getTShowInfoNew() != null) {
            ArrayList<IconData> tShowInfoNew = this.biT.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.o(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.x.b(tShowInfoNew, 0) != null && (url = this.biT.getAuthor().getTShowInfoNew().get(0).getUrl()) != null) {
                context2 = this.blR.mContext;
                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                    com.baidu.tbadk.core.util.be wt = com.baidu.tbadk.core.util.be.wt();
                    context3 = this.blR.mContext;
                    wt.c((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                }
            }
        }
    }
}
