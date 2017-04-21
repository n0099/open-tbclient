package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aOn;
    private final /* synthetic */ e aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, e eVar) {
        this.aOn = tbRichTextView;
        this.aOp = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aOn.getContext(), this.aOp.getVideoUrl(), this.aOp.getWidth(), this.aOp.getHeight(), this.aOp.qP());
    }
}
