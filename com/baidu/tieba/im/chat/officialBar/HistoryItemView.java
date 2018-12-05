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
    LinearLayout aIp;
    TbRichTextView eJr;
    TextView eJs;
    ChatImageWithTailView eJt;
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
        this.aIp = (LinearLayout) findViewById(e.g.history_container);
        this.eJs = (TextView) findViewById(e.g.history_send_time);
        this.eJr = (TbRichTextView) findViewById(e.g.history_txt);
        this.eJt = (ChatImageWithTailView) findViewById(e.g.history_pic);
        al.i(this.aIp, e.f.selector_history_multi_single_bg);
        al.c(this.eJs, e.d.common_color_10067, 1);
        this.eJr.setTextColor(al.getColor(e.d.cp_cont_c));
        this.eJt.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.eJs.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.eJr;
    }

    public ChatImageWithTailView getImageView() {
        return this.eJt;
    }

    public void bc(View view) {
        this.aIp.setBackgroundDrawable(null);
        this.aIp.removeAllViews();
        this.aIp.addView(view);
    }
}
