package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class l extends c {
    public bl threadData;
    public static String bDg = "";
    public static String bDh = "";
    public static String bDi = "";
    public static String bDj = "";
    public static String bDk = "";
    public static String bDl = "";
    public static String bDm = "";
    public static String bDn = "";
    public static String bDo = "";
    public static String bDp = "";
    public static String bDq = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bDr = BdUniqueId.gen();
    public static final BdUniqueId Xp = BdUniqueId.gen();
    public boolean bDs = false;
    public boolean isLinkThread = false;
    public boolean bDt = false;
    public boolean aAa = true;

    public static boolean w(bl blVar) {
        if (blVar == null) {
            return false;
        }
        return blVar.getType() == bl.Xo || blVar.getType() == bl.Xq || blVar.getType() == bl.Xp;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bDs) {
            return bDr;
        }
        if (this.isLinkThread) {
            return Xp;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl LH() {
        return this.threadData;
    }

    public boolean UJ() {
        return (this.threadData == null || x.q(this.threadData.rI()) == 0) ? false : true;
    }

    public as UK() {
        if (UJ()) {
            as ht = ht(bDl);
            if (ht != null && LH() != null) {
                ht.r("obj_name", LH().sG() != null && LH().sG().avd() != null && !au.isEmpty(LH().sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
            }
            return ht;
        }
        as ht2 = ht(bDg);
        if (ht2 != null) {
            ht2.Z("ab_tag", UD()).Z("ab_action", "show");
            if (LH() != null) {
                ht2.r("obj_name", LH().sG() != null && LH().sG().avd() != null && !au.isEmpty(LH().sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
            }
        }
        return ht2;
    }

    public as ii(String str) {
        as ht = ht(str);
        if (ht != null) {
            ht.Z("ab_tag", UD()).Z("ab_action", "show");
            if (LH() != null) {
                ht.r("obj_name", LH().sG() != null && LH().sG().avd() != null && !au.isEmpty(LH().sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
            }
        }
        return ht;
    }

    public as ij(String str) {
        as ht = ht(str);
        if (ht != null) {
            ht.Z("ab_tag", UD()).Z("ab_action", "click");
        }
        return ht;
    }

    public as UL() {
        if (UJ()) {
            return ht(bDm);
        }
        as ht = ht(bDh);
        if (ht != null) {
            ht.Z("ab_tag", UD()).Z("ab_action", "click");
            return ht;
        }
        return ht;
    }

    public as UM() {
        if (UJ()) {
            return ht(bDn);
        }
        as I = I(bDi, 0);
        if (I != null) {
            I.Z("ab_tag", UD()).Z("ab_action", "click");
            return I;
        }
        return I;
    }

    public as UN() {
        if (UJ()) {
            return ht(bDo);
        }
        as ht = ht(bDj);
        if (ht != null) {
            ht.Z("ab_tag", UD()).Z("ab_action", "click");
            return ht;
        }
        return ht;
    }

    public as UO() {
        if (UJ()) {
            return ht(bDp);
        }
        as ht = ht(bDk);
        if (ht != null) {
            ht.Z("ab_tag", UD()).Z("ab_action", "click");
            return ht;
        }
        return ht;
    }

    public as UP() {
        return ht(bDq);
    }

    public as ik(String str) {
        return ht(str);
    }
}
