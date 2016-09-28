package com.baidu.tieba.homepage.personalize.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends t<Object> {
    private final /* synthetic */ ThreadInfo cIf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ThreadInfo threadInfo) {
        this.cIf = threadInfo;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String[] split = com.baidu.tbadk.core.sharedPref.b.uh().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
        if (split.length == 2) {
            String str = split[0];
            long c = com.baidu.adp.lib.h.b.c(split[1], 0L);
            if (c != 0 && !StringUtils.isNull(str)) {
                com.baidu.tbadk.core.sharedPref.b.uh().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.cIf.tid + "," + c);
            }
        }
        return null;
    }
}
