package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aTU;
    private final /* synthetic */ TbPageContext aTV;
    private final /* synthetic */ p aTW;
    private final /* synthetic */ int aTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, TbPageContext tbPageContext, p pVar, int i) {
        this.aTU = cVar;
        this.aTV = tbPageContext;
        this.aTW = pVar;
        this.aTX = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String str;
        Context context2;
        int i;
        bm.pV().b(this.aTV, new String[]{this.aTW.url});
        if (this.aTX == 1) {
            context = this.aTU.mContext;
            TiebaStatic.eventStat(context, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aTW.fid);
            str = this.aTU.aTT;
            com.baidu.tieba.im.data.g ht = com.baidu.tieba.im.util.i.ht(str);
            if (ht != null) {
                context2 = this.aTU.mContext;
                StringBuilder sb = new StringBuilder();
                i = this.aTU.aTS;
                TiebaStatic.eventStat(context2, "message_open_detail", "click", 1, "task_type", ht.aXX, "task_id", ht.aXY, "loc", sb.append(i).toString());
            }
        }
    }
}
