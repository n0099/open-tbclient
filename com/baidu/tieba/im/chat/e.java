package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements DialogInterface.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aRj = absMsgImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aRj.getListMenu();
        if (dialogInterface == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aRj.aQZ;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aRj.aQZ;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aRj.aQW = new h(this.aRj, currentImageUrl, currentImageData);
                            hVar = this.aRj.aQW;
                            hVar.execute(new String[0]);
                            frameLayout = this.aRj.aQX;
                            frameLayout.setClickable(false);
                        } else {
                            this.aRj.showToast(this.aRj.getPageContext().getString(com.baidu.tieba.z.no_data));
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
