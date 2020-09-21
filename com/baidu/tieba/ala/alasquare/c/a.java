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
    private static a fMd;
    private List<aq> fql;

    public static a bHO() {
        if (fMd == null) {
            synchronized (a.class) {
                if (fMd == null) {
                    fMd = new a();
                }
            }
        }
        return fMd;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fql == null) {
                this.fql = new ArrayList();
            }
            if (this.fql != null) {
                this.fql.add(aqVar);
            }
        }
    }

    public void Fa(String str) {
        if (str != null) {
            if (this.fql == null) {
                this.fql = new ArrayList();
            }
            if (this.fql != null) {
                this.fql.add(new aq(str));
            }
        }
    }

    public void bFm() {
        if (y.getCount(this.fql) != 0) {
            for (aq aqVar : this.fql) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fql.clear();
        }
    }

    public void kO(boolean z) {
        if (y.getCount(this.fql) != 0) {
            for (aq aqVar : this.fql) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.fql.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        String str3 = "";
        if (bwVar.bfS() != null && !StringUtils.isNull(bwVar.bfS().appId)) {
            str3 = bwVar.bfS().appId;
        }
        aq aqVar = new aq(str);
        aqVar.ai("obj_type", 1);
        aqVar.u("obj_id", S(bwVar));
        aqVar.dF("tid", bwVar.getId());
        aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.ai("entryid", i2);
        aqVar.dF("name", str2);
        aqVar.ai("is_small_follow", i);
        return aqVar;
    }

    private long S(bw bwVar) {
        if (bwVar == null || bwVar.bfS() == null) {
            return -1L;
        }
        return bwVar.bfS().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.ai("obj_source", i);
        aqVar.ai("obj_type", i2);
        aqVar.dF("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
