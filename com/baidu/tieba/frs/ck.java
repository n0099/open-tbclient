package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    private final /* synthetic */ MetaData bnB;
    private final /* synthetic */ BaseActivity bnD;
    private final /* synthetic */ com.baidu.tbadk.core.data.as bnE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(BaseActivity baseActivity, com.baidu.tbadk.core.data.as asVar, MetaData metaData) {
        this.bnD = baseActivity;
        this.bnE = asVar;
        this.bnB = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.bnD.showToast(t.j.neterror);
        } else if (com.baidu.tbadk.core.util.bl.ad(this.bnD.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").ac("tid", this.bnE.getTid()).r("obj_locate", 2));
            new com.baidu.tbadk.coreExtra.d.a(null).a(true, this.bnB.getPortrait(), this.bnB.getUserId());
        }
    }
}
