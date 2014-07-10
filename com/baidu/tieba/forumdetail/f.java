package com.baidu.tieba.forumdetail;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ BaseActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, BaseActivity baseActivity) {
        this.a = itemFootNavView;
        this.b = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b(this.b);
    }
}
