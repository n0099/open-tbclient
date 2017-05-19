package com.baidu.tieba.frs.d;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aIm;
    private final /* synthetic */ bk bWY;
    private final /* synthetic */ MetaData cag;
    private final /* synthetic */ boolean cai;
    private final /* synthetic */ BdUniqueId caj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbPageContext tbPageContext, bk bkVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.aIm = tbPageContext;
        this.bWY = bkVar;
        this.cag = metaData;
        this.cai = z;
        this.caj = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.aIm.showToast(w.l.neterror);
        } else if (bg.aN(this.aIm.getPageActivity())) {
            TiebaStatic.log(new as("c10803").aa("tid", this.bWY.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.cag.getPortrait(), this.cag.getUserId(), this.cai, this.caj);
        }
    }
}
