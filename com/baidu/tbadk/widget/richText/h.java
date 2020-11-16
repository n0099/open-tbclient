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
    void au(Context context, String str);

    void av(Context context, String str);

    void aw(Context context, String str);

    void ax(Context context, String str);

    void ay(Context context, String str);

    int bFM();

    com.baidu.adp.lib.d.b<ImageView> bFN();

    com.baidu.adp.lib.d.b<TextView> bFO();

    com.baidu.adp.lib.d.b<GifView> bFP();

    com.baidu.adp.lib.d.b<View> bFQ();

    com.baidu.adp.lib.d.b<LinearLayout> bFR();

    com.baidu.adp.lib.d.b<RelativeLayout> bFS();

    void f(Context context, String str, boolean z);

    ListView getListView();

    void u(Context context, String str, String str2);
}
