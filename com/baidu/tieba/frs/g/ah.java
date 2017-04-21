package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.frs.mc.w {
    private ab.b alq;
    private ab.a alr;
    private ab.c als;
    private com.baidu.tieba.frs.smartsort.c bPn;
    private final CustomMessageListener ceg;
    private final BdExpandListView.a ceh;

    public ah(FrsActivity frsActivity) {
        super(frsActivity);
        this.ceg = new ai(this, CmdConfigCustom.CMD_REFRESH);
        this.alq = new aj(this);
        this.als = new ak(this);
        this.alr = new am(this);
        this.ceh = new an(this);
        this.bPn = this.bVk.ZT();
        this.bOU.a(this.ceh);
        this.bVk.registerListener(this.ceg);
    }

    public void a(az azVar, boolean z) {
        if (azVar != null) {
            if (z) {
                azVar.abo();
                azVar.a(this.alq);
                azVar.a(this.als);
                azVar.a(this.alr);
                return;
            }
            azVar.abp();
            azVar.a(this.ceh);
        }
    }
}
