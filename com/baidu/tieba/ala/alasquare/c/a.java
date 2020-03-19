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
    private static a eqB;
    private List<an> dYi;

    public static a bdd() {
        if (eqB == null) {
            synchronized (a.class) {
                if (eqB == null) {
                    eqB = new a();
                }
            }
        }
        return eqB;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.dYi == null) {
                this.dYi = new ArrayList();
            }
            if (this.dYi != null) {
                this.dYi.add(anVar);
            }
        }
    }

    public void xK(String str) {
        if (str != null) {
            if (this.dYi == null) {
                this.dYi = new ArrayList();
            }
            if (this.dYi != null) {
                this.dYi.add(new an(str));
            }
        }
    }

    public void bbW() {
        if (v.getCount(this.dYi) != 0) {
            for (an anVar : this.dYi) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dYi.clear();
        }
    }

    public void id(boolean z) {
        if (v.getCount(this.dYi) != 0) {
            for (an anVar : this.dYi) {
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
            this.dYi.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str3 = "";
        if (bjVar.aCK() != null && !StringUtils.isNull(bjVar.aCK().appId)) {
            str3 = bjVar.aCK().appId;
        }
        an anVar = new an(str);
        anVar.X("obj_type", 1);
        anVar.s("obj_id", S(bjVar));
        anVar.cx("tid", bjVar.getId());
        anVar.cx(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.X("entryid", i2);
        anVar.cx("name", str2);
        anVar.X("is_small_follow", i);
        return anVar;
    }

    private long S(bj bjVar) {
        if (bjVar == null || bjVar.aCK() == null) {
            return -1L;
        }
        return bjVar.aCK().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.X("obj_source", i);
        anVar.X("obj_type", i2);
        anVar.cx("tid", str2);
        TiebaStatic.log(anVar);
    }
}
