package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.k;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.emotion.editortool.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.g.e
    public boolean dJ() {
        return l.nW().oc();
    }

    private String y(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: d */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return c.CQ().fS(y(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
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
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> RC = x.RA().RC();
        if (valueOf3.booleanValue()) {
            String z = x.RA().z(valueOf2, true);
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = RC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                if (next.fr(valueOf2)) {
                    if (next.BE()) {
                        aVar2 = next.ft(valueOf2);
                    } else {
                        aVar2 = a(next.getGroupId(), z, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, z, aVar);
            }
        } else {
            String z2 = x.RA().z(valueOf2, false);
            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = RC.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                if (next2.fr(valueOf2)) {
                    if (next2.BE()) {
                        aVar3 = next2.fs(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), z2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, z2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        k kVar;
        byte[] l;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (l = (kVar = new k()).l(valueOf4, false)) == null || !kVar.uD()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String z = x.RA().z(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, z, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.n(false);
                aVar3.setData(l);
                d.bH().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar.f(aVar3);
                    aVar.lU = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.RA().RC().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.fr(valueOf2)) {
                        aVar2 = a(next.getGroupId(), z, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, z, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.CQ().eD(80000);
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(l);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, z, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.n(false);
                cVar.setData(l);
                cVar.q(valueOf3.booleanValue());
                d.bH().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar2 = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar2.f(cVar);
                    aVar.lU = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            c.CQ().c(y(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar) {
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
        aVar2.n(false);
        aVar2.o(false);
        aVar2.h((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.f(aVar2);
            aVar.lU = dVar;
        }
        if (d.bH().c(aVar2)) {
            int i = 2000;
            if (i.fs()) {
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
                aVar2.h(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.cc());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.g.a aVar) {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        j jVar = new j(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        jVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        jVar.n(false);
        jVar.o(false);
        jVar.h((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.f(jVar);
            aVar.lU = dVar;
        }
        if (d.bH().c(jVar)) {
            int i = 2000;
            if (i.fs()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (jVar.isSuccess()) {
                jVar.h(jVar.getData());
                bitmap = jVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel dK() {
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public int dL() {
        return 1;
    }
}
