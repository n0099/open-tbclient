package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.download.DownloadMessage;
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
        com.baidu.tieba.p.c();
        this.f = (NotificationManager) com.baidu.tieba.p.d().getSystemService("notification");
        com.baidu.tieba.p.c();
        PendingIntent activity = PendingIntent.getActivity(com.baidu.tieba.p.d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        com.baidu.tieba.p.c();
        notification.contentView = new RemoteViews(com.baidu.tieba.p.d().getPackageName(), com.baidu.tieba.a.i.notify_item);
        notification.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        this.g = notification;
    }

    public static b a() {
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
        }
        return a;
    }

    public final void a(String str, String str2, String str3, int i2) {
        com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(str);
        aVar.b(12);
        if (this.c <= 5) {
            this.c++;
            aVar.a(1);
            aVar.e((String) null);
        } else {
            aVar.a(2);
            com.baidu.tieba.p.c();
            aVar.e(com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.download_fail_over_max));
        }
        a(aVar);
        e eVar = new e(this);
        eVar.a(str);
        eVar.b(str2);
        eVar.c(str3);
        eVar.a(i2);
        i.add(eVar);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (h == null && !i.isEmpty()) {
            e eVar = i.get(0);
            h = eVar;
            if (eVar != null) {
                this.d = new c(this, (byte) 0);
                this.d.setPriority(3);
                this.d.execute(h);
            }
        }
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public static void a(com.baidu.tieba.download.a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar);
        com.baidu.adp.framework.c.a().b(new DownloadMessage(linkedList));
    }

    public static void a(List<com.baidu.tieba.download.a> list) {
        com.baidu.adp.framework.c.a().b(new DownloadMessage(list));
    }

    public final NotificationManager b() {
        return this.f;
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        this.e = new d(this, (byte) 0);
        this.e.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(b bVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.w.d());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public final void b(com.baidu.tieba.download.a aVar) {
        if (this.f != null && this.g != null) {
            Notification notification = this.g;
            StringBuilder sb = new StringBuilder(String.valueOf(aVar.b()));
            com.baidu.tieba.p.c();
            notification.tickerText = sb.append(com.baidu.tieba.p.d().getResources().getString(com.baidu.tieba.a.k.download_will_begin)).toString();
            this.g.contentView.setTextViewText(com.baidu.tieba.a.h.info, aVar.b());
            this.g.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, (int) ((aVar.h() * 100) / aVar.i()), false);
            StringBuilder sb2 = new StringBuilder(20);
            sb2.append(String.valueOf(aVar.h() / 1000));
            sb2.append("K/");
            sb2.append(String.valueOf(aVar.i() / 1000));
            sb2.append("K");
            this.g.contentView.setTextViewText(com.baidu.tieba.a.h.schedule, sb2);
            this.f.notify(aVar.o(), this.g);
        }
    }

    public final void c(com.baidu.tieba.download.a aVar) {
        if (this.f != null && this.g != null) {
            Notification notification = this.g;
            StringBuilder sb = new StringBuilder(String.valueOf(aVar.b()));
            com.baidu.tieba.p.c();
            notification.tickerText = sb.append(com.baidu.tieba.p.d().getResources().getString(com.baidu.tieba.a.k.download_fail_tip)).toString();
            RemoteViews remoteViews = this.g.contentView;
            int i2 = com.baidu.tieba.a.h.info;
            com.baidu.tieba.p.c();
            remoteViews.setTextViewText(i2, com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.error_sd_error));
            this.g.flags = 16;
            this.f.notify(aVar.o(), this.g);
        }
    }
}
