package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class dk {
    BaseActivity mActivity;
    String mUrl;

    public dk(String str, BaseActivity baseActivity) {
        this.mUrl = null;
        this.mUrl = str;
        this.mActivity = baseActivity;
    }

    public void execute() {
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                showToast(this.mActivity.getString(com.baidu.tieba.y.save_error));
            }
            com.baidu.adp.lib.f.d.ef().a(this.mUrl, 10, new dl(this), this.mActivity.getUniqueId());
        } catch (Exception e) {
            showToast(this.mActivity.getString(com.baidu.tieba.y.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.s.a(str, bArr, this.mActivity)) {
            case -2:
                return com.baidu.tbadk.core.util.s.lu();
            case -1:
            default:
                return this.mActivity.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.mActivity.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        this.mActivity.showToast(str);
    }
}
