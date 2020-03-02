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
    private static a epS;
    private List<an> dXF;

    public static a bcX() {
        if (epS == null) {
            synchronized (a.class) {
                if (epS == null) {
                    epS = new a();
                }
            }
        }
        return epS;
    }

    public void d(an anVar) {
        if (anVar != null) {
            if (this.dXF == null) {
                this.dXF = new ArrayList();
            }
            if (this.dXF != null) {
                this.dXF.add(anVar);
            }
        }
    }

    public void xI(String str) {
        if (str != null) {
            if (this.dXF == null) {
                this.dXF = new ArrayList();
            }
            if (this.dXF != null) {
                this.dXF.add(new an(str));
            }
        }
    }

    public void bbR() {
        if (v.getCount(this.dXF) != 0) {
            for (an anVar : this.dXF) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dXF.clear();
        }
    }

    public void ib(boolean z) {
        if (v.getCount(this.dXF) != 0) {
            for (an anVar : this.dXF) {
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
            this.dXF.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str3 = "";
        if (bjVar.aCH() != null && !StringUtils.isNull(bjVar.aCH().appId)) {
            str3 = bjVar.aCH().appId;
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
        if (bjVar == null || bjVar.aCH() == null) {
            return -1L;
        }
        return bjVar.aCH().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.X("obj_source", i);
        anVar.X("obj_type", i2);
        anVar.cy("tid", str2);
        TiebaStatic.log(anVar);
    }
}
