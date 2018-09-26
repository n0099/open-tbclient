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
    com.baidu.adp.lib.e.b<View> PA();

    com.baidu.adp.lib.e.b<LinearLayout> PB();

    com.baidu.adp.lib.e.b<RelativeLayout> PC();

    int Pw();

    com.baidu.adp.lib.e.b<ImageView> Px();

    com.baidu.adp.lib.e.b<TextView> Py();

    com.baidu.adp.lib.e.b<GifView> Pz();

    void am(Context context, String str);

    void an(Context context, String str);

    void ao(Context context, String str);

    void ap(Context context, String str);

    void aq(Context context, String str);

    void e(Context context, String str, boolean z);

    ListView getListView();

    void i(Context context, String str, String str2);
}
