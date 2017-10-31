package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.f.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity brJ;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.brJ = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.brJ.getPageContext().getString(d.j.save_fail));
            }
            com.baidu.adp.lib.f.c.fJ().a(this.mUrl, 10, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.l(i.this.mUrl, aVar.kN()));
                    } else {
                        i.this.showToast(i.this.brJ.getPageContext().getString(d.j.save_fail));
                    }
                }
            }, this.brJ.getUniqueId());
        } catch (Exception e) {
            showToast(this.brJ.getPageContext().getString(d.j.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.brJ.getPageContext().getPageActivity())) {
            case -2:
                return k.uh();
            case -1:
            default:
                return this.brJ.getPageContext().getString(d.j.save_fail);
            case 0:
                return this.brJ.getPageContext().getString(d.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.brJ.showToast(str);
    }
}
