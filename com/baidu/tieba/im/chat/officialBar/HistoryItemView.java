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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes3.dex */
public class HistoryItemView extends LinearLayout {
    LinearLayout bZi;
    TbRichTextView gua;
    TextView gub;
    ChatImageWithTailView guc;
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
        this.bZi = (LinearLayout) findViewById(R.id.history_container);
        this.gub = (TextView) findViewById(R.id.history_send_time);
        this.gua = (TbRichTextView) findViewById(R.id.history_txt);
        this.guc = (ChatImageWithTailView) findViewById(R.id.history_pic);
        al.k(this.bZi, R.drawable.selector_history_multi_single_bg);
        al.f(this.gub, R.color.common_color_10067, 1);
        this.gua.setTextColor(al.getColor(R.color.cp_cont_c));
        this.guc.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.gub.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.gua;
    }

    public ChatImageWithTailView getImageView() {
        return this.guc;
    }

    public void cb(View view) {
        this.bZi.setBackgroundDrawable(null);
        this.bZi.removeAllViews();
        this.bZi.addView(view);
    }
}
