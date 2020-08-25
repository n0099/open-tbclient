package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class j {
    private ArrayList<i> hus;

    public void ci(List<FrsTabInfo> list) {
        if (this.hus == null) {
            this.hus = new ArrayList<>();
        }
        this.hus.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.hus.add(new i(frsTabInfo));
                }
            }
        }
    }
}
