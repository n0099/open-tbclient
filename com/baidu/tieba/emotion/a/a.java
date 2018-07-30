package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.imageManager.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean ik() {
        return i.te().tk();
    }

    private String y(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        return c.IQ().he(y(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        com.baidu.adp.widget.ImageView.a aVar2;
        Bitmap b;
        com.baidu.adp.widget.ImageView.a aVar3;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aon = com.baidu.tieba.emotion.editortool.e.aol().aon();
        if (com.baidu.tieba.emotion.editortool.e.aol().lw(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.aol().z(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.aol().ly(valueOf2) && valueOf3.booleanValue()) {
            String z = com.baidu.tieba.emotion.editortool.e.aol().z(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.aol().lx(valueOf2);
            if (!new File(l.CD + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + z).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String z2 = com.baidu.tieba.emotion.editortool.e.aol().z(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = aon.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar2 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.gD(valueOf2)) {
                            if (next.HH()) {
                                aVar2 = next.gF(valueOf2);
                            } else {
                                aVar2 = a(next.getGroupId(), z2, aVar);
                            }
                        }
                    }
                    if (aVar2 == null && str3 != null) {
                        aVar2 = a(str3, z2, aVar);
                    }
                } else {
                    String z3 = com.baidu.tieba.emotion.editortool.e.aol().z(valueOf2, false);
                    if (booleanValue && com.baidu.tieba.emotion.editortool.e.aol().ly(valueOf2)) {
                        z3.replaceFirst("s_", "d_");
                    }
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = aon.iterator();
                    com.baidu.adp.widget.ImageView.a aVar4 = null;
                    while (true) {
                        if (!it2.hasNext()) {
                            aVar2 = aVar4;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                        if (!next2.gD(valueOf2)) {
                            aVar3 = aVar4;
                        } else if (next2.HH()) {
                            aVar3 = next2.gE(valueOf2);
                        } else {
                            Bitmap b2 = b(next2.getGroupId(), z3, aVar);
                            if (b2 == null) {
                                return null;
                            }
                            aVar2 = new com.baidu.adp.widget.ImageView.a(b2, false, valueOf2);
                        }
                        aVar4 = aVar3;
                    }
                    if (aVar2 == null && str3 != null && (b = b(str3, z3, aVar)) != null) {
                        aVar2 = new com.baidu.adp.widget.ImageView.a(b, false, valueOf2);
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
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] i3;
        com.baidu.adp.widget.ImageView.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (i3 = (iVar = new com.baidu.tbadk.core.util.a.i()).i(valueOf4, false)) == null || !iVar.zU()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String z = com.baidu.tieba.emotion.editortool.e.aol().z(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, z, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.u(false);
                aVar3.x(false);
                aVar3.w(false);
                aVar3.setData(i3);
                d.ge().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
                    eVar.f(aVar3);
                    aVar.An = eVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.aol().aon().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.gD(valueOf2)) {
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
                c.IQ().fe(80000);
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(i3);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, z, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.u(false);
                cVar.setData(i3);
                cVar.x(false);
                cVar.w(false);
                cVar.y(valueOf3.booleanValue());
                d.ge().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar2 = new com.baidu.tbadk.core.util.d.e();
                    eVar2.f(cVar);
                    aVar.An = eVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            c.IQ().c(y(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar) {
        String str3 = str != null ? ".emotions/" + str + "/" : ".emotions/";
        if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
            Bitmap b = b(str, str2, aVar);
            if (b == null) {
                return null;
            }
            return new com.baidu.adp.widget.ImageView.a(b, false, str2);
        }
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(str3, str2, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.u(false);
        aVar2.v(false);
        aVar2.x(false);
        aVar2.w(false);
        aVar2.m(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(aVar2);
            aVar.An = eVar;
        }
        if (d.ge().c(aVar2)) {
            int i = 2000;
            if (j.jF()) {
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
                return new com.baidu.adp.widget.ImageView.a(aVar2.gA());
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
        h hVar = new h(append.append(str).toString(), str2, DiskFileOperate.Action.READ);
        hVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        hVar.u(false);
        hVar.v(false);
        hVar.x(false);
        hVar.w(false);
        hVar.m(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(hVar);
            aVar.An = eVar;
        }
        if (d.ge().c(hVar)) {
            int i = 2000;
            if (j.jF()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (hVar.isSuccess()) {
                hVar.i(hVar.getData());
                bitmap = hVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel il() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int im() {
        return 1;
    }
}
