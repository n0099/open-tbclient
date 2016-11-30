package com.baidu.tieba.frs.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.frs.e.s {
    private z.b ahd;
    private z.a ahe;
    private z.c ahf;
    private com.baidu.tieba.frs.g.d bSp;
    private final CustomMessageListener ckk;
    private final BdExpandListView.a ckl;

    public y(FrsActivity frsActivity) {
        super(frsActivity);
        this.ckk = new z(this, CmdConfigCustom.CMD_REFRESH);
        this.ahd = new aa(this);
        this.ahf = new ab(this);
        this.ahe = new ad(this);
        this.ckl = new ae(this);
        this.bSp = this.bZY.abR();
        this.bRW.a(this.ckl);
        this.bZY.registerListener(this.ckk);
    }

    public void b(au auVar, boolean z) {
        if (auVar != null) {
            if (z) {
                auVar.adr();
                auVar.a(this.ahd);
                auVar.a(this.ahf);
                auVar.a(this.ahe);
                return;
            }
            auVar.ads();
            auVar.a(this.ckl);
        }
    }
}
