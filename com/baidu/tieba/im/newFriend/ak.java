package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView bjT;
    TextView bjU;
    TextView bjV;
    TextView bjW;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void f(com.baidu.tieba.im.data.b bVar) {
        this.bjT.d(bVar.getPortrait(), 12, false);
        this.bjU.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.bjV.setText(bVar.getContent());
        } else {
            this.bjV.setText("");
        }
        int status = bVar.getStatus();
        this.bjW.setText(((Integer) ah.RC().get(status)).intValue());
        this.bjW.setEnabled(status == 0 || status == 1);
    }
}
