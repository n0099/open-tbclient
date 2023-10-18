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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EmotionView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionImageData a;
    public EmotionPreview b;
    public int c;
    public int d;
    public FrameLayout e;
    public long f;
    public boolean g;
    public boolean h;
    public float i;
    public float j;
    public float k;
    public float l;
    public View.OnClickListener m;
    public float n;
    public int o;
    public c p;

    /* loaded from: classes5.dex */
    public interface c {
        void b();

        boolean c();

        void d();

        boolean e();
    }

    /* loaded from: classes5.dex */
    public class a extends BdResourceCallback<BdImage> {
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
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) && bdImage != null) {
                this.a.mIsGif = bdImage.isGif();
                View findViewWithTag = this.a.findViewWithTag(str);
                if (findViewWithTag != null && (findViewWithTag instanceof TbImageView) && str != null) {
                    TbImageView tbImageView = (TbImageView) findViewWithTag;
                    bdImage.drawImageTo(tbImageView);
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
                            this.a.g = false;
                            this.a.D();
                        }
                    } else {
                        this.a.g = false;
                        if (!this.a.h) {
                            if (this.a.m != null && this.a.u()) {
                                this.a.m.onClick(this.a);
                            }
                        } else {
                            this.a.D();
                        }
                    }
                } else {
                    this.a.g = true;
                    this.a.i = motionEvent.getRawX();
                    this.a.j = motionEvent.getRawY();
                    EmotionView emotionView = this.a;
                    emotionView.k = emotionView.i;
                    EmotionView emotionView2 = this.a;
                    emotionView2.l = emotionView2.j;
                    this.a.f = System.currentTimeMillis();
                    if (this.a.x()) {
                        EmotionView emotionView3 = this.a;
                        emotionView3.postDelayed(new d(emotionView3, emotionView3.f), 500L);
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.g || this.a != this.b.f || !this.b.z()) {
                return;
            }
            this.b.C();
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
        this.o = 10;
        init();
    }

    public void A(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, emotionImageData) == null) && emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            this.a = emotionImageData;
            setTag(emotionImageData.getThumbUrl());
            if (this.o == 20) {
                B(this.a);
            } else {
                startLoad(this.a.getThumbUrl(), this.o, false);
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
        this.o = 10;
        init();
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
        this.o = 10;
        init();
    }

    public void setController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void setLoadProcType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public final void B(EmotionImageData emotionImageData) {
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData) == null) {
            Object loadResource = BdResourceLoader.getInstance().loadResource(emotionImageData.getThumbUrl(), 20, new a(this), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
            if (loadResource != null && (loadResource instanceof BdImage)) {
                bdImage = (BdImage) loadResource;
            } else {
                bdImage = null;
            }
            if (bdImage != null) {
                bdImage.drawImageTo(this);
                setTag(null);
            }
        }
    }

    public final void C() {
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.h && x() && (emotionImageData = this.a) != null && !TextUtils.isEmpty(emotionImageData.getPicUrl())) {
            c cVar = this.p;
            if (cVar != null) {
                cVar.d();
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (this.b == null) {
                this.b = new EmotionPreview(getContext());
            }
            this.b.e(this.a.getPicUrl(), this.a.getThumbUrl(), this.mIsGif, this.o);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.d);
            int i = iArr[0] - 60;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = iArr[1] - this.d;
            if (i < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.c > BdUtilHelper.getEquipmentWidth(getContext())) {
                layoutParams.leftMargin = BdUtilHelper.getEquipmentWidth(getContext()) - this.c;
            }
            if (this.e == null) {
                this.e = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
            }
            if (this.b.getParent() != null) {
                ViewParent parent = this.b.getParent();
                FrameLayout frameLayout = this.e;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.b);
                }
            }
            this.e.addView(this.b, layoutParams);
            this.h = true;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b != null && this.h) {
            c cVar = this.p;
            if (cVar != null) {
                cVar.b();
            }
            if (this.b.getParent() != null) {
                ViewParent parent = this.b.getParent();
                FrameLayout frameLayout = this.e;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.b);
                }
            }
            this.h = false;
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703a1);
            this.d = BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703a8);
            this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        }
    }

    public EmotionImageData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (EmotionImageData) invokeV.objValue;
    }

    public boolean getIsGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mIsGif;
        }
        return invokeV.booleanValue;
    }

    public int getLoadProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a = null;
            setImageResource(0);
            super.reset();
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c cVar = this.p;
            if (cVar != null && !cVar.c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c cVar = this.p;
            if (cVar != null && !cVar.e()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            setOnTouchListener(new b(this));
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            float abs = Math.abs(this.k - this.i);
            float abs2 = Math.abs(this.l - this.j);
            float f = this.n;
            if (abs < f && abs2 < f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
