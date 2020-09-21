package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes21.dex */
public class j {
    private ArrayList<i> hBD;

    public void co(List<FrsTabInfo> list) {
        if (this.hBD == null) {
            this.hBD = new ArrayList<>();
        }
        this.hBD.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.hBD.add(new i(frsTabInfo));
                }
            }
        }
    }
}
