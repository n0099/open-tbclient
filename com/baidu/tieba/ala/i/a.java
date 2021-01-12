package com.baidu.tieba.ala.i;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes10.dex */
public class a {
    public static String fO(long j) {
        int i;
        int i2;
        int i3 = (int) (j / 1000);
        if (3600 <= i3) {
            int i4 = i3 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
            i3 -= i4 * SdkConfigData.DEFAULT_REQUEST_INTERVAL;
            i = i4;
        } else {
            i = 0;
        }
        if (60 <= i3) {
            i2 = i3 / 60;
            i3 -= i2 * 60;
        } else {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (i < 10) {
            sb.append("0").append(i).append(":");
        } else {
            sb.append(i).append(":");
        }
        if (i2 < 10) {
            sb.append("0").append(i2).append(":");
        } else {
            sb.append(i2).append(":");
        }
        if (i3 < 10) {
            sb.append("0").append(i3);
        } else {
            sb.append(i3);
        }
        return sb.toString();
    }
}
