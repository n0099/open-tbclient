package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private aj bJJ;
    private aj bJK;
    private aj bJL;
    private aj bJM;
    public bl bcL;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bl blVar) {
        this.bcL = blVar;
    }

    public static boolean B(bl blVar) {
        return blVar != null && blVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MF() {
        return this.bcL;
    }

    public int WU() {
        return (this.bcL == null || StringUtils.isNull(this.bcL.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aj ajVar) {
        this.bJJ = ajVar;
    }

    public void c(aj ajVar) {
        this.bJK = ajVar;
    }

    public void d(aj ajVar) {
        this.bJL = ajVar;
    }

    public void e(aj ajVar) {
        this.bJM = ajVar;
    }

    public aj WV() {
        return this.bJJ != null ? this.bJJ.aa("obj_param3", com.baidu.tieba.card.m.Ws()) : this.bJJ;
    }

    public aj WW() {
        return this.bJK != null ? this.bJK.aa("obj_param3", com.baidu.tieba.card.m.Ws()) : this.bJK;
    }

    public aj WX() {
        return this.bJM != null ? this.bJM.aa("obj_param3", com.baidu.tieba.card.m.Ws()) : this.bJM;
    }

    public aj WY() {
        return this.bJL != null ? this.bJL.aa("obj_param3", com.baidu.tieba.card.m.Ws()) : this.bJL;
    }
}
