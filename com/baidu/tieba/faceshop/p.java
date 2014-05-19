package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.resourceLoader.g<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.resourceLoader.g
    public boolean a() {
        return com.baidu.tbadk.core.h.a().f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        Bitmap b;
        com.baidu.adp.widget.a.a aVar3;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        String valueOf2 = String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.editortool.ag> d = com.baidu.tbadk.editortool.ac.a().d();
        if (valueOf3.booleanValue()) {
            String a = com.baidu.tbadk.editortool.ac.a().a(valueOf2, true);
            Iterator<com.baidu.tbadk.editortool.ag> it = d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar3 = null;
                    break;
                }
                com.baidu.tbadk.editortool.ag next = it.next();
                if (next.a(valueOf2)) {
                    aVar3 = a(next.e(), a, aVar);
                    break;
                }
            }
            if (aVar3 == null && valueOf != null) {
                return a(valueOf, a, aVar);
            }
            return aVar3;
        }
        String a2 = com.baidu.tbadk.editortool.ac.a().a(valueOf2, false);
        Iterator<com.baidu.tbadk.editortool.ag> it2 = d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                aVar2 = null;
                break;
            } else if (it2.next().a(valueOf2)) {
                Bitmap b2 = b(valueOf, a2, aVar);
                if (b2 == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
            }
        }
        if (aVar2 == null && valueOf != null && (b = b(valueOf, a2, aVar)) != null) {
            return new com.baidu.adp.widget.a.a(b, false, valueOf2);
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.a.e eVar;
        byte[] a;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        String valueOf2 = String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (a = (eVar = new com.baidu.tbadk.core.util.a.e()).a(valueOf4, false)) == null || !eVar.b()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.g.a) {
            String a2 = com.baidu.tbadk.editortool.ac.a().a(valueOf2, valueOf3.booleanValue());
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
                Iterator<com.baidu.tbadk.editortool.ag> it = com.baidu.tbadk.editortool.ac.a().d().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortool.ag next = it.next();
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
                Bitmap a3 = com.baidu.tbadk.core.util.g.a(a);
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

    @Override // com.baidu.adp.lib.resourceLoader.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.a().b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar) {
        String str3 = ".emotions/" + str + "/";
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
                    BdLog.d("wait exception. class is " + e.getClass().getName() + e.getMessage());
                }
            }
            if (aVar2.g()) {
                aVar2.b(aVar2.b());
                return new com.baidu.adp.widget.a.a(aVar2.s());
            }
            BdLog.d("local failed");
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(".emotions/" + str, str2, DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.b(false);
        cVar.d(false);
        cVar.a((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.b bVar = new com.baidu.tbadk.core.util.resourceLoaderProc.b();
            bVar.a(cVar);
            aVar.a = bVar;
        }
        if (com.baidu.adp.lib.Disk.d.a().b(cVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (BdResourceLoaderNetHelperStatic.a()) {
                i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.d("wait exception. class is " + e.getClass().getName() + e.getMessage());
                }
            }
            if (cVar.g()) {
                cVar.b(cVar.b());
                bitmap = cVar.u();
            } else {
                BdLog.d("local failed");
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }
}
