package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bd bjD;
    private ak cdG;
    private ak cdH;
    private ak cdI;
    private ak cdJ;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bd bdVar) {
        this.bjD = bdVar;
    }

    public static boolean D(bd bdVar) {
        return bdVar != null && bdVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjD;
    }

    public int ack() {
        return (this.bjD == null || StringUtils.isNull(this.bjD.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.cdG = akVar;
    }

    public void c(ak akVar) {
        this.cdH = akVar;
    }

    public void d(ak akVar) {
        this.cdI = akVar;
    }

    public void e(ak akVar) {
        this.cdJ = akVar;
    }

    public ak acl() {
        return this.cdG != null ? this.cdG.ac("obj_param3", com.baidu.tieba.card.k.abH()) : this.cdG;
    }

    public ak acm() {
        return this.cdH != null ? this.cdH.ac("obj_param3", com.baidu.tieba.card.k.abH()) : this.cdH;
    }

    public ak acn() {
        return this.cdJ != null ? this.cdJ.ac("obj_param3", com.baidu.tieba.card.k.abH()) : this.cdJ;
    }

    public ak aco() {
        return this.cdI != null ? this.cdI.ac("obj_param3", com.baidu.tieba.card.k.abH()) : this.cdI;
    }
}
