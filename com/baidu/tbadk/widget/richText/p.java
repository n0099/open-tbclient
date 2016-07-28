package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView) {
        this.aGW = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        String str;
        TbRichTextView.d dVar2;
        boolean O;
        dVar = this.aGW.aGw;
        if (dVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aGW.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aGW.getChildAt(i2);
                O = this.aGW.O(childAt);
                if (O) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            dVar2 = this.aGW.aGw;
            dVar2.a(view, str, i);
        }
    }
}
