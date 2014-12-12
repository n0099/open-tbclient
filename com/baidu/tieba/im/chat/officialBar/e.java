package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aSI;
    private final /* synthetic */ TbPageContext aSJ;
    private final /* synthetic */ p aSK;
    private final /* synthetic */ int aSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, TbPageContext tbPageContext, p pVar, int i) {
        this.aSI = cVar;
        this.aSJ = tbPageContext;
        this.aSK = pVar;
        this.aSL = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bh.pK().b(this.aSJ, new String[]{this.aSK.url});
        if (this.aSL == 1) {
            context = this.aSI.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aSK.fid);
        }
    }
}
