package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bcJ;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bcJ = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bcJ.getPageContext().getString(d.k.save_fail));
            }
            com.baidu.adp.lib.f.c.fp().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.l(i.this.mUrl, aVar.kp()));
                    } else {
                        i.this.showToast(i.this.bcJ.getPageContext().getString(d.k.save_fail));
                    }
                }
            }, this.bcJ.getUniqueId());
        } catch (Exception e) {
            showToast(this.bcJ.getPageContext().getString(d.k.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.bcJ.getPageContext().getPageActivity())) {
            case -2:
                return k.uD();
            case -1:
            default:
                return this.bcJ.getPageContext().getString(d.k.save_fail);
            case 0:
                return this.bcJ.getPageContext().getString(d.k.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bcJ.showToast(str);
    }
}
