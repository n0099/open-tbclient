package com.baidu.tieba.a;

import android.content.Context;
/* loaded from: classes.dex */
public final class a extends com.baidu.tieba.f.a {
    public a(Context context, String str, boolean z) {
        super(context);
        d().putExtra("forum_id", str);
        d().putExtra("show_recommend", z);
    }
}
