package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout anM;
    TbRichTextView dSb;
    TextView dSc;
    ChatImageWithTailView dSd;
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
        this.anM = (LinearLayout) findViewById(d.g.history_container);
        this.dSc = (TextView) findViewById(d.g.history_send_time);
        this.dSb = (TbRichTextView) findViewById(d.g.history_txt);
        this.dSd = (ChatImageWithTailView) findViewById(d.g.history_pic);
        ak.i(this.anM, d.f.selector_history_multi_single_bg);
        ak.c(this.dSc, d.C0126d.common_color_10067, 1);
        this.dSb.setTextColor(ak.getColor(d.C0126d.cp_cont_c));
        this.dSd.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.dSc.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.dSb;
    }

    public ChatImageWithTailView getImageView() {
        return this.dSd;
    }

    public void aF(View view2) {
        this.anM.setBackgroundDrawable(null);
        this.anM.removeAllViews();
        this.anM.addView(view2);
    }
}
