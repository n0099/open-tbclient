package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ AbsMsgImageActivity bKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.bKg = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        AbsMsgImageActivity.a aVar;
        listMenu = this.bKg.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.bKg.bJU;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.bKg.bJU;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.bKg.bJR = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bKg.bJR;
                            aVar.execute(new String[0]);
                            this.bKg.bJS.setClickable(false);
                        } else {
                            this.bKg.showToast(this.bKg.getPageContext().getString(n.j.no_data));
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
