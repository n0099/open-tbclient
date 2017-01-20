package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ bh bPK;
    private final /* synthetic */ MetaData bUm;
    private final /* synthetic */ BaseActivity bUo;
    private final /* synthetic */ boolean bUp;
    private final /* synthetic */ BdUniqueId bUq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bh bhVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bUo = baseActivity;
        this.bPK = bhVar;
        this.bUm = metaData;
        this.bUp = z;
        this.bUq = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.gk()) {
            this.bUo.showToast(r.l.neterror);
        } else if (bf.ak(this.bUo.getApplicationContext())) {
            TiebaStatic.log(new ar("c10803").ab("tid", this.bPK.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.d.a(null).a(true, this.bUm.getPortrait(), this.bUm.getUserId(), this.bUp, this.bUq);
        }
    }
}
