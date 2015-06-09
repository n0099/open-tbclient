package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class al {
    HeadImageView aAh;
    TextView aAi;
    TextView aAj;
    TextView aAk;

    private al() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(al alVar) {
        this();
    }

    public void c(com.baidu.tieba.im.data.b bVar) {
        this.aAh.c(bVar.getPortrait(), 12, false);
        this.aAi.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.aAj.setText(bVar.getContent());
        } else {
            this.aAj.setText("");
        }
        int status = bVar.getStatus();
        this.aAk.setText(((Integer) ai.FS().get(status)).intValue());
        this.aAk.setEnabled(status == 0 || status == 1);
    }
}
