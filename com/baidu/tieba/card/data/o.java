package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bh aVi;
    private ar bov;
    private ar bow;
    private ar box;
    private ar boy;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public o(bh bhVar) {
        this.aVi = bhVar;
    }

    public static boolean n(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Ji() {
        return this.aVi;
    }

    public int RV() {
        return (this.aVi == null || StringUtils.isNull(this.aVi.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ar arVar) {
        this.bov = arVar;
    }

    public void c(ar arVar) {
        this.bow = arVar;
    }

    public void d(ar arVar) {
        this.box = arVar;
    }

    public void e(ar arVar) {
        this.boy = arVar;
    }

    public ar RW() {
        return this.bov != null ? this.bov.ab("obj_param3", at.Rr()) : this.bov;
    }

    public ar RX() {
        return this.bow != null ? this.bow.ab("obj_param3", at.Rr()) : this.bow;
    }

    public ar RY() {
        return this.boy != null ? this.boy.ab("obj_param3", at.Rr()) : this.boy;
    }

    public ar RZ() {
        return this.box != null ? this.box.ab("obj_param3", at.Rr()) : this.box;
    }
}
