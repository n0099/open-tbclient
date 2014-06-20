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
            writeImagesInfo4 = this.a.Y;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.Y;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.Y;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.Z = String.valueOf(System.currentTimeMillis());
            FrsActivity frsActivity = this.a;
            str = this.a.Z;
            com.baidu.tbadk.core.util.bd.a(frsActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.Y;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.Y;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FrsActivity frsActivity2 = this.a;
                    writeImagesInfo3 = this.a.Y;
                    com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(frsActivity2, writeImagesInfo3.toJsonString());
                    aVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
                }
            }
        }
    }
}
