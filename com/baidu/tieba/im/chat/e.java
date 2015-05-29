package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ AbsMsgImageActivity aZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aZl = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aZl.getListMenu();
        if (eVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aZl.aYZ;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aZl.aYZ;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aZl.aYW = new h(this.aZl, currentImageUrl, currentImageData);
                            hVar = this.aZl.aYW;
                            hVar.execute(new String[0]);
                            frameLayout = this.aZl.aYX;
                            frameLayout.setClickable(false);
                        } else {
                            this.aZl.showToast(this.aZl.getPageContext().getString(com.baidu.tieba.t.no_data));
                        }
                        break;
                    } catch (Exception e) {
                        break;
                    }
            }
            eVar.dismiss();
        }
    }
}
