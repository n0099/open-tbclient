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
    LinearLayout cbk;
    TbRichTextView gCW;
    TextView gCX;
    ChatImageWithTailView gCY;
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
        this.cbk = (LinearLayout) findViewById(R.id.history_container);
        this.gCX = (TextView) findViewById(R.id.history_send_time);
        this.gCW = (TbRichTextView) findViewById(R.id.history_txt);
        this.gCY = (ChatImageWithTailView) findViewById(R.id.history_pic);
        am.k(this.cbk, R.drawable.selector_history_multi_single_bg);
        am.f(this.gCX, R.color.common_color_10067, 1);
        this.gCW.setTextColor(am.getColor(R.color.cp_cont_c));
        this.gCY.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.gCX.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.gCW;
    }

    public ChatImageWithTailView getImageView() {
        return this.gCY;
    }

    public void cf(View view) {
        this.cbk.setBackgroundDrawable(null);
        this.cbk.removeAllViews();
        this.cbk.addView(view);
    }
}
