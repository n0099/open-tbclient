package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o aHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aHR = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        bh pK = bh.pK();
        tbPageContext = this.aHR.mContext;
        pK.b(tbPageContext, new String[]{(String) view.getTag()});
    }
}
