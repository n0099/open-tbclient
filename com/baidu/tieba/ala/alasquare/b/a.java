package com.baidu.tieba.ala.alasquare.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static a gCB;
    private List<aq> gdB;

    public static a bRu() {
        if (gCB == null) {
            synchronized (a.class) {
                if (gCB == null) {
                    gCB = new a();
                }
            }
        }
        return gCB;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gdB == null) {
                this.gdB = new ArrayList();
            }
            if (this.gdB != null) {
                this.gdB.add(aqVar);
            }
        }
    }

    public void Fz(String str) {
        if (str != null) {
            if (this.gdB == null) {
                this.gdB = new ArrayList();
            }
            if (this.gdB != null) {
                this.gdB.add(new aq(str));
            }
        }
    }

    public void bOb() {
        if (x.getCount(this.gdB) != 0) {
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gdB.clear();
        }
    }

    public void mC(boolean z) {
        if (x.getCount(this.gdB) != 0) {
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.gdB.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        String str3 = "";
        if (bzVar.bnQ() != null && !StringUtils.isNull(bzVar.bnQ().appId)) {
            str3 = bzVar.bnQ().appId;
        }
        aq aqVar = new aq(str);
        aqVar.an("obj_type", 1);
        aqVar.w("obj_id", S(bzVar));
        aqVar.dW("tid", bzVar.getId());
        aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.an("entryid", i2);
        aqVar.dW("name", str2);
        aqVar.an("is_small_follow", i);
        return aqVar;
    }

    private long S(bz bzVar) {
        if (bzVar == null || bzVar.bnQ() == null) {
            return -1L;
        }
        return bzVar.bnQ().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.an("obj_source", i);
        aqVar.an("obj_type", i2);
        aqVar.dW("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
