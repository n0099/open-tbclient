package com.baidu.tieba.im.b;

import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements com.baidu.tieba.im.net.j {
    final /* synthetic */ a a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str, String str2, int i) {
        this.a = aVar;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    @Override // com.baidu.tieba.im.net.j
    public final void a(boolean z) {
        int i;
        int i2;
        com.baidu.tieba.im.net.f.a().a(z ? 1 : 0, this.b);
        if (z) {
            this.a.o = 0;
            this.a.p = false;
            TiebaSocketLinkService.c("change ip and stop to restart to reconnet.");
            this.a.q = true;
            TiebaSocketLinkService.a(this.b);
            TiebaSocketLinkService.a(true, this.c);
            a aVar = this.a;
            i2 = aVar.s;
            aVar.s = i2 + 1;
            return;
        }
        a aVar2 = this.a;
        i = aVar2.s;
        aVar2.s = i + 1;
        this.a.a(this.c, this.d);
    }
}
