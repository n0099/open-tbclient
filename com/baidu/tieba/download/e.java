package com.baidu.tieba.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.a.k;
import com.baidu.tieba.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public final class e extends BdAsyncTask<a, a, Integer> {
    final /* synthetic */ c a;
    private ak b = new ak();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Integer num) {
        String string;
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        List list;
        List list2;
        a aVar10;
        a aVar11;
        a aVar12;
        a aVar13;
        a aVar14;
        a aVar15;
        a aVar16;
        a aVar17;
        Integer num2 = num;
        super.a((e) num2);
        f.e("download:result_code::" + num2);
        if (num2.intValue() == 0) {
            aVar10 = c.b;
            if (aVar10.m() != null) {
                aVar16 = c.b;
                b m = aVar16.m();
                aVar17 = c.b;
                m.d(aVar17);
            }
            aVar11 = c.b;
            aVar11.a(0);
            StringBuilder sb = new StringBuilder("download_file:success:");
            aVar12 = c.b;
            f.e(sb.append(aVar12.e()).toString());
            aVar13 = c.b;
            if (aVar13.m() != null) {
                aVar14 = c.b;
                b m2 = aVar14.m();
                aVar15 = c.b;
                m2.a(aVar15);
            }
        } else {
            switch (num2.intValue()) {
                case 1:
                    p.c();
                    string = p.d().getString(k.download_fail);
                    break;
                case 2:
                    p.c();
                    string = p.d().getString(k.download_fail);
                    break;
                case 3:
                    p.c();
                    string = p.d().getString(k.download_fail_net);
                    break;
                case 4:
                    p.c();
                    string = p.d().getString(k.download_fail);
                    break;
                default:
                    string = null;
                    break;
            }
            aVar = c.b;
            aVar.e(string);
            aVar2 = c.b;
            if (aVar2.m() != null) {
                aVar8 = c.b;
                b m3 = aVar8.m();
                aVar9 = c.b;
                m3.a(aVar9, num2.intValue());
            }
            aVar3 = c.b;
            aVar3.a(2);
            aVar4 = c.b;
            if (aVar4.m() != null) {
                aVar6 = c.b;
                b m4 = aVar6.m();
                aVar7 = c.b;
                m4.a(aVar7);
            }
            StringBuilder sb2 = new StringBuilder("download_file:fail:");
            aVar5 = c.b;
            f.e(sb2.append(aVar5.e()).toString());
        }
        c.b = null;
        list = c.c;
        if (list.isEmpty()) {
            return;
        }
        list2 = c.c;
        list2.remove(0);
        this.a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        a aVar;
        a aVar2;
        a aVar3;
        List list;
        List list2;
        a aVar4;
        a aVar5;
        super.d();
        this.b.g();
        aVar = c.b;
        aVar.a(4);
        aVar2 = c.b;
        aVar2.e((String) null);
        aVar3 = c.b;
        if (aVar3.m() != null) {
            aVar4 = c.b;
            b m = aVar4.m();
            aVar5 = c.b;
            m.a(aVar5);
        }
        list = c.c;
        if (!list.isEmpty()) {
            list2 = c.c;
            list2.remove(0);
        }
        c.b = null;
        this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4, 344=4, 345=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(a... aVarArr) {
        int i;
        FileInputStream fileInputStream;
        Handler handler;
        FileInputStream fileInputStream2 = null;
        Boolean.valueOf(false);
        if (aVarArr[0] == null) {
            return null;
        }
        if (aVarArr[0].m() != null && !aVarArr[0].m().b(aVarArr[0])) {
            return 0;
        }
        if (!new File(aVarArr[0].e()).exists()) {
            this.b.a(aVarArr[0].d());
            ak akVar = this.b;
            String str = String.valueOf(aVarArr[0].a()) + "_" + aVarArr[0].b() + ".tmp";
            handler = this.a.f;
            if (!Boolean.valueOf(akVar.a(str, handler, 900002, 3, 3000)).booleanValue()) {
                return 3;
            }
            File d = w.d(String.valueOf(aVarArr[0].a()) + "_" + aVarArr[0].b() + ".tmp");
            if (d == null) {
                return 1;
            }
            if (!w.g(d.getAbsolutePath(), aVarArr[0].e())) {
                return 1;
            }
        }
        try {
            if (!bc.c(aVarArr[0].l())) {
                try {
                    fileInputStream = new FileInputStream(aVarArr[0].e());
                } catch (FileNotFoundException e) {
                    e = e;
                }
                try {
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    f.e(e.getMessage());
                    i = 4;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            f.e(e3.getMessage());
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            f.e(e4.getMessage());
                        }
                    }
                    throw th;
                }
                if (!bc.a(fileInputStream).equalsIgnoreCase(aVarArr[0].l())) {
                    i = 4;
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        f.e(e5.getMessage());
                    }
                    return i;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    f.e(e6.getMessage());
                }
            }
            i = (aVarArr[0].m() == null || aVarArr[0].m().c(aVarArr[0])) ? 0 : 2;
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
