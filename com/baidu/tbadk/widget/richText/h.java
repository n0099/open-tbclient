package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOF;
    private final /* synthetic */ TbRichTextData aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOF = tbRichTextView;
        this.aOG = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aOF.aOl;
        if (dVar != null) {
            TbRichTextEmotionInfo HI = this.aOG.HI();
            dVar2 = this.aOF.aOl;
            dVar2.a(view, HI.mGifInfo.mGid, HI.mGifInfo.mPackageName, HI.mGifInfo.mIcon, HI.mGifInfo.mStaticUrl, HI.mGifInfo.mDynamicUrl, HI.mGifInfo.mSharpText, HI.mGifInfo.mGifWidth, HI.mGifInfo.mGifHeight);
        }
    }
}
