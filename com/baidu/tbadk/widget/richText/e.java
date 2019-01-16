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
public interface e {
    int Te();

    com.baidu.adp.lib.e.b<ImageView> Tf();

    com.baidu.adp.lib.e.b<TextView> Tg();

    com.baidu.adp.lib.e.b<GifView> Th();

    com.baidu.adp.lib.e.b<View> Ti();

    com.baidu.adp.lib.e.b<LinearLayout> Tj();

    com.baidu.adp.lib.e.b<RelativeLayout> Tk();

    void al(Context context, String str);

    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    void e(Context context, String str, boolean z);

    ListView getListView();

    void k(Context context, String str, String str2);
}
