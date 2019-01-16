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
    LinearLayout aIS;
    TbRichTextView eMU;
    TextView eMV;
    ChatImageWithTailView eMW;
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
        this.aIS = (LinearLayout) findViewById(e.g.history_container);
        this.eMV = (TextView) findViewById(e.g.history_send_time);
        this.eMU = (TbRichTextView) findViewById(e.g.history_txt);
        this.eMW = (ChatImageWithTailView) findViewById(e.g.history_pic);
        al.i(this.aIS, e.f.selector_history_multi_single_bg);
        al.c(this.eMV, e.d.common_color_10067, 1);
        this.eMU.setTextColor(al.getColor(e.d.cp_cont_c));
        this.eMW.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.eMV.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.eMU;
    }

    public ChatImageWithTailView getImageView() {
        return this.eMW;
    }

    public void bf(View view) {
        this.aIS.setBackgroundDrawable(null);
        this.aIS.removeAllViews();
        this.aIS.addView(view);
    }
}
