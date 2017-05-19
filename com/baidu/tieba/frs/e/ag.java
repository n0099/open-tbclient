package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.frs.mc.w {
    private ae.b alm;
    private ae.a aln;
    private ae.c alo;
    private com.baidu.tieba.frs.smartsort.c bOC;
    private final CustomMessageListener cbP;
    private final BdExpandListView.a cbQ;

    public ag(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.cbP = new ah(this, CmdConfigCustom.CMD_REFRESH);
        this.alm = new ai(this);
        this.alo = new aj(this);
        this.aln = new al(this);
        this.cbQ = new am(this);
        this.bOC = rVar.YT();
        rVar.registerListener(this.cbP);
    }

    public void a(at atVar, boolean z) {
        if (atVar != null) {
            atVar.dT(z);
            atVar.a(this.alm);
            atVar.a(this.alo);
            atVar.a(this.aln);
        }
    }
}
