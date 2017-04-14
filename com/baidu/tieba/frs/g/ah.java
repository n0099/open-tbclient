package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.frs.mc.w {
    private ab.b alp;
    private ab.a alq;
    private ab.c alr;
    private com.baidu.tieba.frs.smartsort.c bMW;
    private final CustomMessageListener cbP;
    private final BdExpandListView.a cbQ;

    public ah(FrsActivity frsActivity) {
        super(frsActivity);
        this.cbP = new ai(this, CmdConfigCustom.CMD_REFRESH);
        this.alp = new aj(this);
        this.alr = new ak(this);
        this.alq = new am(this);
        this.cbQ = new an(this);
        this.bMW = this.bST.YS();
        this.bMD.a(this.cbQ);
        this.bST.registerListener(this.cbP);
    }

    public void a(az azVar, boolean z) {
        if (azVar != null) {
            if (z) {
                azVar.aan();
                azVar.a(this.alp);
                azVar.a(this.alr);
                azVar.a(this.alq);
                return;
            }
            azVar.aao();
            azVar.a(this.cbQ);
        }
    }
}
