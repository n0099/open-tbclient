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
    public Context f17461e;

    /* renamed from: f  reason: collision with root package name */
    public TbRichTextView f17462f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17463g;

    /* renamed from: h  reason: collision with root package name */
    public ChatImageWithTailView f17464h;
    public LinearLayout i;

    public HistoryItemView(Context context) {
        super(context);
        this.f17461e = context;
        b();
    }

    public void a(View view) {
        this.i.setBackgroundDrawable(null);
        this.i.removeAllViews();
        this.i.addView(view);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17461e).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.i = (LinearLayout) findViewById(R.id.history_container);
        this.f17463g = (TextView) findViewById(R.id.history_send_time);
        this.f17462f = (TbRichTextView) findViewById(R.id.history_txt);
        this.f17464h = (ChatImageWithTailView) findViewById(R.id.history_pic);
        SkinManager.setBackgroundResource(this.i, R.drawable.selector_history_multi_single_bg);
        SkinManager.setViewTextColor(this.f17463g, R.color.common_color_10067, 1);
        this.f17462f.setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.f17464h.setIsSupportNight(true);
    }

    public ChatImageWithTailView getImageView() {
        return this.f17464h;
    }

    public TbRichTextView getRichTextView() {
        return this.f17462f;
    }

    public void setTime(String str) {
        this.f17463g.setText(str);
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17461e = context;
        b();
    }
}
