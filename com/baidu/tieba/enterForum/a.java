package com.baidu.tieba.enterForum;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class a {
    private static an a(String str, bj bjVar, String str2) {
        if (bjVar == null) {
            return null;
        }
        an anVar = new an(str);
        anVar.cI("tid", bjVar.getTid());
        anVar.t("fid", bjVar.getFid());
        anVar.cI("resource_id", str2);
        return anVar;
    }

    private static int ai(bj bjVar) {
        if (bjVar.getType() == bj.dqR || bjVar.aMx()) {
            return 2;
        }
        if (bjVar.aJr() || bjVar.aJs()) {
            return 3;
        }
        return 1;
    }

    public static an g(bj bjVar, String str) {
        if (bjVar == null) {
            return null;
        }
        an a = a("c13629", bjVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.af("obj_locate", bjVar.dpd);
        a.af("obj_source", bjVar.threadType);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        a.af("obj_type", bjVar.aLF());
        if (bjVar.aMc() != null) {
            a.af("obj_name", bjVar.aMc().kTp ? 1 : 0);
        }
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
        }
        if (bjVar.aKC() != null) {
            a.af(TiebaInitialize.Params.AB_TYPE, bjVar.aKC().getIsLike() ? 1 : 0);
        }
        a.af("is_full", bjVar.aMp() ? 1 : 0);
        return a;
    }

    public static an h(bj bjVar, String str) {
        if (bjVar == null) {
            return null;
        }
        an a = a("c13628", bjVar, str);
        a.af("obj_locate", bjVar.dpd);
        a.af("obj_source", bjVar.threadType);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        a.cI("obj_name", bjVar.mRecomAbTag);
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
            a.cI("obj_param6", bjVar.getBaijiahaoData().oriUgcVid);
        }
        if (bjVar.dtq > 0) {
            a.af("midpageflag", 1);
        } else {
            a.af("midpageflag", 0);
        }
        if (bjVar.aKC() != null) {
            a.af(TiebaInitialize.Params.AB_TYPE, bjVar.aKC().getIsLike() ? 1 : 0);
        }
        return a;
    }

    public static an i(bj bjVar, String str) {
        an a;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.getType() == bj.dqZ) {
            a = a("c13636", bjVar, str);
            if (bjVar.getBaijiahaoData() != null) {
                a.cI("obj_param6", bjVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13633", bjVar, str);
            a.af("obj_type", bjVar.aLF());
        }
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.af("obj_locate", bjVar.dpd);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static an j(bj bjVar, String str) {
        an anVar;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.getType() == bj.dqZ) {
            an a = a("c13637", bjVar, str);
            if (bjVar.getBaijiahaoData() != null) {
                a.cI("obj_param6", bjVar.getBaijiahaoData().oriUgcVid);
            }
            if (bjVar.dtq > 0) {
                a.af("midpageflag", 1);
                anVar = a;
            } else {
                a.af("midpageflag", 0);
                anVar = a;
            }
        } else {
            an a2 = a("c13631", bjVar, str);
            a2.af("obj_type", bjVar.aLF());
            a2.af("is_full", bjVar.aMp() ? 1 : 0);
            anVar = a2;
        }
        anVar.t("uid", TbadkApplication.getCurrentAccountId());
        anVar.af("obj_locate", bjVar.dpd);
        anVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        anVar.af("obj_param5", ai(bjVar));
        if (bjVar.getBaijiahaoData() != null) {
            anVar.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
            return anVar;
        }
        return anVar;
    }

    public static an k(bj bjVar, String str) {
        if (bjVar == null) {
            return null;
        }
        an a = a("c13632", bjVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.af("obj_locate", bjVar.dpd);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        a.af("obj_type", bjVar.aLF());
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
        }
        a.af("is_full", bjVar.aMp() ? 1 : 0);
        return a;
    }

    public static an l(bj bjVar, String str) {
        if (bjVar == null) {
            return null;
        }
        an a = a("c13638", bjVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.af("obj_locate", bjVar.dpd);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
            a.cI("obj_param6", bjVar.getBaijiahaoData().oriUgcVid);
            return a;
        }
        return a;
    }

    public static an m(bj bjVar, String str) {
        an a;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.getType() == bj.dqZ) {
            a = a("c13639", bjVar, str);
            a.af("obj_type", 1);
            if (bjVar.getBaijiahaoData() != null) {
                a.cI("obj_param6", bjVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13634", bjVar, str);
            a.af("obj_type", bjVar.aLF());
        }
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.af("obj_locate", bjVar.dpd);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.af("obj_param5", ai(bjVar));
        if (bjVar.getBaijiahaoData() != null) {
            a.cI("obj_param4", bjVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static an a(al alVar, String str) {
        an anVar;
        if (alVar == null) {
            return null;
        }
        if (alVar.cardType == 2 || alVar.cardType == 6 || alVar.cardType == 8) {
            anVar = new an("c13640");
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            anVar = new an("c13635");
            anVar.af(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        anVar.t("uid", TbadkApplication.getCurrentAccountId());
        anVar.cI("tid", alVar.getTid());
        anVar.cI("fid", alVar.getFid());
        anVar.cI("resource_id", str);
        return anVar;
    }
}
