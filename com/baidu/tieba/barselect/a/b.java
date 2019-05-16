package com.baidu.tieba.barselect.a;

import android.content.res.Resources;
/* loaded from: classes3.dex */
public class b {
    public static int dpToPx(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }
}
