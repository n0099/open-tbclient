package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout aIq;
    TbRichTextView eMi;
    TextView eMj;
    ChatImageWithTailView eMk;
    Context mContext;

    public HistoryItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(this.mContext).inflate(e.h.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.aIq = (LinearLayout) findViewById(e.g.history_container);
        this.eMj = (TextView) findViewById(e.g.history_send_time);
        this.eMi = (TbRichTextView) findViewById(e.g.history_txt);
        this.eMk = (ChatImageWithTailView) findViewById(e.g.history_pic);
        al.i(this.aIq, e.f.selector_history_multi_single_bg);
        al.c(this.eMj, e.d.common_color_10067, 1);
        this.eMi.setTextColor(al.getColor(e.d.cp_cont_c));
        this.eMk.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.eMj.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.eMi;
    }

    public ChatImageWithTailView getImageView() {
        return this.eMk;
    }

    public void bf(View view) {
        this.aIq.setBackgroundDrawable(null);
        this.aIq.removeAllViews();
        this.aIq.addView(view);
    }
}
