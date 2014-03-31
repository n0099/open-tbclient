package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
final class aj implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        String str;
        if (i == 0) {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this.a, 12004, true)));
        } else if (i == 10) {
            FrsActivity.j(this.a, null);
        } else if (i != 4) {
            if (i == 22) {
                writeImagesInfo8 = this.a.S;
                int size = writeImagesInfo8.size();
                writeImagesInfo9 = this.a.S;
                if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                    this.a.T = String.valueOf(System.currentTimeMillis());
                    FrsActivity frsActivity = this.a;
                    str = this.a.T;
                    com.baidu.tbadk.core.util.az.a(frsActivity, str);
                    return;
                }
                this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo5 = this.a.S;
                if (writeImagesInfo5 != null) {
                    writeImagesInfo6 = this.a.S;
                    if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                        FrsActivity frsActivity2 = this.a;
                        writeImagesInfo7 = this.a.S;
                        com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(frsActivity2, writeImagesInfo7.toJsonString());
                        aVar.a(12002);
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                    }
                }
            } else if (i == 42) {
                int intValue = ((Integer) obj).intValue();
                writeImagesInfo = this.a.S;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.a.S;
                    if (writeImagesInfo2.getChosedFiles() != null) {
                        writeImagesInfo3 = this.a.S;
                        int size2 = writeImagesInfo3.getChosedFiles().size();
                        if (size2 > 0 && intValue >= 0 && intValue < size2) {
                            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
                            FrsActivity frsActivity3 = this.a;
                            writeImagesInfo4 = this.a.S;
                            a.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(frsActivity3, 12012, writeImagesInfo4, intValue)));
                        }
                    }
                }
            } else if (i != 7) {
            } else {
                alertDialog = this.a.aw;
                if (alertDialog == null) {
                    return;
                }
                alertDialog2 = this.a.aw;
                alertDialog2.show();
            }
        }
    }
}
