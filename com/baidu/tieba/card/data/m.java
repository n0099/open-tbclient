package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private au bEn;
    private au bEo;
    private au bEp;
    private au bEq;
    public bm bai;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bm bmVar) {
        this.bai = bmVar;
    }

    public static boolean x(bm bmVar) {
        return bmVar != null && bmVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bm Mv() {
        return this.bai;
    }

    public int Wh() {
        return (this.bai == null || StringUtils.isNull(this.bai.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(au auVar) {
        this.bEn = auVar;
    }

    public void c(au auVar) {
        this.bEo = auVar;
    }

    public void d(au auVar) {
        this.bEp = auVar;
    }

    public void e(au auVar) {
        this.bEq = auVar;
    }

    public au Wi() {
        return this.bEn != null ? this.bEn.Z("obj_param3", at.VG()) : this.bEn;
    }

    public au Wj() {
        return this.bEo != null ? this.bEo.Z("obj_param3", at.VG()) : this.bEo;
    }

    public au Wk() {
        return this.bEq != null ? this.bEq.Z("obj_param3", at.VG()) : this.bEq;
    }

    public au Wl() {
        return this.bEp != null ? this.bEp.Z("obj_param3", at.VG()) : this.bEp;
    }
}
