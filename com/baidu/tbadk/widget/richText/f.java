package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbRichTextView tbRichTextView) {
        this.aOn = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        boolean M;
        eVar = this.aOn.aNM;
        if (eVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String)) {
                str = (String) tag;
            } else if (!(view instanceof TbImageView)) {
                str = null;
            } else {
                str = ((TbImageView) view).getUrl();
            }
            int childCount = this.aOn.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.aOn.getChildAt(i2);
                M = this.aOn.M(childAt);
                if (M) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            eVar2 = this.aOn.aNM;
            eVar2.a(view, str, i);
        }
    }
}
