package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class n extends c {
    public bl aYA;
    public static final BdUniqueId bDy = BdUniqueId.gen();
    public static final BdUniqueId bDz = BdUniqueId.gen();
    public static String bDA = "";
    public static String bDB = "";
    public static String bDC = "";
    public static String bDD = "";
    public static String bDE = "";
    public static String bDF = "";
    public static String bDG = "";
    public boolean bDt = false;
    public boolean bDH = true;
    public int sourceType = 0;

    public n(bl blVar) {
        this.aYA = blVar;
    }

    public static boolean w(bl blVar) {
        return (blVar == null || blVar.rL() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aYA == null) {
            return bDy;
        }
        if (this.aYA.rx() || this.aYA.ry()) {
            return bDz;
        }
        return bDy;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl LH() {
        return this.aYA;
    }

    public as UK() {
        as x = x(bDD, true);
        if (x != null && LH() != null) {
            x.r("obj_name", LH().sG() != null && LH().sG().avd() != null && !au.isEmpty(LH().sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
        }
        return x;
    }

    public as x(bl blVar) {
        return (blVar.sx() == null || blVar.sx().channelId <= 0) ? x(bDE, true) : x(bDF, true);
    }

    public as UM() {
        return x(bDB, true);
    }

    public as y(bl blVar) {
        return (blVar.sx() == null || blVar.sx().channelId <= 0) ? x(bDA, true) : x(bDG, true);
    }
}
