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
    private static a eTY;
    private List<an> eyd;

    public static a blU() {
        if (eTY == null) {
            synchronized (a.class) {
                if (eTY == null) {
                    eTY = new a();
                }
            }
        }
        return eTY;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyd == null) {
                this.eyd = new ArrayList();
            }
            if (this.eyd != null) {
                this.eyd.add(anVar);
            }
        }
    }

    public void zo(String str) {
        if (str != null) {
            if (this.eyd == null) {
                this.eyd = new ArrayList();
            }
            if (this.eyd != null) {
                this.eyd.add(new an(str));
            }
        }
    }

    public void bjZ() {
        if (v.getCount(this.eyd) != 0) {
            for (an anVar : this.eyd) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eyd.clear();
        }
    }

    public void jd(boolean z) {
        if (v.getCount(this.eyd) != 0) {
            for (an anVar : this.eyd) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!anVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        anVar.af(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(anVar);
                }
            }
            this.eyd.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        String str3 = "";
        if (bjVar.aKX() != null && !StringUtils.isNull(bjVar.aKX().appId)) {
            str3 = bjVar.aKX().appId;
        }
        an anVar = new an(str);
        anVar.af("obj_type", 1);
        anVar.t("obj_id", S(bjVar));
        anVar.cI("tid", bjVar.getId());
        anVar.cI(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.af("entryid", i2);
        anVar.cI("name", str2);
        anVar.af("is_small_follow", i);
        return anVar;
    }

    private long S(bj bjVar) {
        if (bjVar == null || bjVar.aKX() == null) {
            return -1L;
        }
        return bjVar.aKX().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.af("obj_source", i);
        anVar.af("obj_type", i2);
        anVar.cI("tid", str2);
        TiebaStatic.log(anVar);
    }
}
