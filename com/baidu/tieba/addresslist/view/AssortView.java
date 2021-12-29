package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import c.a.s0.t.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AssortView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f43360e;

    /* renamed from: f  reason: collision with root package name */
    public int f43361f;

    /* renamed from: g  reason: collision with root package name */
    public a f43362g;

    /* loaded from: classes12.dex */
    public interface a {
        void onTouchDown(String str);

        void onTouchUP();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssortView(Context context) {
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
        this.f43361f = -1;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f43360e = new Paint();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? super.dispatchTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int height = getHeight();
            int width = getWidth();
            float f2 = (float) (width / 48.0d);
            String[] strArr = c.a;
            int length = height / strArr.length;
            int length2 = strArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                this.f43360e.setAntiAlias(true);
                this.f43360e.setTypeface(Typeface.DEFAULT_BOLD);
                this.f43360e.setColor(SkinManager.getColor(R.color.CAM_X0108));
                this.f43360e.setTextSize(26.0f * f2);
                canvas.drawText(c.a[i2], (width / 2.0f) - (this.f43360e.measureText(c.a[i2]) / 2.0f), (length * i2) + length, this.f43360e);
                this.f43360e.reset();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            super.onTouchEvent(motionEvent);
            float y = motionEvent.getY() / getHeight();
            String[] strArr = c.a;
            int length = (int) (y * strArr.length);
            if (length >= 0 && length < strArr.length) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f43361f = length;
                    a aVar = this.f43362g;
                    if (aVar != null) {
                        aVar.onTouchDown(c.a[length]);
                    }
                } else if (action != 1) {
                    if (action == 2 && this.f43361f != length) {
                        this.f43361f = length;
                        a aVar2 = this.f43362g;
                        if (aVar2 != null) {
                            aVar2.onTouchDown(c.a[length]);
                        }
                    }
                } else {
                    a aVar3 = this.f43362g;
                    if (aVar3 != null) {
                        aVar3.onTouchUP();
                    }
                    this.f43361f = -1;
                }
            } else {
                this.f43361f = -1;
                a aVar4 = this.f43362g;
                if (aVar4 != null) {
                    aVar4.onTouchUP();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setOnTouchListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f43362g = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssortView(Context context, AttributeSet attributeSet) {
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
        this.f43361f = -1;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssortView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f43361f = -1;
        a();
    }
}
