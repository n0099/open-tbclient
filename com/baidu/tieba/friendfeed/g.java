package com.baidu.tieba.friendfeed;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
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
            writeImagesInfo4 = this.ayL.ahS;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.ayL.ahS;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.ayL.ahS;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.ayL.showToast(String.format(this.ayL.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.ayL.ayx = String.valueOf(System.currentTimeMillis());
            FriendFeedActivity friendFeedActivity = this.ayL;
            str = this.ayL.ayx;
            av.a(friendFeedActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.ayL.ahS;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.ayL.ahS;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FriendFeedActivity friendFeedActivity2 = this.ayL;
                    writeImagesInfo3 = this.ayL.ahS;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(friendFeedActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
