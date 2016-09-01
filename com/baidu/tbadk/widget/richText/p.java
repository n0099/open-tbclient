package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView) {
        this.aKi = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        String str;
        TbRichTextView.d dVar2;
        boolean P;
        dVar = this.aKi.aJI;
        if (dVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aKi.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aKi.getChildAt(i2);
                P = this.aKi.P(childAt);
                if (P) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            dVar2 = this.aKi.aJI;
            dVar2.a(view, str, i);
        }
    }
}
