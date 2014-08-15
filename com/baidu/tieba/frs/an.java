package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        g gVar;
        g gVar2;
        g gVar3;
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
        cu cuVar;
        if (i == 0) {
            cuVar = this.a.z;
            if (cuVar.ab()) {
                this.a.showToast(com.baidu.tieba.x.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo10 = this.a.aa;
                    int size = writeImagesInfo10.size();
                    writeImagesInfo11 = this.a.aa;
                    if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                        this.a.ad = String.valueOf(System.currentTimeMillis());
                        FrsActivity frsActivity = this.a;
                        str = this.a.ad;
                        com.baidu.tbadk.core.util.ax.a(frsActivity, str);
                        return;
                    }
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo7 = this.a.aa;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.a.aa;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            FrsActivity frsActivity2 = this.a;
                            writeImagesInfo9 = this.a.aa;
                            com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(frsActivity2, writeImagesInfo9.toJsonString());
                            bVar.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.a.aa;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.a.aa;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.a.aa;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity3 = this.a;
                                writeImagesInfo6 = this.a.aa;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cg(frsActivity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    this.a.m();
                    alertDialog = this.a.aF;
                    if (alertDialog == null) {
                        return;
                    }
                    alertDialog2 = this.a.aF;
                    com.baidu.adp.lib.e.d.a(alertDialog2, this.a);
                } else if (i == 48) {
                    com.baidu.tieba.e.a.c();
                    if (!com.baidu.tieba.e.a.a()) {
                        gVar = this.a.L;
                        if (gVar != null) {
                            gVar2 = this.a.L;
                            if (gVar2.k() != null) {
                                gVar3 = this.a.L;
                                if (gVar3.k().getIsMem() == 0) {
                                    this.a.showToast(com.baidu.tieba.x.baobao_over_limit);
                                    return;
                                }
                            }
                        }
                    }
                    com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
                    if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
                        baobaoSdkDelegate.startMatchImage(this.a, this.a.getResources().getString(com.baidu.tieba.x.send_reply), 12013);
                    }
                } else if (i == 51) {
                    writeImagesInfo = this.a.ab;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.a.ab;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.a.ac;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.a.ac;
                    writeData.setIsBaobao(false);
                }
            }
        } else {
            this.a.d((String) null);
        }
    }
}
