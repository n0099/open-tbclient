package com.baidu.tieba.im.searchGroup;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements View.OnFocusChangeListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        SearchGroupActivity searchGroupActivity;
        if (!z) {
            searchGroupActivity = this.a.b;
            BdUtilHelper.a(searchGroupActivity, view);
        }
    }
}
