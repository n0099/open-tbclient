package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public final class da {
    String a;
    com.baidu.tbadk.a b;

    public da(String str, com.baidu.tbadk.a aVar) {
        this.a = null;
        this.a = str;
        this.b = aVar;
    }

    public final void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(com.baidu.tieba.im.j.save_error));
            }
            new com.baidu.tbadk.editortool.ab(this.b).a(this.a, false, true, (com.baidu.tbadk.imageManager.d) new db(this));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.b.getString(com.baidu.tieba.im.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(da daVar, String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.w.a(str, bArr, daVar.b)) {
            case -2:
                return com.baidu.tbadk.core.util.w.b();
            case -1:
            default:
                return daVar.b.getString(com.baidu.tieba.im.j.save_error);
            case 0:
                return daVar.b.getString(com.baidu.tieba.im.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
