package com.baidu.tieba.ad.browser.newstyle.view;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.d;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ad.download.mvp.a<b, AdDownloadData> {
    public a(@NonNull b bVar, @NonNull AdDownloadData adDownloadData, String str) {
        super(bVar, adDownloadData, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ad.download.mvp.a
    public void a(AdDownloadData adDownloadData) {
        if (adDownloadData != null) {
            DownloadStatus currentState = adDownloadData.getCurrentState();
            DownloadCacheKey rt = d.aDI().rt(adDownloadData.adId());
            switch (currentState) {
                case STATUS_NONE:
                    if (rt != null) {
                        d.aDI().c(rt, null);
                        return;
                    }
                    return;
                case STATUS_DOWNLOADING:
                    d.aDI().rq(adDownloadData.adId());
                    return;
                case STATUS_PAUSED:
                    d.aDI().rr(adDownloadData.adId());
                    return;
                case STATUS_SUCCESS:
                    if (rt != null) {
                        String downloadFilePath = adDownloadData.extra().getDownloadFilePath();
                        if (!TextUtils.isEmpty(downloadFilePath) && new File(downloadFilePath).exists()) {
                            d.aDI().a(aDK().getRealView().getContext(), rt, adDownloadData.extra().getDownloadFilePath());
                            return;
                        }
                        adDownloadData.extra().setStatus(DownloadStatus.STATUS_NONE);
                        a(adDownloadData);
                        return;
                    }
                    return;
                case STATUS_INSTALL_SUCCESS:
                    d.aDI().au(aDK().getRealView().getContext(), adDownloadData.pkgName());
                    return;
                default:
                    return;
            }
        }
    }
}
