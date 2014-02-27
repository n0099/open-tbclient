package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class bp extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
    private TextView c;

    public bp(Context context) {
        super(context, R.layout.msg_msgmid_view);
        this.c = null;
        this.c = (TextView) a(R.id.tex_msgcontent);
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            String g = com.baidu.tieba.im.util.l.g(bVar);
            if (!TextUtils.isEmpty(g)) {
                this.c.setText(g);
                return;
            }
        }
        this.c.setText("");
    }
}
