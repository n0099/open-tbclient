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
    int Jn();

    com.baidu.adp.lib.e.b<ImageView> Jo();

    com.baidu.adp.lib.e.b<TextView> Jp();

    com.baidu.adp.lib.e.b<GifView> Jq();

    com.baidu.adp.lib.e.b<View> Jr();

    com.baidu.adp.lib.e.b<LinearLayout> Js();

    com.baidu.adp.lib.e.b<RelativeLayout> Jt();

    void U(Context context, String str);

    void V(Context context, String str);

    void W(Context context, String str);

    void X(Context context, String str);

    void Y(Context context, String str);

    void Z(Context context, String str);

    void g(Context context, String str, String str2);

    ListView getListView();
}
