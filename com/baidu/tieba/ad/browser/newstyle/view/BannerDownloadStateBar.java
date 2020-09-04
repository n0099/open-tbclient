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
/* loaded from: classes15.dex */
public class BannerDownloadStateBar extends LinearLayout {
    private TextView foS;
    private ImageView foT;
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
        this.foT = (ImageView) this.mRootView.findViewById(R.id.apk_download_state_icon);
        this.foS = (TextView) this.mRootView.findViewById(R.id.apk_download_state_text);
        setState(0);
    }

    public void setState(int i) {
        switch (i) {
            case 0:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.foT.setVisibility(8);
                this.foT.setImageDrawable(null);
                this.foS.setText(R.string.ad_button_download_now);
                this.foS.setTextColor(Color.parseColor("#333333"));
                return;
            case 1:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.foT.setVisibility(0);
                this.foT.setImageResource(R.drawable.ad_banner_download_pause);
                this.foS.setText(R.string.ad_button_pause);
                this.foS.setTextColor(Color.parseColor("#333333"));
                return;
            case 2:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.foT.setVisibility(0);
                this.foT.setImageResource(R.drawable.ad_banner_download_resume);
                this.foS.setText(R.string.ad_button_resume);
                this.foS.setTextColor(Color.parseColor("#333333"));
                return;
            case 3:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.foT.setVisibility(8);
                this.foT.setImageDrawable(null);
                this.foS.setText(R.string.ad_button_install);
                this.foS.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            case 4:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.foT.setVisibility(8);
                this.foT.setImageDrawable(null);
                this.foS.setText(R.string.ad_button_open);
                this.foS.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            default:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.foT.setVisibility(8);
                this.foT.setImageDrawable(null);
                this.foS.setText(R.string.ad_button_download_now);
                this.foS.setTextColor(Color.parseColor("#333333"));
                return;
        }
    }
}
