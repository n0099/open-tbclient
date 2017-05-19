package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOG;
    private final /* synthetic */ TbRichTextData aOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOG = tbRichTextView;
        this.aOH = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aOG.aOn;
        if (dVar != null) {
            TbRichTextEmotionInfo HN = this.aOH.HN();
            dVar2 = this.aOG.aOn;
            dVar2.a(view, HN.mGifInfo.mGid, HN.mGifInfo.mPackageName, HN.mGifInfo.mIcon, HN.mGifInfo.mStaticUrl, HN.mGifInfo.mDynamicUrl, HN.mGifInfo.mSharpText, HN.mGifInfo.mGifWidth, HN.mGifInfo.mGifHeight);
        }
    }
}
