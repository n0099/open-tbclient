package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    Context a;
    TbRichTextView b;
    TextView c;
    ChatImageWithTailView d;
    LinearLayout e;

    public a(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setOrientation(1);
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.official_history_item, this, true);
        setClickable(false);
        setFocusable(false);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.u.history_container);
        this.c = (TextView) findViewById(com.baidu.tieba.u.history_send_time);
        this.b = (TbRichTextView) findViewById(com.baidu.tieba.u.history_txt);
        this.d = (ChatImageWithTailView) findViewById(com.baidu.tieba.u.history_pic);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.e.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_single_bg_1);
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.official_time_text_1));
            this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.official_list_item_content_1));
            return;
        }
        this.e.setBackgroundResource(com.baidu.tieba.t.selector_history_multi_single_bg);
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.official_time_text));
        this.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.official_list_item_content));
    }

    public void setTime(String str) {
        this.c.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.b;
    }

    public ChatImageWithTailView getImageView() {
        return this.d;
    }

    public void a(View view) {
        this.e.setBackgroundDrawable(null);
        this.e.removeAllViews();
        this.e.addView(view);
    }
}
