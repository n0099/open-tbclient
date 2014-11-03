package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView bhb;
    TextView bhc;
    TextView bhd;
    TextView bhe;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void e(com.baidu.tieba.im.data.e eVar) {
        this.bhb.c(eVar.getPortrait(), 12, false);
        this.bhc.setText(eVar.getName());
        if (!TextUtils.isEmpty(eVar.getContent())) {
            this.bhd.setText(eVar.getContent());
        } else {
            this.bhd.setText("");
        }
        int status = eVar.getStatus();
        this.bhe.setText(((Integer) ah.Ri().get(status)).intValue());
        this.bhe.setEnabled(status == 0 || status == 1);
    }
}
