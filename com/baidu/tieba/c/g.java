package com.baidu.tieba.c;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.a {
    final /* synthetic */ f a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private int d;
    private com.baidu.tieba.a.ba e;

    public g(f fVar, String str, int i) {
        this.a = fVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.a.ba();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.B());
        this.b.a("tid", this.c);
        this.e.a(this.b.i());
        return this.b.b() && this.e.a() == 0;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.d = null;
        if (this.a.a != null) {
            this.a.a.a(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = null;
        this.a.d = null;
        if (bool.booleanValue()) {
            int i = this.d;
            arrayList = this.a.e;
            if (i < arrayList.size()) {
                arrayList2 = this.a.e;
                arrayList2.remove(this.d);
            }
        } else if (this.b.b()) {
            str = this.e.b();
        } else {
            str = this.b.f();
        }
        if (this.a.a != null) {
            this.a.a.a(2, bool, str);
        }
    }
}
