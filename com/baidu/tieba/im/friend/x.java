package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements j {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.tieba.im.friend.j
    public final void a(Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof cr) {
                ((cr) obj).setChecked(false);
            }
            bdListView = this.a.f;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tieba.im.data.d) {
                this.a.c((com.baidu.tieba.im.data.d) obj);
            }
        }
    }
}
