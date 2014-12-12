package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.aCV = frsActivity;
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
            writeImagesInfo4 = this.aCV.writeImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.aCV.writeImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.aCV.writeImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.aCV.showToast(String.format(this.aCV.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.aCV.aAI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.aCV.getPageContext();
            str = this.aCV.aAI;
            com.baidu.tbadk.core.util.aw.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.aCV.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.aCV.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity pageActivity = this.aCV.getPageContext().getPageActivity();
                    writeImagesInfo3 = this.aCV.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
