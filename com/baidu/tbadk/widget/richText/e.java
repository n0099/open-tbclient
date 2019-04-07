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
    void aA(Context context, String str);

    void aB(Context context, String str);

    void aC(Context context, String str);

    int ata();

    com.baidu.adp.lib.e.b<ImageView> atb();

    com.baidu.adp.lib.e.b<TextView> atc();

    com.baidu.adp.lib.e.b<GifView> atd();

    com.baidu.adp.lib.e.b<View> ate();

    com.baidu.adp.lib.e.b<LinearLayout> atf();

    com.baidu.adp.lib.e.b<RelativeLayout> atg();

    void ay(Context context, String str);

    void az(Context context, String str);

    void e(Context context, String str, boolean z);

    ListView getListView();

    void k(Context context, String str, String str2);
}
