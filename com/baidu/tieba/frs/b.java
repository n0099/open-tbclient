package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
    private int b = 5;
    private int c = 0;
    private c d = null;
    private d e = null;
    private int j = LocationClientOption.MIN_SCAN_SPAN;

    private b() {
        this.f = null;
        this.g = null;
        this.f = (NotificationManager) TiebaApplication.g().b().getSystemService("notification");
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
        com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(str);
        aVar.b(12);
        if (this.c <= this.b) {
            this.c++;
            aVar.a(1);
            aVar.e((String) null);
        } else {
            aVar.a(2);
            aVar.e(TiebaApplication.g().b().getString(R.string.download_fail_over_max));
        }
        a(aVar);
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

    public void a(com.baidu.tieba.d.a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar);
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.d.b(linkedList));
    }

    public void a(List<com.baidu.tieba.d.a> list) {
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.d.b(list));
    }

    public Notification b() {
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.g().b(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.g().b().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    public NotificationManager c() {
        return this.f;
    }

    public void a(ArrayList<g> arrayList) {
        this.e = new d(this, null);
        this.e.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tieba.util.af.d());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void b(com.baidu.tieba.d.a aVar) {
        if (this.f != null && this.g != null) {
            this.g.tickerText = String.valueOf(aVar.b()) + TiebaApplication.g().b().getResources().getString(R.string.download_will_begin);
            this.g.contentView.setTextViewText(R.id.info, aVar.b());
            this.g.contentView.setProgressBar(R.id.progress, 100, (int) ((aVar.h() * 100) / aVar.i()), false);
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(aVar.h() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(aVar.i() / 1000));
            sb.append("K");
            this.g.contentView.setTextViewText(R.id.schedule, sb);
            this.f.notify(aVar.o(), this.g);
        }
    }

    public void c(com.baidu.tieba.d.a aVar) {
        if (this.f != null && this.g != null) {
            this.g.tickerText = String.valueOf(aVar.b()) + TiebaApplication.g().b().getResources().getString(R.string.download_fail_tip);
            this.g.contentView.setTextViewText(R.id.info, TiebaApplication.g().b().getString(R.string.error_sd_error));
            this.g.flags = 16;
            this.f.notify(aVar.o(), this.g);
        }
    }
}
