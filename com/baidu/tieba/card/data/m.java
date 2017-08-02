package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private aj bIA;
    private aj bIB;
    private aj bIC;
    private aj bIz;
    public bl bbB;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }

    public m(bl blVar) {
        this.bbB = blVar;
    }

    public static boolean B(bl blVar) {
        return blVar != null && blVar.getThreadType() == 33;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MA() {
        return this.bbB;
    }

    public int WP() {
        return (this.bbB == null || StringUtils.isNull(this.bbB.getPhotoLiveCover())) ? 0 : 1;
    }

    public void b(aj ajVar) {
        this.bIz = ajVar;
    }

    public void c(aj ajVar) {
        this.bIA = ajVar;
    }

    public void d(aj ajVar) {
        this.bIB = ajVar;
    }

    public void e(aj ajVar) {
        this.bIC = ajVar;
    }

    public aj WQ() {
        return this.bIz != null ? this.bIz.aa("obj_param3", com.baidu.tieba.card.m.Wn()) : this.bIz;
    }

    public aj WR() {
        return this.bIA != null ? this.bIA.aa("obj_param3", com.baidu.tieba.card.m.Wn()) : this.bIA;
    }

    public aj WS() {
        return this.bIC != null ? this.bIC.aa("obj_param3", com.baidu.tieba.card.m.Wn()) : this.bIC;
    }

    public aj WT() {
        return this.bIB != null ? this.bIB.aa("obj_param3", com.baidu.tieba.card.m.Wn()) : this.bIB;
    }
}
