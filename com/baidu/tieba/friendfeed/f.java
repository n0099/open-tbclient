package com.baidu.tieba.friendfeed;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
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
            yVar3 = this.aAU.aAB;
            if (yVar3.Fl()) {
                this.aAU.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aAU.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo8 = this.aAU.apq;
                    int size = writeImagesInfo8.size();
                    writeImagesInfo9 = this.aAU.apq;
                    if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                        this.aAU.aAI = String.valueOf(System.currentTimeMillis());
                        TbPageContext pageContext = this.aAU.getPageContext();
                        str = this.aAU.aAI;
                        aw.a(pageContext, str);
                        return;
                    }
                    this.aAU.showToast(String.format(this.aAU.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo5 = this.aAU.apq;
                    if (writeImagesInfo5 != null) {
                        writeImagesInfo6 = this.aAU.apq;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity pageActivity = this.aAU.getPageContext().getPageActivity();
                            writeImagesInfo7 = this.aAU.apq;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo = this.aAU.apq;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aAU.apq;
                        if (writeImagesInfo2.getChosedFiles() != null) {
                            writeImagesInfo3 = this.aAU.apq;
                            int size2 = writeImagesInfo3.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity2 = this.aAU.getPageContext().getPageActivity();
                                writeImagesInfo4 = this.aAU.apq;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                    if (i == 52) {
                        yVar = this.aAU.aAB;
                        if (yVar.Fh() != null) {
                            yVar2 = this.aAU.aAB;
                            i2 = yVar2.Fh().getLocationInfoViewState();
                        }
                        switch (i2) {
                            case 0:
                                this.aAU.ER();
                                return;
                            case 1:
                            default:
                                return;
                            case 2:
                                this.aAU.EQ();
                                return;
                        }
                    } else if (i == 53) {
                        MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    }
                } else {
                    alertDialog = this.aAU.aAR;
                    if (alertDialog == null) {
                        this.aAU.EU();
                    }
                    alertDialog2 = this.aAU.aAR;
                    if (alertDialog2 == null) {
                        return;
                    }
                    alertDialog3 = this.aAU.aAR;
                    com.baidu.adp.lib.g.k.a(alertDialog3, this.aAU.getPageContext());
                }
            }
        } else {
            this.aAU.fs(null);
        }
    }
}
