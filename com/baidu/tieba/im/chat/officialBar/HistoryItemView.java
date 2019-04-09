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
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout bRr;
    TbRichTextView gcK;
    TextView gcL;
    ChatImageWithTailView gcM;
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
        LayoutInflater.from(this.mContext).inflate(d.h.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.bRr = (LinearLayout) findViewById(d.g.history_container);
        this.gcL = (TextView) findViewById(d.g.history_send_time);
        this.gcK = (TbRichTextView) findViewById(d.g.history_txt);
        this.gcM = (ChatImageWithTailView) findViewById(d.g.history_pic);
        al.k(this.bRr, d.f.selector_history_multi_single_bg);
        al.d(this.gcL, d.C0277d.common_color_10067, 1);
        this.gcK.setTextColor(al.getColor(d.C0277d.cp_cont_c));
        this.gcM.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.gcL.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.gcK;
    }

    public ChatImageWithTailView getImageView() {
        return this.gcM;
    }

    public void bU(View view) {
        this.bRr.setBackgroundDrawable(null);
        this.bRr.removeAllViews();
        this.bRr.addView(view);
    }
}
