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
    private static a gom;
    private List<aq> fQJ;

    public static a bPC() {
        if (gom == null) {
            synchronized (a.class) {
                if (gom == null) {
                    gom = new a();
                }
            }
        }
        return gom;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fQJ == null) {
                this.fQJ = new ArrayList();
            }
            if (this.fQJ != null) {
                this.fQJ.add(aqVar);
            }
        }
    }

    public void Gy(String str) {
        if (str != null) {
            if (this.fQJ == null) {
                this.fQJ = new ArrayList();
            }
            if (this.fQJ != null) {
                this.fQJ.add(new aq(str));
            }
        }
    }

    public void bMp() {
        if (y.getCount(this.fQJ) != 0) {
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fQJ.clear();
        }
    }

    public void lN(boolean z) {
        if (y.getCount(this.fQJ) != 0) {
            for (aq aqVar : this.fQJ) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.fQJ.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        String str3 = "";
        if (bwVar.bmU() != null && !StringUtils.isNull(bwVar.bmU().appId)) {
            str3 = bwVar.bmU().appId;
        }
        aq aqVar = new aq(str);
        aqVar.al("obj_type", 1);
        aqVar.w("obj_id", S(bwVar));
        aqVar.dR("tid", bwVar.getId());
        aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.al("entryid", i2);
        aqVar.dR("name", str2);
        aqVar.al("is_small_follow", i);
        return aqVar;
    }

    private long S(bw bwVar) {
        if (bwVar == null || bwVar.bmU() == null) {
            return -1L;
        }
        return bwVar.bmU().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.al("obj_source", i);
        aqVar.al("obj_type", i2);
        aqVar.dR("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
