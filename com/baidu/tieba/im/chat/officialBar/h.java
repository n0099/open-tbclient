package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aTU;
    private final /* synthetic */ p aTV;
    private final /* synthetic */ int aTW;
    final /* synthetic */ f aTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, TbPageContext tbPageContext, p pVar, int i) {
        this.aTX = fVar;
        this.aTU = tbPageContext;
        this.aTV = pVar;
        this.aTW = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        bm.pO().b(this.aTU, new String[]{this.aTV.url});
        if (this.aTW == 1) {
            context = this.aTX.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aTV.fid);
            com.baidu.tieba.im.data.g hq = com.baidu.tieba.im.util.i.hq(this.aTV.aTS);
            if (hq != null) {
                context2 = this.aTX.mContext;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", hq.aXW, "task_id", hq.aXX, "loc", "0");
            }
        }
    }
}
