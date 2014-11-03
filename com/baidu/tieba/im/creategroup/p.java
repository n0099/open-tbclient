package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnClickListener {
    final /* synthetic */ o aUr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aUr = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        if (i == 0) {
            av.h(this.aUr.aTd);
        } else if (i == 1) {
            CreateGroupStepActivity createGroupStepActivity = this.aUr.aTd;
            writeImagesInfo = this.aUr.writeImagesInfo;
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(createGroupStepActivity, writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }
}
