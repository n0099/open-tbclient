package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView) {
        this.aBw = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        String str;
        TbRichTextView.d dVar2;
        boolean x;
        dVar = this.aBw.aBf;
        if (dVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aBw.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aBw.getChildAt(i2);
                x = this.aBw.x(childAt);
                if (x) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            dVar2 = this.aBw.aBf;
            dVar2.a(view, str, i);
        }
    }
}
