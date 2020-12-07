package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class j {
    private ArrayList<i> iuD;

    public void cM(List<FrsTabInfo> list) {
        if (this.iuD == null) {
            this.iuD = new ArrayList<>();
        }
        this.iuD.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iuD.add(new i(frsTabInfo));
                }
            }
        }
    }
}
