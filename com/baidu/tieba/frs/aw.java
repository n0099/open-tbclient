package com.baidu.tieba.frs;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
            writeImagesInfo4 = this.aBu.writeImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.aBu.writeImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.aBu.writeImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.aBu.showToast(String.format(this.aBu.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.aBu.ayG = String.valueOf(System.currentTimeMillis());
            FrsActivity frsActivity = this.aBu;
            str = this.aBu.ayG;
            com.baidu.tbadk.core.util.av.a(frsActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.aBu.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.aBu.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FrsActivity frsActivity2 = this.aBu;
                    writeImagesInfo3 = this.aBu.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(frsActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
