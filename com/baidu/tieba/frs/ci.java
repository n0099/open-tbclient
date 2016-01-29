package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    private final /* synthetic */ MetaData biQ;
    private final /* synthetic */ BaseActivity biS;
    private final /* synthetic */ com.baidu.tbadk.core.data.ah biT;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.d.a biU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(BaseActivity baseActivity, com.baidu.tbadk.core.data.ah ahVar, com.baidu.tbadk.coreExtra.d.a aVar, MetaData metaData) {
        this.biS = baseActivity;
        this.biT = ahVar;
        this.biU = aVar;
        this.biQ = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.biS.showToast(t.j.neterror);
        } else if (com.baidu.tbadk.core.util.bi.ah(this.biS.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10803").aa("tid", this.biT.getTid()).r("obj_locate", 2));
            this.biU.a(true, this.biQ.getPortrait(), this.biQ.getUserId());
        }
    }
}
