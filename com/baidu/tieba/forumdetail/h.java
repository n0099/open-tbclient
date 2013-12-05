package com.baidu.tieba.forumdetail;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.model.ax;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f1331a;
    final /* synthetic */ com.baidu.tieba.j b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ItemFootNavView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ax axVar, com.baidu.tieba.j jVar, boolean z) {
        this.d = itemFootNavView;
        this.f1331a = axVar;
        this.b = jVar;
        this.c = z;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.f1331a.getErrorCode() == 22) {
            this.b.showToast(this.b.getString(R.string.like_success));
            this.d.b(true);
            this.d.a(this.c);
        } else if (this.f1331a.getErrorCode() != 0) {
            this.b.showToast(this.f1331a.getErrorString());
        } else if (((af) obj) != null) {
            this.b.showToast(this.b.getString(R.string.like_success));
            TiebaApplication h = TiebaApplication.h();
            forumDetailData = this.d.f;
            h.f(forumDetailData.forumInfo.forumName);
            this.d.b(true);
            this.d.a(this.c);
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
        }
    }
}
