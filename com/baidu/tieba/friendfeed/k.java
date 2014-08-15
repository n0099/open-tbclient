package com.baidu.tieba.friendfeed;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.cg;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.editortool.w;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements w {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
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
        t tVar;
        if (i == 0) {
            tVar = this.a.c;
            if (tVar.e()) {
                this.a.showToast(x.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12004, true)));
            }
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo8 = this.a.k;
                    int size = writeImagesInfo8.size();
                    writeImagesInfo9 = this.a.k;
                    if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                        this.a.h = String.valueOf(System.currentTimeMillis());
                        FriendFeedActivity friendFeedActivity = this.a;
                        str = this.a.h;
                        ax.a(friendFeedActivity, str);
                        return;
                    }
                    this.a.showToast(String.format(this.a.getString(x.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo5 = this.a.k;
                    if (writeImagesInfo5 != null) {
                        writeImagesInfo6 = this.a.k;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            FriendFeedActivity friendFeedActivity2 = this.a;
                            writeImagesInfo7 = this.a.k;
                            com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(friendFeedActivity2, writeImagesInfo7.toJsonString());
                            bVar.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo = this.a.k;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.a.k;
                        if (writeImagesInfo2.getChosedFiles() != null) {
                            writeImagesInfo3 = this.a.k;
                            int size2 = writeImagesInfo3.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                FriendFeedActivity friendFeedActivity3 = this.a;
                                writeImagesInfo4 = this.a.k;
                                messageManager.sendMessage(new CustomMessage(2002001, new cg(friendFeedActivity3, 12012, writeImagesInfo4, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                } else {
                    alertDialog = this.a.o;
                    if (alertDialog == null) {
                        this.a.b();
                    }
                    alertDialog2 = this.a.o;
                    if (alertDialog2 == null) {
                        return;
                    }
                    alertDialog3 = this.a.o;
                    com.baidu.adp.lib.e.d.a(alertDialog3, this.a);
                }
            }
        } else {
            this.a.a((String) null);
        }
    }
}
