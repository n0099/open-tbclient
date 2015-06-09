package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ AbsMsgImageActivity aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aZm = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aZm.getListMenu();
        if (eVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aZm.aZa;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aZm.aZa;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aZm.aYX = new h(this.aZm, currentImageUrl, currentImageData);
                            hVar = this.aZm.aYX;
                            hVar.execute(new String[0]);
                            frameLayout = this.aZm.aYY;
                            frameLayout.setClickable(false);
                        } else {
                            this.aZm.showToast(this.aZm.getPageContext().getString(com.baidu.tieba.t.no_data));
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
