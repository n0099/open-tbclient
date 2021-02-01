package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.b.i;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.imageManager.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a implements e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return k.bkT().isShowImages();
    }

    private String aL(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return c.bCP().Dk(aL(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        String str3;
        com.baidu.adp.widget.ImageView.a aVar;
        Bitmap b2;
        com.baidu.adp.widget.ImageView.a aVar2;
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
        com.baidu.adp.widget.ImageView.a aVar4 = null;
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cuQ = com.baidu.tieba.emotion.editortool.e.cuO().cuQ();
        if (com.baidu.tieba.emotion.editortool.e.cuO().Je(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.cuO().aM(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.cuO().Jg(valueOf2) && valueOf3.booleanValue()) {
            String aM = com.baidu.tieba.emotion.editortool.e.cuO().aM(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.cuO().Jf(valueOf2);
            if (!new File(o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + aM).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String aM2 = com.baidu.tieba.emotion.editortool.e.cuO().aM(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = cuQ.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar3 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.CP(valueOf2)) {
                            if (next.bBA()) {
                                aVar3 = next.CR(valueOf2);
                            } else {
                                aVar3 = a(next.getGroupId(), aM2, bVar);
                            }
                        }
                    }
                    if (aVar3 == null && str3 != null) {
                        return a(str3, aM2, bVar);
                    }
                    return aVar3;
                }
                String aM3 = com.baidu.tieba.emotion.editortool.e.cuO().aM(valueOf2, false);
                String replaceFirst = (booleanValue && com.baidu.tieba.emotion.editortool.e.cuO().Jg(valueOf2)) ? aM3.replaceFirst("s_", "d_") : aM3;
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = cuQ.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar = aVar4;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                    if (!next2.CP(valueOf2)) {
                        aVar2 = aVar4;
                    } else if (next2.bBA()) {
                        aVar2 = next2.CQ(valueOf2);
                    } else {
                        Bitmap b3 = b(next2.getGroupId(), replaceFirst, bVar);
                        if (b3 == null) {
                            return null;
                        }
                        aVar = new com.baidu.adp.widget.ImageView.a(b3, false, valueOf2);
                    }
                    aVar4 = aVar2;
                }
                if (aVar == null && str3 != null && (b2 = b(str3, replaceFirst, bVar)) != null) {
                    return new com.baidu.adp.widget.ImageView.a(b2, false, valueOf2);
                }
                return aVar;
            }
        }
        str3 = valueOf;
        if (!valueOf3.booleanValue()) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        i iVar = new i();
        byte[] aw = iVar.aw(valueOf4, false);
        boolean btj = iVar.btj();
        if (aw == null || !iVar.bti()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String aM = com.baidu.tieba.emotion.editortool.e.cuO().aM(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(str3, aM, DiskFileOperate.Action.WRITE);
                aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar2.setSubFolder(false);
                aVar2.setSavedCache(false);
                aVar2.setSdCard(false);
                aVar2.setData(aw);
                d.lg().b(aVar2);
                if (bVar != null) {
                    com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
                    dVar.f(aVar2);
                    bVar.Nl = dVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.cuO().cuQ().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.CP(valueOf2)) {
                        aVar = a(next.getGroupId(), aM, bVar);
                        break;
                    }
                }
                if (aVar == null && valueOf != null) {
                    aVar = a(valueOf, aM, bVar);
                }
                if (aVar == null) {
                    return null;
                }
            } else {
                c.bCP().freePicCache(80000);
                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aw), i, i2);
                if (checkBitmapSize == null) {
                    return null;
                }
                aVar = new com.baidu.adp.widget.ImageView.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                aVar.setNeedCache(btj);
                if (btj) {
                    com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, aM, DiskFileOperate.Action.WRITE);
                    cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    cVar.setSubFolder(false);
                    cVar.setData(aw);
                    cVar.setSavedCache(false);
                    cVar.setSdCard(false);
                    cVar.setGif(valueOf3.booleanValue());
                    d.lg().c(cVar);
                    if (bVar != null) {
                        com.baidu.tbadk.core.util.d.d dVar2 = new com.baidu.tbadk.core.util.d.d();
                        dVar2.f(cVar);
                        bVar.Nl = dVar2;
                    }
                }
            }
            return aVar;
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            c.bCP().b(aL(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    public com.baidu.adp.widget.ImageView.a a(String str, String str2, b bVar) {
        String str3 = str != null ? ".emotions/" + str + "/" : ".emotions/";
        if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
            Bitmap b2 = b(str, str2, bVar);
            if (b2 == null) {
                return null;
            }
            return new com.baidu.adp.widget.ImageView.a(b2, false, str2);
        }
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar = new com.baidu.adp.lib.Disk.ops.a(str3, str2, DiskFileOperate.Action.READ);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSubFolder(false);
        aVar.setIsFormatData(false);
        aVar.setSavedCache(false);
        aVar.setSdCard(false);
        aVar.setLock(bArr);
        if (bVar != null) {
            com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
            dVar.f(aVar);
            bVar.Nl = dVar;
        }
        if (d.lg().c(aVar)) {
            int i = 2000;
            if (j.isWifiNet()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (aVar.isSuccess()) {
                aVar.formatData(aVar.getData());
                return new com.baidu.adp.widget.ImageView.a(aVar.lm());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, b bVar) {
        Bitmap bitmap;
        StringBuilder append = new StringBuilder().append(".emotions/");
        if (str == null) {
            str = "";
        }
        byte[] bArr = new byte[0];
        com.baidu.tbadk.core.util.i iVar = new com.baidu.tbadk.core.util.i(append.append(str).toString(), str2, DiskFileOperate.Action.READ);
        iVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        iVar.setSubFolder(false);
        iVar.setIsFormatData(false);
        iVar.setSavedCache(false);
        iVar.setSdCard(false);
        iVar.setLock(bArr);
        if (bVar != null) {
            com.baidu.tbadk.core.util.d.d dVar = new com.baidu.tbadk.core.util.d.d();
            dVar.f(iVar);
            bVar.Nl = dVar;
        }
        if (d.lg().c(iVar)) {
            int i = 2000;
            if (j.isWifiNet()) {
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
                iVar.formatData(iVar.getData());
                bitmap = iVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return 1;
    }
}
