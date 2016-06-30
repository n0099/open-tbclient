package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ AbsMsgImageActivity cDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.cDW = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        AbsMsgImageActivity.a aVar;
        listMenu = this.cDW.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.cDW.cDK;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.cDW.cDK;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.cDW.cDH = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cDW.cDH;
                            aVar.execute(new String[0]);
                            this.cDW.cDI.setClickable(false);
                        } else {
                            this.cDW.showToast(this.cDW.getPageContext().getString(u.j.no_data));
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
