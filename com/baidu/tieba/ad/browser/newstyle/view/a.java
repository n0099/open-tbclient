package com.baidu.tieba.ad.browser.newstyle.view;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.c;
import com.baidu.tieba.ad.download.state.DownloadStatus;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ad.download.mvp.a<ApkDownloadBannerView, AdDownloadData> {
    private static final String TAG = a.class.getSimpleName();

    public a(@NonNull ApkDownloadBannerView apkDownloadBannerView, @NonNull AdDownloadData adDownloadData) {
        super(apkDownloadBannerView, adDownloadData);
        aDC().getActionBar().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ad.browser.newstyle.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aDw();
            }
        });
    }

    @Override // com.baidu.tieba.ad.download.mvp.a
    public void a(@NonNull DownloadStatus downloadStatus) {
        super.a(downloadStatus);
        ApkDownloadBannerView aDC = aDC();
        if (downloadStatus != DownloadStatus.STATUS_NONE && !aDC.isShowing()) {
            aDC.setVisibility(0);
        }
        AdDownloadData aDD = aDD();
        if (aDD != null) {
            aDD.extra().setStatus(downloadStatus);
        }
    }

    @Override // com.baidu.tieba.ad.download.mvp.a
    public void cw(int i) {
        super.cw(i);
        AdDownloadData aDD = aDD();
        if (aDD != null) {
            aDD.extra().setPercent(i);
            if (aDD.extra().getStatus() != DownloadStatus.STATUS_NONE && !aDC().isShowing()) {
                aDC().setVisibility(0);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ad.download.mvp.a
    public void a(@NonNull AdDownloadData adDownloadData) {
        super.a((a) adDownloadData);
        ApkDownloadBannerView aDC = aDC();
        if (adDownloadData.extra().getStatus() != DownloadStatus.STATUS_NONE && !aDC.isShowing()) {
            aDC.setVisibility(0);
        }
        aDC.a(adDownloadData.extra().getStatus(), adDownloadData.extra().getPercent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDw() {
        AdDownloadData aDD = aDD();
        if (aDD != null) {
            DownloadStatus status = aDD.extra().getStatus();
            DownloadCacheKey sK = c.aDA().sK(aDD.adId());
            switch (status) {
                case STATUS_NONE:
                    if (sK != null) {
                        c.aDA().c(sK, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    c.aDA().sH(aDD.adId());
                    return;
                case STATUS_PAUSED:
                    c.aDA().sI(aDD.adId());
                    return;
                case STATUS_SUCCESS:
                    if (sK != null) {
                        c.aDA().a(aDC().getContext(), sK, aDD.extra().getDownloadFilePath());
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    c.aDA().ax(aDC().getContext(), aDD.pkgName());
                    return;
                default:
                    return;
            }
        }
    }
}
