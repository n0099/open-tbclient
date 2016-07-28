package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId OB = BdUniqueId.gen();
    public be aWa;
    private ay aWt;
    private ay aWu;
    private ay aWv;
    private ay aWw;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OB;
    }

    public n(be beVar) {
        this.aWa = beVar;
    }

    public static boolean c(be beVar) {
        return beVar != null && beVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public be Iw() {
        return this.aWa;
    }

    public int LA() {
        return (this.aWa == null || StringUtils.isNull(this.aWa.getPhotoLiveCover())) ? 0 : 1;
    }

    public void c(ay ayVar) {
        this.aWt = ayVar;
    }

    public void d(ay ayVar) {
        this.aWu = ayVar;
    }

    public void e(ay ayVar) {
        this.aWv = ayVar;
    }

    public void f(ay ayVar) {
        this.aWw = ayVar;
    }

    public ay LB() {
        return this.aWt != null ? this.aWt.ab("obj_param3", at.KZ()) : this.aWt;
    }

    public ay LC() {
        return this.aWu != null ? this.aWu.ab("obj_param3", at.KZ()) : this.aWu;
    }

    public ay LD() {
        return this.aWw != null ? this.aWw.ab("obj_param3", at.KZ()) : this.aWw;
    }

    public ay LE() {
        return this.aWv != null ? this.aWv.ab("obj_param3", at.KZ()) : this.aWv;
    }
}
