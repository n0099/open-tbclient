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
/* loaded from: classes4.dex */
public interface ev5 {
    xf<LinearLayout> A();

    xf<TiebaPlusRecommendCard> D1();

    int E();

    void I(Context context, String str);

    void K(Context context, String str);

    xf<RelativeLayout> S();

    xf<FestivalTipView> U();

    xf<ImageView> W();

    xf<View> X();

    xf<TextView> X0();

    void Y(Context context, String str);

    void Z(Context context, String str, boolean z);

    void f0(Context context, String str, String str2);

    void g1(Context context, String str);

    ListView getListView();

    void j0(Context context, String str);

    xf<ItemCardView> o0();

    xf<GifView> x();
}
