package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbRichTextView tbRichTextView) {
        this.aOF = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        boolean L;
        eVar = this.aOF.aOb;
        if (eVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aOF.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aOF.getChildAt(i2);
                L = this.aOF.L(childAt);
                if (L) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            eVar2 = this.aOF.aOb;
            eVar2.a(view, str, i);
        }
    }
}
