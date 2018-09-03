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
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout awg;
    TbRichTextView elY;
    TextView elZ;
    ChatImageWithTailView ema;
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
        LayoutInflater.from(this.mContext).inflate(f.h.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.awg = (LinearLayout) findViewById(f.g.history_container);
        this.elZ = (TextView) findViewById(f.g.history_send_time);
        this.elY = (TbRichTextView) findViewById(f.g.history_txt);
        this.ema = (ChatImageWithTailView) findViewById(f.g.history_pic);
        am.i(this.awg, f.C0146f.selector_history_multi_single_bg);
        am.c(this.elZ, f.d.common_color_10067, 1);
        this.elY.setTextColor(am.getColor(f.d.cp_cont_c));
        this.ema.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.elZ.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.elY;
    }

    public ChatImageWithTailView getImageView() {
        return this.ema;
    }

    public void aM(View view) {
        this.awg.setBackgroundDrawable(null);
        this.awg.removeAllViews();
        this.awg.addView(view);
    }
}
