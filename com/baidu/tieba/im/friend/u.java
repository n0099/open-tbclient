package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements j {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.tieba.im.friend.j
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof cl) {
                ((cl) obj).a(false);
            }
            bdListView = this.a.h;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tieba.im.data.d) {
                this.a.b((com.baidu.tieba.im.data.d) obj);
            }
        }
    }
}
