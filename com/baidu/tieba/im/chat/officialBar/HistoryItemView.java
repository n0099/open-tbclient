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
    LinearLayout avU;
    TbRichTextView ees;
    TextView eet;
    ChatImageWithTailView eeu;
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
        this.avU = (LinearLayout) findViewById(d.g.history_container);
        this.eet = (TextView) findViewById(d.g.history_send_time);
        this.ees = (TbRichTextView) findViewById(d.g.history_txt);
        this.eeu = (ChatImageWithTailView) findViewById(d.g.history_pic);
        al.i(this.avU, d.f.selector_history_multi_single_bg);
        al.c(this.eet, d.C0141d.common_color_10067, 1);
        this.ees.setTextColor(al.getColor(d.C0141d.cp_cont_c));
        this.eeu.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.eet.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.ees;
    }

    public ChatImageWithTailView getImageView() {
        return this.eeu;
    }

    public void aI(View view) {
        this.avU.setBackgroundDrawable(null);
        this.avU.removeAllViews();
        this.avU.addView(view);
    }
}
