package com.baidu.tieba.forumdetail;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ax;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.g {
    final /* synthetic */ ax a;
    final /* synthetic */ com.baidu.tieba.j b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ItemFootNavView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ax axVar, com.baidu.tieba.j jVar, boolean z) {
        this.d = itemFootNavView;
        this.a = axVar;
        this.b = jVar;
        this.c = z;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.a.getErrorCode() == 22) {
            this.b.showToast(this.b.getString(R.string.like_success));
            this.d.b(true);
            this.d.a(this.c);
        } else if (this.a.getErrorCode() != 0) {
            this.b.showToast(this.a.getErrorString());
        } else if (((ag) obj) != null) {
            this.b.showToast(this.b.getString(R.string.like_success));
            TiebaApplication h = TiebaApplication.h();
            forumDetailData = this.d.f;
            h.e(forumDetailData.forumInfo.forumName);
            this.d.b(true);
            this.d.a(this.c);
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
        }
    }
}
