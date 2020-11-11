package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class j {
    private ArrayList<i> iiW;

    public void cI(List<FrsTabInfo> list) {
        if (this.iiW == null) {
            this.iiW = new ArrayList<>();
        }
        this.iiW.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iiW.add(new i(frsTabInfo));
                }
            }
        }
    }
}
