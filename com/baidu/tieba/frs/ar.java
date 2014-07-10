package com.baidu.tieba.frs;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.a.X;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.X;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.X;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.aa = String.valueOf(System.currentTimeMillis());
            FrsActivity frsActivity = this.a;
            str = this.a.aa;
            com.baidu.tbadk.core.util.bj.a(frsActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.X;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.X;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FrsActivity frsActivity2 = this.a;
                    writeImagesInfo3 = this.a.X;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(frsActivity2, writeImagesInfo3.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        }
    }
}
