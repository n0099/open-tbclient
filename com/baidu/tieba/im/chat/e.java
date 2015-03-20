package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ AbsMsgImageActivity aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.aWp = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        com.baidu.tbadk.core.dialog.e listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        h hVar;
        FrameLayout frameLayout;
        listMenu = this.aWp.getListMenu();
        if (eVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.aWp.aWe;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.aWp.aWe;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.aWp.aWb = new h(this.aWp, currentImageUrl, currentImageData);
                            hVar = this.aWp.aWb;
                            hVar.execute(new String[0]);
                            frameLayout = this.aWp.aWc;
                            frameLayout.setClickable(false);
                        } else {
                            this.aWp.showToast(this.aWp.getPageContext().getString(com.baidu.tieba.y.no_data));
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
