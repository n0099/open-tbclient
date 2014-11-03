package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    LinearLayout Hl;
    TbRichTextView aQU;
    TextView aQV;
    ChatImageWithTailView aQW;
    Context mContext;

    public a(Context context) {
        super(context);
        this.mContext = context;
        nu();
    }

    private void nu() {
        setOrientation(1);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.official_history_item, this, true);
        setClickable(false);
        setFocusable(false);
        this.Hl = (LinearLayout) findViewById(com.baidu.tieba.v.history_container);
        this.aQV = (TextView) findViewById(com.baidu.tieba.v.history_send_time);
        this.aQU = (TbRichTextView) findViewById(com.baidu.tieba.v.history_txt);
        this.aQW = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.history_pic);
        com.baidu.tbadk.core.util.aw.h(this.Hl, com.baidu.tieba.u.selector_history_multi_single_bg);
        com.baidu.tbadk.core.util.aw.b(this.aQV, com.baidu.tieba.s.official_time_text, 1);
        com.baidu.tbadk.core.util.aw.b(this.aQU, com.baidu.tieba.s.official_list_item_content, 1);
    }

    public void setTime(String str) {
        this.aQV.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aQU;
    }

    public ChatImageWithTailView getImageView() {
        return this.aQW;
    }

    public void J(View view) {
        this.Hl.setBackgroundDrawable(null);
        this.Hl.removeAllViews();
        this.Hl.addView(view);
    }
}
