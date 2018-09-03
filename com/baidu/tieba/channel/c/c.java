package com.baidu.tieba.channel.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class c {
    private static int cFl = -1;

    public static final String bl(long j) {
        long j2 = 1000 * j;
        return bm(j2) == getCurrentYear() ? ap.y(j2) : ap.w(j2);
    }

    private static final int bm(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    private static final int getCurrentYear() {
        if (cFl == -1) {
            cFl = bm(System.currentTimeMillis());
        }
        return cFl;
    }

    public static void a(int i, String str, Class cls) {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
        tbHttpMessageTask.setResponsedClass(cls);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().unRegisterTask(i);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
