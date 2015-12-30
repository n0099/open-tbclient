package com.baidu.tieba.applist;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.n;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    private static volatile b aLN = null;
    private AlarmManager aLO;
    private final int aLL = 7;
    private int aLM = 604800000;
    private HttpMessageListener aLP = new c(this, CmdConfigHttp.REPORT_APPLIST);

    static {
        a aVar = new a(null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(1000);
        intentFilter.addAction("com.baidu.tieba.report.applist");
        BdBaseApplication.getInst().getApp().registerReceiver(aVar, intentFilter);
    }

    private b() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(AY());
        messageManager.registerListener(this.aLP);
        HI();
    }

    public static b HH() {
        if (aLN == null) {
            synchronized (b.class) {
                if (aLN == null) {
                    aLN = new b();
                }
            }
        }
        return aLN;
    }

    public void HI() {
        if (this.aLO == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(6, 7);
            PendingIntent broadcast = PendingIntent.getBroadcast(BdBaseApplication.getInst().getApp(), 0, new Intent("com.baidu.tieba.report.applist"), 134217728);
            this.aLO = (AlarmManager) BdBaseApplication.getInst().getApp().getSystemService("alarm");
            this.aLO.setRepeating(0, calendar.getTimeInMillis(), this.aLM, broadcast);
        }
    }

    public void bN(boolean z) {
        if (com.baidu.adp.lib.c.e.gw().aj("applist_switch") != 0) {
            long j = com.baidu.tbadk.core.sharedPref.b.tJ().getLong("applist_report_time", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (j == 0 || z || currentTimeMillis >= this.aLM) {
                n.a(new d(this), null);
            }
        }
    }

    private HttpMessageTask AY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_APPLIST, TbConfig.REPORT_APPLIST);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setRetry(3);
        tbHttpMessageTask.setResponsedClass(ApplistResponse.class);
        return tbHttpMessageTask;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.baidu.tieba.report.applist")) {
                b.HH().bN(true);
            }
        }
    }
}
