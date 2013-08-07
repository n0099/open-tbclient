package com.baidu.tbadk.widget.richText;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TbRichTextView f810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView) {
        this.f810a = tbRichTextView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        mVar = this.f810a.r;
        if (mVar != null && (view instanceof ImageView)) {
            String str = null;
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                str = (String) view.getTag();
            }
            int childCount = this.f810a.getChildCount();
            int i = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.f810a.getChildAt(i2) instanceof ImageView) {
                    i++;
                }
                if (view == this.f810a.getChildAt(i2)) {
                    break;
                }
            }
            mVar2 = this.f810a.r;
            mVar2.onClick(view, str, i);
        }
    }
}
