package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class j {
    private ArrayList<i> iuF;

    public void cM(List<FrsTabInfo> list) {
        if (this.iuF == null) {
            this.iuF = new ArrayList<>();
        }
        this.iuF.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iuF.add(new i(frsTabInfo));
                }
            }
        }
    }
}
