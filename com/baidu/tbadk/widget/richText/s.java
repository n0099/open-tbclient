package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aEi;
    private final /* synthetic */ m aEj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbRichTextView tbRichTextView, m mVar) {
        this.aEi = tbRichTextView;
        this.aEj = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aEi.getContext(), this.aEj.getVideoUrl(), this.aEj.getWidth(), this.aEj.getHeight(), this.aEj.Gk());
    }
}
