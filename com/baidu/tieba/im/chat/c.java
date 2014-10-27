package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aNA = absMsgImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        g gVar;
        listMenu = this.aNA.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.aNA.aNr;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.aNA.aNr;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.aNA.aNp = new g(this.aNA, currentImageUrl, currentImageData);
                    gVar = this.aNA.aNp;
                    gVar.execute(new String[0]);
                    this.aNA.showProgressBarWithOffset(0, 0);
                } else {
                    this.aNA.showToast(this.aNA.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
            }
        }
    }
}
