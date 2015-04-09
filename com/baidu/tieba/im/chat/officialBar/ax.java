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
public class ax implements View.OnClickListener {
    private final /* synthetic */ TbPageContext aYR;
    private final /* synthetic */ q aYS;
    private final /* synthetic */ int aYT;
    final /* synthetic */ av bai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar, TbPageContext tbPageContext, q qVar, int i) {
        this.bai = avVar;
        this.aYR = tbPageContext;
        this.aYS = qVar;
        this.aYT = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        bk.tl().b(this.aYR, new String[]{this.aYS.url});
        if (this.aYT == 1) {
            context = this.bai.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aYS.fid);
            com.baidu.tieba.im.data.g gY = com.baidu.tieba.im.util.i.gY(this.aYS.aYP);
            if (gY != null) {
                context2 = this.bai.mContext;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", gY.bcu, "task_id", gY.bcv, "loc", GameInfoData.NOT_FROM_DETAIL);
            }
        }
    }
}
