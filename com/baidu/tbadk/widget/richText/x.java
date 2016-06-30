package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGf;
    private final /* synthetic */ o aGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, o oVar) {
        this.aGf = tbRichTextView;
        this.aGh = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aGf.getContext(), this.aGh.getVideoUrl(), this.aGh.getWidth(), this.aGh.getHeight(), this.aGh.pg());
    }
}
