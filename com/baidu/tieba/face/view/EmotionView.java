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
import com.baidu.tieba.ej;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.on;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EmotionView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A0;
    public long B0;
    public boolean C0;
    public boolean D0;
    public float E0;
    public float F0;
    public float G0;
    public float H0;
    public View.OnClickListener I0;
    public float J0;
    public int K0;
    public c L0;
    public EmotionImageData w0;
    public EmotionPreview x0;
    public int y0;
    public int z0;

    /* loaded from: classes4.dex */
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes4.dex */
    public class a extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionView a;

        public a(EmotionView emotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) && onVar != null) {
                this.a.H = onVar.t();
                View findViewWithTag = this.a.findViewWithTag(str);
                if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                    TbImageView tbImageView = (TbImageView) findViewWithTag;
                    onVar.h(tbImageView);
                    tbImageView.setTag(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionView a;

        public b(EmotionView emotionView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 3) {
                            this.a.C0 = false;
                            this.a.p0();
                        }
                    } else {
                        this.a.C0 = false;
                        if (!this.a.D0) {
                            if (this.a.I0 != null && this.a.i0()) {
                                this.a.I0.onClick(this.a);
                            }
                        } else {
                            this.a.p0();
                        }
                    }
                } else {
                    this.a.C0 = true;
                    this.a.E0 = motionEvent.getRawX();
                    this.a.F0 = motionEvent.getRawY();
                    EmotionView emotionView = this.a;
                    emotionView.G0 = emotionView.E0;
                    EmotionView emotionView2 = this.a;
                    emotionView2.H0 = emotionView2.F0;
                    this.a.B0 = System.currentTimeMillis();
                    if (this.a.j0()) {
                        EmotionView emotionView3 = this.a;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.B0), 500L);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ EmotionView b;

        public d(EmotionView emotionView, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionView, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = emotionView;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.C0 || this.a != this.b.B0 || !this.b.l0()) {
                return;
            }
            this.b.o0();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K0 = 10;
        v();
    }

    public void m0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) && emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.w0 = emotionImageData;
            setTag(emotionImageData.getThumbUrl());
            if (this.K0 == 20) {
                n0(this.w0);
            } else {
                K(this.w0.getThumbUrl(), this.K0, false);
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K0 = 10;
        v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.K0 = 10;
        v();
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.L0 = cVar;
        }
    }

    public void setLoadProcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.K0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.I0 = onClickListener;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.w0 = null;
            setImageResource(0);
            super.F();
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w0;
        }
        return (EmotionImageData) invokeV.objValue;
    }

    public boolean getIsGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public int getLoadProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.K0;
        }
        return invokeV.intValue;
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.L0;
            if (cVar != null && !cVar.c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.L0;
            if (cVar != null && !cVar.e()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setOnTouchListener(new b(this));
        }
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float abs = Math.abs(this.G0 - this.E0);
            float abs2 = Math.abs(this.H0 - this.F0);
            float f = this.J0;
            if (abs < f && abs2 < f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n0(EmotionImageData emotionImageData) {
        on onVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionImageData) == null) {
            Object k = zg.h().k(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            if (k != null && (k instanceof on)) {
                onVar = (on) k;
            } else {
                onVar = null;
            }
            if (onVar != null) {
                onVar.h(this);
                setTag(null);
            }
        }
    }

    public final void o0() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.D0 && j0() && (emotionImageData = this.w0) != null && !TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            c cVar = this.L0;
            if (cVar != null) {
                cVar.d();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.x0 == null) {
                this.x0 = new EmotionPreview(getContext());
            }
            this.x0.e(this.w0.getPicUrl(), this.w0.getThumbUrl(), this.H, this.K0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.y0, this.z0);
            int i = iArr[0] - 60;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = iArr[1] - this.z0;
            if (i < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.y0 > ej.l(getContext())) {
                layoutParams.leftMargin = ej.l(getContext()) - this.y0;
            }
            if (this.A0 == null) {
                this.A0 = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.x0.getParent() != null) {
                ViewParent parent = this.x0.getParent();
                FrameLayout frameLayout = this.A0;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.x0);
                }
            }
            this.A0.addView(this.x0, layoutParams);
            this.D0 = true;
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.x0 != null && this.D0) {
            c cVar = this.L0;
            if (cVar != null) {
                cVar.b();
            }
            if (this.x0.getParent() != null) {
                ViewParent parent = this.x0.getParent();
                FrameLayout frameLayout = this.A0;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.x0);
                }
            }
            this.D0 = false;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.y0 = ej.g(getContext(), R.dimen.obfuscated_res_0x7f070284);
            this.z0 = ej.g(getContext(), R.dimen.obfuscated_res_0x7f07028b);
            this.J0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        }
    }
}
