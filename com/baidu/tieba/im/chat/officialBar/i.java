package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aYB;
    private final /* synthetic */ q aYC;
    private final /* synthetic */ int aYD;
    final /* synthetic */ g aYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, TbPageContext tbPageContext, q qVar, int i) {
        this.aYE = gVar;
        this.aYB = tbPageContext;
        this.aYC = qVar;
        this.aYD = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        bk.tl().b(this.aYB, new String[]{this.aYC.url});
        if (this.aYD == 1) {
            context = this.aYE.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aYC.fid);
            com.baidu.tieba.im.data.g gV = com.baidu.tieba.im.util.i.gV(this.aYC.aYz);
            if (gV != null) {
                context2 = this.aYE.mContext;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", gV.bce, "task_id", gV.bcf, "loc", GameInfoData.NOT_FROM_DETAIL);
            }
        }
    }
}
