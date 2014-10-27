package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupInfoActivity ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(GroupInfoActivity groupInfoActivity) {
        this.ban = groupInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        if (i == 0) {
            av.h(this.ban);
        } else if (i == 1) {
            GroupInfoActivity groupInfoActivity = this.ban;
            writeImagesInfo = this.ban.writeImagesInfo;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(groupInfoActivity, writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }
}
