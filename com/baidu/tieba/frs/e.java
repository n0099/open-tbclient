package com.baidu.tieba.frs;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.c.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        FrsActivity frsActivity;
        ListView listView;
        if (bitmap == null) {
            return;
        }
        frsActivity = this.a.a;
        listView = frsActivity.v;
        View findViewWithTag = listView.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
