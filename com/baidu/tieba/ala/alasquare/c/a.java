package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a giz;
    private List<aq> fKT;

    public static a bNc() {
        if (giz == null) {
            synchronized (a.class) {
                if (giz == null) {
                    giz = new a();
                }
            }
        }
        return giz;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fKT == null) {
                this.fKT = new ArrayList();
            }
            if (this.fKT != null) {
                this.fKT.add(aqVar);
            }
        }
    }

    public void Gk(String str) {
        if (str != null) {
            if (this.fKT == null) {
                this.fKT = new ArrayList();
            }
            if (this.fKT != null) {
                this.fKT.add(new aq(str));
            }
        }
    }

    public void bJQ() {
        if (y.getCount(this.fKT) != 0) {
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fKT.clear();
        }
    }

    public void lE(boolean z) {
        if (y.getCount(this.fKT) != 0) {
            for (aq aqVar : this.fKT) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.fKT.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        String str3 = "";
        if (bwVar.bku() != null && !StringUtils.isNull(bwVar.bku().appId)) {
            str3 = bwVar.bku().appId;
        }
        aq aqVar = new aq(str);
        aqVar.aj("obj_type", 1);
        aqVar.w("obj_id", S(bwVar));
        aqVar.dR("tid", bwVar.getId());
        aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.aj("entryid", i2);
        aqVar.dR("name", str2);
        aqVar.aj("is_small_follow", i);
        return aqVar;
    }

    private long S(bw bwVar) {
        if (bwVar == null || bwVar.bku() == null) {
            return -1L;
        }
        return bwVar.bku().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.aj("obj_source", i);
        aqVar.aj("obj_type", i2);
        aqVar.dR("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
