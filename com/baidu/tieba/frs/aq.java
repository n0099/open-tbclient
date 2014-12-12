package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        bq bqVar;
        bq bqVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        String str;
        bq bqVar3;
        int i2 = 0;
        if (i == 0) {
            bqVar3 = this.aCV.aBX;
            if (bqVar3.Fl()) {
                this.aCV.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aCV.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo10 = this.aCV.writeImagesInfo;
                    int size = writeImagesInfo10.size();
                    writeImagesInfo11 = this.aCV.writeImagesInfo;
                    if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                        this.aCV.aAI = String.valueOf(System.currentTimeMillis());
                        TbPageContext pageContext = this.aCV.getPageContext();
                        str = this.aCV.aAI;
                        com.baidu.tbadk.core.util.aw.a(pageContext, str);
                        return;
                    }
                    this.aCV.showToast(String.format(this.aCV.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo7 = this.aCV.writeImagesInfo;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.aCV.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            Activity pageActivity = this.aCV.getPageContext().getPageActivity();
                            writeImagesInfo9 = this.aCV.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo9.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.aCV.writeImagesInfo;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.aCV.writeImagesInfo;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.aCV.writeImagesInfo;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity activity = this.aCV.getActivity();
                                writeImagesInfo6 = this.aCV.writeImagesInfo;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    this.aCV.EU();
                    alertDialog = this.aCV.aAR;
                    if (alertDialog == null) {
                        return;
                    }
                    alertDialog2 = this.aCV.aAR;
                    com.baidu.adp.lib.g.k.a(alertDialog2, this.aCV.getPageContext());
                } else if (i == 48) {
                    com.baidu.tieba.tbadkCore.PbEditor.a.aeJ();
                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.aeH()) {
                        eVar = this.aCV.aCh;
                        if (eVar != null) {
                            eVar2 = this.aCV.aCh;
                            if (eVar2.getUserData() != null) {
                                eVar3 = this.aCV.aCh;
                                if (eVar3.getUserData().getIsMem() == 0) {
                                    this.aCV.showToast(com.baidu.tieba.z.baobao_over_limit);
                                    return;
                                }
                            }
                        }
                    }
                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.aCV.getPageContext().getPageActivity());
                    aVar.getIntent().putExtra("title", this.aCV.getResources().getString(com.baidu.tieba.z.send_reply));
                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                    this.aCV.sendMessage(new CustomMessage(2802001, aVar));
                } else if (i == 51) {
                    writeImagesInfo = this.aCV.baobaoImagesInfo;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aCV.baobaoImagesInfo;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.aCV.aCr;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.aCV.aCr;
                    writeData.setIsBaobao(false);
                } else if (i == 52) {
                    bqVar = this.aCV.aBX;
                    if (bqVar.Fh() != null) {
                        bqVar2 = this.aCV.aBX;
                        i2 = bqVar2.Fh().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aCV.ER();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aCV.EQ();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            this.aCV.fs(null);
        }
    }
}
