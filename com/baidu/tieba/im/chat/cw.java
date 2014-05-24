package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class cw {
    String a;
    BaseActivity b;

    public cw(String str, BaseActivity baseActivity) {
        this.a = null;
        this.a = str;
        this.b = baseActivity;
    }

    public void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(com.baidu.tieba.y.save_error));
            }
            new com.baidu.tbadk.editortool.ab(this.b).a(this.a, false, true, (com.baidu.tbadk.imageManager.d) new cx(this));
        } catch (Exception e) {
            BdLog.e("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.b.getString(com.baidu.tieba.y.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.x.a(str, bArr, this.b)) {
            case -2:
                return com.baidu.tbadk.core.util.x.b();
            case -1:
            default:
                return this.b.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.b.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
