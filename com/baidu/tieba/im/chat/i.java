package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bnd;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bnd = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bnd.getPageContext().getString(d.l.save_fail));
            }
            com.baidu.adp.lib.f.c.fK().a(this.mUrl, 10, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.l(i.this.mUrl, aVar.kR()));
                    } else {
                        i.this.showToast(i.this.bnd.getPageContext().getString(d.l.save_fail));
                    }
                }
            }, this.bnd.getUniqueId());
        } catch (Exception e) {
            showToast(this.bnd.getPageContext().getString(d.l.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.bnd.getPageContext().getPageActivity())) {
            case -2:
                return k.uE();
            case -1:
            default:
                return this.bnd.getPageContext().getString(d.l.save_fail);
            case 0:
                return this.bnd.getPageContext().getString(d.l.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bnd.showToast(str);
    }
}
