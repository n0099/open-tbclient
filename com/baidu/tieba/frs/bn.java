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
    private final /* synthetic */ MetaData bEH;
    private final /* synthetic */ BaseActivity bEJ;
    private final /* synthetic */ com.baidu.tbadk.core.data.az bEK;
    private final /* synthetic */ boolean bEL;
    private final /* synthetic */ BdUniqueId bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(BaseActivity baseActivity, com.baidu.tbadk.core.data.az azVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bEJ = baseActivity;
        this.bEK = azVar;
        this.bEH = metaData;
        this.bEL = z;
        this.bEM = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.fr()) {
            this.bEJ.showToast(u.j.neterror);
        } else if (com.baidu.tbadk.core.util.bn.ab(this.bEJ.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.bEK.getTid()).s("obj_locate", 2));
            new a(null).a(true, this.bEH.getPortrait(), this.bEH.getUserId(), this.bEL, this.bEM);
        }
    }
}
