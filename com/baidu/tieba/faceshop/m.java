package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.resourceLoader.h<com.baidu.adp.widget.a.a> {
    private final String a = "_gif";

    @Override // com.baidu.adp.lib.resourceLoader.h
    public boolean a() {
        return com.baidu.tbadk.core.h.a().f();
    }

    private String a(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.a().c(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
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
        ArrayList<com.baidu.tbadk.editortool.ad> c = com.baidu.tbadk.editortool.aa.a().c();
        if (valueOf3.booleanValue()) {
            String a = com.baidu.tbadk.editortool.aa.a().a(valueOf2, true);
            Iterator<com.baidu.tbadk.editortool.ad> it = c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                com.baidu.tbadk.editortool.ad next = it.next();
                if (next.a(valueOf2)) {
                    if (next.i()) {
                        aVar2 = next.c(valueOf2);
                    } else {
                        aVar2 = a(next.e(), a, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, a, aVar);
            }
        } else {
            String a2 = com.baidu.tbadk.editortool.aa.a().a(valueOf2, false);
            Iterator<com.baidu.tbadk.editortool.ad> it2 = c.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                com.baidu.tbadk.editortool.ad next2 = it2.next();
                if (next2.a(valueOf2)) {
                    if (next2.i()) {
                        aVar3 = next2.b(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.e(), a2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, a2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.httpNet.k kVar;
        byte[] a;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (a = (kVar = new com.baidu.tbadk.core.util.httpNet.k()).a(valueOf4, false)) == null || !kVar.b()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.d.a) {
            String a2 = com.baidu.tbadk.editortool.aa.a().a(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, a2, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.b(false);
                aVar3.a(a);
                com.baidu.adp.lib.Disk.d.a().a(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
                    bVar.a(aVar3);
                    aVar.a = bVar;
                }
                Iterator<com.baidu.tbadk.editortool.ad> it = com.baidu.tbadk.editortool.aa.a().c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortool.ad next = it.next();
                    if (next.a(valueOf2)) {
                        aVar2 = a(next.e(), a2, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, a2, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                com.baidu.tbadk.imageManager.e.a().c(80000);
                Bitmap a3 = com.baidu.tbadk.core.util.d.a(a);
                if (a3 == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(a3, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, a2, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.b(false);
                cVar.a(a);
                cVar.f(valueOf3.booleanValue());
                com.baidu.adp.lib.Disk.d.a().b(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.b bVar2 = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
                    bVar2.a(cVar);
                    aVar.a = bVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.a().b(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar) {
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
        aVar2.b(false);
        aVar2.d(false);
        aVar2.a((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
            bVar.a(aVar2);
            aVar.a = bVar;
        }
        if (com.baidu.adp.lib.Disk.d.a().b(aVar2)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (BdResourceLoaderNetHelperStatic.a()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (aVar2.g()) {
                aVar2.b(aVar2.b());
                return new com.baidu.adp.widget.a.a(aVar2.v());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar) {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oVar.b(false);
        oVar.d(false);
        oVar.a((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
            bVar.a(oVar);
            aVar.a = bVar;
        }
        if (com.baidu.adp.lib.Disk.d.a().b(oVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (BdResourceLoaderNetHelperStatic.a()) {
                i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (oVar.g()) {
                oVar.b(oVar.b());
                bitmap = oVar.w();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public BdAsyncTaskParallel b() {
        return null;
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public int c() {
        return 1;
    }
}
