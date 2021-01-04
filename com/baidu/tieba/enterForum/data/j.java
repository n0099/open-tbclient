package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class j {
    private ArrayList<i> iGS;

    public void cT(List<FrsTabInfo> list) {
        if (this.iGS == null) {
            this.iGS = new ArrayList<>();
        }
        this.iGS.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iGS.add(new i(frsTabInfo));
                }
            }
        }
    }
}
