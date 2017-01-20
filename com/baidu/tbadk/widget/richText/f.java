package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbRichTextView tbRichTextView) {
        this.aIy = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        boolean O;
        eVar = this.aIy.aHX;
        if (eVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aIy.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aIy.getChildAt(i2);
                O = this.aIy.O(childAt);
                if (O) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            eVar2 = this.aIy.aHX;
            eVar2.a(view, str, i);
        }
    }
}
