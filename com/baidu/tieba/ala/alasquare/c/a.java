package com.baidu.tieba.ala.alasquare.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static a fIO;
    private List<aq> fng;

    public static a bGy() {
        if (fIO == null) {
            synchronized (a.class) {
                if (fIO == null) {
                    fIO = new a();
                }
            }
        }
        return fIO;
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fng == null) {
                this.fng = new ArrayList();
            }
            if (this.fng != null) {
                this.fng.add(aqVar);
            }
        }
    }

    public void EC(String str) {
        if (str != null) {
            if (this.fng == null) {
                this.fng = new ArrayList();
            }
            if (this.fng != null) {
                this.fng.add(new aq(str));
            }
        }
    }

    public void bDW() {
        if (y.getCount(this.fng) != 0) {
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    TiebaStatic.log(aqVar);
                }
            }
            this.fng.clear();
        }
    }

    public void kM(boolean z) {
        if (y.getCount(this.fng) != 0) {
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    int i = 0;
                    if (z) {
                        i = 1;
                    }
                    if (!aqVar.getParams().contains(TiebaInitialize.Params.OBJ_PARAM2)) {
                        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, i);
                    }
                    TiebaStatic.log(aqVar);
                }
            }
            this.fng.clear();
        }
    }

    public aq a(int i, String str, int i2, String str2, bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        String str3 = "";
        if (bwVar.beY() != null && !StringUtils.isNull(bwVar.beY().appId)) {
            str3 = bwVar.beY().appId;
        }
        aq aqVar = new aq(str);
        aqVar.ai("obj_type", 1);
        aqVar.u("obj_id", R(bwVar));
        aqVar.dD("tid", bwVar.getId());
        aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, str3);
        aqVar.ai("entryid", i2);
        aqVar.dD("name", str2);
        aqVar.ai("is_small_follow", i);
        return aqVar;
    }

    private long R(bw bwVar) {
        if (bwVar == null || bwVar.beY() == null) {
            return -1L;
        }
        return bwVar.beY().live_id;
    }

    public void c(String str, int i, int i2, String str2) {
        aq aqVar = new aq(str);
        aqVar.ai("obj_source", i);
        aqVar.ai("obj_type", i2);
        aqVar.dD("tid", str2);
        TiebaStatic.log(aqVar);
    }
}
