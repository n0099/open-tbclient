package com.baidu.tieba.ala.alasquare.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static a gFl;
    private List<ar> gfQ;

    public static a bRX() {
        if (gFl == null) {
            synchronized (a.class) {
                if (gFl == null) {
                    gFl = new a();
                }
            }
        }
        return gFl;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfQ == null) {
                this.gfQ = new ArrayList();
            }
            if (this.gfQ != null) {
                this.gfQ.add(arVar);
            }
        }
    }

    public void FX(String str) {
        if (str != null) {
            if (this.gfQ == null) {
                this.gfQ = new ArrayList();
            }
            if (this.gfQ != null) {
                this.gfQ.add(new ar(str));
            }
        }
    }

    public void bOF() {
        if (y.getCount(this.gfQ) != 0) {
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.gfQ.clear();
        }
    }

    public void mG(boolean z) {
        if (y.getCount(this.gfQ) != 0) {
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!arVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(arVar);
                }
            }
            this.gfQ.clear();
        }
    }

    public ar a(int i, String str, int i2, String str2, cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        String str3 = "";
        if (cbVar.boj() != null && !StringUtils.isNull(cbVar.boj().appId)) {
            str3 = cbVar.boj().appId;
        }
        ar arVar = new ar(str);
        arVar.ap("obj_type", 1);
        arVar.v("obj_id", T(cbVar));
        arVar.dR("tid", cbVar.getId());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str3);
        arVar.ap("entryid", i2);
        arVar.dR("name", str2);
        arVar.ap("is_small_follow", i);
        return arVar;
    }

    private long T(cb cbVar) {
        if (cbVar == null || cbVar.boj() == null) {
            return -1L;
        }
        return cbVar.boj().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ar arVar = new ar(str);
        arVar.ap("obj_source", i);
        arVar.ap("obj_type", i2);
        arVar.dR("tid", str2);
        TiebaStatic.log(arVar);
    }
}
