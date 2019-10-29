package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static a dAy;
    private List<an> dgw;

    public static a aJO() {
        if (dAy == null) {
            synchronized (a.class) {
                if (dAy == null) {
                    dAy = new a();
                }
            }
        }
        return dAy;
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dgw == null) {
                this.dgw = new ArrayList();
            }
            if (this.dgw != null) {
                this.dgw.add(anVar);
            }
        }
    }

    public void sD(String str) {
        if (str != null) {
            if (this.dgw == null) {
                this.dgw = new ArrayList();
            }
            if (this.dgw != null) {
                this.dgw.add(new an(str));
            }
        }
    }

    public void aIL() {
        if (v.getCount(this.dgw) != 0) {
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.dgw.clear();
        }
    }

    public void gF(boolean z) {
        if (v.getCount(this.dgw) != 0) {
            for (an anVar : this.dgw) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!anVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        anVar.O(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(anVar);
                }
            }
            this.dgw.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        String str3 = "";
        if (bhVar.aiZ() != null && !StringUtils.isNull(bhVar.aiZ().appId)) {
            str3 = bhVar.aiZ().appId;
        }
        an anVar = new an(str);
        anVar.O("obj_type", 1);
        anVar.p("obj_id", L(bhVar));
        anVar.bS("tid", bhVar.getId());
        anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.O("entryid", i2);
        anVar.bS("name", str2);
        anVar.O("is_small_follow", i);
        return anVar;
    }

    private long L(bh bhVar) {
        if (bhVar == null || bhVar.aiZ() == null) {
            return -1L;
        }
        return bhVar.aiZ().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.O("obj_source", i);
        anVar.O("obj_type", i2);
        anVar.bS("tid", str2);
        TiebaStatic.log(anVar);
    }
}
