package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aJn;
    private final /* synthetic */ bm clj;
    private final /* synthetic */ MetaData coI;
    private final /* synthetic */ boolean coK;
    private final /* synthetic */ BdUniqueId coL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbPageContext tbPageContext, bm bmVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.aJn = tbPageContext;
        this.clj = bmVar;
        this.coI = metaData;
        this.coK = z;
        this.coL = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.hj()) {
            this.aJn.showToast(w.l.neterror);
        } else if (bl.aN(this.aJn.getPageActivity())) {
            TiebaStatic.log(new au("c10803").Z("tid", this.clj.getTid()).r("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.coI.getPortrait(), this.coI.getUserId(), this.coK, this.coL);
        }
    }
}
