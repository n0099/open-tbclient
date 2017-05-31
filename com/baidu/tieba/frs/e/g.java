package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aHZ;
    private final /* synthetic */ bl ccX;
    private final /* synthetic */ MetaData cgs;
    private final /* synthetic */ boolean cgu;
    private final /* synthetic */ BdUniqueId cgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbPageContext tbPageContext, bl blVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.aHZ = tbPageContext;
        this.ccX = blVar;
        this.cgs = metaData;
        this.cgu = z;
        this.cgv = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.aHZ.showToast(w.l.neterror);
        } else if (bh.aN(this.aHZ.getPageActivity())) {
            TiebaStatic.log(new as("c10803").Z("tid", this.ccX.getTid()).r("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.cgs.getPortrait(), this.cgs.getUserId(), this.cgu, this.cgv);
        }
    }
}
