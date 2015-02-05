package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aRi = absMsgImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aRi.getListMenu();
        if (dialogInterface == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aRi.aQY;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aRi.aQY;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aRi.aQV = new h(this.aRi, currentImageUrl, currentImageData);
                            hVar = this.aRi.aQV;
                            hVar.execute(new String[0]);
                            frameLayout = this.aRi.aQW;
                            frameLayout.setClickable(false);
                        } else {
                            this.aRi.showToast(this.aRi.getPageContext().getString(com.baidu.tieba.z.no_data));
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
