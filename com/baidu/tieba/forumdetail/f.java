package com.baidu.tieba.forumdetail;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView axj;
    private final /* synthetic */ BaseActivity axk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.axj = itemFootNavView;
        this.axk = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.axj.a(this.axk);
    }
}
