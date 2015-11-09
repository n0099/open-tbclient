package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView) {
        this.aBw = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        eVar = this.aBw.aBg;
        if (eVar != null && (view instanceof TbImageView)) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof TbRichTextView.b)) {
                str = null;
            } else {
                str = ((TbRichTextView.b) tag).url;
            }
            eVar2 = this.aBw.aBg;
            eVar2.b(view, str);
        }
    }
}
