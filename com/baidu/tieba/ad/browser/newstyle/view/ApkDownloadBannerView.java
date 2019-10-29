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
    private int dhV;
    private BannerDownloadProgressBar dhW;
    private BannerDownloadStateBar dhX;
    private BannerDownloadStateBar dhY;
    private int dhZ;
    private View mRootView;

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhV = 100;
        this.dhZ = 1;
        initView(context);
        setDownloadStateBarPosition(1);
    }

    private void initView(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int dip2px = l.dip2px(getContext(), 22.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.dhW = (BannerDownloadProgressBar) this.mRootView.findViewById(R.id.apk_download_progress);
        this.dhX = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_left);
        this.dhY = (BannerDownloadStateBar) this.mRootView.findViewById(R.id.apk_download_state_right);
        this.dhW.setTextColor(Color.parseColor("#999999"));
    }

    public void setDownloadStateBarPosition(int i) {
        this.dhZ = i;
        switch (this.dhZ) {
            case 0:
                this.dhX.setVisibility(0);
                this.dhY.setVisibility(8);
                return;
            case 1:
                this.dhX.setVisibility(8);
                this.dhY.setVisibility(0);
                return;
            default:
                this.dhX.setVisibility(0);
                this.dhY.setVisibility(8);
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ad.download.mvp.b
    public BannerDownloadStateBar getActionBar() {
        return this.dhX.getVisibility() == 0 ? this.dhX : this.dhY;
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void bo(View view) {
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(b(downloadStatus));
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void cr(int i) {
        this.dhW.setProgress(i);
    }

    @Override // com.baidu.tieba.ad.download.mvp.b
    public void a(DownloadStatus downloadStatus, int i) {
        switch (downloadStatus) {
            case STATUS_NONE:
                cr(0);
                this.dhW.setText("");
                break;
            case STATUS_SUCCESS:
            case STATUS_INSTALL_SUCCESS:
                cr(this.dhV);
                this.dhW.setText("");
                break;
            case STATUS_DOWNLOADING:
            case STATUS_PAUSED:
                cr(i);
                break;
            default:
                cr(0);
                this.dhW.setText("");
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
