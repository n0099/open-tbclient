package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbRichTextView tbRichTextView) {
        this.aKA = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        boolean Q;
        eVar = this.aKA.aJZ;
        if (eVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aKA.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aKA.getChildAt(i2);
                Q = this.aKA.Q(childAt);
                if (Q) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            eVar2 = this.aKA.aJZ;
            eVar2.a(view, str, i);
        }
    }
}
