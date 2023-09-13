package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.view.festivalview.FestivalTipView;
/* loaded from: classes6.dex */
public interface h26 {
    bg<GifView> A();

    bg<LinearLayout> D();

    int H();

    void M(Context context, String str);

    void P(Context context, String str);

    bg<TiebaPlusRecommendCard> V1();

    bg<RelativeLayout> Y();

    bg<FestivalTipView> b0();

    bg<ImageView> c0();

    bg<View> d0();

    void f0(Context context, String str);

    ListView getListView();

    void h0(Context context, String str, boolean z);

    bg<TextView> j1();

    void m0(Context context, String str, String str2);

    void p0(Context context, String str);

    void u1(Context context, String str);

    bg<ItemCardView> v0();
}
