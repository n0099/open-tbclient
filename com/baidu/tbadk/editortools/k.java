package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public static l a(Context context, r rVar, int i) {
        switch (i) {
            case 1:
                return new c(context, rVar.aBt, rVar.id);
            default:
                return new e(context, rVar.aBt, rVar.name, rVar.id);
        }
    }
}
