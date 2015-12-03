package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.slidingmenu.lib.SlidingMenu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements SlidingMenu.OnClosedListener {
    final /* synthetic */ l bjm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bjm = lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    @Override // com.slidingmenu.lib.SlidingMenu.OnClosedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClosed() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.bjm.bhN;
        if (!TextUtils.isEmpty(frsActivity.getFrom())) {
            frsActivity4 = this.bjm.bhN;
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(frsActivity4.getFrom())) {
                frsActivity5 = this.bjm.bhN;
                frsActivity5.setSwipeBackEnabled(false);
                if (!this.bjm.PL().Om()) {
                    this.bjm.PL().cw(false);
                    frsActivity3 = this.bjm.bhN;
                    frsActivity3.refresh();
                    return;
                }
                return;
            }
        }
        frsActivity2 = this.bjm.bhN;
        frsActivity2.setSwipeBackEnabled(true);
        if (!this.bjm.PL().Om()) {
        }
    }
}
