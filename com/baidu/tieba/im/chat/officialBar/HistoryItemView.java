package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes4.dex */
public class HistoryItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17469e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f17470f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17471g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f17472h;
    public LinearLayout i;

    public HistoryItemView(Context context) {
        super(context);
        this.f17469e = context;
        b();
    }

    public void a(View view) {
        this.i.setBackgroundDrawable(null);
        this.i.removeAllViews();
        this.i.addView(view);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17469e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.i = (LinearLayout) findViewById(R.id.history_container);
        this.f17471g = (TextView) findViewById(R.id.history_send_time);
        this.f17470f = (TbRichTextView) findViewById(R.id.history_txt);
        this.f17472h = (ChatImageWithTailView) findViewById(R.id.history_pic);
        SkinManager.setBackgroundResource(this.i, R.drawable.selector_history_multi_single_bg);
        SkinManager.setViewTextColor(this.f17471g, R.color.common_color_10067, 1);
        this.f17470f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.f17472h.setIsSupportNight(true);
    }

    public ChatImageWithTailView getImageView() {
        return this.f17472h;
    }

    public TbRichTextView getRichTextView() {
        return this.f17470f;
    }

    public void setTime(String str) {
        this.f17471g.setText(str);
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17469e = context;
        b();
    }
}
