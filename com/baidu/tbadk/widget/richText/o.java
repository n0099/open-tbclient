package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCr;
    private final /* synthetic */ j aCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, j jVar) {
        this.aCr = tbRichTextView;
        this.aCs = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10067");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aCr.getContext(), this.aCs.getVideoUrl());
    }
}
