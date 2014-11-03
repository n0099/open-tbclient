package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class l implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupInfoActivity baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupInfoActivity groupInfoActivity) {
        this.baC = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        if (i == 0) {
            av.h(this.baC);
        } else if (i == 1) {
            GroupInfoActivity groupInfoActivity = this.baC;
            writeImagesInfo = this.baC.writeImagesInfo;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(groupInfoActivity, writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }
}
