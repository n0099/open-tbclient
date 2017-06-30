package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aPX;
    private final /* synthetic */ TbRichTextData aPZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aPX = tbRichTextView;
        this.aPZ = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aPX.aPB;
        if (dVar != null) {
            TbRichTextEmotionInfo If = this.aPZ.If();
            dVar2 = this.aPX.aPB;
            dVar2.a(view, If.mGifInfo.mGid, If.mGifInfo.mPackageName, If.mGifInfo.mIcon, If.mGifInfo.mStaticUrl, If.mGifInfo.mDynamicUrl, If.mGifInfo.mSharpText, If.mGifInfo.mGifWidth, If.mGifInfo.mGifHeight);
        }
    }
}
