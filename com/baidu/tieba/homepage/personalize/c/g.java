package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.w;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends w<Object> {
    private final /* synthetic */ ThreadInfo cLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ThreadInfo threadInfo) {
        this.cLf = threadInfo;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        String[] split = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length == 2) {
            String str = split[0];
            long c = com.baidu.adp.lib.g.b.c(split[1], 0L);
            if (c != 0 && !StringUtils.isNull(str)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.cLf.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + c);
            }
        }
        return null;
    }
}
