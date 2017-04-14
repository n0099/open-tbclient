package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ bi bWH;
    private final /* synthetic */ MetaData bZZ;
    private final /* synthetic */ BaseActivity cab;
    private final /* synthetic */ boolean cac;
    private final /* synthetic */ BdUniqueId cad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bi biVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.cab = baseActivity;
        this.bWH = biVar;
        this.bZZ = metaData;
        this.cac = z;
        this.cad = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.hj()) {
            this.cab.showToast(w.l.neterror);
        } else if (bg.aK(this.cab.getApplicationContext())) {
            TiebaStatic.log(new as("c10803").aa("tid", this.bWH.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.bZZ.getPortrait(), this.bZZ.getUserId(), this.cac, this.cad);
        }
    }
}
