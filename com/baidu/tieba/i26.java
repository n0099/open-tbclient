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
public interface i26 {
    ag<ItemCardView> D0();

    ag<GifView> G();

    ag<LinearLayout> K();

    int P();

    void U(Context context, String str);

    void X(Context context, String str);

    ag<TiebaPlusRecommendCard> b2();

    ag<RelativeLayout> g0();

    ListView getListView();

    ag<FestivalTipView> j0();

    ag<ImageView> k0();

    ag<View> l0();

    void n0(Context context, String str);

    void o0(Context context, String str, boolean z);

    ag<TextView> q1();

    void t0(Context context, String str, String str2);

    void x0(Context context, String str);

    void y1(Context context, String str);
}
