package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.h {
    final /* synthetic */ ItemFootNavView axj;
    private final /* synthetic */ BaseActivity axk;
    private final /* synthetic */ ag axm;
    private final /* synthetic */ boolean axn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ag agVar, BaseActivity baseActivity, boolean z) {
        this.axj = itemFootNavView;
        this.axm = agVar;
        this.axk = baseActivity;
        this.axn = z;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.axm.getErrorCode() == 22) {
            this.axk.showToast(this.axk.getString(y.like_success));
            this.axj.bI(true);
            this.axj.bH(this.axn);
        } else if (this.axm.getErrorCode() != 0) {
            this.axk.showToast(this.axm.getErrorString());
        } else if (((aa) obj) != null) {
            this.axk.showToast(this.axk.getString(y.like_success));
            aj wk = aj.wk();
            forumDetailData = this.axj.awZ;
            wk.dW(forumDetailData.forum_info.forum_name);
            this.axj.bI(true);
            this.axj.bH(this.axn);
        } else {
            this.axk.showToast(this.axk.getString(y.neterror));
        }
    }
}
