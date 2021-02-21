package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {
    private int dWi;
    private BannerDownloadProgressBar ghg;
    private BannerDownloadStateBar ghh;
    private BannerDownloadStateBar ghi;
    private int ghj;
    private View mRootView;

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWi = 100;
        this.ghj = 1;
        initView(context);
        setDownloadStateBarPosition(1);
    }

    private void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int dip2px = l.dip2px(getContext(), 22.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.ghg = (BannerDownloadProgressBar) this.mRootView.findViewById(R.id.apk_download_progress);
        this.ghh = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_left);
        this.ghi = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_right);
        this.ghg.setTextColor(Color.parseColor("#999999"));
    }

    public void setDownloadStateBarPosition(int i) {
        this.ghj = i;
        switch (this.ghj) {
            case 0:
                this.ghh.setVisibility(0);
                this.ghi.setVisibility(8);
                return;
            case 1:
                this.ghh.setVisibility(8);
                this.ghi.setVisibility(0);
                return;
            default:
                this.ghh.setVisibility(0);
                this.ghi.setVisibility(8);
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ad.download.mvp.b
    public BannerDownloadStateBar getActionBar() {
        return this.ghh.getVisibility() == 0 ? this.ghh : this.ghi;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public boolean ce(View view) {
        return false;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(b(downloadStatus));
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void fn(int i) {
        this.ghg.setProgress(i);
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        switch (downloadStatus) {
            case STATUS_NONE:
                fn(0);
                this.ghg.setText("");
                break;
            case STATUS_SUCCESS:
            case STATUS_INSTALL_SUCCESS:
                fn(this.dWi);
                this.ghg.setText("");
                break;
            case STATUS_DOWNLOADING:
            case STATUS_PAUSED:
                fn(i);
                break;
            default:
                fn(0);
                this.ghg.setText("");
                break;
        }
        a(downloadStatus);
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    @NonNull
    public View getRealView() {
        return this;
    }

    private int b(DownloadStatus downloadStatus) {
        switch (downloadStatus) {
            case STATUS_NONE:
            default:
                return 0;
            case STATUS_SUCCESS:
                return 3;
            case STATUS_INSTALL_SUCCESS:
                return 4;
            case STATUS_DOWNLOADING:
                return 1;
            case STATUS_PAUSED:
                return 2;
        }
    }
}
