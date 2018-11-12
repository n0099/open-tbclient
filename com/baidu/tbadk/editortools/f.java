package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class f {
    public static g a(Context context, k kVar, int i) {
        switch (i) {
            case 1:
                return new BLauncher(context, kVar.aVy, kVar.id);
            default:
                return new DLauncher(context, kVar.aVy, kVar.name, kVar.id);
        }
    }
}
