package com.baidu.tieba.emotion.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.e.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.i;
import com.baidu.tbadk.core.util.h;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.imageManager.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class a implements e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return k.biL().isShowImages();
    }

    private String aL(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return c.bAt().DA(aL(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
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
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cqn = com.baidu.tieba.emotion.editortool.e.cql().cqn();
        if (com.baidu.tieba.emotion.editortool.e.cql().IR(valueOf2) && valueOf3.booleanValue() && !new File(com.baidu.tieba.emotion.editortool.e.cql().aM(valueOf2, true)).exists()) {
            valueOf3 = false;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (com.baidu.tieba.emotion.editortool.e.cql().IT(valueOf2) && valueOf3.booleanValue()) {
            String aM = com.baidu.tieba.emotion.editortool.e.cql().aM(valueOf2, true);
            valueOf = com.baidu.tieba.emotion.editortool.e.cql().IS(valueOf2);
            if (!new File(n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + valueOf + "/" + aM).exists()) {
                valueOf3 = false;
                str3 = valueOf;
                if (!valueOf3.booleanValue()) {
                    String aM2 = com.baidu.tieba.emotion.editortool.e.cql().aM(valueOf2, true);
                    Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = cqn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar4 = null;
                            break;
                        }
                        com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                        if (next.Df(valueOf2)) {
                            if (next.bzg()) {
                                aVar4 = next.Dh(valueOf2);
                            } else {
                                aVar4 = a(next.getGroupId(), aM2, aVar);
                            }
                        }
                    }
                    if (aVar4 == null && str3 != null) {
                        return a(str3, aM2, aVar);
                    }
                    return aVar4;
                }
                String aM3 = com.baidu.tieba.emotion.editortool.e.cql().aM(valueOf2, false);
                String replaceFirst = (booleanValue && com.baidu.tieba.emotion.editortool.e.cql().IT(valueOf2)) ? aM3.replaceFirst("s_", "d_") : aM3;
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it2 = cqn.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar2 = aVar5;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next2 = it2.next();
                    if (!next2.Df(valueOf2)) {
                        aVar3 = aVar5;
                    } else if (next2.bzg()) {
                        aVar3 = next2.Dg(valueOf2);
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
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
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
        boolean bqQ = iVar.bqQ();
        if (aw == null || !iVar.bqP()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String aM = com.baidu.tieba.emotion.editortool.e.cql().aM(valueOf2, valueOf3.booleanValue());
            String str3 = ".emotions/" + valueOf;
            if (valueOf3.booleanValue()) {
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(str3, aM, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.setSubFolder(false);
                aVar3.setSavedCache(false);
                aVar3.setSdCard(false);
                aVar3.setData(aw);
                d.lL().b(aVar3);
                if (aVar != null) {
                    com.baidu.tbadk.core.util.c.e eVar = new com.baidu.tbadk.core.util.c.e();
                    eVar.f(aVar3);
                    aVar.MS = eVar;
                }
                Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = com.baidu.tieba.emotion.editortool.e.cql().cqn().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar2 = null;
                        break;
                    }
                    com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                    if (next.Df(valueOf2)) {
                        aVar2 = a(next.getGroupId(), aM, aVar);
                        break;
                    }
                }
                if (aVar2 == null && valueOf != null) {
                    aVar2 = a(valueOf, aM, aVar);
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                c.bAt().freePicCache(80000);
                Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aw), i, i2);
                if (checkBitmapSize == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                aVar2.setNeedCache(bqQ);
                if (bqQ) {
                    com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(str3, aM, DiskFileOperate.Action.WRITE);
                    cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    cVar.setSubFolder(false);
                    cVar.setData(aw);
                    cVar.setSavedCache(false);
                    cVar.setSdCard(false);
                    cVar.setGif(valueOf3.booleanValue());
                    d.lL().c(cVar);
                    if (aVar != null) {
                        com.baidu.tbadk.core.util.c.e eVar2 = new com.baidu.tbadk.core.util.c.e();
                        eVar2.f(cVar);
                        aVar.MS = eVar2;
                    }
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aK(i);
            aVar.aL(i2);
            c.bAt().c(aL(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar) {
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
            com.baidu.tbadk.core.util.c.e eVar = new com.baidu.tbadk.core.util.c.e();
            eVar.f(aVar2);
            aVar.MS = eVar;
        }
        if (d.lL().c(aVar2)) {
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
                return new com.baidu.adp.widget.ImageView.a(aVar2.lP());
            }
            return null;
        }
        return null;
    }

    public Bitmap b(String str, String str2, com.baidu.adp.lib.e.a aVar) {
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
            com.baidu.tbadk.core.util.c.e eVar = new com.baidu.tbadk.core.util.c.e();
            eVar.f(hVar);
            aVar.MS = eVar;
        }
        if (d.lL().c(hVar)) {
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

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mW() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mX() {
        return 1;
    }
}
