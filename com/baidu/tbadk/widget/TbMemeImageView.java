package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.l.c;
import c.a.e.e.l.d;
import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TbMemeImageView extends ImageView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.d.b f48661e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f48662f;

    /* renamed from: g  reason: collision with root package name */
    public int f48663g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.l.d.a f48664h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48665i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f48666j;
    public Drawable k;
    public String l;
    public View.OnClickListener m;
    public TbRichTextView.x n;
    public final Handler o;
    public c<c.a.e.l.d.a> p;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbMemeImageView f48667a;

        public a(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48667a = tbMemeImageView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.a.e.d.b gif;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.f48667a.getGif()) != null && message.what == 1) {
                this.f48667a.f48663g++;
                if (this.f48667a.f48663g >= gif.getFrameCount()) {
                    this.f48667a.f48663g = 0;
                }
                gif.c(this.f48667a.f48663g);
                gif.a(this.f48667a.f48662f, null);
                this.f48667a.invalidate();
                this.f48667a.o.removeMessages(1);
                this.f48667a.o.sendEmptyMessageDelayed(1, gif.b(this.f48667a.f48663g));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbMemeImageView f48668a;

        public b(TbMemeImageView tbMemeImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbMemeImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48668a = tbMemeImageView;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.h().c(str, 33);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            this.f48668a.startLoad(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context) {
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
        this.f48665i = true;
        this.f48666j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
        e();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.n;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setBackgroundDrawable(this.f48666j);
            setOnClickListener(null);
        }
    }

    public c.a.e.l.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48664h : (c.a.e.l.d.a) invokeV.objValue;
    }

    public c.a.e.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.e.d.b bVar = this.f48661e;
            if (bVar == null) {
                return null;
            }
            return bVar;
        }
        return (c.a.e.d.b) invokeV.objValue;
    }

    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
            c.a.e.l.d.a aVar = (c.a.e.l.d.a) d.h().n(this.l, 33, this.p, 0, 0, Boolean.FALSE, null);
            if (aVar != null) {
                startLoad(aVar);
            } else if (!d.h().j(33) && this.f48665i) {
                setHasNoImage(true);
            } else {
                d.h().l(this.l, 33, this.p, 0, 0, false, null, new Object[0]);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (this.f48664h == null && this.f48665i) {
                d.h().l(this.l, 33, this.p, 0, 0, false, null, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            this.o.removeMessages(1);
            c.a.e.d.b bVar = this.f48661e;
            if (bVar != null) {
                bVar.close();
                this.f48661e = null;
            }
            if (this.f48664h != null) {
                this.f48664h = null;
            }
            Bitmap bitmap = this.f48662f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f48662f = null;
            }
            this.f48663g = 0;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStartTemporaryDetach();
            this.o.removeMessages(1);
            c.a.e.d.b bVar = this.f48661e;
            if (bVar != null) {
                bVar.close();
                this.f48661e = null;
            }
            if (this.f48664h != null) {
                this.f48664h = null;
            }
            Bitmap bitmap = this.f48662f;
            if (bitmap != null) {
                bitmap.recycle();
                this.f48662f = null;
            }
            this.f48663g = 0;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (this.f48661e == null) {
                return;
            }
            if (i2 == 4 || i2 == 8) {
                stop();
            } else if (i2 == 0) {
                play();
            }
        }
    }

    public void play() {
        c.a.e.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gif = getGif()) == null) {
            return;
        }
        if (this.f48663g != 0) {
            this.f48663g = 0;
        }
        gif.c(0);
        this.o.removeMessages(1);
        this.o.sendEmptyMessageDelayed(1, gif.b(this.f48663g));
    }

    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xVar) == null) {
            this.n = xVar;
        }
    }

    public void setHasNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z && (this.f48666j != null || this.k != null)) {
                int intrinsicWidth = this.f48666j.getIntrinsicWidth();
                int intrinsicHeight = this.f48666j.getIntrinsicHeight();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (intrinsicWidth > measuredWidth) {
                    intrinsicWidth = measuredWidth;
                }
                if (intrinsicHeight > measuredHeight) {
                    intrinsicHeight = measuredHeight;
                }
                int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
                int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
                this.f48666j.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            if (!isClickable()) {
                setClickable(true);
            }
            super.setOnClickListener(this);
            this.m = onClickListener;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f48665i = z;
        }
    }

    public void startLoad(c.a.e.l.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f48664h = aVar;
        if (aVar.t() && aVar.k() != null && aVar.k().length > 0) {
            NSGif f2 = NSGif.f(aVar.k(), 0, aVar.k().length);
            if (f2 == null) {
                return;
            }
            this.f48661e = f2;
            f2.c(0);
            Bitmap bitmap = this.f48662f;
            if (bitmap == null || (bitmap.getWidth() != this.f48661e.getWidth() && this.f48662f.getHeight() != this.f48661e.getHeight())) {
                this.f48662f = Bitmap.createBitmap(this.f48661e.getWidth(), this.f48661e.getHeight(), Bitmap.Config.ARGB_4444);
            }
            this.f48661e.a(this.f48662f, null);
            setImageBitmap(this.f48662f);
            play();
        } else if (aVar.p() != null) {
            setImageBitmap(aVar.p());
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || getGif() == null) {
            return;
        }
        this.o.removeMessages(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f48665i = true;
        this.f48666j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbMemeImageView(Context context, AttributeSet attributeSet) {
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
        this.f48665i = true;
        this.f48666j = SkinManager.getDrawable(R.color.common_color_10220);
        this.k = SkinManager.getDrawable(R.drawable.icon_click);
        SkinManager.getDrawable(R.drawable.img_default_100);
        new Rect();
        this.o = new a(this);
        this.p = new b(this);
        e();
    }
}
