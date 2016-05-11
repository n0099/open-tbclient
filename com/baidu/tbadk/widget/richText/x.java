package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aFD;
    private final /* synthetic */ o aFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, o oVar) {
        this.aFD = tbRichTextView;
        this.aFF = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aFD.getContext(), this.aFF.getVideoUrl(), this.aFF.getWidth(), this.aFF.getHeight(), this.aFF.po());
    }
}
