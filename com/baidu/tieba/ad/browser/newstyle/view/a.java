package com.baidu.tieba.ad.browser.newstyle.view;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.t;
import java.io.File;
/* loaded from: classes.dex */
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
            DownloadCacheKey EQ = d.bLC().EQ(adDownloadData.adId());
            switch (currentState) {
                case STATUS_NONE:
                    if (EQ != null && bLy()) {
                        d.bLC().c(EQ, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    d.bLC().EN(adDownloadData.adId());
                    return;
                case STATUS_PAUSED:
                    if (bLy()) {
                        d.bLC().EO(adDownloadData.adId());
                        return;
                    }
                    return;
                case STATUS_SUCCESS:
                    if (EQ != null && bLy()) {
                        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                        boolean z = false;
                        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                            z = d.bLC().a(bLE().getRealView().getContext(), EQ, adDownloadData.extra().getDownloadFilePath());
                        }
                        if (TextUtils.isEmpty(downloadFilePath) || !new File(downloadFilePath).exists() || !z) {
                            adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                            a(adDownloadData);
                            return;
                        }
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    d.bLC().aL(bLE().getRealView().getContext(), adDownloadData.pkgName());
                    return;
                default:
                    return;
            }
        }
    }

    private boolean bLy() {
        if (bLE() == null || !(bLE().getRealView().getContext() instanceof Activity) || com.baidu.tieba.a.bJk().bJs()) {
            return true;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission((Activity) bLE().getRealView().getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return !this.mPermissionJudgePolicy.startRequestPermission((Activity) bLE().getRealView().getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.download.mvp.a
    public void b(@NonNull AdDownloadData adDownloadData) {
        if (t.RA(adDownloadData.getPkgName())) {
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            return;
        }
        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
        if (TextUtils.isEmpty(downloadFilePath) && !TextUtils.isEmpty(adDownloadData.adId())) {
            downloadFilePath = com.baidu.tieba.recapp.b.Rr(adDownloadData.adId());
        }
        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
            adDownloadData.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
        }
    }
}
