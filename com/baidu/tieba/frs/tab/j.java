package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.buj = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        morePopupWindow = this.buj.PS;
        com.baidu.adp.lib.h.j.a(morePopupWindow);
    }
}
