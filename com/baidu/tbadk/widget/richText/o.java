package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView) {
        this.aFI = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.e eVar;
        String str;
        TbRichTextView.e eVar2;
        eVar = this.aFI.aFr;
        if (eVar != null && (view instanceof TbImageView)) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof TbRichTextView.b)) {
                str = null;
            } else {
                str = ((TbRichTextView.b) tag).url;
            }
            eVar2 = this.aFI.aFr;
            eVar2.b(view, str);
        }
    }
}
