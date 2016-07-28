package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aGW;
    private final /* synthetic */ o aGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbRichTextView tbRichTextView, o oVar) {
        this.aGW = tbRichTextView;
        this.aGY = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aGW.getContext(), this.aGY.getVideoUrl(), this.aGY.getWidth(), this.aGY.getHeight(), this.aGY.oP());
    }
}
