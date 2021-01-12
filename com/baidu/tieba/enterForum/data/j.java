package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class j {
    private ArrayList<i> iCl;

    public void cT(List<FrsTabInfo> list) {
        if (this.iCl == null) {
            this.iCl = new ArrayList<>();
        }
        this.iCl.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iCl.add(new i(frsTabInfo));
                }
            }
        }
    }
}
