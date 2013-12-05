package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    private int f1001a;

    public p(int i) {
        this.f1001a = 0;
        this.f1001a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.f1001a);
        if (findViewById != null && (findViewById instanceof TbRichTextView)) {
            ((TbRichTextView) findViewById).setText(null);
        }
    }
}
