package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.frs.mc.u {
    private ab.b ala;
    private ab.a alb;
    private ab.c alc;
    private com.baidu.tieba.frs.smartsort.c bNg;
    private final CustomMessageListener cdo;
    private final BdExpandListView.a cdp;

    public ah(FrsActivity frsActivity) {
        super(frsActivity);
        this.cdo = new ai(this, CmdConfigCustom.CMD_REFRESH);
        this.ala = new aj(this);
        this.alc = new ak(this);
        this.alb = new am(this);
        this.cdp = new an(this);
        this.bNg = this.bTf.Yw();
        this.bMN.a(this.cdp);
        this.bTf.registerListener(this.cdo);
    }

    public void a(ax axVar, boolean z) {
        if (axVar != null) {
            if (z) {
                axVar.ZP();
                axVar.a(this.ala);
                axVar.a(this.alc);
                axVar.a(this.alb);
                return;
            }
            axVar.ZQ();
            axVar.a(this.cdp);
        }
    }
}
