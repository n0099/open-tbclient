package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class al {
    HeadImageView ayv;
    TextView ayw;
    TextView ayx;
    TextView ayy;

    private al() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(al alVar) {
        this();
    }

    public void c(com.baidu.tieba.im.data.b bVar) {
        this.ayv.c(bVar.getPortrait(), 12, false);
        this.ayw.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.ayx.setText(bVar.getContent());
        } else {
            this.ayx.setText("");
        }
        int status = bVar.getStatus();
        this.ayy.setText(((Integer) ai.EY().get(status)).intValue());
        this.ayy.setEnabled(status == 0 || status == 1);
    }
}
