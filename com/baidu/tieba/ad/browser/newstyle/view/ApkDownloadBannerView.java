package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes8.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {
    private BannerDownloadProgressBar eOm;
    private BannerDownloadStateBar eOn;
    private BannerDownloadStateBar eOo;
    private int eOp;
    private int mMax;
    private View mRootView;

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMax = 100;
        this.eOp = 1;
        initView(context);
        setDownloadStateBarPosition(1);
    }

    private void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int dip2px = l.dip2px(getContext(), 22.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.eOm = (BannerDownloadProgressBar) this.mRootView.findViewById(R.id.apk_download_progress);
        this.eOn = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_left);
        this.eOo = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_right);
        this.eOm.setTextColor(Color.parseColor("#999999"));
    }

    public void setDownloadStateBarPosition(int i) {
        this.eOp = i;
        switch (this.eOp) {
            case 0:
                this.eOn.setVisibility(0);
                this.eOo.setVisibility(8);
                return;
            case 1:
                this.eOn.setVisibility(8);
                this.eOo.setVisibility(0);
                return;
            default:
                this.eOn.setVisibility(0);
                this.eOo.setVisibility(8);
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ad.download.mvp.b
    public BannerDownloadStateBar getActionBar() {
        return this.eOn.getVisibility() == 0 ? this.eOn : this.eOo;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void br(View view) {
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(b(downloadStatus));
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void dr(int i) {
        this.eOm.setProgress(i);
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        switch (downloadStatus) {
            case STATUS_NONE:
                dr(0);
                this.eOm.setText("");
                break;
            case STATUS_SUCCESS:
            case STATUS_INSTALL_SUCCESS:
                dr(this.mMax);
                this.eOm.setText("");
                break;
            case STATUS_DOWNLOADING:
            case STATUS_PAUSED:
                dr(i);
                break;
            default:
                dr(0);
                this.eOm.setText("");
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
