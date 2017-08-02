package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class l extends c {
    public bl threadData;
    public static String bIl = "";
    public static String bIm = "";
    public static String bIn = "";
    public static String bIo = "";
    public static String bIp = "";
    public static String bIq = "";
    public static String bIr = "";
    public static String bIs = "";
    public static String bIt = "";
    public static String bIu = "";
    public static String bIv = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId XF = BdUniqueId.gen();
    public boolean bIx = false;
    public boolean isLinkThread = false;
    public boolean bIy = false;
    public boolean aCd = true;

    public static boolean B(bl blVar) {
        if (blVar == null) {
            return false;
        }
        return blVar.getType() == bl.XE || blVar.getType() == bl.XG || blVar.getType() == bl.XF;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bIx) {
            return bIw;
        }
        if (this.isLinkThread) {
            return XF;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bl MA() {
        return this.threadData;
    }

    public boolean WI() {
        return (this.threadData == null || u.u(this.threadData.rJ()) == 0) ? false : true;
    }

    public aj WJ() {
        if (WI()) {
            aj je = je(bIq);
            if (je != null && MA() != null) {
                bl MA = MA();
                je.r("obj_name", MA.sK() != null && (MA.sK().aAE() != null || MA.sK().Io() != null) ? 1 : 0);
            }
            return je;
        }
        aj je2 = je(bIl);
        if (je2 != null) {
            je2.aa("ab_tag", WC()).aa("ab_action", "show");
            if (MA() != null) {
                bl MA2 = MA();
                je2.r("obj_name", MA2.sK() != null && (MA2.sK().aAE() != null || MA2.sK().Io() != null) ? 1 : 0);
            }
        }
        return je2;
    }

    public aj jf(String str) {
        aj je = je(str);
        if (je != null) {
            je.f("fid", this.threadData.getFid());
            je.aa("tid", this.threadData.getTid());
            je.r("obj_type", this.threadData.isLinkThread() ? 4 : 1);
        }
        return je;
    }

    public aj jg(String str) {
        aj je = je(str);
        if (je != null) {
            je.aa("ab_tag", WC()).aa("ab_action", "show");
            if (MA() != null) {
                bl MA = MA();
                je.r("obj_name", MA.sK() != null && (MA.sK().aAE() != null || MA.sK().Io() != null) ? 1 : 0);
            }
        }
        return je;
    }

    public aj jh(String str) {
        aj je = je(str);
        if (je != null) {
            je.aa("ab_tag", WC()).aa("ab_action", "click");
        }
        return je;
    }

    public aj WK() {
        if (WI()) {
            return je(bIr);
        }
        aj je = je(bIm);
        if (je != null) {
            je.aa("ab_tag", WC()).aa("ab_action", "click");
            return je;
        }
        return je;
    }

    public aj WL() {
        if (WI()) {
            return je(bIs);
        }
        aj J = J(bIn, 0);
        if (J != null) {
            J.aa("ab_tag", WC()).aa("ab_action", "click");
            return J;
        }
        return J;
    }

    public aj WM() {
        if (WI()) {
            return je(bIt);
        }
        aj je = je(bIo);
        if (je != null) {
            je.aa("ab_tag", WC()).aa("ab_action", "click");
            return je;
        }
        return je;
    }

    public aj WN() {
        if (WI()) {
            return je(bIu);
        }
        aj je = je(bIp);
        if (je != null) {
            je.aa("ab_tag", WC()).aa("ab_action", "click");
            return je;
        }
        return je;
    }

    public aj WO() {
        return je(bIv);
    }

    public aj ji(String str) {
        return je(str);
    }
}
