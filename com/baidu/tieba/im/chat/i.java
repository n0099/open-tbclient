package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i {
    BaseActivity bmZ;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.bmZ = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.bmZ.getPageContext().getString(d.j.save_fail));
            }
            com.baidu.adp.lib.f.c.ih().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.l(i.this.mUrl, aVar.ne()));
                    } else {
                        i.this.showToast(i.this.bmZ.getPageContext().getString(d.j.save_fail));
                    }
                }
            }, this.bmZ.getUniqueId());
        } catch (Exception e) {
            showToast(this.bmZ.getPageContext().getString(d.j.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str, byte[] bArr) {
        switch (l.a(str, bArr, this.bmZ.getPageContext().getPageActivity())) {
            case -2:
                return l.yi();
            case -1:
            default:
                return this.bmZ.getPageContext().getString(d.j.save_fail);
            case 0:
                return this.bmZ.getPageContext().getString(d.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.bmZ.showToast(str);
    }
}
