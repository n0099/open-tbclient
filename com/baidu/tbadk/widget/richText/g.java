package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aIy;
    private final /* synthetic */ TbRichTextData aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aIy = tbRichTextView;
        this.aIz = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aIy.aIg;
        if (dVar != null) {
            TbRichTextEmotionInfo HA = this.aIz.HA();
            dVar2 = this.aIy.aIg;
            dVar2.a(view, HA.mGifInfo.mGid, HA.mGifInfo.mPackageName, HA.mGifInfo.mIcon, HA.mGifInfo.mStaticUrl, HA.mGifInfo.mDynamicUrl, HA.mGifInfo.mSharpText, HA.mGifInfo.mGifWidth, HA.mGifInfo.mGifHeight);
        }
    }
}
