package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    Context a;
    TbRichTextView b;
    TextView c;
    TbImageView d;
    LinearLayout e;

    public a(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setOrientation(1);
        ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(com.baidu.tieba.s.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.r.history_container);
        this.c = (TextView) findViewById(com.baidu.tieba.r.history_send_time);
        this.b = (TbRichTextView) findViewById(com.baidu.tieba.r.history_txt);
        this.d = (TbImageView) findViewById(com.baidu.tieba.r.history_pic);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.e.setBackgroundResource(com.baidu.tieba.q.selector_history_multi_single_bg_1);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.official_time_text_1));
            this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.official_list_item_content_1));
            this.d.setDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d_1);
            return;
        }
        this.e.setBackgroundResource(com.baidu.tieba.q.selector_history_multi_single_bg);
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.official_time_text));
        this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.official_list_item_content));
        this.d.setDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d);
    }

    public void setTime(String str) {
        this.c.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.b;
    }

    public TbImageView getImageView() {
        return this.d;
    }

    public void a(View view) {
        this.e.setBackgroundDrawable(null);
        this.e.removeAllViews();
        this.e.addView(view);
    }
}
