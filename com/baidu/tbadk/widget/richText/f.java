package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbRichTextView tbRichTextView) {
        this.aOl = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        boolean M;
        eVar = this.aOl.aNK;
        if (eVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aOl.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aOl.getChildAt(i2);
                M = this.aOl.M(childAt);
                if (M) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            eVar2 = this.aOl.aNK;
            eVar2.a(view, str, i);
        }
    }
}
