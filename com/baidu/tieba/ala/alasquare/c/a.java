package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a gnT;
    private List<ar> fQs;

    public static a bOV() {
        if (gnT == null) {
            synchronized (a.class) {
                if (gnT == null) {
                    gnT = new a();
                }
            }
        }
        return gnT;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fQs == null) {
                this.fQs = new ArrayList();
            }
            if (this.fQs != null) {
                this.fQs.add(arVar);
            }
        }
    }

    public void FZ(String str) {
        if (str != null) {
            if (this.fQs == null) {
                this.fQs = new ArrayList();
            }
            if (this.fQs != null) {
                this.fQs.add(new ar(str));
            }
        }
    }

    public void bLI() {
        if (y.getCount(this.fQs) != 0) {
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fQs.clear();
        }
    }

    public void lO(boolean z) {
        if (y.getCount(this.fQs) != 0) {
            for (ar arVar : this.fQs) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!arVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(arVar);
                }
            }
            this.fQs.clear();
        }
    }

    public ar a(int i, String str, int i2, String str2, bx bxVar) {
        if (bxVar == null) {
            return null;
        }
        String str3 = "";
        if (bxVar.blW() != null && !StringUtils.isNull(bxVar.blW().appId)) {
            str3 = bxVar.blW().appId;
        }
        ar arVar = new ar(str);
        arVar.ak("obj_type", 1);
        arVar.w("obj_id", U(bxVar));
        arVar.dR("tid", bxVar.getId());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str3);
        arVar.ak("entryid", i2);
        arVar.dR("name", str2);
        arVar.ak("is_small_follow", i);
        return arVar;
    }

    private long U(bx bxVar) {
        if (bxVar == null || bxVar.blW() == null) {
            return -1L;
        }
        return bxVar.blW().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ar arVar = new ar(str);
        arVar.ak("obj_source", i);
        arVar.ak("obj_type", i2);
        arVar.dR("tid", str2);
        TiebaStatic.log(arVar);
    }
}
