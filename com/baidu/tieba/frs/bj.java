package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    private final /* synthetic */ MetaData bRc;
    private final /* synthetic */ BaseActivity bRe;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bRf;
    private final /* synthetic */ boolean bRg;
    private final /* synthetic */ BdUniqueId bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(BaseActivity baseActivity, com.baidu.tbadk.core.data.bg bgVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bRe = baseActivity;
        this.bRf = bgVar;
        this.bRc = metaData;
        this.bRg = z;
        this.bRh = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.bRe.showToast(t.j.neterror);
        } else if (com.baidu.tbadk.core.util.bn.al(this.bRe.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10803").ab("tid", this.bRf.getTid()).s("obj_locate", 2));
            new a(null).a(true, this.bRc.getPortrait(), this.bRc.getUserId(), this.bRg, this.bRh);
        }
    }
}
