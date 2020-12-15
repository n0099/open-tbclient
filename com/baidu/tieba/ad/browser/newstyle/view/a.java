package com.baidu.tieba.ad.browser.newstyle.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.File;
/* loaded from: classes21.dex */
public class a extends com.baidu.tieba.ad.download.mvp.a<b, AdDownloadData> {
    private PermissionJudgePolicy mPermissionJudgePolicy;

    public a(@NonNull b bVar, @NonNull AdDownloadData adDownloadData, String str) {
        super(bVar, adDownloadData, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.download.mvp.a
    public void a(AdDownloadData adDownloadData) {
        if (adDownloadData != null) {
            DownloadStatus currentState = adDownloadData.getCurrentState();
            DownloadCacheKey FA = d.bMy().FA(adDownloadData.adId());
            switch (currentState) {
                case STATUS_NONE:
                    if (FA != null && bMu()) {
                        d.bMy().c(FA, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    d.bMy().Fx(adDownloadData.adId());
                    return;
                case STATUS_PAUSED:
                    if (bMu()) {
                        d.bMy().Fy(adDownloadData.adId());
                        return;
                    }
                    return;
                case STATUS_SUCCESS:
                    if (FA != null && bMu()) {
                        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                            d.bMy().a(bMA().getRealView().getContext(), FA, adDownloadData.extra().getDownloadFilePath());
                            return;
                        }
                        adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                        a(adDownloadData);
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    d.bMy().aG(bMA().getRealView().getContext(), adDownloadData.pkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private boolean bMu() {
        if (bMA() == null || !(bMA().getRealView().getContext() instanceof Activity)) {
            return true;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission((Activity) bMA().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return !this.mPermissionJudgePolicy.startRequestPermission((Activity) bMA().getRealView().getContext());
    }
}
