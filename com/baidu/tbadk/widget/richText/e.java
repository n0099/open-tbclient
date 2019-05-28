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
    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    void aq(Context context, String str);

    int ayg();

    com.baidu.adp.lib.e.b<ImageView> ayh();

    com.baidu.adp.lib.e.b<TextView> ayi();

    com.baidu.adp.lib.e.b<GifView> ayj();

    com.baidu.adp.lib.e.b<View> ayk();

    com.baidu.adp.lib.e.b<LinearLayout> ayl();

    com.baidu.adp.lib.e.b<RelativeLayout> aym();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void n(Context context, String str, String str2);
}
