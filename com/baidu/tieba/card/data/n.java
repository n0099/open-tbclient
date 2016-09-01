package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId Ro = BdUniqueId.gen();
    public bg bbC;
    private ay bbV;
    private ay bbW;
    private ay bbX;
    private ay bbY;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ro;
    }

    public n(bg bgVar) {
        this.bbC = bgVar;
    }

    public static boolean c(bg bgVar) {
        return bgVar != null && bgVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg Kw() {
        return this.bbC;
    }

    public int Oe() {
        return (this.bbC == null || StringUtils.isNull(this.bbC.getPhotoLiveCover())) ? 0 : 1;
    }

    public void c(ay ayVar) {
        this.bbV = ayVar;
    }

    public void d(ay ayVar) {
        this.bbW = ayVar;
    }

    public void e(ay ayVar) {
        this.bbX = ayVar;
    }

    public void f(ay ayVar) {
        this.bbY = ayVar;
    }

    public ay Of() {
        return this.bbV != null ? this.bbV.ab("obj_param3", ap.NC()) : this.bbV;
    }

    public ay Og() {
        return this.bbW != null ? this.bbW.ab("obj_param3", ap.NC()) : this.bbW;
    }

    public ay Oh() {
        return this.bbY != null ? this.bbY.ab("obj_param3", ap.NC()) : this.bbY;
    }

    public ay Oi() {
        return this.bbX != null ? this.bbX.ab("obj_param3", ap.NC()) : this.bbX;
    }
}
