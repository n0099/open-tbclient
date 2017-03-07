package com.baidu.tbadk.widget.richText;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ TbRichTextView aNV;
    private final /* synthetic */ e aNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TbRichTextView tbRichTextView, e eVar) {
        this.aNV = tbRichTextView;
        this.aNX = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10643");
        XiaoyingUtil.startPlayXiaoyingVideo(this.aNV.getContext(), this.aNX.getVideoUrl(), this.aNX.getWidth(), this.aNX.getHeight(), this.aNX.qs());
    }
}
