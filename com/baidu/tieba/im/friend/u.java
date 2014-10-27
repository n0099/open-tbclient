package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements j {
    final /* synthetic */ s aWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.aWf = sVar;
    }

    @Override // com.baidu.tieba.im.friend.j
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.x) {
                ((com.baidu.tbadk.core.view.x) obj).setChecked(false);
            }
            bdListView = this.aWf.vl;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.b) {
                this.aWf.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
            }
        }
    }
}
