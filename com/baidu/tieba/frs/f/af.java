package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.frs.mc.r {
    private aa.b afI;
    private aa.a afJ;
    private aa.c afK;
    private com.baidu.tieba.frs.smartsort.c bFY;
    private final CustomMessageListener bVT;
    private final BdExpandListView.a bVU;

    public af(FrsActivity frsActivity) {
        super(frsActivity);
        this.bVT = new ag(this, CmdConfigCustom.CMD_REFRESH);
        this.afI = new ah(this);
        this.afK = new ai(this);
        this.afJ = new ak(this);
        this.bVU = new al(this);
        this.bFY = this.bLZ.Xx();
        this.bFF.a(this.bVU);
        this.bLZ.registerListener(this.bVT);
    }

    public void a(ax axVar, boolean z) {
        if (axVar != null) {
            if (z) {
                axVar.YQ();
                axVar.a(this.afI);
                axVar.a(this.afK);
                axVar.a(this.afJ);
                return;
            }
            axVar.YR();
            axVar.a(this.bVU);
        }
    }
}
