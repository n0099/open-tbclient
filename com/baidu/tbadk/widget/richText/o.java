package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    private int f993a;

    public o(int i) {
        this.f993a = 0;
        this.f993a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.f993a);
        if (findViewById != null && (findViewById instanceof TbRichTextView)) {
            ((TbRichTextView) findViewById).setText(null);
        }
    }
}
