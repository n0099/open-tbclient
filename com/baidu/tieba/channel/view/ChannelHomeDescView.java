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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ChannelHomeDescView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private TextView cFL;
    private b cFM;
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
        this.cFM = bVar;
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(f.h.channel_home_header_desc_view, (ViewGroup) this, true);
        this.cFL = (TextView) findViewById(f.g.channel_home_header_desc_text);
    }

    public void d(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            String description = channelInfo.getDescription();
            if (TextUtils.isEmpty(description)) {
                description = this.mContext.getResources().getString(f.j.channel_home_default_desc);
            }
            SpannableString spannableString = new SpannableString(description + "^");
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.ds24);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(f.e.ds16);
            Drawable drawable = this.mContext.getResources().getDrawable(f.C0146f.icon_channel_edit);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tieba.channel.c.a(drawable, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2), spannableString.length() - 1, spannableString.length(), 17);
            this.cFL.setText(spannableString);
            this.cFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeDescView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChannelHomeDescView.this.cFM != null) {
                        ChannelHomeDescView.this.cFM.a(11, view, null, -1);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajM() != null) {
            ChannelInfo ajM = dVar.ajM();
            if (this.mIsHost) {
                d(ajM);
                return;
            }
            if (TextUtils.isEmpty(ajM.getDescription())) {
                this.cFL.setText(this.mContext.getResources().getString(f.j.channel_home_default_desc_guest));
            } else {
                this.cFL.setText(ajM.getDescription());
            }
            this.cFL.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
    }
}
