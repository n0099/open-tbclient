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
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.b.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class c {
    private static volatile c clH = null;
    private AlarmManager clI;
    private final int clF = 7;
    private int clG = PersonListModel.CACHETIME;
    private HttpMessageListener blq = new HttpMessageListener(CmdConfigHttp.REPORT_APPLIST) { // from class: com.baidu.tieba.applist.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ApplistResponse)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("applist_report_time", System.currentTimeMillis());
            }
        }
    };

    static {
        a aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(1000);
        intentFilter.addAction("com.baidu.tieba.report.applist");
        BdBaseApplication.getInst().getApp().registerReceiver(aVar, intentFilter);
    }

    private c() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Dt());
        messageManager.registerListener(this.blq);
        aeV();
    }

    public static c aeU() {
        if (clH == null) {
            synchronized (c.class) {
                if (clH == null) {
                    clH = new c();
                }
            }
        }
        return clH;
    }

    public void aeV() {
        if (this.clI == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(6, 7);
            PendingIntent broadcast = PendingIntent.getBroadcast(BdBaseApplication.getInst().getApp(), 0, new Intent("com.baidu.tieba.report.applist"), 134217728);
            this.clI = (AlarmManager) BdBaseApplication.getInst().getApp().getSystemService("alarm");
            this.clI.setRepeating(0, calendar.getTimeInMillis(), this.clG, broadcast);
        }
    }

    public void el(boolean z) {
        if (d.eE().ak("applist_switch") != 0) {
            long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_report_time", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (j == 0 || z || currentTimeMillis >= this.clG) {
                v.a(new u<Object>() { // from class: com.baidu.tieba.applist.c.2
                    @Override // com.baidu.tbadk.util.u
                    public Object doInBackground() {
                        MessageManager.getInstance().sendMessageFromBackground(new ApplistRequest());
                        return null;
                    }
                }, null);
            }
        }
    }

    private HttpMessageTask Dt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REPORT_APPLIST, TbConfig.REPORT_APPLIST);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setRetry(3);
        tbHttpMessageTask.setResponsedClass(ApplistResponse.class);
        return tbHttpMessageTask;
    }

    /* loaded from: classes3.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.baidu.tieba.report.applist")) {
                c.aeU().el(true);
            }
        }
    }
}
