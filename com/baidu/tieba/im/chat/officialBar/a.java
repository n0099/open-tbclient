package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView2;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
public final class a extends LinearLayout {
    Context a;
    TbRichTextView b;
    TextView c;
    BDImageView2 d;
    LinearLayout e;

    public a(Context context) {
        super(context);
        this.a = context;
        setOrientation(1);
        ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.im.h.history_container);
        this.c = (TextView) findViewById(com.baidu.tieba.im.h.history_send_time);
        this.b = (TbRichTextView) findViewById(com.baidu.tieba.im.h.history_txt);
        this.d = (BDImageView2) findViewById(com.baidu.tieba.im.h.history_pic);
        if (TbadkApplication.j().l() != 1) {
            this.e.setBackgroundResource(com.baidu.tieba.im.g.selector_history_multi_single_bg);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.official_time_text));
            this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.official_list_item_content));
            this.d.setDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d);
            return;
        }
        this.e.setBackgroundResource(com.baidu.tieba.im.g.selector_history_multi_single_bg_1);
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.official_time_text_1));
        this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.im.e.official_list_item_content_1));
        this.d.setDefaultResource(com.baidu.tieba.im.g.pic_baidu_logo_d_1);
    }

    public final void setTime(String str) {
        this.c.setText(str);
    }

    public final TbRichTextView getRichTextView() {
        return this.b;
    }

    public final BDImageView2 getImageView() {
        return this.d;
    }

    public final void a(View view) {
        this.e.setBackgroundDrawable(null);
        this.e.removeAllViews();
        this.e.addView(view);
    }
}
