package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements m {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.a = yVar;
    }

    @Override // com.baidu.tieba.im.friend.m
    public final void a(Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof com.baidu.tbadk.core.view.p) {
                ((com.baidu.tbadk.core.view.p) obj).setChecked(false);
            }
            bdListView = this.a.f;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tieba.im.data.c) {
                this.a.c((com.baidu.tieba.im.data.c) obj);
            }
        }
    }
}
