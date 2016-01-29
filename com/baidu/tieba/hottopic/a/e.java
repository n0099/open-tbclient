package com.baidu.tieba.hottopic.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bJm;
    private final /* synthetic */ com.baidu.tieba.hottopic.data.c bJn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.hottopic.data.c cVar) {
        this.bJm = dVar;
        this.bJn = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext<?> tbPageContext2;
        tbPageContext = this.bJm.Nw;
        if (tbPageContext != null) {
            String XL = this.bJn.XL();
            if (!StringUtils.isNull(XL)) {
                be wt = be.wt();
                tbPageContext2 = this.bJm.Nw;
                wt.c(tbPageContext2, new String[]{XL});
            }
        }
        TiebaStatic.log("c10820");
    }
}
