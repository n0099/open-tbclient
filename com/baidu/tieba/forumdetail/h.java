package com.baidu.tieba.forumdetail;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.af;
import com.baidu.tieba.model.ar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.g {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ ar b;
    private final /* synthetic */ com.baidu.tieba.f c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ar arVar, com.baidu.tieba.f fVar, boolean z) {
        this.a = itemFootNavView;
        this.b = arVar;
        this.c = fVar;
        this.d = z;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.b.getErrorCode() == 22) {
            this.c.showToast(this.c.getString(R.string.like_success));
            this.a.b(true);
            this.a.a(this.d);
        } else if (this.b.getErrorCode() != 0) {
            this.c.showToast(this.b.getErrorString());
        } else if (((af) obj) != null) {
            this.c.showToast(this.c.getString(R.string.like_success));
            TiebaApplication g = TiebaApplication.g();
            forumDetailData = this.a.f;
            g.e(forumDetailData.forumInfo.forumName);
            this.a.b(true);
            this.a.a(this.d);
        } else {
            this.c.showToast(this.c.getString(R.string.neterror));
        }
    }
}
