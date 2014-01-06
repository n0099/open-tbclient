package com.baidu.tieba.c;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.explorer.BdExplorePopView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bo;
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
    private at b = new at();

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
        this.b.j();
        aVar = g.b;
        aVar.a(4);
        aVar2 = g.b;
        aVar2.d((String) null);
        aVar3 = g.b;
        if (aVar3.m() != null) {
            aVar4 = g.b;
            f m = aVar4.m();
            aVar5 = g.b;
            m.b(aVar5);
        }
        list = g.c;
        if (!list.isEmpty()) {
            list2 = g.c;
            list2.remove(0);
        }
        a unused = g.b = null;
        this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [337=5, 339=4, 340=4, 341=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        if (aVarArr[0].m() == null || aVarArr[0].m().c(aVarArr[0])) {
            if (!new File(aVarArr[0].e()).exists()) {
                this.b.a(aVarArr[0].d());
                at atVar = this.b;
                String str = aVarArr[0].a() + "_" + aVarArr[0].b() + ".tmp";
                handler = this.a.f;
                if (!Boolean.valueOf(atVar.a(str, handler, 900002, 3, BdExplorePopView.SELECTION_TOP_DUR)).booleanValue()) {
                    return 3;
                }
                File d = aa.d(aVarArr[0].a() + "_" + aVarArr[0].b() + ".tmp");
                if (d == null) {
                    return 1;
                }
                if (!aa.f(d.getAbsolutePath(), aVarArr[0].e())) {
                    return 1;
                }
            }
            if (!bm.c(aVarArr[0].l())) {
                try {
                    fileInputStream = new FileInputStream(aVarArr[0].e());
                    try {
                        if (!bm.a(fileInputStream).toLowerCase().equals(aVarArr[0].l().toLowerCase())) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 4;
                                } catch (IOException e) {
                                    bo.c(e.getMessage());
                                    return 4;
                                }
                            }
                            return 4;
                        } else if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                bo.c(e2.getMessage());
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        try {
                            bo.c(e.getMessage());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    return 4;
                                } catch (IOException e4) {
                                    bo.c(e4.getMessage());
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
                                    bo.c(e5.getMessage());
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
            return (aVarArr[0].m() == null || aVarArr[0].m().a(aVarArr[0])) ? 0 : 2;
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
        a aVar10;
        List list;
        List list2;
        a aVar11;
        a aVar12;
        a aVar13;
        a aVar14;
        a aVar15;
        a aVar16;
        a aVar17;
        a aVar18;
        a aVar19;
        super.a((i) num);
        bo.c("download:result_code::" + num);
        if (num.intValue() == 0) {
            aVar11 = g.b;
            if (aVar11.m() != null) {
                aVar17 = g.b;
                f m = aVar17.m();
                aVar18 = g.b;
                String a = aVar18.a();
                aVar19 = g.b;
                m.a(a, aVar19.e());
            }
            aVar12 = g.b;
            aVar12.a(0);
            StringBuilder append = new StringBuilder().append("download_file:success:");
            aVar13 = g.b;
            bo.c(append.append(aVar13.e()).toString());
            aVar14 = g.b;
            if (aVar14.m() != null) {
                aVar15 = g.b;
                f m2 = aVar15.m();
                aVar16 = g.b;
                m2.b(aVar16);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TiebaApplication.g().getString(R.string.download_fail);
                    break;
                case 2:
                    string = TiebaApplication.g().getString(R.string.download_fail);
                    break;
                case 3:
                    string = TiebaApplication.g().getString(R.string.download_fail_net);
                    break;
                case 4:
                    string = TiebaApplication.g().getString(R.string.download_fail);
                    break;
                default:
                    string = null;
                    break;
            }
            aVar = g.b;
            aVar.d(string);
            aVar2 = g.b;
            if (aVar2.m() != null) {
                aVar8 = g.b;
                f m3 = aVar8.m();
                aVar9 = g.b;
                String a2 = aVar9.a();
                aVar10 = g.b;
                m3.a(a2, aVar10.e(), num.intValue(), string);
            }
            aVar3 = g.b;
            aVar3.a(2);
            aVar4 = g.b;
            if (aVar4.m() != null) {
                aVar6 = g.b;
                f m4 = aVar6.m();
                aVar7 = g.b;
                m4.b(aVar7);
            }
            StringBuilder append2 = new StringBuilder().append("download_file:fail:");
            aVar5 = g.b;
            bo.c(append2.append(aVar5.e()).toString());
        }
        a unused = g.b = null;
        list = g.c;
        if (!list.isEmpty()) {
            list2 = g.c;
            list2.remove(0);
            this.a.e();
        }
    }
}
