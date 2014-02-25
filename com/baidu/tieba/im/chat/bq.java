package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
    private TextView c;

    public bq(Context context) {
        super(context, R.layout.msg_msgmid_view);
        this.c = null;
        e();
    }

    private void e() {
        this.c = (TextView) a(R.id.tex_msgcontent);
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            this.c.setText("");
            return;
        }
        String h = com.baidu.tieba.im.util.l.h(bVar);
        if (!TextUtils.isEmpty(h)) {
            this.c.setText(h);
        } else {
            this.c.setText("");
        }
    }
}
