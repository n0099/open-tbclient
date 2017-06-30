package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.frs.mc.z {
    private ae.b alP;
    private ae.a alQ;
    private ae.c alR;
    private com.baidu.tieba.frs.smartsort.c ccx;
    private final CustomMessageListener cqd;
    private final BdExpandListView.a cqe;

    public x(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.cqd = new y(this, CmdConfigCustom.CMD_REFRESH);
        this.alP = new z(this);
        this.alR = new aa(this);
        this.alQ = new ac(this);
        this.cqe = new ad(this);
        this.ccx = rVar.adO();
        rVar.registerListener(this.cqd);
    }

    public void a(av avVar, boolean z) {
        if (avVar != null) {
            avVar.eB(z);
            avVar.a(this.alP);
            avVar.a(this.alR);
            avVar.a(this.alQ);
        }
    }
}
