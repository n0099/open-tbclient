package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView blq;
    TextView blr;
    TextView bls;
    TextView blt;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void f(com.baidu.tieba.im.data.b bVar) {
        this.blq.d(bVar.getPortrait(), 12, false);
        this.blr.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.bls.setText(bVar.getContent());
        } else {
            this.bls.setText("");
        }
        int status = bVar.getStatus();
        this.blt.setText(((Integer) ah.RY().get(status)).intValue());
        this.blt.setEnabled(status == 0 || status == 1);
    }
}
