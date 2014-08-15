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
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.b = (TbImageView) findViewById(com.baidu.tieba.u.bottom_content_pic);
        this.c = (TextView) findViewById(com.baidu.tieba.u.bottom_title);
    }

    public void a(p pVar, View view) {
        if (pVar != null) {
            String str = "";
            if (!TextUtils.isEmpty(pVar.a)) {
                str = pVar.a;
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(pVar.d)) {
                setOnClickListener(new e(this, pVar));
            }
            if (!TextUtils.isEmpty(pVar.c)) {
                this.b.setTag(pVar.c);
                this.b.a(pVar.c, 10, false);
            }
        }
    }

    public void a() {
        this.c.setText("");
        this.b.setBackgroundDrawable(null);
        this.b.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.d = bVar;
    }

    public void setPosition(int i) {
        this.e = i;
    }

    public void a(boolean z) {
        if (z) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text_1));
        } else {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.official_msg_bottom_text));
        }
    }
}
