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
    LinearLayout awj;
    TbRichTextView emc;
    TextView emd;
    ChatImageWithTailView eme;
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
        this.awj = (LinearLayout) findViewById(d.g.history_container);
        this.emd = (TextView) findViewById(d.g.history_send_time);
        this.emc = (TbRichTextView) findViewById(d.g.history_txt);
        this.eme = (ChatImageWithTailView) findViewById(d.g.history_pic);
        am.i(this.awj, d.f.selector_history_multi_single_bg);
        am.c(this.emd, d.C0140d.common_color_10067, 1);
        this.emc.setTextColor(am.getColor(d.C0140d.cp_cont_c));
        this.eme.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.emd.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.emc;
    }

    public ChatImageWithTailView getImageView() {
        return this.eme;
    }

    public void aM(View view) {
        this.awj.setBackgroundDrawable(null);
        this.awj.removeAllViews();
        this.awj.addView(view);
    }
}
