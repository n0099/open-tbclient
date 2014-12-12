package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aQe = absMsgImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aQe.getListMenu();
        if (dialogInterface == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aQe.aPU;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aQe.aPU;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aQe.aPR = new h(this.aQe, currentImageUrl, currentImageData);
                            hVar = this.aQe.aPR;
                            hVar.execute(new String[0]);
                            frameLayout = this.aQe.aPS;
                            frameLayout.setClickable(false);
                        } else {
                            this.aQe.showToast(this.aQe.getPageContext().getString(com.baidu.tieba.z.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 1:
                    dialogInterface.dismiss();
                    return;
                default:
                    return;
            }
        }
    }
}
