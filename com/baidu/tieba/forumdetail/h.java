package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.ad;
import com.baidu.tieba.data.z;
import com.baidu.tieba.model.af;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ af b;
    private final /* synthetic */ BaseActivity c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, af afVar, BaseActivity baseActivity, boolean z) {
        this.a = itemFootNavView;
        this.b = afVar;
        this.c = baseActivity;
        this.d = z;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.b.getErrorCode() == 22) {
            this.c.showToast(this.c.getString(u.like_success));
            this.a.b(true);
            this.a.a(this.d);
        } else if (this.b.getErrorCode() != 0) {
            this.c.showToast(this.b.getErrorString());
        } else if (((z) obj) != null) {
            this.c.showToast(this.c.getString(u.like_success));
            ad c = ad.c();
            forumDetailData = this.a.f;
            c.e(forumDetailData.forumInfo.forumName);
            this.a.b(true);
            this.a.a(this.d);
        } else {
            this.c.showToast(this.c.getString(u.neterror));
        }
    }
}
