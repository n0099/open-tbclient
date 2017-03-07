package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aNV;
    private final /* synthetic */ TbRichTextData aNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aNV = tbRichTextView;
        this.aNW = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aNV.aND;
        if (dVar != null) {
            TbRichTextEmotionInfo Ia = this.aNW.Ia();
            dVar2 = this.aNV.aND;
            dVar2.a(view, Ia.mGifInfo.mGid, Ia.mGifInfo.mPackageName, Ia.mGifInfo.mIcon, Ia.mGifInfo.mStaticUrl, Ia.mGifInfo.mDynamicUrl, Ia.mGifInfo.mSharpText, Ia.mGifInfo.mGifWidth, Ia.mGifInfo.mGifHeight);
        }
    }
}
