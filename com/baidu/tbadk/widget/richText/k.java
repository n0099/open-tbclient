package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ TbRichTextView atr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TbRichTextView tbRichTextView) {
        this.atr = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        String str;
        s sVar2;
        sVar = this.atr.atd;
        if (sVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.atr.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.atr.getChildAt(i2);
                if ((childAt instanceof ImageView) && !(childAt instanceof GifView)) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            sVar2 = this.atr.atd;
            sVar2.onClick(view, str, i);
        }
    }
}
