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
/* loaded from: classes15.dex */
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
            DownloadCacheKey Bb = d.bsi().Bb(adDownloadData.adId());
            switch (currentState) {
                case STATUS_NONE:
                    if (Bb != null && bse()) {
                        d.bsi().c(Bb, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    d.bsi().AY(adDownloadData.adId());
                    return;
                case STATUS_PAUSED:
                    if (bse()) {
                        d.bsi().AZ(adDownloadData.adId());
                        return;
                    }
                    return;
                case STATUS_SUCCESS:
                    if (Bb != null && bse()) {
                        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                            d.bsi().a(bsk().getRealView().getContext(), Bb, adDownloadData.extra().getDownloadFilePath());
                            return;
                        }
                        adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                        a(adDownloadData);
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    d.bsi().av(bsk().getRealView().getContext(), adDownloadData.pkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private boolean bse() {
        if (bsk() == null || !(bsk().getRealView().getContext() instanceof Activity)) {
            return true;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission((Activity) bsk().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return !this.mPermissionJudgePolicy.startRequestPermission((Activity) bsk().getRealView().getContext());
    }
}
