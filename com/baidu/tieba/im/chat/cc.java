package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class cc extends com.baidu.adp.a.d<com.baidu.tieba.im.message.a.a> {
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private Context f;

    public cc(Context context) {
        super(context, com.baidu.tieba.im.i.msg_msgtopic_view);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f = context;
        this.d = (TextView) a(com.baidu.tieba.im.h.tex_content);
        this.c = (TextView) a(com.baidu.tieba.im.h.tex_title);
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        this.e = (LinearLayout) a(com.baidu.tieba.im.h.topic_title_layout);
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar != null && (aVar instanceof com.baidu.tieba.im.message.bn)) {
            com.baidu.tieba.im.message.bn bnVar = (com.baidu.tieba.im.message.bn) aVar;
            if (!TextUtils.isEmpty(bnVar.a)) {
                this.c.setText(bnVar.a);
            } else {
                this.c.setText("");
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (!TextUtils.isEmpty(bnVar.b)) {
                this.d.setVisibility(0);
                this.d.setText(bnVar.b);
                layoutParams.topMargin = this.f.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.ds24);
                this.e.setLayoutParams(layoutParams);
                return;
            }
            this.d.setText("");
            this.d.setVisibility(8);
            layoutParams.topMargin = 0;
            this.e.setLayoutParams(layoutParams);
        }
    }
}
