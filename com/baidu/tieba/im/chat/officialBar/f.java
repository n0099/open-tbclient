package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ d aYQ;
    private final /* synthetic */ TbPageContext aYR;
    private final /* synthetic */ q aYS;
    private final /* synthetic */ int aYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, TbPageContext tbPageContext, q qVar, int i) {
        this.aYQ = dVar;
        this.aYR = tbPageContext;
        this.aYS = qVar;
        this.aYT = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        Context context2;
        int i;
        bk.tl().b(this.aYR, new String[]{this.aYS.url});
        if (this.aYT == 1) {
            context = this.aYQ.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aYS.fid);
            str = this.aYQ.aYP;
            com.baidu.tieba.im.data.g gY = com.baidu.tieba.im.util.i.gY(str);
            if (gY != null) {
                context2 = this.aYQ.mContext;
                StringBuilder sb = new StringBuilder();
                i = this.aYQ.aYO;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", gY.bcu, "task_id", gY.bcv, "loc", sb.append(i).toString());
            }
        }
    }
}
