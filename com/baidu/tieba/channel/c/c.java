package com.baidu.tieba.channel.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class c {
    private static int cEQ = -1;

    public static final String bn(long j) {
        long j2 = 1000 * j;
        return bo(j2) == akd() ? ao.w(j2) : ao.v(j2);
    }

    private static final int bo(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    private static final int akd() {
        if (cEQ == -1) {
            cEQ = bo(System.currentTimeMillis());
        }
        return cEQ;
    }

    public static void a(int i, String str, Class cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setResponsedClass(cls);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
