package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes26.dex */
public class HistoryItemView extends LinearLayout {
    TbRichTextView klv;
    TextView klw;
    ChatImageWithTailView klx;
    LinearLayout mContainer;
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
        this.mContainer = (LinearLayout) findViewById(R.id.history_container);
        this.klw = (TextView) findViewById(R.id.history_send_time);
        this.klv = (TbRichTextView) findViewById(R.id.history_txt);
        this.klx = (ChatImageWithTailView) findViewById(R.id.history_pic);
        ap.setBackgroundResource(this.mContainer, R.drawable.selector_history_multi_single_bg);
        ap.setViewTextColor(this.klw, R.color.common_color_10067, 1);
        this.klv.setTextColor(ap.getColor(R.color.CAM_X0108));
        this.klx.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.klw.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.klv;
    }

    public ChatImageWithTailView getImageView() {
        return this.klx;
    }

    public void dd(View view) {
        this.mContainer.setBackgroundDrawable(null);
        this.mContainer.removeAllViews();
        this.mContainer.addView(view);
    }
}
