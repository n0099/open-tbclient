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
    private final /* synthetic */ bi bYY;
    private final /* synthetic */ MetaData ccq;
    private final /* synthetic */ BaseActivity ccs;
    private final /* synthetic */ boolean cct;
    private final /* synthetic */ BdUniqueId ccu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bi biVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.ccs = baseActivity;
        this.bYY = biVar;
        this.ccq = metaData;
        this.cct = z;
        this.ccu = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.ccs.showToast(w.l.neterror);
        } else if (bg.aK(this.ccs.getApplicationContext())) {
            TiebaStatic.log(new as("c10803").aa("tid", this.bYY.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.ccq.getPortrait(), this.ccq.getUserId(), this.cct, this.ccu);
        }
    }
}
