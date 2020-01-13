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
/* loaded from: classes6.dex */
public class BannerDownloadStateBar extends LinearLayout {
    private TextView dVo;
    private ImageView dVp;
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
        this.dVp = (ImageView) this.mRootView.findViewById(R.id.apk_download_state_icon);
        this.dVo = (TextView) this.mRootView.findViewById(R.id.apk_download_state_text);
        setState(0);
    }

    public void setState(int i) {
        switch (i) {
            case 0:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.dVp.setVisibility(8);
                this.dVp.setImageDrawable(null);
                this.dVo.setText(R.string.ad_button_download_now);
                this.dVo.setTextColor(Color.parseColor("#333333"));
                return;
            case 1:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.dVp.setVisibility(0);
                this.dVp.setImageResource(R.drawable.ad_banner_download_pause);
                this.dVo.setText(R.string.ad_button_pause);
                this.dVo.setTextColor(Color.parseColor("#333333"));
                return;
            case 2:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.dVp.setVisibility(0);
                this.dVp.setImageResource(R.drawable.ad_banner_download_resume);
                this.dVo.setText(R.string.ad_button_resume);
                this.dVo.setTextColor(Color.parseColor("#333333"));
                return;
            case 3:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.dVp.setVisibility(8);
                this.dVp.setImageDrawable(null);
                this.dVo.setText(R.string.ad_button_install);
                this.dVo.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            case 4:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_open);
                this.dVp.setVisibility(8);
                this.dVp.setImageDrawable(null);
                this.dVo.setText(R.string.ad_button_open);
                this.dVo.setTextColor(Color.parseColor("#FFFFFF"));
                return;
            default:
                setBackgroundResource(R.drawable.ad_banner_download_button_bg_normal);
                this.dVp.setVisibility(8);
                this.dVp.setImageDrawable(null);
                this.dVo.setText(R.string.ad_button_download_now);
                this.dVo.setTextColor(Color.parseColor("#333333"));
                return;
        }
    }
}
