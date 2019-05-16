package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    BaseActivity cVo;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.cVo = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.cVo.getPageContext().getString(R.string.save_fail));
            }
            com.baidu.adp.lib.f.c.iv().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.k(i.this.mUrl, aVar.nv()));
                    } else {
                        i.this.showToast(i.this.cVo.getPageContext().getString(R.string.save_fail));
                    }
                }
            }, this.cVo.getUniqueId());
        } catch (Exception e) {
            showToast(this.cVo.getPageContext().getString(R.string.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (m.a(str, bArr, this.cVo.getPageContext().getPageActivity())) {
            case -2:
                return m.agZ();
            case -1:
            default:
                return this.cVo.getPageContext().getString(R.string.save_fail);
            case 0:
                return this.cVo.getPageContext().getString(R.string.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.cVo.showToast(str);
    }
}
