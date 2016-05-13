package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bjh;
    final /* synthetic */ fa bmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bmw = faVar;
        this.bjh = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String url;
        Context context2;
        Context context3;
        context = this.bmw.mContext;
        if (com.baidu.tbadk.core.util.bl.ac(context) && this.bjh != null && this.bjh.getAuthor() != null && this.bjh.getAuthor().getTShowInfoNew() != null) {
            ArrayList<IconData> tShowInfoNew = this.bjh.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.r(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.c(tShowInfoNew, 0) != null && (url = this.bjh.getAuthor().getTShowInfoNew().get(0).getUrl()) != null) {
                context2 = this.bmw.mContext;
                if (com.baidu.adp.base.l.s(context2) instanceof TbPageContext) {
                    com.baidu.tbadk.core.util.bg ut = com.baidu.tbadk.core.util.bg.ut();
                    context3 = this.bmw.mContext;
                    ut.c((TbPageContext) com.baidu.adp.base.l.s(context3), new String[]{url});
                }
            }
        }
    }
}
