package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.download.DownloadMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class g {
    private static g a = new g();
    private j b;
    private List<String> c;
    private int d = 5;
    private com.baidu.adp.framework.c.a e = new h(this, 2001144);
    private com.baidu.adp.framework.c.a f = new i(this, 2001123);

    private g() {
        com.baidu.adp.framework.c.a().a(this.f);
        com.baidu.adp.framework.c.a().a(this.e);
    }

    public static g a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(g gVar, List list) {
        gVar.b = new j(gVar);
        gVar.b.execute(list);
    }

    public final void a(String str, String str2, String str3) {
        if (!com.baidu.tbadk.core.util.bc.c(str) && !com.baidu.tbadk.core.util.bc.c(str3)) {
            com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(str, str2, str3, new f());
            aVar.e(TbadkApplication.E());
            aVar.b(11);
            String[] split = str3.split("/");
            if (split.length > 1) {
                String[] split2 = split[split.length - 1].split("_");
                if (split2 != null) {
                    if (split2.length == 5) {
                        aVar.b(split2[1]);
                        aVar.d(split2[2]);
                        aVar.c(com.baidu.adp.lib.f.b.a(split2[3], 200));
                        aVar.d(com.baidu.adp.lib.f.b.a(split2[4].split(".png")[0], 200));
                    } else if (split2.length == 3) {
                        aVar.b(split2[1]);
                        aVar.d(split2[2].split(".png")[0]);
                        aVar.c(200);
                        aVar.d(200);
                    } else {
                        com.baidu.tieba.p.c();
                        aVar.e(com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.download_fail));
                        aVar.a(2);
                    }
                } else {
                    com.baidu.tieba.p.c();
                    aVar.e(com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.download_fail));
                    aVar.a(2);
                }
            } else {
                com.baidu.tieba.p.c();
                aVar.e(com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.download_fail));
                aVar.a(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.tbadk.core.util.w.d());
            sb.append(com.baidu.tbadk.core.util.w.a(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            aVar.c(sb.toString());
            com.baidu.adp.lib.util.f.e("download:path:" + aVar.e());
            com.baidu.tieba.download.c.a().a(aVar, this.d);
        }
    }

    public static void a(String str) {
        com.baidu.tieba.download.c.a().a(str, 11);
    }

    public static void b() {
        com.baidu.tieba.download.c.a().a(11);
    }

    public static void a(com.baidu.tieba.download.a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar);
        com.baidu.adp.framework.c.a().b(new DownloadMessage(linkedList));
    }

    public static void a(List<com.baidu.tieba.download.a> list) {
        com.baidu.adp.framework.c.a().b(new DownloadMessage(list));
    }
}
