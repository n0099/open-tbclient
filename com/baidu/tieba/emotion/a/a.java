package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.i;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tieba.emotion.editortool.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean fX() {
        return h.oY().pe();
    }

    private String H(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return c.Ex().gt(H(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        com.baidu.adp.widget.a.a aVar2;
        Bitmap b;
        com.baidu.adp.widget.a.a aVar3;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> abx = g.abv().abx();
        if (g.abv().jC(valueOf2) && valueOf3.booleanValue() && !new File(g.abv().I(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (g.abv().jE(valueOf2) && valueOf3.booleanValue()) {
            String I = g.abv().I(valueOf2, true);
            valueOf = g.abv().jD(valueOf2);
            if (!new File(k.zW + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + I).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String I2 = g.abv().I(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = abx.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar2 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.fO(valueOf2)) {
                            if (next.Do()) {
                                aVar2 = next.fQ(valueOf2);
                            } else {
                                aVar2 = a(next.getGroupId(), I2, aVar);
                            }
                        }
                    }
                    if (aVar2 == null && str3 != null) {
                        aVar2 = a(str3, I2, aVar);
                    }
                } else {
                    String I3 = g.abv().I(valueOf2, false);
                    if (booleanValue && g.abv().jE(valueOf2)) {
                        I3.replaceFirst("s_", "d_");
                    }
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = abx.iterator();
                    com.baidu.adp.widget.a.a aVar4 = null;
                    while (true) {
                        if (!it2.hasNext()) {
                            aVar2 = aVar4;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                        if (!next2.fO(valueOf2)) {
                            aVar3 = aVar4;
                        } else if (next2.Do()) {
                            aVar3 = next2.fP(valueOf2);
                        } else {
                            Bitmap b2 = b(next2.getGroupId(), I3, aVar);
                            if (b2 == null) {
                                return null;
                            }
                            aVar2 = new com.baidu.adp.widget.a.a(b2, false, valueOf2);
                        }
                        aVar4 = aVar3;
                    }
                    if (aVar2 == null && str3 != null && (b = b(str3, I3, aVar)) != null) {
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
        i iVar;
        byte[] k;
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (k = (iVar = new i()).k(valueOf4, false)) == null || !iVar.wr()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String I = g.abv().I(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, I, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.s(false);
                aVar3.setData(k);
                d.dS().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
                    dVar.f(aVar3);
                    aVar.xL = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = g.abv().abx().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.fO(valueOf2)) {
                        aVar2 = a(next.getGroupId(), I, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, I, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.Ex().eX(80000);
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(k);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, I, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(false);
                cVar.setData(k);
                cVar.v(valueOf3.booleanValue());
                d.dS().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.c.d dVar2 = new com.baidu.tbadk.core.util.c.d();
                    dVar2.f(cVar);
                    aVar.xL = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            c.Ex().c(H(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        String str3 = str != null ? ".emotions/" + str + "/" : ".emotions/";
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
        aVar2.k(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
            dVar.f(aVar2);
            aVar.xL = dVar;
        }
        if (d.dS().c(aVar2)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.hs()) {
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
                aVar2.n(aVar2.getData());
                return new com.baidu.adp.widget.a.a(aVar2.em());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        Bitmap bitmap;
        StringBuilder append = new StringBuilder().append(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        com.baidu.tbadk.core.util.g gVar = new com.baidu.tbadk.core.util.g(append.append(str).toString(), str2, DiskFileOperate.Action.READ);
        gVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        gVar.s(false);
        gVar.t(false);
        gVar.k(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.c.d dVar = new com.baidu.tbadk.core.util.c.d();
            dVar.f(gVar);
            aVar.xL = dVar;
        }
        if (d.dS().c(gVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.hs()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (gVar.isSuccess()) {
                gVar.n(gVar.getData());
                bitmap = gVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fY() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fZ() {
        return 1;
    }
}
