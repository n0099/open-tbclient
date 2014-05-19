package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class h extends RelativeLayout {
    private Context a;
    private TbImageView b;
    private TextView c;
    private TextView d;
    private com.baidu.adp.lib.b.b e;
    private int f;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = null;
        this.a = context;
        b();
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.b = (TbImageView) findViewById(com.baidu.tieba.r.top_content_pic);
        this.c = (TextView) findViewById(com.baidu.tieba.r.top_title);
        this.d = (TextView) findViewById(com.baidu.tieba.r.show_time);
        setOnLongClickListener(new i(this));
    }

    public void a(t tVar, View view) {
        setPadding((int) this.a.getResources().getDimension(com.baidu.tieba.p.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.p.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.p.multi_padding_left_right), (int) this.a.getResources().getDimension(com.baidu.tieba.p.multi_top_padding_bottom));
        if (tVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(tVar.a)) {
                str = tVar.a;
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(tVar.d)) {
                setOnClickListener(new j(this, tVar));
            }
            this.b.setDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d);
            this.b.setNightDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d_1);
            if (!TextUtils.isEmpty(tVar.c)) {
                this.b.setTag(tVar.c);
                com.baidu.tbadk.editortool.ab abVar = new com.baidu.tbadk.editortool.ab(this.a);
                abVar.d(true);
                abVar.b(tVar.c, new k(this, view));
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
        this.b.setImageBitmap(null);
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
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.o.official_msg_top_text_1));
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.o.official_time_text_1));
            return;
        }
        this.c.setTextColor(getResources().getColor(com.baidu.tieba.o.official_msg_top_text));
        this.d.setTextColor(getResources().getColor(com.baidu.tieba.o.official_time_text));
    }
}
