package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public final class c extends LinearLayout {
    private Context a;
    private TbImageView b;
    private TextView c;
    private com.baidu.adp.lib.b.b d;
    private int e;

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.d = null;
        this.a = context;
        setOrientation(0);
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.b = (TbImageView) findViewById(com.baidu.tieba.im.h.bottom_content_pic);
        this.c = (TextView) findViewById(com.baidu.tieba.im.h.bottom_title);
        setOnLongClickListener(new d(this));
    }

    public final void a(t tVar, View view) {
        if (tVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(tVar.a)) {
                str = tVar.a;
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(tVar.d)) {
                setOnClickListener(new e(this, tVar));
            }
            this.b.setDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d);
            this.b.setNightDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d_1);
            if (!TextUtils.isEmpty(tVar.c)) {
                this.b.setTag(tVar.c);
                com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(this.a);
                abVar.a(true);
                abVar.b(tVar.c, new f(this, view));
            }
        }
    }

    public final void a() {
        this.c.setText("");
        this.b.setBackgroundDrawable(null);
        this.b.setImageBitmap(null);
    }

    public final void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.d = bVar;
    }

    public final void setPosition(int i) {
        this.e = i;
    }

    public final void a(boolean z) {
        if (z) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text_1));
        } else {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text));
        }
    }
}
