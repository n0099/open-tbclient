package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class cq {
    BaseActivity mActivity;
    String mUrl;

    public cq(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.mActivity = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.mActivity.getPageContext().getString(com.baidu.tieba.z.save_error));
            }
            com.baidu.adp.lib.f.d.ee().a(this.mUrl, 10, new cr(this), this.mActivity.getUniqueId());
        } catch (Exception e) {
            showToast(this.mActivity.getPageContext().getString(com.baidu.tieba.z.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.s.a(str, bArr, this.mActivity.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.s.op();
            case -1:
            default:
                return this.mActivity.getPageContext().getString(com.baidu.tieba.z.save_error);
            case 0:
                return this.mActivity.getPageContext().getString(com.baidu.tieba.z.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.mActivity.showToast(str);
    }
}
