package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class n implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    private int f978a;

    public n(int i) {
        this.f978a = 0;
        this.f978a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.f978a);
        if (findViewById != null && (findViewById instanceof TbRichTextView)) {
            ((TbRichTextView) findViewById).setText(null);
        }
    }
}
