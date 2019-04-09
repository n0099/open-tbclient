package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity cNd;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.cNd = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.cNd.getPageContext().getString(d.j.save_fail));
            }
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.k(i.this.mUrl, aVar.oB()));
                    } else {
                        i.this.showToast(i.this.cNd.getPageContext().getString(d.j.save_fail));
                    }
                }
            }, this.cNd.getUniqueId());
        } catch (Exception e) {
            showToast(this.cNd.getPageContext().getString(d.j.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (m.a(str, bArr, this.cNd.getPageContext().getPageActivity())) {
            case -2:
                return m.acb();
            case -1:
            default:
                return this.cNd.getPageContext().getString(d.j.save_fail);
            case 0:
                return this.cNd.getPageContext().getString(d.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.cNd.showToast(str);
    }
}
