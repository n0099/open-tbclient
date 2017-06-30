package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aPX;
    private final /* synthetic */ e aPY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbRichTextView tbRichTextView, e eVar) {
        this.aPX = tbRichTextView;
        this.aPY = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aPX.getContext(), this.aPY.getVideoUrl(), this.aPY.getWidth(), this.aPY.getHeight(), this.aPY.getThumbUrl());
    }
}
