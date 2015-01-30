package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements j {
    final /* synthetic */ s bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.bcg = sVar;
    }

    @Override // com.baidu.tieba.im.friend.j
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof aj) {
                ((aj) obj).setChecked(false);
            }
            bdListView = this.bcg.mListView;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.b) {
                this.bcg.h((com.baidu.tbadk.coreExtra.relationship.b) obj);
            }
        }
    }
}
