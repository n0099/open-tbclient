package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class t implements AbsListView.RecyclerListener {
    private int mId;

    public t(int i) {
        this.mId = 0;
        this.mId = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.mId);
        if (findViewById != null && (findViewById instanceof TbRichTextView)) {
            ((TbRichTextView) findViewById).setText(null);
        }
    }
}
