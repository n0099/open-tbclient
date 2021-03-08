package com.baidu.tieba.ala.alasquare.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static a gHi;
    private List<ar> ghy;

    public static a bSk() {
        if (gHi == null) {
            synchronized (a.class) {
                if (gHi == null) {
                    gHi = new a();
                }
            }
        }
        return gHi;
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.ghy == null) {
                this.ghy = new ArrayList();
            }
            if (this.ghy != null) {
                this.ghy.add(arVar);
            }
        }
    }

    public void Gh(String str) {
        if (str != null) {
            if (this.ghy == null) {
                this.ghy = new ArrayList();
            }
            if (this.ghy != null) {
                this.ghy.add(new ar(str));
            }
        }
    }

    public void bOS() {
        if (y.getCount(this.ghy) != 0) {
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    TiebaStatic.log(arVar);
                }
            }
            this.ghy.clear();
        }
    }

    public void mG(boolean z) {
        if (y.getCount(this.ghy) != 0) {
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!arVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(arVar);
                }
            }
            this.ghy.clear();
        }
    }

    public ar a(int i, String str, int i2, String str2, cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        String str3 = "";
        if (cbVar.bol() != null && !StringUtils.isNull(cbVar.bol().appId)) {
            str3 = cbVar.bol().appId;
        }
        ar arVar = new ar(str);
        arVar.aq("obj_type", 1);
        arVar.v("obj_id", T(cbVar));
        arVar.dR("tid", cbVar.getId());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str3);
        arVar.aq("entryid", i2);
        arVar.dR("name", str2);
        arVar.aq("is_small_follow", i);
        return arVar;
    }

    private long T(cb cbVar) {
        if (cbVar == null || cbVar.bol() == null) {
            return -1L;
        }
        return cbVar.bol().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ar arVar = new ar(str);
        arVar.aq("obj_source", i);
        arVar.aq("obj_type", i2);
        arVar.dR("tid", str2);
        TiebaStatic.log(arVar);
    }
}
