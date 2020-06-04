package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a fgW;
    private List<an> eMV;

    public static a brs() {
        if (fgW == null) {
            synchronized (a.class) {
                if (fgW == null) {
                    fgW = new a();
                }
            }
        }
        return fgW;
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMV == null) {
                this.eMV = new ArrayList();
            }
            if (this.eMV != null) {
                this.eMV.add(anVar);
            }
        }
    }

    public void AX(String str) {
        if (str != null) {
            if (this.eMV == null) {
                this.eMV = new ArrayList();
            }
            if (this.eMV != null) {
                this.eMV.add(new an(str));
            }
        }
    }

    public void bpt() {
        if (v.getCount(this.eMV) != 0) {
            for (an anVar : this.eMV) {
                if (anVar != null) {
                    TiebaStatic.log(anVar);
                }
            }
            this.eMV.clear();
        }
    }

    public void jv(boolean z) {
        if (v.getCount(this.eMV) != 0) {
            for (an anVar : this.eMV) {
                if (anVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!anVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(anVar);
                }
            }
            this.eMV.clear();
        }
    }

    public an a(int i, String str, int i2, String str2, bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        String str3 = "";
        if (bkVar.aQS() != null && !StringUtils.isNull(bkVar.aQS().appId)) {
            str3 = bkVar.aQS().appId;
        }
        an anVar = new an(str);
        anVar.ag("obj_type", 1);
        anVar.s("obj_id", T(bkVar));
        anVar.dh("tid", bkVar.getId());
        anVar.dh(TiebaInitialize.Params.OBJ_PARAM3, str3);
        anVar.ag("entryid", i2);
        anVar.dh("name", str2);
        anVar.ag("is_small_follow", i);
        return anVar;
    }

    private long T(bk bkVar) {
        if (bkVar == null || bkVar.aQS() == null) {
            return -1L;
        }
        return bkVar.aQS().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        an anVar = new an(str);
        anVar.ag("obj_source", i);
        anVar.ag("obj_type", i2);
        anVar.dh("tid", str2);
        TiebaStatic.log(anVar);
    }
}
