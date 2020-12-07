package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static a gwc;
    private List<ar> fYB;

    public static a bSG() {
        if (gwc == null) {
            synchronized (a.class) {
                if (gwc == null) {
                    gwc = new a();
                }
            }
        }
        return gwc;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.fYB == null) {
                this.fYB = new ArrayList();
            }
            if (this.fYB != null) {
                this.fYB.add(arVar);
            }
        }
    }

    public void GN(String str) {
        if (str != null) {
            if (this.fYB == null) {
                this.fYB = new ArrayList();
            }
            if (this.fYB != null) {
                this.fYB.add(new ar(str));
            }
        }
    }

    public void bPr() {
        if (y.getCount(this.fYB) != 0) {
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.fYB.clear();
        }
    }

    public void mj(boolean z) {
        if (y.getCount(this.fYB) != 0) {
            for (ar arVar : this.fYB) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!arVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(arVar);
                }
            }
            this.fYB.clear();
        }
    }

    public ar a(int i, String str, int i2, String str2, by byVar) {
        if (byVar == null) {
            return null;
        }
        String str3 = "";
        if (byVar.bpj() != null && !StringUtils.isNull(byVar.bpj().appId)) {
            str3 = byVar.bpj().appId;
        }
        ar arVar = new ar(str);
        arVar.al("obj_type", 1);
        arVar.w("obj_id", U(byVar));
        arVar.dY("tid", byVar.getId());
        arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, str3);
        arVar.al("entryid", i2);
        arVar.dY("name", str2);
        arVar.al("is_small_follow", i);
        return arVar;
    }

    private long U(by byVar) {
        if (byVar == null || byVar.bpj() == null) {
            return -1L;
        }
        return byVar.bpj().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ar arVar = new ar(str);
        arVar.al("obj_source", i);
        arVar.al("obj_type", i2);
        arVar.dY("tid", str2);
        TiebaStatic.log(arVar);
    }
}
