package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j cbO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cbO = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.cbO.RC;
        com.baidu.adp.lib.g.j.a(morePopupWindow);
    }
}
