package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    private final /* synthetic */ MetaData bFU;
    private final /* synthetic */ BaseActivity bFW;
    private final /* synthetic */ com.baidu.tbadk.core.data.be bFX;
    private final /* synthetic */ boolean bFY;
    private final /* synthetic */ BdUniqueId bFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(BaseActivity baseActivity, com.baidu.tbadk.core.data.be beVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bFW = baseActivity;
        this.bFX = beVar;
        this.bFU = metaData;
        this.bFY = z;
        this.bFZ = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.fq()) {
            this.bFW.showToast(u.j.neterror);
        } else if (com.baidu.tbadk.core.util.bn.ab(this.bFW.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.bFX.getTid()).s("obj_locate", 2));
            new a(null).a(true, this.bFU.getPortrait(), this.bFU.getUserId(), this.bFY, this.bFZ);
        }
    }
}
