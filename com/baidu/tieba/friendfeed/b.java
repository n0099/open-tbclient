package com.baidu.tieba.friendfeed;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements DialogInterface.OnClickListener {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
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
            writeImagesInfo4 = this.a.k;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.k;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.k;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.showToast(String.format(this.a.getString(x.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.h = String.valueOf(System.currentTimeMillis());
            FriendFeedActivity friendFeedActivity = this.a;
            str = this.a.h;
            ax.a(friendFeedActivity, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.k;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.k;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    FriendFeedActivity friendFeedActivity2 = this.a;
                    writeImagesInfo3 = this.a.k;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(friendFeedActivity2, writeImagesInfo3.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        }
    }
}
