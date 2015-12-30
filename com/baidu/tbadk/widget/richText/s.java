package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFI;
    private final /* synthetic */ m aFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView, m mVar) {
        this.aFI = tbRichTextView;
        this.aFJ = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aFI.getContext(), this.aFJ.getVideoUrl(), this.aFJ.getWidth(), this.aFJ.getHeight(), this.aFJ.FZ());
    }
}
