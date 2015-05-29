package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class al {
    HeadImageView aAg;
    TextView aAh;
    TextView aAi;
    TextView aAj;

    private al() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(al alVar) {
        this();
    }

    public void c(com.baidu.tieba.im.data.b bVar) {
        this.aAg.c(bVar.getPortrait(), 12, false);
        this.aAh.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.aAi.setText(bVar.getContent());
        } else {
            this.aAi.setText("");
        }
        int status = bVar.getStatus();
        this.aAj.setText(((Integer) ai.FR().get(status)).intValue());
        this.aAj.setEnabled(status == 0 || status == 1);
    }
}
