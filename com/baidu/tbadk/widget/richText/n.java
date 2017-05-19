package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOG;
    private final /* synthetic */ e aOI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, e eVar) {
        this.aOG = tbRichTextView;
        this.aOI = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aOG.getContext(), this.aOI.getVideoUrl(), this.aOI.getWidth(), this.aOI.getHeight(), this.aOI.qc());
    }
}
