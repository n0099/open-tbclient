package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aDV;
    private final /* synthetic */ j aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, j jVar) {
        this.aDV = tbRichTextView;
        this.aDW = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10067");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aDV.getContext(), this.aDW.getVideoUrl());
    }
}
