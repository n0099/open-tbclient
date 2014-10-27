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
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.aBk = frsActivity;
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
            writeImagesInfo4 = this.aBk.writeImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.aBk.writeImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.aBk.writeImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.aBk.showToast(String.format(this.aBk.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.aBk.ayx = String.valueOf(System.currentTimeMillis());
            FrsActivity frsActivity = this.aBk;
            str = this.aBk.ayx;
            com.baidu.tbadk.core.util.av.a(frsActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.aBk.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.aBk.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FrsActivity frsActivity2 = this.aBk;
                    writeImagesInfo3 = this.aBk.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(frsActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
