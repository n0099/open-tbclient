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
    public Context f17161e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f17162f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17163g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f17164h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f17165i;

    public HistoryItemView(Context context) {
        super(context);
        this.f17161e = context;
        b();
    }

    public void a(View view) {
        this.f17165i.setBackgroundDrawable(null);
        this.f17165i.removeAllViews();
        this.f17165i.addView(view);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17161e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.f17165i = (LinearLayout) findViewById(R.id.history_container);
        this.f17163g = (TextView) findViewById(R.id.history_send_time);
        this.f17162f = (TbRichTextView) findViewById(R.id.history_txt);
        this.f17164h = (ChatImageWithTailView) findViewById(R.id.history_pic);
        SkinManager.setBackgroundResource(this.f17165i, R.drawable.selector_history_multi_single_bg);
        SkinManager.setViewTextColor(this.f17163g, R.color.common_color_10067, 1);
        this.f17162f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.f17164h.setIsSupportNight(true);
    }

    public ChatImageWithTailView getImageView() {
        return this.f17164h;
    }

    public TbRichTextView getRichTextView() {
        return this.f17162f;
    }

    public void setTime(String str) {
        this.f17163g.setText(str);
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17161e = context;
        b();
    }
}
