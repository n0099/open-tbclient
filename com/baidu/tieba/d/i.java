package com.baidu.tieba.d;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<a, a, Integer> {
    final /* synthetic */ g a;
    private ba b = new ba();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        a aVar;
        a aVar2;
        a aVar3;
        List list;
        List list2;
        a aVar4;
        a aVar5;
        super.c();
        this.b.k();
        aVar = g.b;
        aVar.a(4);
        aVar2 = g.b;
        aVar2.e((String) null);
        aVar3 = g.b;
        if (aVar3.m() != null) {
            aVar4 = g.b;
            f m = aVar4.m();
            aVar5 = g.b;
            m.c(aVar5);
        }
        list = g.c;
        if (!list.isEmpty()) {
            list2 = g.c;
            list2.remove(0);
        }
        g.b = null;
        this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [337=4, 339=4, 340=4, 341=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer a(a... aVarArr) {
        FileInputStream fileInputStream;
        Handler handler;
        FileInputStream fileInputStream2 = null;
        Boolean.valueOf(false);
        if (aVarArr[0] == null) {
            return null;
        }
        if (aVarArr[0].m() == null || aVarArr[0].m().d(aVarArr[0])) {
            if (!new File(aVarArr[0].e()).exists()) {
                this.b.a(aVarArr[0].d());
                ba baVar = this.b;
                String str = String.valueOf(aVarArr[0].a()) + "_" + aVarArr[0].b() + ".tmp";
                handler = this.a.f;
                if (!Boolean.valueOf(baVar.a(str, handler, 900002, 3, 3000)).booleanValue()) {
                    return 3;
                }
                File d = af.d(String.valueOf(aVarArr[0].a()) + "_" + aVarArr[0].b() + ".tmp");
                if (d == null) {
                    return 1;
                }
                if (!af.f(d.getAbsolutePath(), aVarArr[0].e())) {
                    return 1;
                }
            }
            if (!bs.c(aVarArr[0].l())) {
                try {
                    fileInputStream = new FileInputStream(aVarArr[0].e());
                    try {
                        if (!bs.a(fileInputStream).toLowerCase().equals(aVarArr[0].l().toLowerCase())) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 4;
                                } catch (IOException e) {
                                    com.baidu.adp.lib.util.f.e(e.getMessage());
                                    return 4;
                                }
                            }
                            return 4;
                        } else if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                com.baidu.adp.lib.util.f.e(e2.getMessage());
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        try {
                            com.baidu.adp.lib.util.f.e(e.getMessage());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    return 4;
                                } catch (IOException e4) {
                                    com.baidu.adp.lib.util.f.e(e4.getMessage());
                                    return 4;
                                }
                            }
                            return 4;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    com.baidu.adp.lib.util.f.e(e5.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            }
            return (aVarArr[0].m() == null || aVarArr[0].m().b(aVarArr[0])) ? 0 : 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
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
        super.a((i) num);
        com.baidu.adp.lib.util.f.e("download:result_code::" + num);
        if (num.intValue() == 0) {
            aVar10 = g.b;
            if (aVar10.m() != null) {
                aVar16 = g.b;
                f m = aVar16.m();
                aVar17 = g.b;
                m.a(aVar17);
            }
            aVar11 = g.b;
            aVar11.a(0);
            StringBuilder sb = new StringBuilder("download_file:success:");
            aVar12 = g.b;
            com.baidu.adp.lib.util.f.e(sb.append(aVar12.e()).toString());
            aVar13 = g.b;
            if (aVar13.m() != null) {
                aVar14 = g.b;
                f m2 = aVar14.m();
                aVar15 = g.b;
                m2.c(aVar15);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TiebaApplication.g().b().getString(R.string.download_fail);
                    break;
                case 2:
                    string = TiebaApplication.g().b().getString(R.string.download_fail);
                    break;
                case 3:
                    string = TiebaApplication.g().b().getString(R.string.download_fail_net);
                    break;
                case 4:
                    string = TiebaApplication.g().b().getString(R.string.download_fail);
                    break;
                default:
                    string = null;
                    break;
            }
            aVar = g.b;
            aVar.e(string);
            aVar2 = g.b;
            if (aVar2.m() != null) {
                aVar8 = g.b;
                f m3 = aVar8.m();
                aVar9 = g.b;
                m3.a(aVar9, num.intValue(), string);
            }
            aVar3 = g.b;
            aVar3.a(2);
            aVar4 = g.b;
            if (aVar4.m() != null) {
                aVar6 = g.b;
                f m4 = aVar6.m();
                aVar7 = g.b;
                m4.c(aVar7);
            }
            StringBuilder sb2 = new StringBuilder("download_file:fail:");
            aVar5 = g.b;
            com.baidu.adp.lib.util.f.e(sb2.append(aVar5.e()).toString());
        }
        g.b = null;
        list = g.c;
        if (!list.isEmpty()) {
            list2 = g.c;
            list2.remove(0);
            this.a.e();
        }
    }
}
