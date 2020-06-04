package com.baidu.tieba.enterForum;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class a {
    private static an a(String str, bk bkVar, String str2) {
        if (bkVar == null) {
            return null;
        }
        an anVar = new an(str);
        anVar.dh("tid", bkVar.getTid());
        anVar.s("fid", bkVar.getFid());
        anVar.dh("resource_id", str2);
        return anVar;
    }

    private static int aj(bk bkVar) {
        if (bkVar.getType() == bk.dEN || bkVar.aSw()) {
            return 2;
        }
        if (bkVar.aPm() || bkVar.aPn()) {
            return 3;
        }
        return 1;
    }

    public static an g(bk bkVar, String str) {
        if (bkVar == null) {
            return null;
        }
        an a = a("c13629", bkVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", bkVar.dDb);
        a.ag("obj_source", bkVar.threadType);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        a.ag("obj_type", bkVar.aRE());
        if (bkVar.aSb() != null) {
            a.ag("obj_name", bkVar.aSb().lmP ? 1 : 0);
        }
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
        }
        if (bkVar.aQx() != null) {
            a.ag(TiebaInitialize.Params.AB_TYPE, bkVar.aQx().getIsLike() ? 1 : 0);
        }
        a.ag("is_full", bkVar.aSo() ? 1 : 0);
        return a;
    }

    public static an h(bk bkVar, String str) {
        if (bkVar == null) {
            return null;
        }
        an a = a("c13628", bkVar, str);
        a.ag("obj_locate", bkVar.dDb);
        a.ag("obj_source", bkVar.threadType);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        a.dh("obj_name", bkVar.mRecomAbTag);
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
            a.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
        }
        if (bkVar.dHk > 0) {
            a.ag("midpageflag", 1);
        } else {
            a.ag("midpageflag", 0);
        }
        if (bkVar.aQx() != null) {
            a.ag(TiebaInitialize.Params.AB_TYPE, bkVar.aQx().getIsLike() ? 1 : 0);
        }
        return a;
    }

    public static an i(bk bkVar, String str) {
        an a;
        if (bkVar == null) {
            return null;
        }
        if (bkVar.getType() == bk.dEV) {
            a = a("c13636", bkVar, str);
            if (bkVar.getBaijiahaoData() != null) {
                a.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13633", bkVar, str);
            a.ag("obj_type", bkVar.aRE());
        }
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", bkVar.dDb);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static an j(bk bkVar, String str) {
        an anVar;
        if (bkVar == null) {
            return null;
        }
        if (bkVar.getType() == bk.dEV) {
            an a = a("c13637", bkVar, str);
            if (bkVar.getBaijiahaoData() != null) {
                a.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
            }
            if (bkVar.dHk > 0) {
                a.ag("midpageflag", 1);
                anVar = a;
            } else {
                a.ag("midpageflag", 0);
                anVar = a;
            }
        } else {
            an a2 = a("c13631", bkVar, str);
            a2.ag("obj_type", bkVar.aRE());
            a2.ag("is_full", bkVar.aSo() ? 1 : 0);
            anVar = a2;
        }
        anVar.s("uid", TbadkApplication.getCurrentAccountId());
        anVar.ag("obj_locate", bkVar.dDb);
        anVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        anVar.ag("obj_param5", aj(bkVar));
        if (bkVar.getBaijiahaoData() != null) {
            anVar.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
            return anVar;
        }
        return anVar;
    }

    public static an k(bk bkVar, String str) {
        if (bkVar == null) {
            return null;
        }
        an a = a("c13632", bkVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", bkVar.dDb);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        a.ag("obj_type", bkVar.aRE());
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
        }
        a.ag("is_full", bkVar.aSo() ? 1 : 0);
        return a;
    }

    public static an l(bk bkVar, String str) {
        if (bkVar == null) {
            return null;
        }
        an a = a("c13638", bkVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", bkVar.dDb);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
            a.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
            return a;
        }
        return a;
    }

    public static an m(bk bkVar, String str) {
        an a;
        if (bkVar == null) {
            return null;
        }
        if (bkVar.getType() == bk.dEV) {
            a = a("c13639", bkVar, str);
            a.ag("obj_type", 1);
            if (bkVar.getBaijiahaoData() != null) {
                a.dh("obj_param6", bkVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13634", bkVar, str);
            a.ag("obj_type", bkVar.aRE());
        }
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", bkVar.dDb);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", aj(bkVar));
        if (bkVar.getBaijiahaoData() != null) {
            a.dh("obj_param4", bkVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static an a(ak akVar, String str) {
        an anVar;
        if (akVar == null) {
            return null;
        }
        if (akVar.cardType == 2 || akVar.cardType == 6 || akVar.cardType == 8) {
            anVar = new an("c13640");
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            anVar = new an("c13635");
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        anVar.s("uid", TbadkApplication.getCurrentAccountId());
        anVar.dh("tid", akVar.getTid());
        anVar.dh("fid", akVar.getFid());
        anVar.dh("resource_id", str);
        return anVar;
    }
}
