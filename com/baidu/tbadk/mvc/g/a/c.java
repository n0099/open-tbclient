package com.baidu.tbadk.mvc.g.a;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b ant;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ant = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.ant.ans;
        morePopupWindow.showWindowInRightBottomOfHost();
    }
}
