package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupImageActivity baw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GroupImageActivity groupImageActivity) {
        this.baw = groupImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        k kVar;
        listMenu = this.baw.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.baw.aNF;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.baw.aNF;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.baw.bau = new k(this.baw, currentImageUrl, currentImageData);
                    kVar = this.baw.bau;
                    kVar.execute(new String[0]);
                    this.baw.showProgressBarWithOffset(0, 0);
                } else {
                    this.baw.showToast(this.baw.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
            }
        }
    }
}
