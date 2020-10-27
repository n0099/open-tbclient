package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class j {
    private ArrayList<i> icV;

    public void cA(List<FrsTabInfo> list) {
        if (this.icV == null) {
            this.icV = new ArrayList<>();
        }
        this.icV.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.icV.add(new i(frsTabInfo));
                }
            }
        }
    }
}
