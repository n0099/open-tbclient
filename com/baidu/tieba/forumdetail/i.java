package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bd {
    final /* synthetic */ ItemFootNavView axj;
    private final /* synthetic */ BaseActivity axk;
    private final /* synthetic */ boolean axn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, BaseActivity baseActivity, boolean z) {
        this.axj = itemFootNavView;
        this.axk = baseActivity;
        this.axn = z;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        this.axk.showToast(this.axk.getString(y.unlike_success));
        this.axj.bI(false);
        this.axj.bH(this.axn);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
        this.axk.showToast(this.axk.getString(y.unlike_failure));
    }
}
