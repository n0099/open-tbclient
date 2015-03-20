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
    final /* synthetic */ d aYA;
    private final /* synthetic */ TbPageContext aYB;
    private final /* synthetic */ q aYC;
    private final /* synthetic */ int aYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, TbPageContext tbPageContext, q qVar, int i) {
        this.aYA = dVar;
        this.aYB = tbPageContext;
        this.aYC = qVar;
        this.aYD = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        Context context2;
        int i;
        bk.tl().b(this.aYB, new String[]{this.aYC.url});
        if (this.aYD == 1) {
            context = this.aYA.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aYC.fid);
            str = this.aYA.aYz;
            com.baidu.tieba.im.data.g gV = com.baidu.tieba.im.util.i.gV(str);
            if (gV != null) {
                context2 = this.aYA.mContext;
                StringBuilder sb = new StringBuilder();
                i = this.aYA.aYy;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", gV.bce, "task_id", gV.bcf, "loc", sb.append(i).toString());
            }
        }
    }
}
