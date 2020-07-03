package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a fsk;
    private List<ao> eXh;

    public static a buo() {
        if (fsk == null) {
            synchronized (a.class) {
                if (fsk == null) {
                    fsk = new a();
                }
            }
        }
        return fsk;
    }

    public void e(ao aoVar) {
        if (aoVar != null) {
            if (this.eXh == null) {
                this.eXh = new ArrayList();
            }
            if (this.eXh != null) {
                this.eXh.add(aoVar);
            }
        }
    }

    public void Bw(String str) {
        if (str != null) {
            if (this.eXh == null) {
                this.eXh = new ArrayList();
            }
            if (this.eXh != null) {
                this.eXh.add(new ao(str));
            }
        }
    }

    public void brT() {
        if (w.getCount(this.eXh) != 0) {
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    TiebaStatic.log(aoVar);
                }
            }
            this.eXh.clear();
        }
    }

    public void jI(boolean z) {
        if (w.getCount(this.eXh) != 0) {
            for (ao aoVar : this.eXh) {
                if (aoVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aoVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aoVar);
                }
            }
            this.eXh.clear();
        }
    }

    public ao a(int i, String str, int i2, String str2, bu buVar) {
        if (buVar == null) {
            return null;
        }
        String str3 = "";
        if (buVar.aSJ() != null && !StringUtils.isNull(buVar.aSJ().appId)) {
            str3 = buVar.aSJ().appId;
        }
        ao aoVar = new ao(str);
        aoVar.ag("obj_type", 1);
        aoVar.s("obj_id", U(buVar));
        aoVar.dk("tid", buVar.getId());
        aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aoVar.ag("entryid", i2);
        aoVar.dk("name", str2);
        aoVar.ag("is_small_follow", i);
        return aoVar;
    }

    private long U(bu buVar) {
        if (buVar == null || buVar.aSJ() == null) {
            return -1L;
        }
        return buVar.aSJ().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        ao aoVar = new ao(str);
        aoVar.ag("obj_source", i);
        aoVar.ag("obj_type", i2);
        aoVar.dk("tid", str2);
        TiebaStatic.log(aoVar);
    }
}
