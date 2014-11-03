package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bd {
    final /* synthetic */ ItemFootNavView axs;
    private final /* synthetic */ BaseActivity axt;
    private final /* synthetic */ boolean axw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, BaseActivity baseActivity, boolean z) {
        this.axs = itemFootNavView;
        this.axt = baseActivity;
        this.axw = z;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        this.axt.showToast(this.axt.getString(y.unlike_success));
        this.axs.bI(false);
        this.axs.bH(this.axw);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
        this.axt.showToast(this.axt.getString(y.unlike_failure));
    }
}
