package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.dva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
import com.qq.e.ads.splash.SplashAD;
/* loaded from: classes5.dex */
public class hva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public SplashAD g;
    public View h;
    public int i;
    public int j;
    public int[] k;
    public int l;
    public int m;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public hva(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new int[2];
        int round = Math.round(Math.min(PxUtils.getDeviceHeightInPixel(context), PxUtils.getDeviceWidthInPixel(context)) * 0.3f);
        this.a = round;
        this.b = Math.round((round * 16) / 9);
        this.c = PxUtils.dpToPx(context, 6);
        this.d = PxUtils.dpToPx(context, 100);
        this.e = 1;
        this.f = 300;
    }

    public final void a(View view2, ViewGroup viewGroup, float f, float f2, int[] iArr, ViewGroup viewGroup2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, viewGroup, Float.valueOf(f), Float.valueOf(f2), iArr, viewGroup2, aVar}) == null) {
            LogPrinter.d("zoomOut onAnimationEnd", new Object[0]);
            ViewUtils.removeFromParent(view2);
            view2.setScaleX(1.0f);
            view2.setScaleY(1.0f);
            view2.setX(0.0f);
            view2.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f3 = (f - iArr2[0]) + iArr[0];
            float f4 = (f2 - iArr2[1]) + iArr[1];
            LogPrinter.d("zoomOut distX:" + f3 + " distY:" + f4, new Object[0]);
            LogPrinter.d("zoomOut containerScreenX:" + iArr2[0] + " containerScreenY:" + iArr2[1], new Object[0]);
            viewGroup2.addView(view2, -1, -1);
            viewGroup.addView(viewGroup2, new FrameLayout.LayoutParams(this.a, this.b));
            viewGroup2.setTranslationX(f3);
            viewGroup2.setTranslationY(f4);
            if (aVar != null) {
                ((dva.b.a) aVar).a.b.zoomOutAnimationFinish();
            }
        }
    }
}
