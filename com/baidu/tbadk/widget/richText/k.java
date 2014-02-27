package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
final class k implements View.OnClickListener {
    final /* synthetic */ TbRichTextView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbRichTextView tbRichTextView) {
        this.a = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        r rVar;
        String str;
        r rVar2;
        rVar = this.a.u;
        if (rVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof String)) {
                str = null;
            } else {
                str = (String) tag;
            }
            int childCount = this.a.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if ((childAt instanceof ImageView) && !(childAt instanceof GifView)) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            rVar2 = this.a.u;
            rVar2.onClick(view, str, i);
        }
    }
}
