package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        bu buVar;
        bu buVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        b bVar;
        b bVar2;
        b bVar3;
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
        bu buVar3;
        int i2 = 0;
        if (i == 0) {
            buVar3 = this.aBu.aAF;
            if (buVar3.Cj()) {
                this.aBu.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.aBu, 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo10 = this.aBu.writeImagesInfo;
                    int size = writeImagesInfo10.size();
                    writeImagesInfo11 = this.aBu.writeImagesInfo;
                    if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                        this.aBu.ayG = String.valueOf(System.currentTimeMillis());
                        FrsActivity frsActivity = this.aBu;
                        str = this.aBu.ayG;
                        com.baidu.tbadk.core.util.av.a(frsActivity, str);
                        return;
                    }
                    this.aBu.showToast(String.format(this.aBu.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo7 = this.aBu.writeImagesInfo;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.aBu.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            FrsActivity frsActivity2 = this.aBu;
                            writeImagesInfo9 = this.aBu.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(frsActivity2, writeImagesInfo9.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.aBu.writeImagesInfo;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.aBu.writeImagesInfo;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.aBu.writeImagesInfo;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity3 = this.aBu;
                                writeImagesInfo6 = this.aBu.writeImagesInfo;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(frsActivity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    this.aBu.ED();
                    alertDialog = this.aBu.ayP;
                    if (alertDialog == null) {
                        return;
                    }
                    alertDialog2 = this.aBu.ayP;
                    com.baidu.adp.lib.g.j.a(alertDialog2, this.aBu);
                } else if (i == 48) {
                    if (PluginHelper.isBaoBaoCanUse(this.aBu)) {
                        com.baidu.tieba.e.a.adK();
                        if (!com.baidu.tieba.e.a.adI()) {
                            bVar = this.aBu.azN;
                            if (bVar != null) {
                                bVar2 = this.aBu.azN;
                                if (bVar2.getUserData() != null) {
                                    bVar3 = this.aBu.azN;
                                    if (bVar3.getUserData().getIsMem() == 0) {
                                        this.aBu.showToast(com.baidu.tieba.y.baobao_over_limit);
                                        return;
                                    }
                                }
                            }
                        }
                        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                        if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                            baobaoSdkDelegate.startMatchImage(this.aBu, this.aBu.getResources().getString(com.baidu.tieba.y.send_reply), 12013);
                        }
                    }
                } else if (i == 51) {
                    writeImagesInfo = this.aBu.baobaoImagesInfo;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.aBu.baobaoImagesInfo;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.aBu.aAW;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.aBu.aAW;
                    writeData.setIsBaobao(false);
                } else if (i == 52) {
                    buVar = this.aBu.aAF;
                    if (buVar.EQ() != null) {
                        buVar2 = this.aBu.aAF;
                        i2 = buVar2.EQ().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.aBu.Ez();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aBu.Ey();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null));
                }
            }
        } else {
            this.aBu.eX(null);
        }
    }
}
