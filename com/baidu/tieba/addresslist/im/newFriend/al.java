package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class al {
    HeadImageView ayn;
    TextView ayo;
    TextView ayp;
    TextView ayq;

    private al() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(al alVar) {
        this();
    }

    public void c(com.baidu.tieba.im.data.b bVar) {
        this.ayn.c(bVar.getPortrait(), 12, false);
        this.ayo.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.ayp.setText(bVar.getContent());
        } else {
            this.ayp.setText("");
        }
        int status = bVar.getStatus();
        this.ayq.setText(((Integer) ai.ES().get(status)).intValue());
        this.ayq.setEnabled(status == 0 || status == 1);
    }
}
