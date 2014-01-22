package com.baidu.tieba.im.chat;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.a.c<com.baidu.tieba.im.message.b> {
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private Context f;

    public bj(Context context) {
        super(context, R.layout.msg_msgtopic_view);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f = context;
        e();
    }

    private void e() {
        this.d = (TextView) a(R.id.tex_content);
        this.c = (TextView) a(R.id.tex_title);
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        this.e = (LinearLayout) a(R.id.topic_title_layout);
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null && (bVar instanceof com.baidu.tieba.im.message.cu)) {
            com.baidu.tieba.im.message.cu cuVar = (com.baidu.tieba.im.message.cu) bVar;
            if (!TextUtils.isEmpty(cuVar.b)) {
                this.c.setText(cuVar.b);
            } else {
                this.c.setText("");
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (!TextUtils.isEmpty(cuVar.c)) {
                this.d.setVisibility(0);
                this.d.setText(cuVar.c);
                layoutParams.topMargin = this.f.getResources().getDimensionPixelSize(R.dimen.ds24);
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
