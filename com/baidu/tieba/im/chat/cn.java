package com.baidu.tieba.im.chat;

import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ GifView a;
    final /* synthetic */ String b;
    final /* synthetic */ com.baidu.tieba.im.message.b c;
    final /* synthetic */ String d;
    final /* synthetic */ com.baidu.tieba.util.i e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(GifView gifView, String str, com.baidu.tieba.im.message.b bVar, String str2, com.baidu.tieba.util.i iVar, String str3, String str4) {
        this.a = gifView;
        this.b = str;
        this.c = bVar;
        this.d = str2;
        this.e = iVar;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        com.baidu.adp.widget.ImageView.d b;
        Object tag = this.a.getTag();
        if (tag != null && ((String) tag).equals(this.b)) {
            this.a.setIsLoading(false);
            if (dVar != null) {
                this.a.setGif(dVar);
                this.c.b(true);
            } else if (dVar == null) {
                if (str != null && str.equals(this.d)) {
                    b = ci.b(this.e, this.f, this.b, this.g, false, this);
                    if (b != null) {
                        this.a.setGif(b);
                        this.a.setIsLoading(false);
                        this.c.b(true);
                        return;
                    }
                    this.a.setIsLoading(true);
                    return;
                }
                this.a.setGif(dVar);
                this.c.b(false);
            }
        }
    }
}
