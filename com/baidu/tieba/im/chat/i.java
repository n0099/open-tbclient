package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bSO;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bSO = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bSO.getPageContext().getString(d.j.save_fail));
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
                        i.this.showToast(i.this.bSO.getPageContext().getString(d.j.save_fail));
                    }
                }
            }, this.bSO.getUniqueId());
        } catch (Exception e) {
            showToast(this.bSO.getPageContext().getString(d.j.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(String str, byte[] bArr) {
        switch (k.a(str, bArr, this.bSO.getPageContext().getPageActivity())) {
            case -2:
                return k.BT();
            case -1:
            default:
                return this.bSO.getPageContext().getString(d.j.save_fail);
            case 0:
                return this.bSO.getPageContext().getString(d.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bSO.showToast(str);
    }
}
