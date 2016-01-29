package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGA;
    private final /* synthetic */ m aGB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView, m mVar) {
        this.aGA = tbRichTextView;
        this.aGB = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aGA.getContext(), this.aGB.getVideoUrl(), this.aGB.getWidth(), this.aGB.getHeight(), this.aGB.Hx());
    }
}
