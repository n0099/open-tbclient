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
    void aC(Context context, String str);

    void aD(Context context, String str);

    void aE(Context context, String str);

    void aF(Context context, String str);

    void aG(Context context, String str);

    com.baidu.adp.lib.d.b<ImageView> aUA();

    com.baidu.adp.lib.d.b<TextView> aUB();

    com.baidu.adp.lib.d.b<GifView> aUC();

    com.baidu.adp.lib.d.b<View> aUD();

    com.baidu.adp.lib.d.b<LinearLayout> aUE();

    com.baidu.adp.lib.d.b<RelativeLayout> aUF();

    int aUz();

    void d(Context context, String str, boolean z);

    ListView getListView();

    void r(Context context, String str, String str2);
}
