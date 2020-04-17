package com.baidu.tieba.ala.g;
/* loaded from: classes3.dex */
public class a {
    public static String dN(long j) {
        int i;
        int i2;
        int i3;
        int i4 = (int) (j / 1000);
        if (3600 <= i4) {
            int i5 = i4 / 3600;
            i4 -= i5 * 3600;
            i = i5;
        } else {
            i = 0;
        }
        if (60 <= i4) {
            int i6 = i4 / 60;
            i2 = i4 - (i6 * 60);
            i3 = i6;
        } else {
            i2 = i4;
            i3 = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (i < 10) {
            sb.append("0").append(i).append(":");
        } else {
            sb.append(i).append(":");
        }
        if (i3 < 10) {
            sb.append("0").append(i3).append(":");
        } else {
            sb.append(i3).append(":");
        }
        if (i2 < 10) {
            sb.append("0").append(i2);
        } else {
            sb.append(i2);
        }
        return sb.toString();
    }
}
