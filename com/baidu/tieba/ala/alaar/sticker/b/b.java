package com.baidu.tieba.ala.alaar.sticker.b;

import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class b {
    private static final DecimalFormat DF = new DecimalFormat("0.00");

    public static String getDownloadPerSize(long j, long j2) {
        return DF.format(((float) j) / 1048576.0f) + "M/" + DF.format(((float) j2) / 1048576.0f) + "M";
    }
}
