package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a fxs;
    private List<ap> fbI;

    public static a bxy() {
        if (fxs == null) {
            synchronized (a.class) {
                if (fxs == null) {
                    fxs = new a();
                }
            }
        }
        return fxs;
    }

    public void e(ap apVar) {
        if (apVar != null) {
            if (this.fbI == null) {
                this.fbI = new ArrayList();
            }
            if (this.fbI != null) {
                this.fbI.add(apVar);
            }
        }
    }

    public void Ch(String str) {
        if (str != null) {
            if (this.fbI == null) {
                this.fbI = new ArrayList();
            }
            if (this.fbI != null) {
                this.fbI.add(new ap(str));
            }
        }
    }

    public void bva() {
        if (x.getCount(this.fbI) != 0) {
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    TiebaStatic.log(apVar);
                }
            }
            this.fbI.clear();
        }
    }

    public void km(boolean z) {
        if (x.getCount(this.fbI) != 0) {
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!apVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(apVar);
                }
            }
            this.fbI.clear();
        }
    }

    public ap a(int i, String str, int i2, String str2, bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        String str3 = "";
        if (bvVar.aWF() != null && !StringUtils.isNull(bvVar.aWF().appId)) {
            str3 = bvVar.aWF().appId;
        }
        ap apVar = new ap(str);
        apVar.ah("obj_type", 1);
        apVar.t("obj_id", R(bvVar));
        apVar.dn("tid", bvVar.getId());
        apVar.dn(TiebaInitialize.Params.OBJ_PARAM3, str3);
        apVar.ah("entryid", i2);
        apVar.dn("name", str2);
        apVar.ah("is_small_follow", i);
        return apVar;
    }

    private long R(bv bvVar) {
        if (bvVar == null || bvVar.aWF() == null) {
            return -1L;
        }
        return bvVar.aWF().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ap apVar = new ap(str);
        apVar.ah("obj_source", i);
        apVar.ah("obj_type", i2);
        apVar.dn("tid", str2);
        TiebaStatic.log(apVar);
    }
}
