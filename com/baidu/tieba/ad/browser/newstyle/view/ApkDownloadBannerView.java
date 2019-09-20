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
/* loaded from: classes3.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {
    private int cYC;
    private BannerDownloadProgressBar cYD;
    private BannerDownloadStateBar cYE;
    private BannerDownloadStateBar cYF;
    private int cYG;
    private View mRootView;

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cYC = 100;
        this.cYG = 1;
        initView(context);
        setDownloadStateBarPosition(1);
    }

    private void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int dip2px = l.dip2px(getContext(), 22.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.cYD = (BannerDownloadProgressBar) this.mRootView.findViewById(R.id.apk_download_progress);
        this.cYE = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_left);
        this.cYF = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_right);
        this.cYD.setTextColor(Color.parseColor("#999999"));
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void setDownloadStateBarPosition(int i) {
        this.cYG = i;
        switch (this.cYG) {
            case 0:
                this.cYE.setVisibility(0);
                this.cYF.setVisibility(8);
                return;
            case 1:
                this.cYE.setVisibility(8);
                this.cYF.setVisibility(0);
                return;
            default:
                this.cYE.setVisibility(0);
                this.cYF.setVisibility(8);
                return;
        }
    }

    public BannerDownloadStateBar getActionBar() {
        return this.cYE.getVisibility() == 0 ? this.cYE : this.cYF;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void b(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(c(downloadStatus));
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cw(int i) {
        this.cYD.setProgress(i);
    }

    public void a(DownloadStatus downloadStatus, int i) {
        switch (downloadStatus) {
            case STATUS_NONE:
                cw(0);
                this.cYD.setText("");
                break;
            case STATUS_SUCCESS:
            case STATUS_INSTALL_SUCCESS:
                cw(this.cYC);
                this.cYD.setText("");
                break;
            case STATUS_DOWNLOADING:
            case STATUS_PAUSED:
                cw(i);
                break;
            default:
                cw(0);
                this.cYD.setText("");
                break;
        }
        b(downloadStatus);
    }

    private int c(DownloadStatus downloadStatus) {
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
