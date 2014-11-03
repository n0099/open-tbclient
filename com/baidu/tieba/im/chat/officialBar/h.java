package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ p aRf;
    final /* synthetic */ f aRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, p pVar) {
        this.aRg = fVar;
        this.aRf = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        bg mR = bg.mR();
        context = this.aRg.mContext;
        mR.b(context, new String[]{this.aRf.url});
        context2 = this.aRg.mContext;
        if (context2 instanceof OfficialBarChatActivity) {
            context3 = this.aRg.mContext;
            TiebaStatic.eventStat(context3, "official_msg_ck", "click", 1, ImageViewerConfig.FORUM_ID, this.aRf.fid);
        }
    }
}
