package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o aIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aIY = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        bm pO = bm.pO();
        tbPageContext = this.aIY.mContext;
        pO.b(tbPageContext, new String[]{(String) view.getTag()});
    }
}
