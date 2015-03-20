package com.baidu.tieba.friendFeed;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        y yVar;
        y yVar2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        String str;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        y yVar3;
        int i2 = 0;
        if (i == 0) {
            yVar3 = this.aHM.aHt;
            if (yVar3.Jc()) {
                this.aHM.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aHM.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 23) {
                    writeImagesInfo8 = this.aHM.aHD;
                    if (writeImagesInfo8 != null) {
                        writeImagesInfo9 = this.aHM.aHD;
                        if (!TextUtils.isEmpty(writeImagesInfo9.toJsonString())) {
                            Activity pageActivity = this.aHM.getPageContext().getPageActivity();
                            writeImagesInfo10 = this.aHM.aHD;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo10.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo4 = this.aHM.aHD;
                    if (writeImagesInfo4 != null) {
                        writeImagesInfo5 = this.aHM.aHD;
                        if (writeImagesInfo5.getChosedFiles() != null) {
                            writeImagesInfo6 = this.aHM.aHD;
                            int size = writeImagesInfo6.getChosedFiles().size();
                            if (size >= 1 && intValue >= 0 && intValue < size) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity2 = this.aHM.getPageContext().getPageActivity();
                                writeImagesInfo7 = this.aHM.aHD;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo7, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    writeImagesInfo = this.aHM.aHD;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aHM.aHD;
                        if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                            this.aHM.aHA = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity3 = this.aHM.getPageContext().getPageActivity();
                            writeImagesInfo3 = this.aHM.aHD;
                            String jsonString = writeImagesInfo3.toJsonString();
                            str = this.aHM.aHA;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity3, jsonString, str);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 52) {
                    yVar = this.aHM.aHt;
                    if (yVar.IY() != null) {
                        yVar2 = this.aHM.aHt;
                        i2 = yVar2.IY().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aHM.IJ();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aHM.II();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            this.aHM.fD(null);
        }
    }
}
