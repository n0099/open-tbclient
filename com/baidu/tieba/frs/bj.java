package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    private final /* synthetic */ MetaData bQV;
    private final /* synthetic */ BaseActivity bQX;
    private final /* synthetic */ com.baidu.tbadk.core.data.bi bQY;
    private final /* synthetic */ boolean bQZ;
    private final /* synthetic */ BdUniqueId bRa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(BaseActivity baseActivity, com.baidu.tbadk.core.data.bi biVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bQX = baseActivity;
        this.bQY = biVar;
        this.bQV = metaData;
        this.bQZ = z;
        this.bRa = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.bQX.showToast(r.j.neterror);
        } else if (com.baidu.tbadk.core.util.bm.ak(this.bQX.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10803").ab("tid", this.bQY.getTid()).s("obj_locate", 2));
            new a(null).a(true, this.bQV.getPortrait(), this.bQV.getUserId(), this.bQZ, this.bRa);
        }
    }
}
