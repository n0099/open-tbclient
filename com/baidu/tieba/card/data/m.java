package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bl aYA;
    private as bDu;
    private as bDv;
    private as bDw;
    private as bDx;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bl blVar) {
        this.aYA = blVar;
    }

    public static boolean w(bl blVar) {
        return blVar != null && blVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl LH() {
        return this.aYA;
    }

    public int UQ() {
        return (this.aYA == null || StringUtils.isNull(this.aYA.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(as asVar) {
        this.bDu = asVar;
    }

    public void c(as asVar) {
        this.bDv = asVar;
    }

    public void d(as asVar) {
        this.bDw = asVar;
    }

    public void e(as asVar) {
        this.bDx = asVar;
    }

    public as UR() {
        return this.bDu != null ? this.bDu.Z("obj_param3", at.Up()) : this.bDu;
    }

    public as US() {
        return this.bDv != null ? this.bDv.Z("obj_param3", at.Up()) : this.bDv;
    }

    public as UT() {
        return this.bDx != null ? this.bDx.Z("obj_param3", at.Up()) : this.bDx;
    }

    public as UU() {
        return this.bDw != null ? this.bDw.Z("obj_param3", at.Up()) : this.bDw;
    }
}
