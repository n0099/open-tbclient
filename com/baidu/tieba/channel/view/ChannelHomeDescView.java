package com.baidu.tieba.channel.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChannelHomeDescView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private TextView cVb;
    private b cVc;
    private Context mContext;
    private boolean mIsHost;

    public ChannelHomeDescView(Context context) {
        super(context);
    }

    public ChannelHomeDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChannelHomeDescView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.channel.view.e
    public void a(boolean z, b bVar) {
        this.mIsHost = z;
        this.cVc = bVar;
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_desc_view, (ViewGroup) this, true);
        this.cVb = (TextView) findViewById(e.g.channel_home_header_desc_text);
    }

    public void d(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            String description = channelInfo.getDescription();
            if (TextUtils.isEmpty(description)) {
                description = this.mContext.getResources().getString(e.j.channel_home_default_desc);
            }
            SpannableString spannableString = new SpannableString(description + "^");
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds24);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds16);
            Drawable drawable = this.mContext.getResources().getDrawable(e.f.icon_channel_edit);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tieba.channel.c.a(drawable, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2), spannableString.length() - 1, spannableString.length(), 17);
            this.cVb.setText(spannableString);
            this.cVb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeDescView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChannelHomeDescView.this.cVc != null) {
                        ChannelHomeDescView.this.cVc.a(11, view, null, -1);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void Z(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aoB() != null) {
            ChannelInfo aoB = dVar.aoB();
            if (this.mIsHost) {
                d(aoB);
                return;
            }
            if (TextUtils.isEmpty(aoB.getDescription())) {
                this.cVb.setText(this.mContext.getResources().getString(e.j.channel_home_default_desc_guest));
            } else {
                this.cVb.setText(aoB.getDescription());
            }
            this.cVb.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
    }
}
