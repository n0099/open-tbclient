package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class j {
    private ArrayList<i> iIj;

    public void cO(List<FrsTabInfo> list) {
        if (this.iIj == null) {
            this.iIj = new ArrayList<>();
        }
        this.iIj.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.iIj.add(new i(frsTabInfo));
                }
            }
        }
    }
}
