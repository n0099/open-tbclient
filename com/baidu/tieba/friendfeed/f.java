package com.baidu.tieba.friendfeed;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        x xVar;
        x xVar2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        WriteImagesInfo writeImagesInfo12;
        String str;
        x xVar3;
        int i2 = 0;
        if (i == 0) {
            xVar3 = this.aBV.aBD;
            if (xVar3.FJ()) {
                this.aBV.showToast(z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aBV.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo11 = this.aBV.aql;
                    int size = writeImagesInfo11.size();
                    writeImagesInfo12 = this.aBV.aql;
                    if (size < writeImagesInfo12.getMaxImagesAllowed()) {
                        this.aBV.aBK = String.valueOf(System.currentTimeMillis());
                        TbPageContext pageContext = this.aBV.getPageContext();
                        str = this.aBV.aBK;
                        bb.a(pageContext, str);
                        return;
                    }
                    this.aBV.showToast(String.format(this.aBV.getPageContext().getString(z.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo8 = this.aBV.aql;
                    if (writeImagesInfo8 != null) {
                        writeImagesInfo9 = this.aBV.aql;
                        if (!TextUtils.isEmpty(writeImagesInfo9.toJsonString())) {
                            Activity pageActivity = this.aBV.getPageContext().getPageActivity();
                            writeImagesInfo10 = this.aBV.aql;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo10.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo4 = this.aBV.aql;
                    if (writeImagesInfo4 != null) {
                        writeImagesInfo5 = this.aBV.aql;
                        if (writeImagesInfo5.getChosedFiles() != null) {
                            writeImagesInfo6 = this.aBV.aql;
                            int size2 = writeImagesInfo6.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity2 = this.aBV.getPageContext().getPageActivity();
                                writeImagesInfo7 = this.aBV.aql;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo7, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    writeImagesInfo = this.aBV.aql;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aBV.aql;
                        if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity3 = this.aBV.getPageContext().getPageActivity();
                            writeImagesInfo3 = this.aBV.aql;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity3, writeImagesInfo3.toJsonString(), valueOf);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 52) {
                    xVar = this.aBV.aBD;
                    if (xVar.FF() != null) {
                        xVar2 = this.aBV.aBD;
                        i2 = xVar2.FF().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aBV.Fq();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aBV.Fp();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            this.aBV.fx(null);
        }
    }
}
