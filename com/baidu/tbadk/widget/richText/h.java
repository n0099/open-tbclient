package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbRichTextView tbRichTextView) {
        this.aOl = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.f fVar;
        String str;
        TbRichTextView.f fVar2;
        fVar = this.aOl.aNL;
        if (fVar != null && (view instanceof TbImageView)) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof TbRichTextView.c)) {
                str = null;
            } else {
                str = ((TbRichTextView.c) tag).url;
            }
            fVar2 = this.aOl.aNL;
            fVar2.b(view, str);
        }
    }
}
