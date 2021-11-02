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
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class EmotionView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionImageData P;
    public EmotionPreview Q;
    public int R;
    public int S;
    public FrameLayout T;
    public long U;
    public boolean V;
    public boolean W;
    public float a0;
    public float b0;
    public float c0;
    public float i0;
    public View.OnClickListener j0;
    public float k0;
    public int l0;
    public c m0;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionView f47799a;

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
            this.f47799a = emotionView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.f47799a.mIsGif = aVar.t();
            View findViewWithTag = this.f47799a.findViewWithTag(str);
            if (findViewWithTag == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            aVar.h(tbImageView);
            tbImageView.setTag(null);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionView f47800e;

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
            this.f47800e = emotionView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f47800e.V = true;
                    this.f47800e.a0 = motionEvent.getRawX();
                    this.f47800e.b0 = motionEvent.getRawY();
                    EmotionView emotionView = this.f47800e;
                    emotionView.c0 = emotionView.a0;
                    EmotionView emotionView2 = this.f47800e;
                    emotionView2.i0 = emotionView2.b0;
                    this.f47800e.U = System.currentTimeMillis();
                    if (this.f47800e.S()) {
                        EmotionView emotionView3 = this.f47800e;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.U), 500L);
                    }
                } else if (action == 1) {
                    this.f47800e.V = false;
                    if (this.f47800e.W) {
                        this.f47800e.W();
                    } else if (this.f47800e.j0 != null && this.f47800e.R()) {
                        this.f47800e.j0.onClick(this.f47800e);
                    }
                } else if (action == 3) {
                    this.f47800e.V = false;
                    this.f47800e.W();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        boolean canClick();

        boolean canShowPreview();

        void startShowPreview();

        void startStopPreview();
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f47801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionView f47802f;

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
            this.f47802f = emotionView;
            this.f47801e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47802f.V && this.f47801e == this.f47802f.U && this.f47802f.T()) {
                this.f47802f.V();
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
        this.l0 = 10;
        init();
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.m0;
            return cVar == null || cVar.canClick();
        }
        return invokeV.booleanValue;
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.m0;
            return cVar == null || cVar.canShowPreview();
        }
        return invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            float abs = Math.abs(this.c0 - this.a0);
            float abs2 = Math.abs(this.i0 - this.b0);
            float f2 = this.k0;
            return abs < f2 && abs2 < f2;
        }
        return invokeV.booleanValue;
    }

    public final void U(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emotionImageData) == null) {
            Object k = b.a.e.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            b.a.e.l.d.a aVar = (k == null || !(k instanceof b.a.e.l.d.a)) ? null : (b.a.e.l.d.a) k;
            if (aVar != null) {
                aVar.h(this);
                setTag(null);
            }
        }
    }

    public final void V() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.W || !S() || (emotionImageData = this.P) == null || TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            return;
        }
        c cVar = this.m0;
        if (cVar != null) {
            cVar.startShowPreview();
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (this.Q == null) {
            this.Q = new EmotionPreview(getContext());
        }
        this.Q.loadImage(this.P.getPicUrl(), this.P.getThumbUrl(), this.mIsGif, this.l0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.R, this.S);
        int i2 = iArr[0] - 60;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = iArr[1] - this.S;
        if (i2 < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.R > l.k(getContext())) {
            layoutParams.leftMargin = l.k(getContext()) - this.R;
        }
        if (this.T == null) {
            this.T = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        }
        if (this.Q.getParent() != null) {
            ViewParent parent = this.Q.getParent();
            FrameLayout frameLayout = this.T;
            if (parent == frameLayout) {
                frameLayout.removeView(this.Q);
            }
        }
        this.T.addView(this.Q, layoutParams);
        this.W = true;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.Q != null && this.W) {
            c cVar = this.m0;
            if (cVar != null) {
                cVar.startStopPreview();
            }
            if (this.Q.getParent() != null) {
                ViewParent parent = this.Q.getParent();
                FrameLayout frameLayout = this.T;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.Q);
                }
            }
            this.W = false;
        }
    }

    public void enablePreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setOnTouchListener(new b(this));
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.P : (EmotionImageData) invokeV.objValue;
    }

    public boolean getIsGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsGif : invokeV.booleanValue;
    }

    public int getLoadProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l0 : invokeV.intValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.R = l.g(getContext(), R.dimen.ds240);
            this.S = l.g(getContext(), R.dimen.ds260);
            this.k0 = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        }
    }

    public void loadData(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, emotionImageData) == null) || emotionImageData == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        this.P = emotionImageData;
        setTag(emotionImageData.getThumbUrl());
        if (this.l0 == 20) {
            U(this.P);
        } else {
            startLoad(this.P.getThumbUrl(), this.l0, false);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.P = null;
            setImageResource(0);
            super.reset();
        }
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.m0 = cVar;
        }
    }

    public void setLoadProcType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l0 = i2;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.j0 = onClickListener;
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
        this.l0 = 10;
        init();
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
        this.l0 = 10;
        init();
    }
}
