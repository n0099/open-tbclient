package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout awD;
    TbRichTextView eim;
    TextView ein;
    ChatImageWithTailView eio;
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
        LayoutInflater.from(this.mContext).inflate(d.i.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.awD = (LinearLayout) findViewById(d.g.history_container);
        this.ein = (TextView) findViewById(d.g.history_send_time);
        this.eim = (TbRichTextView) findViewById(d.g.history_txt);
        this.eio = (ChatImageWithTailView) findViewById(d.g.history_pic);
        am.i(this.awD, d.f.selector_history_multi_single_bg);
        am.c(this.ein, d.C0142d.common_color_10067, 1);
        this.eim.setTextColor(am.getColor(d.C0142d.cp_cont_c));
        this.eio.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.ein.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.eim;
    }

    public ChatImageWithTailView getImageView() {
        return this.eio;
    }

    public void aJ(View view) {
        this.awD.setBackgroundDrawable(null);
        this.awD.removeAllViews();
        this.awD.addView(view);
    }
}
