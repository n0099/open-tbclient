package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FaceGroupInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qi;
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class FaceGroupDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public int c;
    public FaceGroupInfoData.Status d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1682412363, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadButton$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1682412363, "Lcom/baidu/tbadk/coreExtra/view/FaceGroupDownloadButton$a;");
                    return;
                }
            }
            int[] iArr = new int[FaceGroupInfoData.Status.values().length];
            a = iArr;
            try {
                iArr[FaceGroupInfoData.Status.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FaceGroupInfoData.Status.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FaceGroupInfoData.Status.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FaceGroupDownloadButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.e.setColor(this.i);
            this.e.setAlpha((int) (this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.h);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int width = (getWidth() * this.c) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.e.setColor(this.i);
            this.e.setAlpha((int) ((this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.1f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.i);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.e.setColor(this.i);
            this.e.setAlpha((int) (this.a ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.h);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.e.setColor(this.f);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeWidth(this.g);
            int i = this.g;
            canvas.drawRoundRect(i >> 1, i >> 1, getWidth() - this.g, getHeight() - this.g, getHeight(), getHeight(), this.e);
            this.e.setColor(this.f);
            this.e.setAlpha(this.a ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Paint paint = new Paint(1);
            this.e = paint;
            paint.setTextSize(qi.f(getContext(), R.dimen.T_X08));
            this.g = qi.f(getContext(), R.dimen.L_X02);
            e();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = SkinManager.getColor(R.color.CAM_X0111);
            this.i = SkinManager.getColor(R.color.CAM_X0302);
            this.h = SkinManager.getColor(R.color.CAM_X0101);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            int i = a.a[this.d.ordinal()];
            if (i == 1) {
                c(canvas);
            } else if (i != 2 && i != 3) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.a = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
        }
    }

    public void setStatus(@NonNull FaceGroupInfoData.Status status) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, status) == null) {
            this.d = status;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.b = str;
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FaceGroupDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceGroupDownloadButton(Context context, AttributeSet attributeSet, int i) {
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
        this.d = FaceGroupInfoData.Status.NEW;
        d();
    }
}
