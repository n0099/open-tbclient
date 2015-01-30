package com.baidu.tieba.frs;

import android.app.Activity;
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
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        bp bpVar;
        bp bpVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
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
        WriteImagesInfo writeImagesInfo13;
        WriteImagesInfo writeImagesInfo14;
        String str;
        bp bpVar3;
        int i2 = 0;
        if (i == 0) {
            bpVar3 = this.aDW.aCY;
            if (bpVar3.FJ()) {
                this.aDW.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aDW.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo13 = this.aDW.writeImagesInfo;
                    int size = writeImagesInfo13.size();
                    writeImagesInfo14 = this.aDW.writeImagesInfo;
                    if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                        this.aDW.aBK = String.valueOf(System.currentTimeMillis());
                        TbPageContext pageContext = this.aDW.getPageContext();
                        str = this.aDW.aBK;
                        com.baidu.tbadk.core.util.bb.a(pageContext, str);
                        return;
                    }
                    this.aDW.showToast(String.format(this.aDW.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo10 = this.aDW.writeImagesInfo;
                    if (writeImagesInfo10 != null) {
                        writeImagesInfo11 = this.aDW.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                            Activity pageActivity = this.aDW.getPageContext().getPageActivity();
                            writeImagesInfo12 = this.aDW.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo6 = this.aDW.writeImagesInfo;
                    if (writeImagesInfo6 != null) {
                        writeImagesInfo7 = this.aDW.writeImagesInfo;
                        if (writeImagesInfo7.getChosedFiles() != null) {
                            writeImagesInfo8 = this.aDW.writeImagesInfo;
                            int size2 = writeImagesInfo8.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity activity = this.aDW.getActivity();
                                writeImagesInfo9 = this.aDW.writeImagesInfo;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo9, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    writeImagesInfo3 = this.aDW.writeImagesInfo;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.aDW.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo4.toJsonString())) {
                            String valueOf = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity2 = this.aDW.getPageContext().getPageActivity();
                            writeImagesInfo5 = this.aDW.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo5.toJsonString(), valueOf);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 48) {
                    com.baidu.tieba.tbadkCore.PbEditor.a.afn();
                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.afl()) {
                        eVar = this.aDW.aDi;
                        if (eVar != null) {
                            eVar2 = this.aDW.aDi;
                            if (eVar2.getUserData() != null) {
                                eVar3 = this.aDW.aDi;
                                if (eVar3.getUserData().getIsMem() == 0) {
                                    this.aDW.showToast(com.baidu.tieba.z.baobao_over_limit);
                                    return;
                                }
                            }
                        }
                    }
                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.aDW.getPageContext().getPageActivity());
                    aVar.getIntent().putExtra("title", this.aDW.getResources().getString(com.baidu.tieba.z.send_reply));
                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                    this.aDW.sendMessage(new CustomMessage(2802001, aVar));
                } else if (i == 51) {
                    writeImagesInfo = this.aDW.baobaoImagesInfo;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aDW.baobaoImagesInfo;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.aDW.aDs;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.aDW.aDs;
                    writeData.setIsBaobao(false);
                } else if (i == 52) {
                    bpVar = this.aDW.aCY;
                    if (bpVar.FF() != null) {
                        bpVar2 = this.aDW.aCY;
                        i2 = bpVar2.FF().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aDW.Fq();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aDW.Fp();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            this.aDW.fx(null);
        }
    }
}
