package com.baidu.tieba.forumdetail;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ba;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1221a;
    final /* synthetic */ com.baidu.tieba.j b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ItemFootNavView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ba baVar, com.baidu.tieba.j jVar, boolean z) {
        this.d = itemFootNavView;
        this.f1221a = baVar;
        this.b = jVar;
        this.c = z;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.f1221a.getErrorCode() == 22) {
            this.b.a(this.b.getString(R.string.like_success));
            this.d.b(true);
            this.d.a(this.c);
        } else if (this.f1221a.getErrorCode() != 0) {
            this.b.a(this.f1221a.getErrorString());
        } else if (((ag) obj) != null) {
            this.b.a(this.b.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            forumDetailData = this.d.e;
            g.e(forumDetailData.forumInfo.forumName);
            this.d.b(true);
            this.d.a(this.c);
        } else {
            this.b.a(this.b.getString(R.string.neterror));
        }
    }
}
