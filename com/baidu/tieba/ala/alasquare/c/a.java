package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static a elD;
    private List<an> dTz;

    public static a baG() {
        if (elD == null) {
            synchronized (a.class) {
                if (elD == null) {
                    elD = new a();
                }
            }
        }
        return elD;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTz == null) {
                this.dTz = new ArrayList();
            }
            if (this.dTz != null) {
                this.dTz.add(anVar);
            }
        }
    }

    public void xo(String str) {
        if (str != null) {
            if (this.dTz == null) {
                this.dTz = new ArrayList();
            }
            if (this.dTz != null) {
                this.dTz.add(new an(str));
            }
        }
    }

    public void aZA() {
        if (v.getCount(this.dTz) != 0) {
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dTz.clear();
        }
    }

    public void hU(boolean z) {
        if (v.getCount(this.dTz) != 0) {
            for (an anVar : this.dTz) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!anVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(anVar);
                }
            }
            this.dTz.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str3 = "";
        if (bjVar.aAq() != null && !StringUtils.isNull(bjVar.aAq().appId)) {
            str3 = bjVar.aAq().appId;
        }
        an anVar = new an(str);
        anVar.Z("obj_type", 1);
        anVar.s("obj_id", Q(bjVar));
        anVar.cp("tid", bjVar.getId());
        anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.Z("entryid", i2);
        anVar.cp("name", str2);
        anVar.Z("is_small_follow", i);
        return anVar;
    }

    private long Q(bj bjVar) {
        if (bjVar == null || bjVar.aAq() == null) {
            return -1L;
        }
        return bjVar.aAq().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.Z("obj_source", i);
        anVar.Z("obj_type", i2);
        anVar.cp("tid", str2);
        TiebaStatic.log(anVar);
    }
}
