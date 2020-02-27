package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a epR;
    private List<an> dXE;

    public static a bcV() {
        if (epR == null) {
            synchronized (a.class) {
                if (epR == null) {
                    epR = new a();
                }
            }
        }
        return epR;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXE == null) {
                this.dXE = new ArrayList();
            }
            if (this.dXE != null) {
                this.dXE.add(anVar);
            }
        }
    }

    public void xI(String str) {
        if (str != null) {
            if (this.dXE == null) {
                this.dXE = new ArrayList();
            }
            if (this.dXE != null) {
                this.dXE.add(new an(str));
            }
        }
    }

    public void bbP() {
        if (v.getCount(this.dXE) != 0) {
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXE.clear();
        }
    }

    public void ib(boolean z) {
        if (v.getCount(this.dXE) != 0) {
            for (an anVar : this.dXE) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!anVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(anVar);
                }
            }
            this.dXE.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str3 = "";
        if (bjVar.aCF() != null && !StringUtils.isNull(bjVar.aCF().appId)) {
            str3 = bjVar.aCF().appId;
        }
        an anVar = new an(str);
        anVar.X("obj_type", 1);
        anVar.s("obj_id", R(bjVar));
        anVar.cy("tid", bjVar.getId());
        anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.X("entryid", i2);
        anVar.cy("name", str2);
        anVar.X("is_small_follow", i);
        return anVar;
    }

    private long R(bj bjVar) {
        if (bjVar == null || bjVar.aCF() == null) {
            return -1L;
        }
        return bjVar.aCF().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.X("obj_source", i);
        anVar.X("obj_type", i2);
        anVar.cy("tid", str2);
        TiebaStatic.log(anVar);
    }
}
