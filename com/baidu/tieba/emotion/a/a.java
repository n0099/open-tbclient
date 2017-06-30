package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.r;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.k;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.emotion.editortool.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean fO() {
        return r.oK().oQ();
    }

    private String G(String str, boolean z) {
        return String.valueOf(str) + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return c.Eb().ge(G(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
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
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aao = z.aam().aao();
        if (z.aam().jn(valueOf2) && valueOf3.booleanValue() && !new File(z.aam().H(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (z.aam().jp(valueOf2) && valueOf3.booleanValue()) {
            String H = z.aam().H(valueOf2, true);
            valueOf = z.aam().jo(valueOf2);
            if (!new File(n.yu + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + H).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String H2 = z.aam().H(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = aao.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar2 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.fA(valueOf2)) {
                            if (next.CU()) {
                                aVar2 = next.fC(valueOf2);
                            } else {
                                aVar2 = a(next.getGroupId(), H2, aVar);
                            }
                        }
                    }
                    if (aVar2 == null && str3 != null) {
                        aVar2 = a(str3, H2, aVar);
                    }
                } else {
                    String H3 = z.aam().H(valueOf2, false);
                    if (booleanValue && z.aam().jp(valueOf2)) {
                        H3.replaceFirst("s_", "d_");
                    }
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = aao.iterator();
                    com.baidu.adp.widget.a.a aVar3 = null;
                    while (true) {
                        if (!it2.hasNext()) {
                            aVar2 = aVar3;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                        if (next2.fA(valueOf2)) {
                            if (next2.CU()) {
                                aVar3 = next2.fB(valueOf2);
                            } else {
                                Bitmap b2 = b(next2.getGroupId(), H3, aVar);
                                if (b2 == null) {
                                    return null;
                                }
                                aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                            }
                        }
                    }
                    if (aVar2 == null && str3 != null && (b = b(str3, H3, aVar)) != null) {
                        aVar2 = new com.baidu.adp.widget.a.a(b, false, valueOf2);
                    }
                }
                return aVar2;
            }
        }
        str3 = valueOf;
        if (!valueOf3.booleanValue()) {
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        k kVar;
        byte[] k;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (k = (kVar = new k()).k(valueOf4, false)) == null || !kVar.wa()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String H = z.aam().H(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, H, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.s(false);
                aVar3.setData(k);
                d.dI().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
                    dVar.f(aVar3);
                    aVar.wg = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = z.aam().aao().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.fA(valueOf2)) {
                        aVar2 = a(next.getGroupId(), H, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, H, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.Eb().eS(80000);
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(k);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, H, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(false);
                cVar.setData(k);
                cVar.v(valueOf3.booleanValue());
                d.dI().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.c.d dVar2 = new com.baidu.tbadk.core.util.c.d();
                    dVar2.f(cVar);
                    aVar.wg = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            c.Eb().c(G(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
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
        aVar2.s(false);
        aVar2.t(false);
        aVar2.k((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
            dVar.f(aVar2);
            aVar.wg = dVar;
        }
        if (d.dI().c(aVar2)) {
            int i = 2000;
            if (i.hk()) {
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
                aVar2.k(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.ed());
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
        com.baidu.tbadk.core.util.i iVar = new com.baidu.tbadk.core.util.i(sb.append(str).toString(), str2, DiskFileOperate.Action.READ);
        iVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        iVar.s(false);
        iVar.t(false);
        iVar.k((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
            dVar.f(iVar);
            aVar.wg = dVar;
        }
        if (d.dI().c(iVar)) {
            int i = 2000;
            if (i.hk()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (iVar.isSuccess()) {
                iVar.k(iVar.getData());
                bitmap = iVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fP() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fQ() {
        return 1;
    }
}
