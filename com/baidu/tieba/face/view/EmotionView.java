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
import com.repackage.jg;
import com.repackage.kg;
import com.repackage.qi;
import com.repackage.zm;
/* loaded from: classes3.dex */
public class EmotionView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A0;
    public boolean B0;
    public boolean C0;
    public float D0;
    public float E0;
    public float F0;
    public float G0;
    public View.OnClickListener H0;
    public float I0;
    public int J0;
    public c K0;
    public EmotionImageData v0;
    public EmotionPreview w0;
    public int x0;
    public int y0;
    public FrameLayout z0;

    /* loaded from: classes3.dex */
    public class a extends jg<zm> {
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
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) || zmVar == null) {
                return;
            }
            this.a.H = zmVar.t();
            View findViewWithTag = this.a.findViewWithTag(str);
            if (findViewWithTag == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            zmVar.h(tbImageView);
            tbImageView.setTag(null);
        }
    }

    /* loaded from: classes3.dex */
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
                if (action == 0) {
                    this.a.B0 = true;
                    this.a.D0 = motionEvent.getRawX();
                    this.a.E0 = motionEvent.getRawY();
                    EmotionView emotionView = this.a;
                    emotionView.F0 = emotionView.D0;
                    EmotionView emotionView2 = this.a;
                    emotionView2.G0 = emotionView2.E0;
                    this.a.A0 = System.currentTimeMillis();
                    if (this.a.j0()) {
                        EmotionView emotionView3 = this.a;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.A0), 500L);
                    }
                } else if (action == 1) {
                    this.a.B0 = false;
                    if (this.a.C0) {
                        this.a.p0();
                    } else if (this.a.H0 != null && this.a.i0()) {
                        this.a.H0.onClick(this.a);
                    }
                } else if (action == 3) {
                    this.a.B0 = false;
                    this.a.p0();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.B0 && this.a == this.b.A0 && this.b.l0()) {
                this.b.o0();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J0 = 10;
        v();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.v0 = null;
            setImageResource(0);
            super.F();
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v0 : (EmotionImageData) invokeV.objValue;
    }

    public boolean getIsGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public int getLoadProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.J0 : invokeV.intValue;
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c cVar = this.K0;
            return cVar == null || cVar.c();
        }
        return invokeV.booleanValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.K0;
            return cVar == null || cVar.e();
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
            float abs = Math.abs(this.F0 - this.D0);
            float abs2 = Math.abs(this.G0 - this.E0);
            float f = this.I0;
            return abs < f && abs2 < f;
        }
        return invokeV.booleanValue;
    }

    public void m0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) || emotionImageData == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        this.v0 = emotionImageData;
        setTag(emotionImageData.getThumbUrl());
        if (this.J0 == 20) {
            n0(this.v0);
        } else {
            K(this.v0.getThumbUrl(), this.J0, false);
        }
    }

    public final void n0(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionImageData) == null) {
            Object k = kg.h().k(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            zm zmVar = (k == null || !(k instanceof zm)) ? null : (zm) k;
            if (zmVar != null) {
                zmVar.h(this);
                setTag(null);
            }
        }
    }

    public final void o0() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.C0 || !j0() || (emotionImageData = this.v0) == null || TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            return;
        }
        c cVar = this.K0;
        if (cVar != null) {
            cVar.d();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (this.w0 == null) {
            this.w0 = new EmotionPreview(getContext());
        }
        this.w0.e(this.v0.getPicUrl(), this.v0.getThumbUrl(), this.H, this.J0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x0, this.y0);
        int i = iArr[0] - 60;
        layoutParams.leftMargin = i;
        layoutParams.topMargin = iArr[1] - this.y0;
        if (i < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.x0 > qi.k(getContext())) {
            layoutParams.leftMargin = qi.k(getContext()) - this.x0;
        }
        if (this.z0 == null) {
            this.z0 = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        }
        if (this.w0.getParent() != null) {
            ViewParent parent = this.w0.getParent();
            FrameLayout frameLayout = this.z0;
            if (parent == frameLayout) {
                frameLayout.removeView(this.w0);
            }
        }
        this.z0.addView(this.w0, layoutParams);
        this.C0 = true;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.w0 != null && this.C0) {
            c cVar = this.K0;
            if (cVar != null) {
                cVar.b();
            }
            if (this.w0.getParent() != null) {
                ViewParent parent = this.w0.getParent();
                FrameLayout frameLayout = this.z0;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.w0);
                }
            }
            this.C0 = false;
        }
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.K0 = cVar;
        }
    }

    public void setLoadProcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.J0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.H0 = onClickListener;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.x0 = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070283);
            this.y0 = qi.f(getContext(), R.dimen.obfuscated_res_0x7f07028a);
            this.I0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
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
        this.J0 = 10;
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
        this.J0 = 10;
        v();
    }
}
