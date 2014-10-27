package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView bgN;
    TextView bgO;
    TextView bgP;
    TextView bgQ;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void e(com.baidu.tieba.im.data.e eVar) {
        this.bgN.c(eVar.getPortrait(), 12, false);
        this.bgO.setText(eVar.getName());
        if (!TextUtils.isEmpty(eVar.getContent())) {
            this.bgP.setText(eVar.getContent());
        } else {
            this.bgP.setText("");
        }
        int status = eVar.getStatus();
        this.bgQ.setText(((Integer) ah.Rf().get(status)).intValue());
        this.bgQ.setEnabled(status == 0 || status == 1);
    }
}
