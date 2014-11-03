package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AbsMsgImageActivity absMsgImageActivity) {
        this.aNO = absMsgImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        g gVar;
        listMenu = this.aNO.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.aNO.aNF;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.aNO.aNF;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.aNO.aND = new g(this.aNO, currentImageUrl, currentImageData);
                    gVar = this.aNO.aND;
                    gVar.execute(new String[0]);
                    this.aNO.showProgressBarWithOffset(0, 0);
                } else {
                    this.aNO.showToast(this.aNO.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
            }
        }
    }
}
