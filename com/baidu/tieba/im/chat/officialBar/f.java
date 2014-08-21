package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class f extends RelativeLayout {
    private Context a;
    private TbImageView b;
    private TextView c;
    private TextView d;
    private com.baidu.adp.lib.b.b e;
    private int f;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = null;
        this.a = context;
        b();
    }

    private void b() {
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.msg_multi_pic_text_top_view, this, true);
        this.b = (TbImageView) findViewById(com.baidu.tieba.u.top_content_pic);
        this.c = (TextView) findViewById(com.baidu.tieba.u.top_title);
        this.d = (TextView) findViewById(com.baidu.tieba.u.show_time);
        setOnLongClickListener(new g(this));
    }

    public void a(p pVar, View view) {
        setPadding((int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_top_padding_bottom));
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.a)) {
                str = pVar.a;
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(pVar.d)) {
                setOnClickListener(new h(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.c)) {
                this.b.setTag(pVar.c);
                this.b.a(pVar.c, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
            this.d.setText("");
            return;
        }
        this.d.setVisibility(0);
        this.d.setText(str);
    }

    public void a() {
        this.c.setText("");
        this.b.setBackgroundDrawable(null);
        this.b.setImageDrawable(null);
        this.d.setVisibility(8);
        this.d.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.e = bVar;
    }

    public void setPosition(int i) {
        this.f = i;
    }

    public void a(boolean z) {
        if (z) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_top_text_1));
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.r.official_time_text_1));
            return;
        }
        this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_top_text));
        this.d.setTextColor(getResources().getColor(com.baidu.tieba.r.official_time_text));
    }
}
