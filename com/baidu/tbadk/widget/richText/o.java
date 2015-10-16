package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCC;
    private final /* synthetic */ j aCD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, j jVar) {
        this.aCC = tbRichTextView;
        this.aCD = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10067");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aCC.getContext(), this.aCD.getVideoUrl());
    }
}
