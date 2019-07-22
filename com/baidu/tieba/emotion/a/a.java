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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.imageManager.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a implements e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean iH() {
        return i.aca().ace();
    }

    private String ai(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return c.atw().qH(ai(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        com.baidu.adp.widget.ImageView.a aVar2;
        Bitmap b;
        com.baidu.adp.widget.ImageView.a aVar3;
        com.baidu.adp.widget.ImageView.a aVar4;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a aVar5 = null;
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> beZ = com.baidu.tieba.emotion.editortool.e.beX().beZ();
        if (com.baidu.tieba.emotion.editortool.e.beX().vT(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.beX().aj(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.beX().vV(valueOf2) && valueOf3.booleanValue()) {
            String aj = com.baidu.tieba.emotion.editortool.e.beX().aj(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.beX().vU(valueOf2);
            if (!new File(m.Dz + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + aj).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String aj2 = com.baidu.tieba.emotion.editortool.e.beX().aj(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = beZ.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar4 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.qi(valueOf2)) {
                            if (next.asn()) {
                                aVar4 = next.qk(valueOf2);
                            } else {
                                aVar4 = a(next.getGroupId(), aj2, aVar);
                            }
                        }
                    }
                    if (aVar4 == null && str3 != null) {
                        return a(str3, aj2, aVar);
                    }
                    return aVar4;
                }
                String aj3 = com.baidu.tieba.emotion.editortool.e.beX().aj(valueOf2, false);
                String replaceFirst = (booleanValue && com.baidu.tieba.emotion.editortool.e.beX().vV(valueOf2)) ? aj3.replaceFirst("s_", "d_") : aj3;
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = beZ.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar2 = aVar5;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                    if (!next2.qi(valueOf2)) {
                        aVar3 = aVar5;
                    } else if (next2.asn()) {
                        aVar3 = next2.qj(valueOf2);
                    } else {
                        Bitmap b2 = b(next2.getGroupId(), replaceFirst, aVar);
                        if (b2 == null) {
                            return null;
                        }
                        aVar2 = new com.baidu.adp.widget.ImageView.a(b2, false, valueOf2);
                    }
                    aVar5 = aVar3;
                }
                if (aVar2 == null && str3 != null && (b = b(str3, replaceFirst, aVar)) != null) {
                    return new com.baidu.adp.widget.ImageView.a(b, false, valueOf2);
                }
                return aVar2;
            }
        }
        str3 = valueOf;
        if (!valueOf3.booleanValue()) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] O;
        com.baidu.adp.widget.ImageView.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (O = (iVar = new com.baidu.tbadk.core.util.a.i()).O(valueOf4, false)) == null || !iVar.ajN()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String aj = com.baidu.tieba.emotion.editortool.e.beX().aj(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, aj, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.J(false);
                aVar3.M(false);
                aVar3.L(false);
                aVar3.setData(O);
                d.gC().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
                    eVar.f(aVar3);
                    aVar.Bk = eVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.beX().beZ().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.qi(valueOf2)) {
                        aVar2 = a(next.getGroupId(), aj, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, aj, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.atw().kF(80000);
                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(O), i, i2);
                if (checkBitmapSize == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, aj, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.J(false);
                cVar.setData(O);
                cVar.M(false);
                cVar.L(false);
                cVar.O(valueOf3.booleanValue());
                d.gC().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.d.e eVar2 = new com.baidu.tbadk.core.util.d.e();
                    eVar2.f(cVar);
                    aVar.Bk = eVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aG(i);
            aVar.aH(i2);
            c.atw().c(ai(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
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
        aVar2.J(false);
        aVar2.K(false);
        aVar2.M(false);
        aVar2.L(false);
        aVar2.q(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(aVar2);
            aVar.Bk = eVar;
        }
        if (d.gC().c(aVar2)) {
            int i = 2000;
            if (j.kd()) {
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
                return new com.baidu.adp.widget.ImageView.a(aVar2.gX());
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
        hVar.J(false);
        hVar.K(false);
        hVar.M(false);
        hVar.L(false);
        hVar.q(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.d.e eVar = new com.baidu.tbadk.core.util.d.e();
            eVar.f(hVar);
            aVar.Bk = eVar;
        }
        if (d.gC().c(hVar)) {
            int i = 2000;
            if (j.kd()) {
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
    public BdAsyncTaskParallel iI() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int iJ() {
        return 1;
    }
}
