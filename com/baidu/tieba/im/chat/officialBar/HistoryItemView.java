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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout cal;
    TbRichTextView gAn;
    TextView gAo;
    ChatImageWithTailView gAp;
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
        LayoutInflater.from(this.mContext).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.cal = (LinearLayout) findViewById(R.id.history_container);
        this.gAo = (TextView) findViewById(R.id.history_send_time);
        this.gAn = (TbRichTextView) findViewById(R.id.history_txt);
        this.gAp = (ChatImageWithTailView) findViewById(R.id.history_pic);
        am.k(this.cal, R.drawable.selector_history_multi_single_bg);
        am.f(this.gAo, R.color.common_color_10067, 1);
        this.gAn.setTextColor(am.getColor(R.color.cp_cont_c));
        this.gAp.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.gAo.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.gAn;
    }

    public ChatImageWithTailView getImageView() {
        return this.gAp;
    }

    public void ce(View view) {
        this.cal.setBackgroundDrawable(null);
        this.cal.removeAllViews();
        this.cal.addView(view);
    }
}
