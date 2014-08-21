package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class bc extends RelativeLayout {
    private Context a;
    private TextView b;
    private TextView c;
    private TbImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private com.baidu.adp.lib.b.b i;
    private int j;

    public bc(Context context) {
        this(context, null);
    }

    public bc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = null;
        this.a = context;
        b();
    }

    private void b() {
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.msg_single_pic_text_view, this, true);
        this.b = (TextView) findViewById(com.baidu.tieba.u.single_title);
        this.c = (TextView) findViewById(com.baidu.tieba.u.single_abstract);
        this.d = (TbImageView) findViewById(com.baidu.tieba.u.single_content_pic);
        this.f = (TextView) findViewById(com.baidu.tieba.u.read_all);
        this.g = (ImageView) findViewById(com.baidu.tieba.u.arrow);
        this.e = findViewById(com.baidu.tieba.u.single_divider);
        this.h = (TextView) findViewById(com.baidu.tieba.u.show_time_single);
        setOnLongClickListener(new bd(this));
    }

    public void a(p pVar, View view) {
        setPadding(0, (int) this.a.getResources().getDimension(com.baidu.tieba.s.multi_padding_left_right), 0, 0);
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.a)) {
                str = pVar.a;
            }
            this.b.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(pVar.b)) {
                str2 = pVar.b;
            }
            this.c.setText(str2);
            if (!TextUtils.isEmpty(pVar.d)) {
                setOnClickListener(new be(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.c)) {
                this.d.setTag(pVar.c);
                this.d.a(pVar.c, 10, false);
            }
        }
    }

    public void a() {
        this.b.setText("");
        this.c.setText("");
        this.d.setBackgroundDrawable(null);
        this.d.setImageDrawable(null);
        this.h.setText("");
        this.h.setVisibility(8);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.i = bVar;
    }

    public void setPosition(int i) {
        this.j = i;
    }

    public void a(boolean z) {
        if (z) {
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text_1));
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_abstract_1));
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text_1));
            this.g.setBackgroundResource(com.baidu.tieba.t.icon_ba_top_arrow_big_1);
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.r.official_time_text_1));
            this.e.setBackgroundResource(com.baidu.tieba.t.multi_single_divider_selector_1);
            return;
        }
        this.b.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text));
        this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_abstract_1));
        this.f.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text));
        this.g.setBackgroundResource(com.baidu.tieba.t.icon_ba_top_arrow_big);
        this.h.setTextColor(getResources().getColor(com.baidu.tieba.r.official_time_text));
        this.e.setBackgroundResource(com.baidu.tieba.t.multi_single_divider_selector);
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.h.setVisibility(8);
            this.h.setText("");
            return;
        }
        this.h.setVisibility(0);
        this.h.setText(str);
    }
}
