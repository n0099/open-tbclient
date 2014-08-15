package com.baidu.tieba.game;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.ai;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private static e f = null;
    private static List<e> g = new LinkedList();
    private final int b = 10;
    private int c = 0;
    private c d = null;
    private d e = null;
    private int h = 0;
    private String i = null;

    private b() {
    }

    public static b a() {
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
        }
        return a;
    }

    public void a(String str, String str2, String str3) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        if (this.c <= 10) {
            this.c++;
            downloadData.setStatus(1);
            downloadData.setStatusMsg(null);
        } else {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(ai.c().d().getString(com.baidu.tieba.x.download_fail_over_max));
        }
        a(downloadData);
        e eVar = new e(this);
        eVar.a(str);
        eVar.b(str2);
        eVar.c(str3);
        g.add(eVar);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (f == null && !g.isEmpty()) {
            f = g.get(0);
            if (f != null) {
                this.d = new c(this, null);
                this.d.setPriority(3);
                this.d.execute(f);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.s.d());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            this.h = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(downloadData.getLength() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(downloadData.getSize() / 1000));
            sb.append("K");
            this.i = sb.toString();
            ap.a((Context) ai.c().d(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + ai.c().d().getResources().getString(com.baidu.tieba.x.download_will_begin), this.h, this.i, downloadData.getName(), true);
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null) {
            ap.a((Context) ai.c().d(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + ai.c().d().getResources().getString(com.baidu.tieba.x.download_fail_tip), this.h, this.i, ai.c().d().getString(com.baidu.tieba.x.download_fail_tip), false);
        }
    }

    public boolean b(String str) {
        for (DownloadData downloadData : com.baidu.tbadk.download.b.a().b()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        com.baidu.tbadk.download.b.a().a(str);
    }

    public boolean b(String str, String str2) {
        File d = com.baidu.tbadk.core.util.s.d(String.valueOf(str) + "_" + str2 + ".tmp");
        return d != null && d.exists() && d.isFile();
    }

    public boolean c(String str) {
        return (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.s.d(new StringBuilder(String.valueOf(str)).append(".apk").toString()) == null) ? false : true;
    }

    public File d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.tbadk.core.util.s.d(String.valueOf(str) + ".apk");
    }
}
