package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    private final String asC = "_gif";

    @Override // com.baidu.adp.lib.f.g
    public boolean eh() {
        return com.baidu.tbadk.core.l.js().jw();
    }

    private String n(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.si().dt(n(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
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
        ArrayList<com.baidu.tbadk.editortool.ad> rD = com.baidu.tbadk.editortool.aa.rB().rD();
        if (valueOf3.booleanValue()) {
            String m = com.baidu.tbadk.editortool.aa.rB().m(valueOf2, true);
            Iterator<com.baidu.tbadk.editortool.ad> it = rD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar2 = null;
                    break;
                }
                com.baidu.tbadk.editortool.ad next = it.next();
                if (next.cY(valueOf2)) {
                    if (next.ru()) {
                        aVar2 = next.da(valueOf2);
                    } else {
                        aVar2 = a(next.getGroupId(), m, aVar);
                    }
                }
            }
            if (aVar2 == null && valueOf != null) {
                aVar2 = a(valueOf, m, aVar);
            }
        } else {
            String m2 = com.baidu.tbadk.editortool.aa.rB().m(valueOf2, false);
            Iterator<com.baidu.tbadk.editortool.ad> it2 = rD.iterator();
            com.baidu.adp.widget.a.a aVar3 = null;
            while (true) {
                if (!it2.hasNext()) {
                    aVar2 = aVar3;
                    break;
                }
                com.baidu.tbadk.editortool.ad next2 = it2.next();
                if (next2.cY(valueOf2)) {
                    if (next2.ru()) {
                        aVar3 = next2.cZ(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), m2, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                    }
                }
            }
            if (aVar2 == null && valueOf != null && (b = b(valueOf, m2, aVar)) != null) {
                aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
            }
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.httpNet.k kVar;
        byte[] j;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (j = (kVar = new com.baidu.tbadk.core.util.httpNet.k()).j(valueOf4, false)) == null || !kVar.ni()) {
            return null;
        }
        synchronized (com.baidu.tbadk.core.util.d.tg) {
            String m = com.baidu.tbadk.editortool.aa.rB().m(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, m, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.k(false);
                aVar3.setData(j);
                com.baidu.adp.lib.Disk.d.bn().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar.g(aVar3);
                    aVar.lb = dVar;
                }
                Iterator<com.baidu.tbadk.editortool.ad> it = com.baidu.tbadk.editortool.aa.rB().rD().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortool.ad next = it.next();
                    if (next.cY(valueOf2)) {
                        aVar2 = a(next.getGroupId(), m, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, m, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                com.baidu.tbadk.imageManager.e.si().cR(80000);
                Bitmap w = com.baidu.tbadk.core.util.d.w(j);
                if (w == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(w, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, m, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.k(false);
                cVar.setData(j);
                cVar.n(valueOf3.booleanValue());
                com.baidu.adp.lib.Disk.d.bn().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.resourceLoaderProc.d dVar2 = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
                    dVar2.g(cVar);
                    aVar.lb = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.si().c(n(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
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
        aVar2.k(false);
        aVar2.l(false);
        aVar2.b(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.g(aVar2);
            aVar.lb = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.bn().c(aVar2)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (com.baidu.adp.lib.util.j.fi()) {
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
                aVar2.i(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.bK());
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
        com.baidu.tbadk.core.util.o oVar = new com.baidu.tbadk.core.util.o(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        oVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oVar.k(false);
        oVar.l(false);
        oVar.b(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.resourceLoaderProc.d dVar = new com.baidu.tbadk.core.util.resourceLoaderProc.d();
            dVar.g(oVar);
            aVar.lb = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.bn().c(oVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (com.baidu.adp.lib.util.j.fi()) {
                i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (oVar.isSuccess()) {
                oVar.i(oVar.getData());
                bitmap = oVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int ej() {
        return 1;
    }
}
