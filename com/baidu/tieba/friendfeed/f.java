package com.baidu.tieba.friendfeed;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        y yVar;
        y yVar2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        String str;
        y yVar3;
        int i2 = 0;
        if (i == 0) {
            yVar3 = this.ayL.ayq;
            if (yVar3.Ch()) {
                this.ayL.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.ayL, 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo8 = this.ayL.ahS;
                    int size = writeImagesInfo8.size();
                    writeImagesInfo9 = this.ayL.ahS;
                    if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                        this.ayL.ayx = String.valueOf(System.currentTimeMillis());
                        FriendFeedActivity friendFeedActivity = this.ayL;
                        str = this.ayL.ayx;
                        av.a(friendFeedActivity, str);
                        return;
                    }
                    this.ayL.showToast(String.format(this.ayL.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo5 = this.ayL.ahS;
                    if (writeImagesInfo5 != null) {
                        writeImagesInfo6 = this.ayL.ahS;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            FriendFeedActivity friendFeedActivity2 = this.ayL;
                            writeImagesInfo7 = this.ayL.ahS;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(friendFeedActivity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo = this.ayL.ahS;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.ayL.ahS;
                        if (writeImagesInfo2.getChosedFiles() != null) {
                            writeImagesInfo3 = this.ayL.ahS;
                            int size2 = writeImagesInfo3.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FriendFeedActivity friendFeedActivity3 = this.ayL;
                                writeImagesInfo4 = this.ayL.ahS;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(friendFeedActivity3, 12012, writeImagesInfo4, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                    if (i != 52) {
                        if (i == 53) {
                            MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null));
                            return;
                        }
                        return;
                    }
                    yVar = this.ayL.ayq;
                    if (yVar.EO() != null) {
                        yVar2 = this.ayL.ayq;
                        i2 = yVar2.EO().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.ayL.Ex();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.ayL.Ew();
                            return;
                    }
                } else {
                    alertDialog = this.ayL.ayG;
                    if (alertDialog == null) {
                        this.ayL.EB();
                    }
                    alertDialog2 = this.ayL.ayG;
                    if (alertDialog2 == null) {
                        return;
                    }
                    alertDialog3 = this.ayL.ayG;
                    com.baidu.adp.lib.g.j.a(alertDialog3, this.ayL);
                }
            }
        } else {
            this.ayL.eX(null);
        }
    }
}
