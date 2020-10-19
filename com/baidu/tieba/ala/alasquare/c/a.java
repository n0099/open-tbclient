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
    private static a fYu;
    private List<aq> fCy;

    public static a bKA() {
        if (fYu == null) {
            synchronized (a.class) {
                if (fYu == null) {
                    fYu = new a();
                }
            }
        }
        return fYu;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fCy == null) {
                this.fCy = new ArrayList();
            }
            if (this.fCy != null) {
                this.fCy.add(aqVar);
            }
        }
    }

    public void FL(String str) {
        if (str != null) {
            if (this.fCy == null) {
                this.fCy = new ArrayList();
            }
            if (this.fCy != null) {
                this.fCy.add(new aq(str));
            }
        }
    }

    public void bHY() {
        if (y.getCount(this.fCy) != 0) {
            for (aq aqVar : this.fCy) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fCy.clear();
        }
    }

    public void lm(boolean z) {
        if (y.getCount(this.fCy) != 0) {
            for (aq aqVar : this.fCy) {
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
            this.fCy.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        String str3 = "";
        if (bwVar.biB() != null && !StringUtils.isNull(bwVar.biB().appId)) {
            str3 = bwVar.biB().appId;
        }
        aq aqVar = new aq(str);
        aqVar.aj("obj_type", 1);
        aqVar.u("obj_id", S(bwVar));
        aqVar.dK("tid", bwVar.getId());
        aqVar.dK(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.aj("entryid", i2);
        aqVar.dK("name", str2);
        aqVar.aj("is_small_follow", i);
        return aqVar;
    }

    private long S(bw bwVar) {
        if (bwVar == null || bwVar.biB() == null) {
            return -1L;
        }
        return bwVar.biB().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.aj("obj_source", i);
        aqVar.aj("obj_type", i2);
        aqVar.dK("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
