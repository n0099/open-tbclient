package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
final class br implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public final void onOpened() {
        TiebaStatic.a(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
    }
}
