package com.baidu.tieba.c;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.q;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.bu;
import com.slidingmenu.lib.R;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.messageCenter.g {
    private static d a = new d();
    private e b;
    private List<String> c;
    private int d = 5;

    private d() {
        com.baidu.tieba.im.messageCenter.e.a().a(-123, this);
    }

    public static d a() {
        return a;
    }

    private void b(List<String> list) {
        this.b = new e(this);
        this.b.execute(list);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        if (qVar.w() == -123 && (qVar instanceof j)) {
            this.c = ((j) qVar).a();
            b(this.c);
        }
    }

    public void a(String str, String str2, String str3) {
        if (!bu.c(str) && !bu.c(str3)) {
            a aVar = new a(str, str2, str3, new c());
            aVar.d(TiebaApplication.A());
            aVar.b(11);
            String[] split = str3.split("/");
            if (split.length > 1) {
                String[] split2 = split[split.length - 1].split("_");
                if (split2 != null) {
                    if (split2.length == 5) {
                        aVar.a(split2[1]);
                        aVar.c(split2[2]);
                        aVar.c(com.baidu.adp.lib.f.b.a(split2[3], 200));
                        aVar.d(com.baidu.adp.lib.f.b.a(split2[4].split(".png")[0], 200));
                    } else if (split2.length == 3) {
                        aVar.a(split2[1]);
                        aVar.c(split2[2].split(".png")[0]);
                        aVar.c(200);
                        aVar.d(200);
                    } else {
                        aVar.d(TiebaApplication.h().getString(R.string.download_fail));
                        aVar.a(2);
                    }
                } else {
                    aVar.d(TiebaApplication.h().getString(R.string.download_fail));
                    aVar.a(2);
                }
            } else {
                aVar.d(TiebaApplication.h().getString(R.string.download_fail));
                aVar.a(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(ad.d());
            sb.append(ad.a(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            aVar.b(sb.toString());
            com.baidu.adp.lib.g.e.d("download:path:" + aVar.e());
            g.a().a(aVar, this.d);
        }
    }

    public void a(String str) {
        g.a().a(str, 11);
    }

    public void b() {
        g.a().a(11);
    }

    public void a(a aVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar);
        com.baidu.tieba.im.messageCenter.e.a().d(new b(linkedList));
    }

    public void a(List<a> list) {
        com.baidu.tieba.im.messageCenter.e.a().d(new b(list));
    }
}
