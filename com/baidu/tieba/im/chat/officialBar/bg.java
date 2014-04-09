package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public final class bg extends RelativeLayout {
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

    public bg(Context context) {
        this(context, null);
    }

    private bg(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private bg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.i = null;
        this.a = context;
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.msg_single_pic_text_view, (ViewGroup) this, true);
        this.b = (TextView) findViewById(com.baidu.tieba.im.h.single_title);
        this.c = (TextView) findViewById(com.baidu.tieba.im.h.single_abstract);
        this.d = (TbImageView) findViewById(com.baidu.tieba.im.h.single_content_pic);
        this.f = (TextView) findViewById(com.baidu.tieba.im.h.read_all);
        this.g = (ImageView) findViewById(com.baidu.tieba.im.h.arrow);
        this.e = findViewById(com.baidu.tieba.im.h.single_divider);
        this.h = (TextView) findViewById(com.baidu.tieba.im.h.show_time_single);
        setOnLongClickListener(new bh(this));
    }

    public final void a(t tVar, View view) {
        setPadding(0, (int) this.a.getResources().getDimension(com.baidu.tieba.im.f.multi_padding_left_right), 0, 0);
        if (tVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(tVar.a)) {
                str = tVar.a;
            }
            this.b.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(tVar.b)) {
                str2 = tVar.b;
            }
            this.c.setText(str2);
            if (!TextUtils.isEmpty(tVar.d)) {
                setOnClickListener(new bi(this, tVar));
            }
            this.d.setDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d);
            this.d.setNightDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d_1);
            if (!TextUtils.isEmpty(tVar.c)) {
                this.d.setTag(tVar.c);
                com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(this.a);
                abVar.a(true);
                abVar.b(tVar.c, new bj(this, view));
            }
        }
    }

    public final void a() {
        this.b.setText("");
        this.c.setText("");
        this.d.setBackgroundDrawable(null);
        this.d.setImageBitmap(null);
        this.h.setText("");
        this.h.setVisibility(8);
    }

    public final void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.i = bVar;
    }

    public final void setPosition(int i) {
        this.j = i;
    }

    public final void a(boolean z) {
        if (z) {
            this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text_1));
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_abstract_1));
            this.f.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text_1));
            this.g.setBackgroundResource(com.baidu.tieba.im.g.icon_ba_top_arrow_big_1);
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_time_text_1));
            this.e.setBackgroundResource(com.baidu.tieba.im.g.multi_single_divider_selector_1);
            return;
        }
        this.b.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text));
        this.c.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_abstract_1));
        this.f.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_msg_bottom_text));
        this.g.setBackgroundResource(com.baidu.tieba.im.g.icon_ba_top_arrow_big);
        this.h.setTextColor(getResources().getColor(com.baidu.tieba.im.e.official_time_text));
        this.e.setBackgroundResource(com.baidu.tieba.im.g.multi_single_divider_selector);
    }

    public final void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.h.setVisibility(8);
            this.h.setText("");
            return;
        }
        this.h.setVisibility(0);
        this.h.setText(str);
    }
}
