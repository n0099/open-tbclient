package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView blp;
    TextView blq;
    TextView blr;
    TextView bls;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void f(com.baidu.tieba.im.data.b bVar) {
        this.blp.d(bVar.getPortrait(), 12, false);
        this.blq.setText(bVar.getName());
        if (!TextUtils.isEmpty(bVar.getContent())) {
            this.blr.setText(bVar.getContent());
        } else {
            this.blr.setText("");
        }
        int status = bVar.getStatus();
        this.bls.setText(((Integer) ah.RT().get(status)).intValue());
        this.bls.setEnabled(status == 0 || status == 1);
    }
}
