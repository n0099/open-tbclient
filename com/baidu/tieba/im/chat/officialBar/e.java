package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aQQ;
    private final /* synthetic */ p aQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, p pVar) {
        this.aQQ = cVar;
        this.aQR = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        bf mR = bf.mR();
        context = this.aQQ.mContext;
        mR.b(context, new String[]{this.aQR.url});
        context2 = this.aQQ.mContext;
        if (context2 instanceof OfficialBarChatActivity) {
            context3 = this.aQQ.mContext;
            TiebaStatic.eventStat(context3, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aQR.fid);
        }
    }
}
