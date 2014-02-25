package com.baidu.tieba.im.chat;

import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ GifView a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.message.b c;
    private final /* synthetic */ String d;
    private final /* synthetic */ com.baidu.tieba.util.i e;
    private final /* synthetic */ String f;
    private final /* synthetic */ String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(GifView gifView, String str, com.baidu.tieba.im.message.b bVar, String str2, com.baidu.tieba.util.i iVar, String str3, String str4) {
        this.a = gifView;
        this.b = str;
        this.c = bVar;
        this.d = str2;
        this.e = iVar;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        Object tag = this.a.getTag();
        if (tag != null && ((String) tag).equals(this.b)) {
            if (bVar != null) {
                this.a.setGif(bVar);
                this.c.b(true);
            } else if (bVar == null) {
                if (str != null && UtilHelper.h(TiebaApplication.g()) == UtilHelper.NetworkStateInfo.UNAVAIL && !this.c.a) {
                    this.c.a = true;
                    com.baidu.adp.widget.ImageView.b b = str.equals(this.d) ? cs.b(this.e, this.f, this.b, this.g, false, this) : cs.b(this.e, this.f, this.b, this.d, true, this);
                    if (b != null) {
                        this.a.setGif(b);
                        this.a.setIsLoading(false);
                        this.c.b(true);
                        return;
                    }
                    this.a.setIsLoading(true);
                    return;
                }
                this.a.setGif(bVar);
                this.c.b(false);
            }
        }
    }
}
