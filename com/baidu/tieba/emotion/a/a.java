package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.emotion.editortool.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean he() {
        return m.qV().qZ();
    }

    private String u(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        return c.BV().fq(u(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        Bitmap b;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Id = w.Ib().Id();
        if (valueOf3.booleanValue()) {
            String v = w.Ib().v(valueOf2, true);
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = Id.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next.eP(valueOf2)) {
                    if (next.AO()) {
                        aVar2 = next.eR(valueOf2);
                    } else {
                        aVar2 = a(next.getGroupId(), v, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, v, aVar);
            }
        } else {
            String v2 = w.Ib().v(valueOf2, false);
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = Id.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                if (next2.eP(valueOf2)) {
                    if (next2.AO()) {
                        aVar3 = next2.eQ(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), v2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, v2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        j jVar;
        byte[] l;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (l = (jVar = new j()).l(valueOf4, false)) == null || !jVar.vj()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.c.Gn) {
            String v = w.Ib().v(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, v, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.o(false);
                aVar3.setData(l);
                d.fj().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar.f(aVar3);
                    aVar.vs = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = w.Ib().Id().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.eP(valueOf2)) {
                        aVar2 = a(next.getGroupId(), v, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, v, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.BV().el(80000);
                Bitmap N = com.baidu.tbadk.core.util.c.N(l);
                if (N == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(N, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, v, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(false);
                cVar.setData(l);
                cVar.r(valueOf3.booleanValue());
                d.fj().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar2 = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar2.f(cVar);
                    aVar.vs = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            c.BV().c(u(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        String str3 = ".emotions/";
        if (str != null) {
            str3 = String.valueOf(".emotions/") + str + "/";
        }
        if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
            Bitmap b = b(str, str2, aVar);
            if (b == null) {
                return null;
            }
            return new com.baidu.adp.widget.a.a(b, false, str2);
        }
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(str3, str2, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.o(false);
        aVar2.p(false);
        aVar2.h(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.f(aVar2);
            aVar.vs = dVar;
        }
        if (d.fj().c(aVar2)) {
            int i = 2000;
            if (i.iO()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (aVar2.isSuccess()) {
                aVar2.x(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.fE());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        k kVar = new k(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        kVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        kVar.o(false);
        kVar.p(false);
        kVar.h(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.f(kVar);
            aVar.vs = dVar;
        }
        if (d.fj().c(kVar)) {
            int i = 2000;
            if (i.iO()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (kVar.isSuccess()) {
                kVar.x(kVar.getData());
                bitmap = kVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hf() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int hg() {
        return 1;
    }
}
