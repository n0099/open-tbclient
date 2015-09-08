package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aDV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbRichTextView tbRichTextView) {
        this.aDV = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.c cVar;
        String str;
        TbRichTextView.c cVar2;
        cVar = this.aDV.aDG;
        if (cVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aDV.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aDV.getChildAt(i2);
                if ((childAt instanceof ImageView) && !(childAt instanceof GifView)) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            cVar2 = this.aDV.aDG;
            cVar2.a(view, str, i);
        }
    }
}
