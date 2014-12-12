package com.baidu.tieba.friendfeed;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
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
            writeImagesInfo4 = this.aAU.apq;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.aAU.apq;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.aAU.apq;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.aAU.showToast(String.format(this.aAU.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.aAU.aAI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.aAU.getPageContext();
            str = this.aAU.aAI;
            aw.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.aAU.apq;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.aAU.apq;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity pageActivity = this.aAU.getPageContext().getPageActivity();
                    writeImagesInfo3 = this.aAU.apq;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
