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
    void aF(Context context, String str);

    void aG(Context context, String str);

    void aH(Context context, String str);

    void aI(Context context, String str);

    void aJ(Context context, String str);

    int bHN();

    com.baidu.adp.lib.d.b<ImageView> bHO();

    com.baidu.adp.lib.d.b<TextView> bHP();

    com.baidu.adp.lib.d.b<GifView> bHQ();

    com.baidu.adp.lib.d.b<View> bHR();

    com.baidu.adp.lib.d.b<LinearLayout> bHS();

    com.baidu.adp.lib.d.b<RelativeLayout> bHT();

    void g(Context context, String str, boolean z);

    ListView getListView();

    void u(Context context, String str, String str2);
}
