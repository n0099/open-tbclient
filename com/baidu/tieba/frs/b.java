package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private static e f = null;
    private static List<e> g = new LinkedList();
    private final int b = 5;
    private int c = 0;
    private c d = null;
    private d e = null;
    private int h = 1000;
    private int i = 0;
    private String j = null;

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

    public void a(String str, String str2, String str3, int i) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        if (this.c <= 5) {
            this.c++;
            downloadData.setStatus(1);
            downloadData.setStatusMsg(null);
        } else {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.download_fail_over_max));
        }
        a(downloadData);
        e eVar = new e(this);
        eVar.a(str);
        eVar.b(str2);
        eVar.c(str3);
        eVar.a(i);
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

    public void a(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        this.e = new d(this, null);
        this.e.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.z.d());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void b(DownloadData downloadData) {
        this.i = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
        StringBuilder sb = new StringBuilder(20);
        sb.append(String.valueOf(downloadData.getLength() / 1000));
        sb.append("K/");
        sb.append(String.valueOf(downloadData.getSize() / 1000));
        sb.append("K");
        this.j = sb.toString();
        com.baidu.tbadk.core.util.bb.a((Context) com.baidu.tieba.ai.c().d(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + com.baidu.tieba.ai.c().d().getResources().getString(com.baidu.tieba.y.download_will_begin), this.i, this.j, downloadData.getName(), true);
    }

    public void c(DownloadData downloadData) {
        com.baidu.tbadk.core.util.bb.a((Context) com.baidu.tieba.ai.c().d(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + com.baidu.tieba.ai.c().d().getResources().getString(com.baidu.tieba.y.download_fail_tip), this.i, this.j, com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.error_sd_error), false);
    }

    public boolean b(String str) {
        for (DownloadData downloadData : com.baidu.tbadk.download.b.a().b()) {
            if (downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str) {
        return (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.z.d(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
