package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bg;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(GameWebViewActivity gameWebViewActivity) {
        this.a = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (this.a.getString(com.baidu.tieba.x.back).equals(tag)) {
            this.a.finish();
        } else if (this.a.getString(com.baidu.tieba.x.refresh).equals(tag)) {
            this.a.refresh();
        } else if (this.a.getString(com.baidu.tieba.x.share).equals(tag)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bg(this.a, 23003, 2)));
        }
    }
}
