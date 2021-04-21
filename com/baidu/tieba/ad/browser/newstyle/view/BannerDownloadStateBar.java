package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BannerDownloadStateBar extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f14203e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14204f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f14205g;

    public BannerDownloadStateBar(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f14203e = LayoutInflater.from(getContext()).inflate(R.layout.ad_apk_download_action_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
        this.f14205g = (ImageView) this.f14203e.findViewById(R.id.apk_download_state_icon);
        this.f14204f = (TextView) this.f14203e.findViewById(R.id.apk_download_state_text);
        setState(0);
    }

    public void setState(int i) {
        if (i == 0) {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
            this.f14205g.setVisibility(8);
            this.f14205g.setImageDrawable(null);
            this.f14204f.setText(R.string.ad_button_download_now);
            this.f14204f.setTextColor(Color.parseColor("#333333"));
        } else if (i == 1) {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
            this.f14205g.setVisibility(0);
            this.f14205g.setImageResource(R.drawable.ad_banner_download_pause);
            this.f14204f.setText(R.string.ad_button_pause);
            this.f14204f.setTextColor(Color.parseColor("#333333"));
        } else if (i == 2) {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
            this.f14205g.setVisibility(0);
            this.f14205g.setImageResource(R.drawable.ad_banner_download_resume);
            this.f14204f.setText(R.string.ad_button_resume);
            this.f14204f.setTextColor(Color.parseColor("#333333"));
        } else if (i == 3) {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
            this.f14205g.setVisibility(8);
            this.f14205g.setImageDrawable(null);
            this.f14204f.setText(R.string.ad_button_install);
            this.f14204f.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (i != 4) {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
            this.f14205g.setVisibility(8);
            this.f14205g.setImageDrawable(null);
            this.f14204f.setText(R.string.ad_button_download_now);
            this.f14204f.setTextColor(Color.parseColor("#333333"));
        } else {
            setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
            this.f14205g.setVisibility(8);
            this.f14205g.setImageDrawable(null);
            this.f14204f.setText(R.string.ad_button_open);
            this.f14204f.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
