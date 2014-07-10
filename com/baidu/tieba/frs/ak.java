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
public class ak implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
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
        ct ctVar;
        if (i == 0) {
            ctVar = this.a.v;
            if (ctVar.ae()) {
                this.a.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo10 = this.a.X;
                    int size = writeImagesInfo10.size();
                    writeImagesInfo11 = this.a.X;
                    if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                        this.a.aa = String.valueOf(System.currentTimeMillis());
                        FrsActivity frsActivity = this.a;
                        str = this.a.aa;
                        com.baidu.tbadk.core.util.bj.a(frsActivity, str);
                        return;
                    }
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo7 = this.a.X;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.a.X;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            FrsActivity frsActivity2 = this.a;
                            writeImagesInfo9 = this.a.X;
                            com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(frsActivity2, writeImagesInfo9.toJsonString());
                            bVar.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.a.X;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.a.X;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.a.X;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity3 = this.a;
                                writeImagesInfo6 = this.a.X;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx(frsActivity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 7) {
                    this.a.n();
                    alertDialog = this.a.aB;
                    if (alertDialog == null) {
                        return;
                    }
                    alertDialog2 = this.a.aB;
                    alertDialog2.show();
                } else if (i == 48) {
                    com.baidu.tieba.d.a.c();
                    if (!com.baidu.tieba.d.a.a()) {
                        gVar = this.a.H;
                        if (gVar != null) {
                            gVar2 = this.a.H;
                            if (gVar2.i() != null) {
                                gVar3 = this.a.H;
                                if (gVar3.i().getIsMem() == 0) {
                                    this.a.showToast(com.baidu.tieba.y.baobao_over_limit);
                                    return;
                                }
                            }
                        }
                    }
                    BaobaoSdkDelegate baobaoSdkDelegate = (BaobaoSdkDelegate) com.baidu.tbadk.tbplugin.m.a().b(BaobaoSdkDelegate.class);
                    if (baobaoSdkDelegate != null) {
                        baobaoSdkDelegate.startMatchImage(this.a, this.a.getResources().getString(com.baidu.tieba.y.send_reply), 12013);
                    }
                } else if (i == 51) {
                    writeImagesInfo = this.a.Y;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.a.Y;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.a.Z;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.a.Z;
                    writeData.setIsBaobao(false);
                }
            }
        } else {
            this.a.d((String) null);
        }
    }
}
