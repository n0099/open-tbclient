package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aJH;
    private final /* synthetic */ o aJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, o oVar) {
        this.aJH = tbRichTextView;
        this.aJJ = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aJH.getContext(), this.aJJ.getVideoUrl(), this.aJJ.getWidth(), this.aJJ.getHeight(), this.aJJ.qd());
    }
}
