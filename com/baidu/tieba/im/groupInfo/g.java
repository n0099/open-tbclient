package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupImageActivity bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(GroupImageActivity groupImageActivity) {
        this.bah = groupImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        j jVar;
        listMenu = this.bah.getListMenu();
        if (dialogInterface == listMenu && i == 0) {
            try {
                multiImageView = this.bah.aNr;
                byte[] currentImageData = multiImageView.getCurrentImageData();
                if (currentImageData != null) {
                    multiImageView2 = this.bah.aNr;
                    String currentImageUrl = multiImageView2.getCurrentImageUrl();
                    this.bah.bag = new j(this.bah, currentImageUrl, currentImageData);
                    jVar = this.bah.bag;
                    jVar.execute(new String[0]);
                    this.bah.showProgressBarWithOffset(0, 0);
                } else {
                    this.bah.showToast(this.bah.getString(com.baidu.tieba.y.no_data));
                }
            } catch (Exception e) {
            }
        }
    }
}
