package com.baidu.tieba.frs.utils;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    private final /* synthetic */ bj bWS;
    private final /* synthetic */ BaseActivity cbA;
    private final /* synthetic */ boolean cbB;
    private final /* synthetic */ BdUniqueId cbC;
    private final /* synthetic */ MetaData cby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BaseActivity baseActivity, bj bjVar, MetaData metaData, boolean z, BdUniqueId bdUniqueId) {
        this.cbA = baseActivity;
        this.bWS = bjVar;
        this.cby = metaData;
        this.cbB = z;
        this.cbC = bdUniqueId;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.he()) {
            this.cbA.showToast(w.l.neterror);
        } else if (bg.aI(this.cbA.getApplicationContext())) {
            TiebaStatic.log(new as("c10803").Z("tid", this.bWS.getTid()).s("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.c.a(null).a(true, this.cby.getPortrait(), this.cby.getUserId(), this.cbB, this.cbC);
        }
    }
}
