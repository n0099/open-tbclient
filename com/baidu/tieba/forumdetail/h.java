package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.h {
    final /* synthetic */ ItemFootNavView axs;
    private final /* synthetic */ BaseActivity axt;
    private final /* synthetic */ ag axv;
    private final /* synthetic */ boolean axw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ItemFootNavView itemFootNavView, ag agVar, BaseActivity baseActivity, boolean z) {
        this.axs = itemFootNavView;
        this.axv = agVar;
        this.axt = baseActivity;
        this.axw = z;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ForumDetailData forumDetailData;
        if (this.axv.getErrorCode() == 22) {
            this.axt.showToast(this.axt.getString(y.like_success));
            this.axs.bI(true);
            this.axs.bH(this.axw);
        } else if (this.axv.getErrorCode() != 0) {
            this.axt.showToast(this.axv.getErrorString());
        } else if (((aa) obj) != null) {
            this.axt.showToast(this.axt.getString(y.like_success));
            aj wm = aj.wm();
            forumDetailData = this.axs.axi;
            wm.dW(forumDetailData.forum_info.forum_name);
            this.axs.bI(true);
            this.axs.bH(this.axw);
        } else {
            this.axt.showToast(this.axt.getString(y.neterror));
        }
    }
}
