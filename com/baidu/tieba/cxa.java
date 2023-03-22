package com.baidu.tieba;

import android.database.ContentObserver;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
/* loaded from: classes3.dex */
public class cxa implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentObserver A;
    @ColorInt
    public int a;
    @ColorInt
    public int b;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float c;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float d;
    public boolean e;
    public boolean f;
    public BarHide g;
    public boolean h;
    public boolean i;
    @ColorInt
    public int j;
    @ColorInt
    public int k;
    public Map<View, Map<Integer, Integer>> l;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float m;
    public boolean n;
    public View o;
    public View p;
    public View q;
    @ColorInt
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public fxa y;
    public hxa z;

    public cxa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -16777216;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = false;
        this.f = false;
        this.g = BarHide.FLAG_SHOW_BAR;
        this.h = false;
        this.i = true;
        this.j = -16777216;
        this.k = -16777216;
        this.l = new HashMap();
        this.m = 0.0f;
        this.n = false;
        this.s = false;
        this.t = false;
        this.u = 18;
        this.v = true;
        this.w = true;
        this.x = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public cxa clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (cxa) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (cxa) invokeV.objValue;
    }
}
