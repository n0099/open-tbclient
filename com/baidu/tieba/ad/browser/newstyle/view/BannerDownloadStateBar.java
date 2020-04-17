package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class BannerDownloadStateBar extends LinearLayout {
    private TextView ezT;
    private ImageView ezU;
    private View mRootView;

    public BannerDownloadStateBar(Context context) {
        this(context, null);
    }

    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerDownloadStateBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.ad_apk_download_action_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
        this.ezU = (ImageView) this.mRootView.findViewById(R.id.apk_download_state_icon);
        this.ezT = (TextView) this.mRootView.findViewById(R.id.apk_download_state_text);
        setState(0);
    }

    public void setState(int i) {
        switch (i) {
            case 0:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.ezU.setVisibility(8);
                this.ezU.setImageDrawable(null);
                this.ezT.setText(R.string.ad_button_download_now);
                this.ezT.setTextColor(Color.parseColor("#333333"));
                return;
            case 1:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.ezU.setVisibility(0);
                this.ezU.setImageResource(R.drawable.ad_banner_download_pause);
                this.ezT.setText(R.string.ad_button_pause);
                this.ezT.setTextColor(Color.parseColor("#333333"));
                return;
            case 2:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.ezU.setVisibility(0);
                this.ezU.setImageResource(R.drawable.ad_banner_download_resume);
                this.ezT.setText(R.string.ad_button_resume);
                this.ezT.setTextColor(Color.parseColor("#333333"));
                return;
            case 3:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.ezU.setVisibility(8);
                this.ezU.setImageDrawable(null);
                this.ezT.setText(R.string.ad_button_install);
                this.ezT.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            case 4:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.ezU.setVisibility(8);
                this.ezU.setImageDrawable(null);
                this.ezT.setText(R.string.ad_button_open);
                this.ezT.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            default:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.ezU.setVisibility(8);
                this.ezU.setImageDrawable(null);
                this.ezT.setText(R.string.ad_button_download_now);
                this.ezT.setTextColor(Color.parseColor("#333333"));
                return;
        }
    }
}
