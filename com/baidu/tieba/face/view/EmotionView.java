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
import com.baidu.tieba.jn;
import com.baidu.tieba.rg;
import com.baidu.tieba.sg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes5.dex */
    public class a extends rg<jn> {
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
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) && jnVar != null) {
                this.a.H = jnVar.t();
                View findViewWithTag = this.a.findViewWithTag(str);
                if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                    TbImageView tbImageView = (TbImageView) findViewWithTag;
                    jnVar.h(tbImageView);
                    tbImageView.setTag(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                            this.a.D0 = false;
                            this.a.s0();
                        }
                    } else {
                        this.a.D0 = false;
                        if (!this.a.E0) {
                            if (this.a.J0 != null && this.a.l0()) {
                                this.a.J0.onClick(this.a);
                            }
                        } else {
                            this.a.s0();
                        }
                    }
                } else {
                    this.a.D0 = true;
                    this.a.F0 = motionEvent.getRawX();
                    this.a.G0 = motionEvent.getRawY();
                    EmotionView emotionView = this.a;
                    emotionView.H0 = emotionView.F0;
                    EmotionView emotionView2 = this.a;
                    emotionView2.I0 = emotionView2.G0;
                    this.a.C0 = System.currentTimeMillis();
                    if (this.a.m0()) {
                        EmotionView emotionView3 = this.a;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.C0), 500L);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.D0 || this.a != this.b.C0 || !this.b.o0()) {
                return;
            }
            this.b.r0();
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
        this.L0 = 10;
        x();
    }

    public void p0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) && emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.x0 = emotionImageData;
            setTag(emotionImageData.getThumbUrl());
            if (this.L0 == 20) {
                q0(this.x0);
            } else {
                N(this.x0.getThumbUrl(), this.L0, false);
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
        this.L0 = 10;
        x();
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
        this.L0 = 10;
        x();
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.M0 = cVar;
        }
    }

    public void setLoadProcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.L0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.J0 = onClickListener;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x0 = null;
            setImageResource(0);
            super.H();
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.x0;
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
            return this.L0;
        }
        return invokeV.intValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.M0;
            if (cVar != null && !cVar.c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.M0;
            if (cVar != null && !cVar.e()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setOnTouchListener(new b(this));
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float abs = Math.abs(this.H0 - this.F0);
            float abs2 = Math.abs(this.I0 - this.G0);
            float f = this.K0;
            if (abs < f && abs2 < f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q0(EmotionImageData emotionImageData) {
        jn jnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionImageData) == null) {
            Object k = sg.h().k(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            if (k != null && (k instanceof jn)) {
                jnVar = (jn) k;
            } else {
                jnVar = null;
            }
            if (jnVar != null) {
                jnVar.h(this);
                setTag(null);
            }
        }
    }

    public final void r0() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.E0 && m0() && (emotionImageData = this.x0) != null && !TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            c cVar = this.M0;
            if (cVar != null) {
                cVar.d();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.y0 == null) {
                this.y0 = new EmotionPreview(getContext());
            }
            this.y0.e(this.x0.getPicUrl(), this.x0.getThumbUrl(), this.H, this.L0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.z0, this.A0);
            int i = iArr[0] - 60;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = iArr[1] - this.A0;
            if (i < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.z0 > yi.l(getContext())) {
                layoutParams.leftMargin = yi.l(getContext()) - this.z0;
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
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.y0 != null && this.E0) {
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

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.z0 = yi.g(getContext(), R.dimen.obfuscated_res_0x7f0703a1);
            this.A0 = yi.g(getContext(), R.dimen.obfuscated_res_0x7f0703a8);
            this.K0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        }
    }
}
