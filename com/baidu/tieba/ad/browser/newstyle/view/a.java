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
            DownloadCacheKey Dv = d.bBf().Dv(adDownloadData.adId());
            switch (currentState) {
                case STATUS_NONE:
                    if (Dv != null && bBb()) {
                        d.bBf().c(Dv, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    d.bBf().Ds(adDownloadData.adId());
                    return;
                case STATUS_PAUSED:
                    if (bBb()) {
                        d.bBf().Dt(adDownloadData.adId());
                        return;
                    }
                    return;
                case STATUS_SUCCESS:
                    if (Dv != null && bBb()) {
                        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                            d.bBf().a(bBh().getRealView().getContext(), Dv, adDownloadData.extra().getDownloadFilePath());
                            return;
                        }
                        adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                        a(adDownloadData);
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    d.bBf().az(bBh().getRealView().getContext(), adDownloadData.pkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private boolean bBb() {
        if (bBh() == null || !(bBh().getRealView().getContext() instanceof Activity)) {
            return true;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission((Activity) bBh().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return !this.mPermissionJudgePolicy.startRequestPermission((Activity) bBh().getRealView().getContext());
    }
}
