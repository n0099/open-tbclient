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
    void al(Context context, String str);

    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    int azG();

    com.baidu.adp.lib.e.b<ImageView> azH();

    com.baidu.adp.lib.e.b<TextView> azI();

    com.baidu.adp.lib.e.b<GifView> azJ();

    com.baidu.adp.lib.e.b<View> azK();

    com.baidu.adp.lib.e.b<LinearLayout> azL();

    com.baidu.adp.lib.e.b<RelativeLayout> azM();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void n(Context context, String str, String str2);
}
