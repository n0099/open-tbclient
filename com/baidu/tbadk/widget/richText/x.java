package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aKi;
    private final /* synthetic */ o aKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, o oVar) {
        this.aKi = tbRichTextView;
        this.aKk = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aKi.getContext(), this.aKk.getVideoUrl(), this.aKk.getWidth(), this.aKk.getHeight(), this.aKk.pS());
    }
}
