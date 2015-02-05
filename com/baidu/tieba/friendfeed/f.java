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
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
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
            xVar3 = this.aBS.aBA;
            if (xVar3.FD()) {
                this.aBS.showToast(z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aBS.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo11 = this.aBS.aqi;
                    int size = writeImagesInfo11.size();
                    writeImagesInfo12 = this.aBS.aqi;
                    if (size < writeImagesInfo12.getMaxImagesAllowed()) {
                        this.aBS.aBH = String.valueOf(System.currentTimeMillis());
                        TbPageContext pageContext = this.aBS.getPageContext();
                        str = this.aBS.aBH;
                        bb.a(pageContext, str);
                        return;
                    }
                    this.aBS.showToast(String.format(this.aBS.getPageContext().getString(z.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo8 = this.aBS.aqi;
                    if (writeImagesInfo8 != null) {
                        writeImagesInfo9 = this.aBS.aqi;
                        if (!TextUtils.isEmpty(writeImagesInfo9.toJsonString())) {
                            Activity pageActivity = this.aBS.getPageContext().getPageActivity();
                            writeImagesInfo10 = this.aBS.aqi;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo10.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo4 = this.aBS.aqi;
                    if (writeImagesInfo4 != null) {
                        writeImagesInfo5 = this.aBS.aqi;
                        if (writeImagesInfo5.getChosedFiles() != null) {
                            writeImagesInfo6 = this.aBS.aqi;
                            int size2 = writeImagesInfo6.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity2 = this.aBS.getPageContext().getPageActivity();
                                writeImagesInfo7 = this.aBS.aqi;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo7, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    writeImagesInfo = this.aBS.aqi;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aBS.aqi;
                        if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity3 = this.aBS.getPageContext().getPageActivity();
                            writeImagesInfo3 = this.aBS.aqi;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity3, writeImagesInfo3.toJsonString(), valueOf);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 52) {
                    xVar = this.aBS.aBA;
                    if (xVar.Fz() != null) {
                        xVar2 = this.aBS.aBA;
                        i2 = xVar2.Fz().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aBS.Fk();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aBS.Fj();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            this.aBS.fu(null);
        }
    }
}
