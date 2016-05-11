package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ AbsMsgImageActivity bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.bYM = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        AbsMsgImageActivity.a aVar;
        listMenu = this.bYM.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.bYM.bYA;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.bYM.bYA;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.bYM.bYx = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bYM.bYx;
                            aVar.execute(new String[0]);
                            this.bYM.bYy.setClickable(false);
                        } else {
                            this.bYM.showToast(this.bYM.getPageContext().getString(t.j.no_data));
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
