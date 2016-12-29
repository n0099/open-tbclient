package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public bg beB;
    private at beC;
    private at beD;
    private at beE;
    private at beF;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }

    public n(bg bgVar) {
        this.beB = bgVar;
    }

    public static boolean l(bg bgVar) {
        return bgVar != null && bgVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg IU() {
        return this.beB;
    }

    public int Pf() {
        return (this.beB == null || StringUtils.isNull(this.beB.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(at atVar) {
        this.beC = atVar;
    }

    public void c(at atVar) {
        this.beD = atVar;
    }

    public void d(at atVar) {
        this.beE = atVar;
    }

    public void e(at atVar) {
        this.beF = atVar;
    }

    public at Pg() {
        return this.beC != null ? this.beC.ab("obj_param3", ap.OA()) : this.beC;
    }

    public at Ph() {
        return this.beD != null ? this.beD.ab("obj_param3", ap.OA()) : this.beD;
    }

    public at Pi() {
        return this.beF != null ? this.beF.ab("obj_param3", ap.OA()) : this.beF;
    }

    public at Pj() {
        return this.beE != null ? this.beE.ab("obj_param3", ap.OA()) : this.beE;
    }
}
