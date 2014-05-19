package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.adp.framework.MessageManager;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private static e h = null;
    private static List<e> i = new LinkedList();
    private NotificationManager f;
    private Notification g;
    private final int b = 5;
    private int c = 0;
    private c d = null;
    private d e = null;
    private int j = LocationClientOption.MIN_SCAN_SPAN;

    private b() {
        this.f = null;
        this.g = null;
        this.f = (NotificationManager) com.baidu.tieba.ad.c().d().getSystemService("notification");
        this.g = b();
    }

    public static b a() {
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
        }
        return a;
    }

    public void a(String str, String str2, String str3, int i2) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        if (this.c <= 5) {
            this.c++;
            downloadData.setStatus(1);
            downloadData.setStatusMsg(null);
        } else {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.download_fail_over_max));
        }
        a(downloadData);
        e eVar = new e(this);
        eVar.a(str);
        eVar.b(str2);
        eVar.c(str3);
        eVar.a(i2);
        i.add(eVar);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (h == null && !i.isEmpty()) {
            h = i.get(0);
            if (h != null) {
                this.d = new c(this, null);
                this.d.setPriority(3);
                this.d.execute(h);
            }
        }
    }

    public String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void a(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void a(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public Notification b() {
        PendingIntent activity = PendingIntent.getActivity(com.baidu.tieba.ad.c().d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(com.baidu.tieba.ad.c().d().getPackageName(), com.baidu.tieba.s.notify_item);
        notification.contentView.setProgressBar(com.baidu.tieba.r.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    public NotificationManager c() {
        return this.f;
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        this.e = new d(this, null);
        this.e.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.x.d());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void b(DownloadData downloadData) {
        if (this.f != null && this.g != null) {
            this.g.tickerText = String.valueOf(downloadData.getName()) + com.baidu.tieba.ad.c().d().getResources().getString(com.baidu.tieba.u.download_will_begin);
            this.g.contentView.setTextViewText(com.baidu.tieba.r.info, downloadData.getName());
            this.g.contentView.setProgressBar(com.baidu.tieba.r.progress, 100, (int) ((downloadData.getLength() * 100) / downloadData.getSize()), false);
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(downloadData.getLength() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(downloadData.getSize() / 1000));
            sb.append("K");
            this.g.contentView.setTextViewText(com.baidu.tieba.r.schedule, sb);
            this.f.notify(downloadData.getNotifyId(), this.g);
        }
    }

    public void c(DownloadData downloadData) {
        if (this.f != null && this.g != null) {
            this.g.tickerText = String.valueOf(downloadData.getName()) + com.baidu.tieba.ad.c().d().getResources().getString(com.baidu.tieba.u.download_fail_tip);
            this.g.contentView.setTextViewText(com.baidu.tieba.r.info, com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.error_sd_error));
            this.g.flags = 16;
            this.f.notify(downloadData.getNotifyId(), this.g);
        }
    }
}
