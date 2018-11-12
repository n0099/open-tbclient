package com.baidu.tieba.channel.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class c {
    private static int cUB = -1;

    public static final String bs(long j) {
        long j2 = 1000 * j;
        return bt(j2) == getCurrentYear() ? ao.G(j2) : ao.E(j2);
    }

    private static final int bt(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    private static final int getCurrentYear() {
        if (cUB == -1) {
            cUB = bt(System.currentTimeMillis());
        }
        return cUB;
    }

    public static void a(int i, String str, Class cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setResponsedClass(cls);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
