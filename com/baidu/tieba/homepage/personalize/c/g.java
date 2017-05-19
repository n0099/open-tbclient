package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends v<Object> {
    private final /* synthetic */ ThreadInfo cwQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ThreadInfo threadInfo) {
        this.cwQ = threadInfo;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String[] split = com.baidu.tbadk.core.sharedPref.b.tX().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
        if (split.length == 2) {
            String str = split[0];
            long c = com.baidu.adp.lib.g.b.c(split[1], 0L);
            if (c != 0 && !StringUtils.isNull(str)) {
                com.baidu.tbadk.core.sharedPref.b.tX().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.cwQ.tid + "," + c);
            }
        }
        return null;
    }
}
