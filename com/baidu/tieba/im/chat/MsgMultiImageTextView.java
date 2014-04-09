package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.im.chat.officialBar.MultiContentView;
import java.util.List;
/* loaded from: classes.dex */
public class MsgMultiImageTextView extends cd {
    private MultiContentView p;

    public MsgMultiImageTextView(Context context) {
        super(context, com.baidu.tieba.im.i.msg_multi_pictext_view);
        this.i = (TextView) a(com.baidu.tieba.im.h.tex_msgitem_time);
        this.p = (MultiContentView) a(com.baidu.tieba.im.h.msg_content);
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar, View view) {
        if (aVar != null) {
            c(aVar);
            List<com.baidu.tieba.im.chat.officialBar.t> a = com.baidu.tieba.im.chat.officialBar.s.a(aVar.v());
            this.p.setPosition(this.f);
            this.p.setOnItemViewLongClickListener(this.d);
            this.p.setNeedNightMode(false);
            this.p.setType(1);
            this.p.a(a, view);
        }
    }
}
