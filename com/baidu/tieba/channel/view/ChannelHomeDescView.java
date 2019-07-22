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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class ChannelHomeDescView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private TextView eJC;
    private b eJD;
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
        this.eJD = bVar;
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_desc_view, (ViewGroup) this, true);
        this.eJC = (TextView) findViewById(R.id.channel_home_header_desc_text);
    }

    public void d(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            String description = channelInfo.getDescription();
            if (TextUtils.isEmpty(description)) {
                description = this.mContext.getResources().getString(R.string.channel_home_default_desc);
            }
            SpannableString spannableString = new SpannableString(description + "^");
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds16);
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_channel_edit);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tieba.channel.c.a(drawable, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2), spannableString.length() - 1, spannableString.length(), 17);
            this.eJC.setText(spannableString);
            this.eJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeDescView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ChannelHomeDescView.this.eJD != null) {
                        ChannelHomeDescView.this.eJD.a(11, view, null, -1);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baB() != null) {
            ChannelInfo baB = dVar.baB();
            if (this.mIsHost) {
                d(baB);
                return;
            }
            if (TextUtils.isEmpty(baB.getDescription())) {
                this.eJC.setText(this.mContext.getResources().getString(R.string.channel_home_default_desc_guest));
            } else {
                this.eJC.setText(baB.getDescription());
            }
            this.eJC.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
    }
}
