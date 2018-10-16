package com.baidu.tieba.channel.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class c {
    private static int cTv = -1;

    public static final String bw(long j) {
        long j2 = 1000 * j;
        return bx(j2) == getCurrentYear() ? ao.E(j2) : ao.C(j2);
    }

    private static final int bx(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    private static final int getCurrentYear() {
        if (cTv == -1) {
            cTv = bx(System.currentTimeMillis());
        }
        return cTv;
    }

    public static void a(int i, String str, Class cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setResponsedClass(cls);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
