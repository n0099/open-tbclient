package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    LinearLayout Hk;
    TbRichTextView aQG;
    TextView aQH;
    ChatImageWithTailView aQI;
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
        this.Hk = (LinearLayout) findViewById(com.baidu.tieba.v.history_container);
        this.aQH = (TextView) findViewById(com.baidu.tieba.v.history_send_time);
        this.aQG = (TbRichTextView) findViewById(com.baidu.tieba.v.history_txt);
        this.aQI = (ChatImageWithTailView) findViewById(com.baidu.tieba.v.history_pic);
        com.baidu.tbadk.core.util.aw.h(this.Hk, com.baidu.tieba.u.selector_history_multi_single_bg);
        com.baidu.tbadk.core.util.aw.b(this.aQH, com.baidu.tieba.s.official_time_text, 1);
        com.baidu.tbadk.core.util.aw.b(this.aQG, com.baidu.tieba.s.official_list_item_content, 1);
    }

    public void setTime(String str) {
        this.aQH.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.aQG;
    }

    public ChatImageWithTailView getImageView() {
        return this.aQI;
    }

    public void J(View view) {
        this.Hk.setBackgroundDrawable(null);
        this.Hk.removeAllViews();
        this.Hk.addView(view);
    }
}
