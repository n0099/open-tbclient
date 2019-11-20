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
    public boolean fW() {
        return i.ago().isShowImages();
    }

    private String ae(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return c.avs().pY(ae(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
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
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bdx = com.baidu.tieba.emotion.editortool.e.bdv().bdx();
        if (com.baidu.tieba.emotion.editortool.e.bdv().uR(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.bdv().af(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.bdv().uT(valueOf2) && valueOf3.booleanValue()) {
            String af = com.baidu.tieba.emotion.editortool.e.bdv().af(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.bdv().uS(valueOf2);
            if (!new File(m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + af).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String af2 = com.baidu.tieba.emotion.editortool.e.bdv().af(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = bdx.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar4 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.pC(valueOf2)) {
                            if (next.aul()) {
                                aVar4 = next.pE(valueOf2);
                            } else {
                                aVar4 = a(next.getGroupId(), af2, aVar);
                            }
                        }
                    }
                    if (aVar4 == null && str3 != null) {
                        return a(str3, af2, aVar);
                    }
                    return aVar4;
                }
                String af3 = com.baidu.tieba.emotion.editortool.e.bdv().af(valueOf2, false);
                String replaceFirst = (booleanValue && com.baidu.tieba.emotion.editortool.e.bdv().uT(valueOf2)) ? af3.replaceFirst("s_", "d_") : af3;
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = bdx.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar2 = aVar5;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                    if (!next2.pC(valueOf2)) {
                        aVar3 = aVar5;
                    } else if (next2.aul()) {
                        aVar3 = next2.pD(valueOf2);
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
        byte[] P;
        com.baidu.adp.widget.ImageView.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null || (P = (iVar = new com.baidu.tbadk.core.util.a.i()).P(valueOf4, false)) == null || !iVar.amX()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String af = com.baidu.tieba.emotion.editortool.e.bdv().af(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, af, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.setSubFolder(false);
                aVar3.setSavedCache(false);
                aVar3.setSdCard(false);
                aVar3.setData(P);
                d.eP().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.e.e eVar = new com.baidu.tbadk.core.util.e.e();
                    eVar.f(aVar3);
                    aVar.pi = eVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.bdv().bdx().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.pC(valueOf2)) {
                        aVar2 = a(next.getGroupId(), af, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, af, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.avs().freePicCache(80000);
                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(P), i, i2);
                if (checkBitmapSize == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, af, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(false);
                cVar.setData(P);
                cVar.setSavedCache(false);
                cVar.setSdCard(false);
                cVar.setGif(valueOf3.booleanValue());
                d.eP().c(cVar);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.e.e eVar2 = new com.baidu.tbadk.core.util.e.e();
                    eVar2.f(cVar);
                    aVar.pi = eVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ac(i);
            aVar.ad(i2);
            c.avs().c(ae(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
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
        aVar2.setSubFolder(false);
        aVar2.setIsFormatData(false);
        aVar2.setSavedCache(false);
        aVar2.setSdCard(false);
        aVar2.setLock(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.e.e eVar = new com.baidu.tbadk.core.util.e.e();
            eVar.f(aVar2);
            aVar.pi = eVar;
        }
        if (d.eP().c(aVar2)) {
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
            if (aVar2.isSuccess()) {
                aVar2.formatData(aVar2.getData());
                return new com.baidu.adp.widget.ImageView.a(aVar2.eT());
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
        hVar.setSubFolder(false);
        hVar.setIsFormatData(false);
        hVar.setSavedCache(false);
        hVar.setSdCard(false);
        hVar.setLock(bArr);
        if (aVar != null) {
            com.baidu.tbadk.core.util.e.e eVar = new com.baidu.tbadk.core.util.e.e();
            eVar.f(hVar);
            aVar.pi = eVar;
        }
        if (d.eP().c(hVar)) {
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
            if (hVar.isSuccess()) {
                hVar.formatData(hVar.getData());
                bitmap = hVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fX() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fY() {
        return 1;
    }
}
