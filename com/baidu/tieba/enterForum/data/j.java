package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes21.dex */
public class j {
    private ArrayList<i> ijK;

    public void cI(List<FrsTabInfo> list) {
        if (this.ijK == null) {
            this.ijK = new ArrayList<>();
        }
        this.ijK.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ijK.add(new i(frsTabInfo));
                }
            }
        }
    }
}
