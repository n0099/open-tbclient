package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public final class de {
    String a;
    com.baidu.tbadk.a b;

    public de(String str, com.baidu.tbadk.a aVar) {
        this.a = null;
        this.a = str;
        this.b = aVar;
    }

    public final void a() {
        try {
            if (this.a == null || this.a.length() <= 0) {
                a(this.b.getString(com.baidu.tieba.im.j.save_error));
            }
            new com.baidu.tbadk.editortool.aa(this.b).a(this.a, false, true, (com.baidu.tbadk.imageManager.d) new df(this));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("SaveImageAsyncTask", "execute", "error" + e.getMessage());
            a(this.b.getString(com.baidu.tieba.im.j.save_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(de deVar, String str, byte[] bArr) {
        switch (com.baidu.tbadk.core.util.w.a(str, bArr, deVar.b)) {
            case -2:
                return com.baidu.tbadk.core.util.w.b();
            case -1:
            default:
                return deVar.b.getString(com.baidu.tieba.im.j.save_error);
            case 0:
                return deVar.b.getString(com.baidu.tieba.im.j.save_image_to_album);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.b.showToast(str);
    }
}
