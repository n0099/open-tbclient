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
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
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
            writeImagesInfo4 = this.ayU.aib;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.ayU.aib;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.ayU.aib;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.ayU.showToast(String.format(this.ayU.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.ayU.ayG = String.valueOf(System.currentTimeMillis());
            FriendFeedActivity friendFeedActivity = this.ayU;
            str = this.ayU.ayG;
            av.a(friendFeedActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.ayU.aib;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.ayU.aib;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FriendFeedActivity friendFeedActivity2 = this.ayU;
                    writeImagesInfo3 = this.ayU.aib;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(friendFeedActivity2, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
