package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class ce {
    BaseActivity mActivity;
    String mUrl;

    public ce(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.mActivity = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.mActivity.getPageContext().getString(com.baidu.tieba.y.save_error));
            }
            com.baidu.adp.lib.f.d.hB().a(this.mUrl, 10, new cf(this), this.mActivity.getUniqueId());
        } catch (Exception e) {
            showToast(this.mActivity.getPageContext().getString(com.baidu.tieba.y.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.o.a(str, bArr, this.mActivity.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.rI();
            case -1:
            default:
                return this.mActivity.getPageContext().getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.mActivity.getPageContext().getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.mActivity.showToast(str);
    }
}
