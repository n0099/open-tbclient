package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ bg bJs;
    private final /* synthetic */ MetaData bNY;
    private final /* synthetic */ boolean bOa;
    private final /* synthetic */ BdUniqueId bOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bg bgVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.bDq = baseActivity;
        this.bJs = bgVar;
        this.bNY = metaData;
        this.bOa = z;
        this.bOb = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.bDq.showToast(r.j.neterror);
        } else if (bh.ai(this.bDq.getApplicationContext())) {
            TiebaStatic.log(new at("c10803").ab("tid", this.bJs.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.d.a(null).a(true, this.bNY.getPortrait(), this.bNY.getUserId(), this.bOa, this.bOb);
        }
    }
}
