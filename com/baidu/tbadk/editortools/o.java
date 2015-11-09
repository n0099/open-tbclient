package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class o {
    public static p a(Context context, w wVar, int i) {
        switch (i) {
            case 1:
                return new c(context, wVar.launcherIcon, wVar.id);
            default:
                return new e(context, wVar.launcherIcon, wVar.name, wVar.id);
        }
    }
}
