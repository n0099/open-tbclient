package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dm implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ GifView a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.a c;
    private final /* synthetic */ String d;
    private final /* synthetic */ com.baidu.tbadk.editortool.aa e;
    private final /* synthetic */ String f;
    private final /* synthetic */ String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(GifView gifView, String str, com.baidu.tieba.im.message.a.a aVar, String str2, com.baidu.tbadk.editortool.aa aaVar, String str3, String str4) {
        this.a = gifView;
        this.b = str;
        this.c = aVar;
        this.d = str2;
        this.e = aaVar;
        this.f = str3;
        this.g = str4;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        Object tag = this.a.getTag();
        if (tag != null && ((String) tag).equals(this.b)) {
            if (bVar != null) {
                this.a.setGif(bVar);
                this.c.b(true);
            } else if (bVar == null) {
                if (str != null && UtilHelper.d(TbadkApplication.j()) == UtilHelper.NetworkStateInfo.UNAVAIL && !this.c.c) {
                    this.c.c = true;
                    com.baidu.adp.widget.ImageView.b b = str.equals(this.d) ? dg.b(this.e, this.f, this.b, this.g, false, this) : dg.b(this.e, this.f, this.b, this.d, true, this);
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
