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
    LinearLayout aEP;
    TbRichTextView eCC;
    TextView eCD;
    ChatImageWithTailView eCE;
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
        this.aEP = (LinearLayout) findViewById(e.g.history_container);
        this.eCD = (TextView) findViewById(e.g.history_send_time);
        this.eCC = (TbRichTextView) findViewById(e.g.history_txt);
        this.eCE = (ChatImageWithTailView) findViewById(e.g.history_pic);
        al.i(this.aEP, e.f.selector_history_multi_single_bg);
        al.c(this.eCD, e.d.common_color_10067, 1);
        this.eCC.setTextColor(al.getColor(e.d.cp_cont_c));
        this.eCE.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.eCD.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.eCC;
    }

    public ChatImageWithTailView getImageView() {
        return this.eCE;
    }

    public void bc(View view) {
        this.aEP.setBackgroundDrawable(null);
        this.aEP.removeAllViews();
        this.aEP.addView(view);
    }
}
