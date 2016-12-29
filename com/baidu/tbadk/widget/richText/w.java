package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJR;
    private final /* synthetic */ n aJT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbRichTextView tbRichTextView, n nVar) {
        this.aJR = tbRichTextView;
        this.aJT = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aJR.getContext(), this.aJT.getVideoUrl(), this.aJT.getWidth(), this.aJT.getHeight(), this.aJT.qh());
    }
}
