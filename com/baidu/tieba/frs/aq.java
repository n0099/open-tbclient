package com.baidu.tieba.frs;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
final class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.a.S;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.S;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.S;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.T = String.valueOf(System.currentTimeMillis());
            FrsActivity frsActivity = this.a;
            str = this.a.T;
            com.baidu.tbadk.core.util.az.a(frsActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.S;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.S;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FrsActivity frsActivity2 = this.a;
                    writeImagesInfo3 = this.a.S;
                    com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(frsActivity2, writeImagesInfo3.toJsonString());
                    aVar.a(12002);
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                }
            }
        }
    }
}
