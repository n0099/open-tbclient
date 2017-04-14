package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c.b {
    final /* synthetic */ AbsMsgImageActivity cMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AbsMsgImageActivity absMsgImageActivity) {
        this.cMz = absMsgImageActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        com.baidu.tbadk.core.dialog.c listMenu;
        MultiImageView multiImageView;
        MultiImageView multiImageView2;
        AbsMsgImageActivity.a aVar;
        listMenu = this.cMz.getListMenu();
        if (cVar == listMenu) {
            switch (i) {
                case 0:
                    try {
                        multiImageView = this.cMz.cMn;
                        byte[] currentImageData = multiImageView.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView2 = this.cMz.cMn;
                            String currentImageUrl = multiImageView2.getCurrentImageUrl();
                            this.cMz.cMk = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cMz.cMk;
                            aVar.execute(new String[0]);
                            this.cMz.cMl.setClickable(false);
                        } else {
                            this.cMz.showToast(this.cMz.getPageContext().getString(w.l.no_data));
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
