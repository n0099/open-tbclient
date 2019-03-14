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
    LinearLayout bRo;
    TbRichTextView gcW;
    TextView gcX;
    ChatImageWithTailView gcY;
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
        this.bRo = (LinearLayout) findViewById(d.g.history_container);
        this.gcX = (TextView) findViewById(d.g.history_send_time);
        this.gcW = (TbRichTextView) findViewById(d.g.history_txt);
        this.gcY = (ChatImageWithTailView) findViewById(d.g.history_pic);
        al.k(this.bRo, d.f.selector_history_multi_single_bg);
        al.d(this.gcX, d.C0277d.common_color_10067, 1);
        this.gcW.setTextColor(al.getColor(d.C0277d.cp_cont_c));
        this.gcY.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.gcX.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.gcW;
    }

    public ChatImageWithTailView getImageView() {
        return this.gcY;
    }

    public void bU(View view) {
        this.bRo.setBackgroundDrawable(null);
        this.bRo.removeAllViews();
        this.bRo.addView(view);
    }
}
