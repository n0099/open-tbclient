package com.baidu.tieba.forumdetail;

import com.baidu.tieba.data.z;
import com.baidu.tieba.model.af;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends com.baidu.adp.a.h {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ af b;
    private final /* synthetic */ com.baidu.tbadk.a c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, af afVar, com.baidu.tbadk.a aVar, boolean z) {
        this.a = itemFootNavView;
        this.b = afVar;
        this.c = aVar;
        this.d = z;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.b.getErrorCode() == 22) {
            this.c.showToast(this.c.getString(com.baidu.tieba.a.k.like_success));
            this.a.a(true);
            ItemFootNavView.b(this.a, this.d);
        } else if (this.b.getErrorCode() != 0) {
            this.c.showToast(this.b.getErrorString());
        } else if (((z) obj) != null) {
            this.c.showToast(this.c.getString(com.baidu.tieba.a.k.like_success));
            r c = r.c();
            forumDetailData = this.a.f;
            c.e(forumDetailData.forumInfo.forumName);
            this.a.a(true);
            ItemFootNavView.b(this.a, this.d);
        } else {
            this.c.showToast(this.c.getString(com.baidu.tieba.a.k.neterror));
        }
    }
}
