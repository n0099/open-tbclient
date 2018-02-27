package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bSC;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bSC = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bSC.getPageContext().getString(d.j.save_fail));
            }
            com.baidu.adp.lib.f.c.nm().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.m(i.this.mUrl, aVar.sk()));
                    } else {
                        i.this.showToast(i.this.bSC.getPageContext().getString(d.j.save_fail));
                    }
                }
            }, this.bSC.getUniqueId());
        } catch (Exception e) {
            showToast(this.bSC.getPageContext().getString(d.j.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.bSC.getPageContext().getPageActivity())) {
            case -2:
                return k.BS();
            case -1:
            default:
                return this.bSC.getPageContext().getString(d.j.save_fail);
            case 0:
                return this.bSC.getPageContext().getString(d.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bSC.showToast(str);
    }
}
