package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aBw;
    private final /* synthetic */ m aBx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView, m mVar) {
        this.aBw = tbRichTextView;
        this.aBx = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10067");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aBw.getContext(), this.aBx.getVideoUrl());
    }
}
