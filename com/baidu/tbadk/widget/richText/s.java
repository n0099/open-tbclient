package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class s implements AbsListView.RecyclerListener {
    private int a;

    public s(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.a);
        if (findViewById != null && (findViewById instanceof TbRichTextView)) {
            ((TbRichTextView) findViewById).setText(null);
        }
    }
}
