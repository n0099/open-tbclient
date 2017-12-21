package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bjI;
    private ak cdY;
    private ak cdZ;
    private ak cea;
    private ak ceb;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bd bdVar) {
        this.bjI = bdVar;
    }

    public static boolean F(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjI;
    }

    public int act() {
        return (this.bjI == null || StringUtils.isNull(this.bjI.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cdY = akVar;
    }

    public void c(ak akVar) {
        this.cdZ = akVar;
    }

    public void d(ak akVar) {
        this.cea = akVar;
    }

    public void e(ak akVar) {
        this.ceb = akVar;
    }

    public ak acu() {
        return this.cdY != null ? this.cdY.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdY;
    }

    public ak acv() {
        return this.cdZ != null ? this.cdZ.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cdZ;
    }

    public ak acw() {
        return this.ceb != null ? this.ceb.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.ceb;
    }

    public ak acx() {
        return this.cea != null ? this.cea.ac("obj_param3", com.baidu.tieba.card.k.abJ()) : this.cea;
    }
}
