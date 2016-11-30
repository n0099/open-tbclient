package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ bk bXx;
    private final /* synthetic */ MetaData ciR;
    private final /* synthetic */ boolean ciT;
    private final /* synthetic */ BdUniqueId ciU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bk bkVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bXg = baseActivity;
        this.bXx = bkVar;
        this.ciR = metaData;
        this.ciT = z;
        this.ciU = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.bXg.showToast(r.j.neterror);
        } else if (com.baidu.tbadk.core.util.bk.ak(this.bXg.getApplicationContext())) {
            TiebaStatic.log(new av("c10803").ab("tid", this.bXx.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.d.a(null).a(true, this.ciR.getPortrait(), this.ciR.getUserId(), this.ciT, this.ciU);
        }
    }
}
