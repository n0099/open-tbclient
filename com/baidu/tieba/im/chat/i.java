package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i {
    BaseActivity mActivity;
    String mUrl;

    public i(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.mActivity = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.mActivity.getPageContext().getString(R.string.save_fail));
            }
            com.baidu.adp.lib.e.c.mS().a(this.mUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.im.chat.i.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str, i);
                    if (aVar != null) {
                        i.this.showToast(i.this.m(i.this.mUrl, aVar.getImageByte()));
                    } else {
                        i.this.showToast(i.this.mActivity.getPageContext().getString(R.string.save_fail));
                    }
                }
            }, this.mActivity.getUniqueId());
        } catch (Exception e) {
            showToast(this.mActivity.getPageContext().getString(R.string.save_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(String str, byte[] bArr) {
        switch (n.saveImageFileByUser(str, bArr, this.mActivity.getPageContext().getPageActivity())) {
            case -2:
                return n.getSdErrorString();
            case -1:
            default:
                return this.mActivity.getPageContext().getString(R.string.save_fail);
            case 0:
                return this.mActivity.getPageContext().getString(R.string.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.mActivity.showToast(str);
    }
}
