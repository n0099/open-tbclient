package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes2.dex */
public class g {
    public static h a(Context context, m mVar, int i) {
        switch (i) {
            case 1:
                return new BLauncher(context, mVar);
            default:
                return new DLauncher(context, mVar);
        }
    }
}
