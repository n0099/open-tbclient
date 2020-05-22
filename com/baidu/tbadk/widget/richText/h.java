package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
public interface h {
    void al(Context context, String str);

    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    int biX();

    com.baidu.adp.lib.d.b<ImageView> biY();

    com.baidu.adp.lib.d.b<TextView> biZ();

    com.baidu.adp.lib.d.b<GifView> bja();

    com.baidu.adp.lib.d.b<View> bjb();

    com.baidu.adp.lib.d.b<LinearLayout> bjc();

    com.baidu.adp.lib.d.b<RelativeLayout> bjd();

    void f(Context context, String str, boolean z);

    ListView getListView();

    void s(Context context, String str, String str2);
}
