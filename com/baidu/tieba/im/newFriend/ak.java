package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ak {
    HeadImageView a;
    TextView b;
    TextView c;
    TextView d;

    private ak() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ak akVar) {
        this();
    }

    public void a(com.baidu.tieba.im.data.k kVar) {
        this.a.a(kVar.c(), 12, false);
        this.b.setText(kVar.b());
        if (!TextUtils.isEmpty(kVar.d())) {
            this.c.setText(kVar.d());
        } else {
            this.c.setText("");
        }
        int e = kVar.e();
        this.d.setText(((Integer) ah.a().get(e)).intValue());
        this.d.setEnabled(e == 0 || e == 1);
    }
}
