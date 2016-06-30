package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId Op = BdUniqueId.gen();
    public az aVc;
    private ay aVv;
    private ay aVw;
    private ay aVx;
    private ay aVy;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }

    public n(az azVar) {
        this.aVc = azVar;
    }

    public static boolean c(az azVar) {
        return azVar != null && azVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.a.c
    public az Ix() {
        return this.aVc;
    }

    public int LB() {
        return (this.aVc == null || StringUtils.isNull(this.aVc.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(ay ayVar) {
        this.aVv = ayVar;
    }

    public void c(ay ayVar) {
        this.aVw = ayVar;
    }

    public void d(ay ayVar) {
        this.aVx = ayVar;
    }

    public void e(ay ayVar) {
        this.aVy = ayVar;
    }

    public ay LC() {
        return this.aVv != null ? this.aVv.ab("obj_param3", at.La()) : this.aVv;
    }

    public ay LD() {
        return this.aVw != null ? this.aVw.ab("obj_param3", at.La()) : this.aVw;
    }

    public ay LE() {
        return this.aVy != null ? this.aVy.ab("obj_param3", at.La()) : this.aVy;
    }

    public ay LF() {
        return this.aVx != null ? this.aVx.ab("obj_param3", at.La()) : this.aVx;
    }
}
