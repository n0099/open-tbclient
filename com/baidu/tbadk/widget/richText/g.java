package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOn;
    private final /* synthetic */ TbRichTextData aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, TbRichTextData tbRichTextData) {
        this.aOn = tbRichTextView;
        this.aOo = tbRichTextData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbRichTextView.d dVar;
        TbRichTextView.d dVar2;
        dVar = this.aOn.aNV;
        if (dVar != null) {
            TbRichTextEmotionInfo Iz = this.aOo.Iz();
            dVar2 = this.aOn.aNV;
            dVar2.a(view, Iz.mGifInfo.mGid, Iz.mGifInfo.mPackageName, Iz.mGifInfo.mIcon, Iz.mGifInfo.mStaticUrl, Iz.mGifInfo.mDynamicUrl, Iz.mGifInfo.mSharpText, Iz.mGifInfo.mGifWidth, Iz.mGifInfo.mGifHeight);
        }
    }
}
