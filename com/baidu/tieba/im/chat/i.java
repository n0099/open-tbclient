package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bll;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bll = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bll.getPageContext().getString(d.l.save_error));
            }
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 10, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.k(i.this.mUrl, aVar.kQ()));
                    } else {
                        i.this.showToast(i.this.bll.getPageContext().getString(d.l.save_error));
                    }
                }
            }, this.bll.getUniqueId());
        } catch (Exception e) {
            showToast(this.bll.getPageContext().getString(d.l.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.bll.getPageContext().getPageActivity())) {
            case -2:
                return k.uy();
            case -1:
            default:
                return this.bll.getPageContext().getString(d.l.save_error);
            case 0:
                return this.bll.getPageContext().getString(d.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bll.showToast(str);
    }
}
