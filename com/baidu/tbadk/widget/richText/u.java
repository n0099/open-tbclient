package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJw;
    private final /* synthetic */ n aJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbRichTextView tbRichTextView, n nVar) {
        this.aJw = tbRichTextView;
        this.aJx = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aJw.getContext(), this.aJx.getVideoUrl(), this.aJx.getWidth(), this.aJx.getHeight(), this.aJx.rV());
    }
}
