package com.baidu.tieba.advert.sdk.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AdSplashStyle {

    /* loaded from: classes4.dex */
    public enum SplashElement {
        LOGO,
        SKIP,
        LABEL,
        VOICE,
        WIFI_TIP
    }

    public AdSplashStyle() {
        TbadkCoreApplication.getInst().getString(R.string.advert_label);
    }
}
