package com.baidu.tieba.d;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.bs;
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
    public void a(s sVar) {
        if (sVar.w() == -123 && (sVar instanceof j)) {
            this.c = ((j) sVar).a();
            b(this.c);
        }
    }

    public void a(String str, String str2, String str3) {
        if (!bs.c(str) && !bs.c(str3)) {
            a aVar = new a(str, str2, str3, new c());
            aVar.e(TiebaApplication.A());
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
                        aVar.e(TiebaApplication.g().b().getString(R.string.download_fail));
                        aVar.a(2);
                    }
                } else {
                    aVar.e(TiebaApplication.g().b().getString(R.string.download_fail));
                    aVar.a(2);
                }
            } else {
                aVar.e(TiebaApplication.g().b().getString(R.string.download_fail));
                aVar.a(2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(af.d());
            sb.append(af.a(2));
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            aVar.c(sb.toString());
            com.baidu.adp.lib.util.f.e("download:path:" + aVar.e());
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
