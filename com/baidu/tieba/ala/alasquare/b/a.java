package com.baidu.tieba.ala.alasquare.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static a gHh;
    private List<aq> gik;

    public static a bVm() {
        if (gHh == null) {
            synchronized (a.class) {
                if (gHh == null) {
                    gHh = new a();
                }
            }
        }
        return gHh;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gik == null) {
                this.gik = new ArrayList();
            }
            if (this.gik != null) {
                this.gik.add(aqVar);
            }
        }
    }

    public void GK(String str) {
        if (str != null) {
            if (this.gik == null) {
                this.gik = new ArrayList();
            }
            if (this.gik != null) {
                this.gik.add(new aq(str));
            }
        }
    }

    public void bRT() {
        if (x.getCount(this.gik) != 0) {
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.gik.clear();
        }
    }

    public void mG(boolean z) {
        if (x.getCount(this.gik) != 0) {
            for (aq aqVar : this.gik) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.gik.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        String str3 = "";
        if (bzVar.brK() != null && !StringUtils.isNull(bzVar.brK().appId)) {
            str3 = bzVar.brK().appId;
        }
        aq aqVar = new aq(str);
        aqVar.an("obj_type", 1);
        aqVar.w("obj_id", S(bzVar));
        aqVar.dX("tid", bzVar.getId());
        aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.an("entryid", i2);
        aqVar.dX("name", str2);
        aqVar.an("is_small_follow", i);
        return aqVar;
    }

    private long S(bz bzVar) {
        if (bzVar == null || bzVar.brK() == null) {
            return -1L;
        }
        return bzVar.brK().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.an("obj_source", i);
        aqVar.an("obj_type", i2);
        aqVar.dX("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
