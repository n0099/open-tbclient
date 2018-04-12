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
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.imageManager.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean ft() {
        return i.pY().qe();
    }

    private String z(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        return c.Fa().gG(z(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
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
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ako = com.baidu.tieba.emotion.editortool.e.akm().ako();
        if (com.baidu.tieba.emotion.editortool.e.akm().kS(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.akm().A(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.akm().kU(valueOf2) && valueOf3.booleanValue()) {
            String A = com.baidu.tieba.emotion.editortool.e.akm().A(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.akm().kT(valueOf2);
            if (!new File(k.wB + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + A).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String A2 = com.baidu.tieba.emotion.editortool.e.akm().A(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = ako.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar2 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.ge(valueOf2)) {
                            if (next.DT()) {
                                aVar2 = next.gg(valueOf2);
                            } else {
                                aVar2 = a(next.getGroupId(), A2, aVar);
                            }
                        }
                    }
                    if (aVar2 == null && str3 != null) {
                        aVar2 = a(str3, A2, aVar);
                    }
                } else {
                    String A3 = com.baidu.tieba.emotion.editortool.e.akm().A(valueOf2, false);
                    if (booleanValue && com.baidu.tieba.emotion.editortool.e.akm().kU(valueOf2)) {
                        A3.replaceFirst("s_", "d_");
                    }
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = ako.iterator();
                    com.baidu.adp.widget.ImageView.a aVar4 = null;
                    while (true) {
                        if (!it2.hasNext()) {
                            aVar2 = aVar4;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                        if (!next2.ge(valueOf2)) {
                            aVar3 = aVar4;
                        } else if (next2.DT()) {
                            aVar3 = next2.gf(valueOf2);
                        } else {
                            Bitmap b2 = b(next2.getGroupId(), A3, aVar);
                            if (b2 == null) {
                                return null;
                            }
                            aVar2 = new com.baidu.adp.widget.ImageView.a(b2, false, valueOf2);
                        }
                        aVar4 = aVar3;
                    }
                    if (aVar2 == null && str3 != null && (b = b(str3, A3, aVar)) != null) {
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
        byte[] j;
        com.baidu.adp.widget.ImageView.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (j = (iVar = new com.baidu.tbadk.core.util.a.i()).j(valueOf4, false)) == null || !iVar.wq()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String A = com.baidu.tieba.emotion.editortool.e.akm().A(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, A, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.u(false);
                aVar3.x(false);
                aVar3.w(false);
                aVar3.setData(j);
                d.dp().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
                    dVar.f(aVar3);
                    aVar.uq = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.akm().ako().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.ge(valueOf2)) {
                        aVar2 = a(next.getGroupId(), A, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, A, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.Fa().eY(80000);
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(j);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, A, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.u(false);
                cVar.setData(j);
                cVar.x(false);
                cVar.w(false);
                cVar.y(valueOf3.booleanValue());
                d.dp().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.d dVar2 = new com.baidu.tbadk.core.util.d.d();
                    dVar2.f(cVar);
                    aVar.uq = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            c.Fa().c(z(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
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
        aVar2.j((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
            dVar.f(aVar2);
            aVar.uq = dVar;
        }
        if (d.dp().c(aVar2)) {
            int i = 2000;
            if (j.gQ()) {
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
                aVar2.j(aVar2.getData());
                return new com.baidu.adp.widget.ImageView.a(aVar2.dK());
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
        g gVar = new g(append.append(str).toString(), str2, DiskFileOperate.Action.READ);
        gVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        gVar.u(false);
        gVar.v(false);
        gVar.x(false);
        gVar.w(false);
        gVar.j((Object) bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
            dVar.f(gVar);
            aVar.uq = dVar;
        }
        if (d.dp().c(gVar)) {
            int i = 2000;
            if (j.gQ()) {
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
                gVar.j(gVar.getData());
                bitmap = gVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fu() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fv() {
        return 1;
    }
}
