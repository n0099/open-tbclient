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
public class c extends LinearLayout {
    private Context a;
    private TbImageView b;
    private TextView c;
    private com.baidu.adp.lib.b.b d;
    private int e;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.a = context;
        b();
        setOnLongClickListener(new d(this));
    }

    private void b() {
        setOrientation(0);
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.b = (TbImageView) findViewById(com.baidu.tieba.v.bottom_content_pic);
        this.c = (TextView) findViewById(com.baidu.tieba.v.bottom_title);
    }

    public void a(t tVar, View view) {
        if (tVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(tVar.a)) {
                str = tVar.a;
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(tVar.d)) {
                setOnClickListener(new e(this, tVar));
            }
            this.b.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
            this.b.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
            if (!TextUtils.isEmpty(tVar.c)) {
                this.b.setTag(tVar.c);
                com.baidu.tbadk.editortool.aa aaVar = new com.baidu.tbadk.editortool.aa(this.a);
                aaVar.b(true);
                aaVar.b(tVar.c, new f(this, view));
            }
        }
    }

    public void a() {
        this.c.setText("");
        this.b.setBackgroundDrawable(null);
        this.b.setImageBitmap(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.d = bVar;
    }

    public void setPosition(int i) {
        this.e = i;
    }

    public void a(boolean z) {
        if (z) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.s.official_msg_bottom_text_1));
        } else {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.s.official_msg_bottom_text));
        }
    }
}
