package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TbRichTextView tbRichTextView) {
        this.f990a = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        String str;
        n nVar2;
        nVar = this.f990a.u;
        if (nVar != null && (view instanceof ImageView)) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof String)) {
                str = null;
            } else {
                str = (String) tag;
            }
            int childCount = this.f990a.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f990a.getChildAt(i2);
                if (childAt instanceof ImageView) {
                    i++;
                }
                if (view == childAt) {
                    break;
                }
            }
            nVar2 = this.f990a.u;
            nVar2.onClick(view, str, i);
        }
    }
}
