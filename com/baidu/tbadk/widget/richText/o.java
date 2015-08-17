package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aCn;
    private final /* synthetic */ j aCo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbRichTextView tbRichTextView, j jVar) {
        this.aCn = tbRichTextView;
        this.aCo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10067");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aCn.getContext(), this.aCo.getVideoUrl());
    }
}
