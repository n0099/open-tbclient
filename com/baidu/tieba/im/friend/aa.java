package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements l {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tieba.im.friend.l
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.p) {
                ((com.baidu.tbadk.core.view.p) obj).setChecked(false);
            }
            bdListView = this.a.e;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.b) {
                this.a.b((com.baidu.tbadk.coreExtra.relationship.b) obj);
            }
        }
    }
}
