package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.frs.mc.w {
    private ae.b alb;
    private ae.a alc;
    private ae.c ald;
    private com.baidu.tieba.frs.smartsort.c bUp;
    private final CustomMessageListener cic;
    private final BdExpandListView.a cie;

    public ag(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.cic = new ah(this, CmdConfigCustom.CMD_REFRESH);
        this.alb = new ai(this);
        this.ald = new aj(this);
        this.alc = new al(this);
        this.cie = new am(this);
        this.bUp = rVar.ZX();
        rVar.registerListener(this.cic);
    }

    public void a(au auVar, boolean z) {
        if (auVar != null) {
            auVar.ej(z);
            auVar.a(this.alb);
            auVar.a(this.ald);
            auVar.a(this.alc);
        }
    }
}
