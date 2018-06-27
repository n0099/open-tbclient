package com.baidu.tieba.channel.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class c {
    private static int cCJ = -1;

    public static final String bh(long j) {
        long j2 = 1000 * j;
        return bi(j2) == ajx() ? ap.x(j2) : ap.w(j2);
    }

    private static final int bi(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    private static final int ajx() {
        if (cCJ == -1) {
            cCJ = bi(System.currentTimeMillis());
        }
        return cCJ;
    }

    public static void a(int i, String str, Class cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setResponsedClass(cls);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
