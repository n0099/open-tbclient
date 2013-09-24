package com.baidu.tieba.forumdetail;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.as;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemFootNavView f1089a;
    private final /* synthetic */ as b;
    private final /* synthetic */ com.baidu.tieba.j c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, as asVar, com.baidu.tieba.j jVar, boolean z) {
        this.f1089a = itemFootNavView;
        this.b = asVar;
        this.c = jVar;
        this.d = z;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.b.getErrorCode() == 22) {
            this.c.a(this.c.getString(R.string.like_success));
            this.f1089a.b(true);
            this.f1089a.a(this.d);
        } else if (this.b.getErrorCode() != 0) {
            this.c.a(this.b.getErrorString());
        } else if (((ag) obj) != null) {
            this.c.a(this.c.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            forumDetailData = this.f1089a.e;
            g.e(forumDetailData.forumInfo.forumName);
            this.f1089a.b(true);
            this.f1089a.a(this.d);
        } else {
            this.c.a(this.c.getString(R.string.neterror));
        }
    }
}
