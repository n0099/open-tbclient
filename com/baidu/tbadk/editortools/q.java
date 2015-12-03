package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class q {
    public static r a(Context context, y yVar, int i) {
        switch (i) {
            case 1:
                return new c(context, yVar.launcherIcon, yVar.id);
            default:
                return new e(context, yVar.launcherIcon, yVar.name, yVar.id);
        }
    }
}
