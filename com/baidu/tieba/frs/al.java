package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
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
        if (i == 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this.a, 12004, true)));
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo8 = this.a.Z;
                    int size = writeImagesInfo8.size();
                    writeImagesInfo9 = this.a.Z;
                    if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                        this.a.aa = String.valueOf(System.currentTimeMillis());
                        FrsActivity frsActivity = this.a;
                        str = this.a.aa;
                        com.baidu.tbadk.core.util.bb.a(frsActivity, str);
                        return;
                    }
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.u.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo5 = this.a.Z;
                    if (writeImagesInfo5 != null) {
                        writeImagesInfo6 = this.a.Z;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            FrsActivity frsActivity2 = this.a;
                            writeImagesInfo7 = this.a.Z;
                            com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(frsActivity2, writeImagesInfo7.toJsonString());
                            aVar.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo = this.a.Z;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.a.Z;
                        if (writeImagesInfo2.getChosedFiles() != null) {
                            writeImagesInfo3 = this.a.Z;
                            int size2 = writeImagesInfo3.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FrsActivity frsActivity3 = this.a;
                                writeImagesInfo4 = this.a.Z;
                                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bj(frsActivity3, 12012, writeImagesInfo4, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                } else {
                    alertDialog = this.a.aA;
                    if (alertDialog == null) {
                        return;
                    }
                    alertDialog2 = this.a.aA;
                    alertDialog2.show();
                }
            }
        } else {
            this.a.d((String) null);
        }
    }
}
