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
    public Context f17079e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f17080f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17081g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f17082h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f17083i;

    public HistoryItemView(Context context) {
        super(context);
        this.f17079e = context;
        b();
    }

    public void a(View view) {
        this.f17083i.setBackgroundDrawable(null);
        this.f17083i.removeAllViews();
        this.f17083i.addView(view);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17079e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.f17083i = (LinearLayout) findViewById(R.id.history_container);
        this.f17081g = (TextView) findViewById(R.id.history_send_time);
        this.f17080f = (TbRichTextView) findViewById(R.id.history_txt);
        this.f17082h = (ChatImageWithTailView) findViewById(R.id.history_pic);
        SkinManager.setBackgroundResource(this.f17083i, R.drawable.selector_history_multi_single_bg);
        SkinManager.setViewTextColor(this.f17081g, R.color.common_color_10067, 1);
        this.f17080f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.f17082h.setIsSupportNight(true);
    }

    public ChatImageWithTailView getImageView() {
        return this.f17082h;
    }

    public TbRichTextView getRichTextView() {
        return this.f17080f;
    }

    public void setTime(String str) {
        this.f17081g.setText(str);
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17079e = context;
        b();
    }
}
