package com.baidu.tieba.frs.h;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.frs.d.s {
    private z.b agw;
    private z.a agx;
    private z.c agy;
    private final CustomMessageListener bPt;
    private final BdExpandListView.a bPu;
    private com.baidu.tieba.frs.f.d byz;

    public ad(FrsActivity frsActivity) {
        super(frsActivity);
        this.bPt = new ae(this, CmdConfigCustom.CMD_REFRESH);
        this.agw = new af(this);
        this.agy = new ag(this);
        this.agx = new ai(this);
        this.bPu = new aj(this);
        this.byz = this.bFI.Wg();
        this.byg.a(this.bPu);
        this.bFI.registerListener(this.bPt);
    }

    public void b(ax axVar, boolean z) {
        if (axVar != null) {
            if (z) {
                axVar.XH();
                axVar.a(this.agw);
                axVar.a(this.agy);
                axVar.a(this.agx);
                return;
            }
            axVar.XI();
            axVar.a(this.bPu);
        }
    }
}
