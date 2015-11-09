package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ AbsMsgImageActivity brt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.brt = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        AbsMsgImageActivity.a aVar;
        listMenu = this.brt.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.brt.brh;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.brt.brh;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.brt.bre = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.brt.bre;
                            aVar.execute(new String[0]);
                            this.brt.brf.setClickable(false);
                        } else {
                            this.brt.showToast(this.brt.getPageContext().getString(i.h.no_data));
                        }
                        break;
                    } catch (Exception e) {
                        break;
                    }
            }
            cVar.dismiss();
        }
    }
}
