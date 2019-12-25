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
    void aB(Context context, String str);

    void aC(Context context, String str);

    void aD(Context context, String str);

    void aE(Context context, String str);

    void aF(Context context, String str);

    int aRM();

    com.baidu.adp.lib.d.b<ImageView> aRN();

    com.baidu.adp.lib.d.b<TextView> aRO();

    com.baidu.adp.lib.d.b<GifView> aRP();

    com.baidu.adp.lib.d.b<View> aRQ();

    com.baidu.adp.lib.d.b<LinearLayout> aRR();

    com.baidu.adp.lib.d.b<RelativeLayout> aRS();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
