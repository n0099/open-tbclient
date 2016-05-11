package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnClickListener {
    private final /* synthetic */ MetaData bje;
    private final /* synthetic */ BaseActivity bjg;
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(BaseActivity baseActivity, com.baidu.tbadk.core.data.ax axVar, MetaData metaData) {
        this.bjg = baseActivity;
        this.bjh = axVar;
        this.bje = metaData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.i.fq()) {
            this.bjg.showToast(t.j.neterror);
        } else if (com.baidu.tbadk.core.util.bl.ac(this.bjg.getApplicationContext())) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10803").ac("tid", this.bjh.getTid()).s("obj_locate", 2));
            new a(null).a(true, this.bje.getPortrait(), this.bje.getUserId());
        }
    }
}
