package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class er implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.z bgh;
    final /* synthetic */ ep biW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(ep epVar, com.baidu.tbadk.core.data.z zVar) {
        this.biW = epVar;
        this.bgh = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String url;
        Context context2;
        Context context3;
        context = this.biW.mContext;
        if (com.baidu.tbadk.core.util.bj.ah(context) && this.bgh != null && this.bgh.getAuthor() != null && this.bgh.getAuthor().getTShowInfoNew() != null) {
            ArrayList<IconData> tShowInfoNew = this.bgh.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.l(tShowInfoNew) != 0 && com.baidu.tbadk.core.util.y.b(tShowInfoNew, 0) != null && (url = this.bgh.getAuthor().getTShowInfoNew().get(0).getUrl()) != null) {
                context2 = this.biW.mContext;
                if (com.baidu.adp.base.l.C(context2) instanceof TbPageContext) {
                    com.baidu.tbadk.core.util.bf vn = com.baidu.tbadk.core.util.bf.vn();
                    context3 = this.biW.mContext;
                    vn.b((TbPageContext) com.baidu.adp.base.l.C(context3), new String[]{url});
                }
            }
        }
    }
}
