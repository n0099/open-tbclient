package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class o {
    public static p a(Context context, v vVar, int i) {
        switch (i) {
            case 1:
                return new c(context, vVar.apr, vVar.id);
            default:
                return new e(context, vVar.apr, vVar.name, vVar.id);
        }
    }
}
