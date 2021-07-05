package com.baidu.tieba.face.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class EmotionView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public FrameLayout B0;
    public long C0;
    public boolean D0;
    public boolean E0;
    public float F0;
    public float G0;
    public float H0;
    public float I0;
    public View.OnClickListener J0;
    public float K0;
    public int L0;
    public c M0;
    public EmotionImageData x0;
    public EmotionPreview y0;
    public int z0;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionView f14819a;

        public a(EmotionView emotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14819a = emotionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.f14819a.L = aVar.t();
            View findViewWithTag = this.f14819a.findViewWithTag(str);
            if (findViewWithTag == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            aVar.h(tbImageView);
            tbImageView.setTag(null);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionView f14820e;

        public b(EmotionView emotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14820e = emotionView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f14820e.D0 = true;
                    this.f14820e.F0 = motionEvent.getRawX();
                    this.f14820e.G0 = motionEvent.getRawY();
                    EmotionView emotionView = this.f14820e;
                    emotionView.H0 = emotionView.F0;
                    EmotionView emotionView2 = this.f14820e;
                    emotionView2.I0 = emotionView2.G0;
                    this.f14820e.C0 = System.currentTimeMillis();
                    if (this.f14820e.p0()) {
                        EmotionView emotionView3 = this.f14820e;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.C0), 500L);
                    }
                } else if (action == 1) {
                    this.f14820e.D0 = false;
                    if (this.f14820e.E0) {
                        this.f14820e.x0();
                    } else if (this.f14820e.J0 != null && this.f14820e.m0()) {
                        this.f14820e.J0.onClick(this.f14820e);
                    }
                } else if (action == 3) {
                    this.f14820e.D0 = false;
                    this.f14820e.x0();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f14821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionView f14822f;

        public d(EmotionView emotionView, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14822f = emotionView;
            this.f14821e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14822f.D0 && this.f14821e == this.f14822f.C0 && this.f14822f.s0()) {
                this.f14822f.w0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L0 = 10;
        v();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x0 = null;
            setImageResource(0);
            super.I();
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x0 : (EmotionImageData) invokeV.objValue;
    }

    public boolean getIsGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public int getLoadProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.L0 : invokeV.intValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.M0;
            return cVar == null || cVar.c();
        }
        return invokeV.booleanValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.M0;
            return cVar == null || cVar.e();
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setOnTouchListener(new b(this));
        }
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float abs = Math.abs(this.H0 - this.F0);
            float abs2 = Math.abs(this.I0 - this.G0);
            float f2 = this.K0;
            return abs < f2 && abs2 < f2;
        }
        return invokeV.booleanValue;
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.M0 = cVar;
        }
    }

    public void setLoadProcType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.L0 = i2;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.J0 = onClickListener;
        }
    }

    public void t0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, emotionImageData) == null) || emotionImageData == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        this.x0 = emotionImageData;
        setTag(emotionImageData.getThumbUrl());
        if (this.L0 == 20) {
            v0(this.x0);
        } else {
            M(this.x0.getThumbUrl(), this.L0, false);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.z0 = l.g(getContext(), R.dimen.ds240);
            this.A0 = l.g(getContext(), R.dimen.ds260);
            this.K0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        }
    }

    public final void v0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, emotionImageData) == null) {
            Object k = d.a.c.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            d.a.c.k.d.a aVar = (k == null || !(k instanceof d.a.c.k.d.a)) ? null : (d.a.c.k.d.a) k;
            if (aVar != null) {
                aVar.h(this);
                setTag(null);
            }
        }
    }

    public final void w0() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.E0 || !p0() || (emotionImageData = this.x0) == null || TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            return;
        }
        c cVar = this.M0;
        if (cVar != null) {
            cVar.d();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (this.y0 == null) {
            this.y0 = new EmotionPreview(getContext());
        }
        this.y0.e(this.x0.getPicUrl(), this.x0.getThumbUrl(), this.L, this.L0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.z0, this.A0);
        int i2 = iArr[0] - 60;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = iArr[1] - this.A0;
        if (i2 < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.z0 > l.k(getContext())) {
            layoutParams.leftMargin = l.k(getContext()) - this.z0;
        }
        if (this.B0 == null) {
            this.B0 = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        }
        if (this.y0.getParent() != null) {
            ViewParent parent = this.y0.getParent();
            FrameLayout frameLayout = this.B0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.y0);
            }
        }
        this.B0.addView(this.y0, layoutParams);
        this.E0 = true;
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.y0 != null && this.E0) {
            c cVar = this.M0;
            if (cVar != null) {
                cVar.b();
            }
            if (this.y0.getParent() != null) {
                ViewParent parent = this.y0.getParent();
                FrameLayout frameLayout = this.B0;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.y0);
                }
            }
            this.E0 = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.L0 = 10;
        v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.L0 = 10;
        v();
    }
}
