package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final /* synthetic */ e aIA;
    final /* synthetic */ TbRichTextView aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, e eVar) {
        this.aIy = tbRichTextView;
        this.aIA = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aIy.getContext(), this.aIA.getVideoUrl(), this.aIA.getWidth(), this.aIA.getHeight(), this.aIA.qa());
    }
}
