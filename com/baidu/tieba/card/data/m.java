package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private ak bVm;
    private ak bVn;
    private ak bVo;
    private ak bVp;
    public bh bff;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bh bhVar) {
        this.bff = bhVar;
    }

    public static boolean A(bh bhVar) {
        return bhVar != null && bhVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh NA() {
        return this.bff;
    }

    public int aaB() {
        return (this.bff == null || StringUtils.isNull(this.bff.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ak akVar) {
        this.bVm = akVar;
    }

    public void c(ak akVar) {
        this.bVn = akVar;
    }

    public void d(ak akVar) {
        this.bVo = akVar;
    }

    public void e(ak akVar) {
        this.bVp = akVar;
    }

    public ak aaC() {
        return this.bVm != null ? this.bVm.ac("obj_param3", com.baidu.tieba.card.m.ZY()) : this.bVm;
    }

    public ak aaD() {
        return this.bVn != null ? this.bVn.ac("obj_param3", com.baidu.tieba.card.m.ZY()) : this.bVn;
    }

    public ak aaE() {
        return this.bVp != null ? this.bVp.ac("obj_param3", com.baidu.tieba.card.m.ZY()) : this.bVp;
    }

    public ak aaF() {
        return this.bVo != null ? this.bVo.ac("obj_param3", com.baidu.tieba.card.m.ZY()) : this.bVo;
    }
}
